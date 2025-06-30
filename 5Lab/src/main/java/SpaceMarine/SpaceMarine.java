package SpaceMarine;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Класс типа данных SpaceMarine
 */
public class SpaceMarine implements Comparable<SpaceMarine>
{
     /**
     * Преобрвзует 7 параметров в обьект класса SpaceMarine
     *
     * @param name 1-я строка
     * @param coordinates 2-я строка
     * @param health 3-я строка
     * @param loyal 4-я строка
     * @param achievements 5-я строка
     * @param weaponType 6-я строка
     * @param chapter 7-я строка
     * @return обьект класса SpaceMarine
     */

    private int id;
    private String name;
    private Coordinates coordinates;
    private ZonedDateTime creationDate;
    private Float health;
    private boolean loyal;
    private String achievements;
    private Weapon weaponType;
    private Chapter chapter;

    public static void checkCorrectData(String name, String coordinates, String health, String loyal, String achievements, String weaponType, String chapter) throws IOException
    {
        if (name.trim().equalsIgnoreCase("") || name.trim().equalsIgnoreCase("null")) { throw new IOException("Ошибка с данными - c name"); }

        if (coordinates.contains("null") || (coordinates.replace("{", "").replace("}", "").split(";").length != 2) || (coordinates.replace("{", "").replace("}", "").split(";")[0].trim() == "") || (coordinates.replace("{", "").replace("}", "").split(";")[1].trim() == "")) { throw new IOException("Ошибка с данными - с coordinates"); }
        try { Integer.parseInt(coordinates.replace("{", "").replace("}", "").split(";")[0]); } catch (NumberFormatException e) { throw new IOException("Ошибка с данными - с coordinates (превышение значения Integer)"); }
        try { Float.parseFloat(coordinates.replace("{", "").replace("}", "").split(";")[1]); } catch (NumberFormatException e) { throw new IOException("Ошибка с данными - с coordinates (превышение значения Float)"); }

        if (health.trim().equalsIgnoreCase("null")) {}
        else if (Float.valueOf(health) <= 0) { throw new IOException("Ошибка с данными - с health"); }
        else { try { Float.parseFloat(health); } catch (NumberFormatException e) { throw new IOException("Ошибка с данными - с coordinates (превышение значения Float)"); } }

        if ((!loyal.equals("true")) && (!loyal.equals("false"))) { throw new IOException("Ошибка с данными - с loyal"); }

        if ((achievements.trim().equalsIgnoreCase("")) || (achievements.trim().equalsIgnoreCase("null"))) { throw new IOException("Ошибка с данными - с achievements"); }

        try { Weapon.valueOf(weaponType); } catch (IllegalArgumentException e) { throw new IOException("Ошибка с данными - с weaponType"); }

        if (chapter.contains("null") || ((chapter.replace("{", "").replace("}", "").trim()).split(";").length != 2)) { throw new IOException("Ошибка с данными - с chapter"); }
    }

    public int generateId(String a1, String a2, String a3, String a4, String a5, String a6, String a7)
    {
        int sumId = 0;

        for (int i = 0; i < a1.length(); ++i) { sumId += Character.getNumericValue(a1.charAt(i)); }
        for (int i = 0; i < a2.length(); ++i) { sumId += Character.getNumericValue(a2.charAt(i)); }
        for (int i = 0; i < a3.length(); ++i) { sumId += Character.getNumericValue(a3.charAt(i)); }
        for (int i = 0; i < a4.length(); ++i) { sumId += Character.getNumericValue(a4.charAt(i)); }
        for (int i = 0; i < a5.length(); ++i) { sumId += Character.getNumericValue(a5.charAt(i)); }
        for (int i = 0; i < a6.length(); ++i) { sumId += Character.getNumericValue(a6.charAt(i)); }
        for (int i = 0; i < a7.length(); ++i) { sumId += Character.getNumericValue(a7.charAt(i)); }

        return sumId;
    }

    public SpaceMarine(String name, String coordinates, String health, String loyal, String achievements, String weaponType, String chapter) throws IOException
    {
        checkCorrectData(name, coordinates, health, loyal, achievements, weaponType, chapter);
        {
        this.id = generateId(name, coordinates, health, loyal, achievements, weaponType, chapter);
        this.name = name;
        this.coordinates = new Coordinates(coordinates);
        this.creationDate = ZonedDateTime.now();
        if (!health.equalsIgnoreCase("null")) { this.health = Float.valueOf(health); }
        else { this.health = null; }
        this.loyal = Boolean.parseBoolean(loyal);
        this.achievements = achievements;
        this.weaponType = Weapon.valueOf(weaponType);
        this.chapter = new Chapter(chapter);
        }
    }
    
    public String getDateCreation()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String Date = creationDate.format(formatter);
        return Date;
    }

    public String getLineData()
    {
        String line = new String();
        line += String.valueOf(id);
        line += (" " + String.valueOf(name));
        line += (" " + String.valueOf(coordinates.getFirstParamenter()) + ";" + String.valueOf(coordinates.getSecondParameter()));
        line += (" " + String.valueOf(creationDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        line += (" " + String.valueOf(health));
        line += (" " + String.valueOf(loyal));
        line += (" " + String.valueOf(achievements));
        line += (" " + String.valueOf(weaponType));
        line += (" " + String.valueOf(chapter.getFirstParameter()) + ";" + String.valueOf(chapter.getSecondParameter()));
        
        return line;
    }

    public void updateFieldValue(String element, String value)
    {
        switch (element)
        {
            case "name":
                this.name = value;
                break;
            
            case "coordinates":
                this.coordinates = new Coordinates(value.replace("_", ";"));
                break;

            case "health":
                if (!value.equalsIgnoreCase("null")) { this.health = Float.valueOf(value); }
                else { this.health = null; }
                break;
            
            case "loyal":
                this.loyal = Boolean.parseBoolean(value);
                break;
            
            case "achievements":
                this.achievements = value;
                break;
            
            case "weaponType":
                this.weaponType = Weapon.valueOf(value);
                break;

            case "chapter":
                this.chapter = new Chapter(value.replace("_", ";"));
                break;
        }
    }

    @Override
    public int compareTo(SpaceMarine other)
    {
        return Integer.compare(this.id, other.id);
    }
}