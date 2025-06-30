package SpaceMarine;

/**
 * Класс типа данных Coordinates
 */
public class Coordinates 
{
    /**
     * Преобрвзует строку в обьекит с двумя полями: Integer и float
     *
     * @param x_y первая строка
     * @return обьект класса Coordinates
     */

    private Integer x;
    private float y;

    public Coordinates(String x_y)
    {
        this.x = Integer.valueOf(x_y.replace("{", "").replace("}", "").split(";")[0]);
        this.y = Float.parseFloat(x_y.replace("{", "").replace("}", "").split(";")[1]);
    }

    public Integer getFirstParamenter()
    {
        return x;
    }

    public float getSecondParameter()
    {
        return y;
    }
}
