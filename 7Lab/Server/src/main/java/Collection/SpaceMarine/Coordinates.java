package Collection.SpaceMarine;

public class Coordinates {

  private Integer x;

  private float y;

  public Coordinates(String x_y) {
    this.x = Integer.valueOf(x_y.replace("{", "").replace("}", "").split(";")[0]);
    this.y = Float.parseFloat(x_y.replace("{", "").replace("}", "").split(";")[1]);
  }

  public Integer getFirstParamenter() {
    return x;
  }

  public float getSecondParameter() {
    return y;
  }
}
