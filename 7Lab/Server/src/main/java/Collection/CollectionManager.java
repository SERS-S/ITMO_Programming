package Collection;

import Collection.SpaceMarine.SpaceMarine;
import java.io.IOException;
import java.util.Vector;

public class CollectionManager {

  Vector<SpaceMarine> collection;

  public CollectionManager(Vector<String[]> dataStats) throws IOException {
    Vector<SpaceMarine> dataList = new Vector<SpaceMarine>();
    for (int i = 0; i < dataStats.size(); ++i) {
      dataList.add(new SpaceMarine(dataStats.get(i)[0], dataStats.get(i)[1], dataStats.get(i)[2], dataStats.get(i)[3], dataStats.get(i)[4], dataStats.get(i)[5], dataStats.get(i)[6], dataStats.get(i)[7], dataStats.get(i)[8], dataStats.get(i)[9]));
    }
    this.collection = dataList;
  }

  public void deleteElementById(String id) {
    for (int i = 0; i < collection.size(); ++i) {
      if (id.equals(collection.get(i).getLineData().split(" ")[0])) {
        collection.remove(i);
        break;
      }
    }
  }

  public void updateCollectionElement(String id, String element, String Value) {
    for (int i = 0; i < collection.size(); ++i) {
      if (id.equals(collection.get(i).getLineData().split(" ")[0])) {
        collection.get(i).updateFieldValue(element, Value);
      }
    }
  }

  public void addNewElement(SpaceMarine oneNew) {
    collection.add(oneNew);
  }

  public Vector<SpaceMarine> getCollection() {
    return collection;
  }
}
