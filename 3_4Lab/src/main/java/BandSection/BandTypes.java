package BandSection;

public enum BandTypes {
    Rock,
    Pop,
    Classic,
    Metal,
    Jazz,
    Guitar;

    public static boolean contains(String value)
    {
        for (BandTypes list : BandTypes.values())
        {
            if (list.name().equalsIgnoreCase(value))
            {
                return true;
            }
        }
        return false;
    }

}