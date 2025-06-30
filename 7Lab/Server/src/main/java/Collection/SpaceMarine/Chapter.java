package Collection.SpaceMarine;

public class Chapter {

  private String name;
  private String parentLegion;

  public Chapter(String name_parentLegion) {
    if (name_parentLegion.replace("{", "").replace("}", "").split(";")[0] != "null") {
      this.name = name_parentLegion.replace("{", "").replace("}", "").split(";")[0];
    } else {
      this.name = null;
    }

    if (name_parentLegion.replace("{", "").replace("}", "").split(";")[1] != "null") {
      this.parentLegion = name_parentLegion.replace("{", "").replace("}", "").split(";")[1];
    } else {
      this.parentLegion = null;
    }
  }

  public String getFirstParameter() {
    return name;
  }

  public String getSecondParameter() {
    return parentLegion;
  }
}
