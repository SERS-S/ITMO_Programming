package CollectionManager;

import java.io.IOException;
import java.util.Vector;

import SpaceMarine.SpaceMarine;

/**
 * Класс управления коллекцией CollectionManager
 */
public class CollectionManager 
{
    Vector<SpaceMarine> collection;

    public CollectionManager(Vector<String[]> data_stats) throws IOException
    {
        Vector<SpaceMarine> data_list = new Vector<>();
        for (int i = 0; i < data_stats.size(); ++i)
        {
            data_list.add
            (
                new SpaceMarine
                (
                data_stats.get(i)[0], 
                data_stats.get(i)[1],
                data_stats.get(i)[2], 
                data_stats.get(i)[3], 
                data_stats.get(i)[4], 
                data_stats.get(i)[5], 
                data_stats.get(i)[6]
                )
            );
        }
        this.collection = data_list;
    }

    public void deleteElementById(String id)
    {
        for (int i = 0; i < collection.size(); ++i)
        {
            if (id.equals(collection.get(i).getLineData().split(" ")[0]))
            {
                collection.remove(i);
                break;
            }
        }
    }

    public void updateCollectionEelement(String id, String element, String Value)
    {
        for (int i = 0; i < collection.size(); ++i)
        {
            if (id.equals(collection.get(i).getLineData().split(" ")[0]))
            {
                collection.get(i).updateFieldValue(element, Value);
            }
        }
    }

    public void addNewElement(SpaceMarine one_new)
    {
        collection.add(one_new);
    }

    public Vector<SpaceMarine> getCollection()
    {
        return collection;
    }
}
