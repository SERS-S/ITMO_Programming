package BandSection;

import StreetSection.*;
import WorkCode.InvalidVetrofonBandException;
import WorkCode.TooManyMembersException;

public class VetrofonBand extends Orchestra implements BaseMusicBand {

    boolean drunk;

    public VetrofonBand(int count_of_members, String type_music, boolean type_local, boolean popularity, boolean drunk) throws InvalidVetrofonBandException {

        super(count_of_members, type_music, type_local, popularity);
        this.drunk = drunk;

        if (count_of_members > 10) { throw new TooManyMembersException("Число участников слишком велико! " + count_of_members); }

        if (!BandTypes.contains(type_music)) { throw new InvalidVetrofonBandException("Выбран несуществующий жанр музыки!"); }

    }

    public void rentAuto() {

        if (super.popularity)
        {
            System.out.println("Группу Ветрофон отвезли бесплатно, они популарити\n");

        } else if (!super.popularity) {
            
            System.out.println("Группу Ветрофон отвезли платно, они НЕ популарити\n");
            
        }

    }

    @Override
    public void goTo(Street[] streets) {

        if (super.popularity)
        {

            if (!drunk) {
                for (int i = 0; i < streets.length; i++) 
                {

                    if (streets[i].name().equals("RedSquare")) 
                    {
                        streets[i] = new Street(true, streets[i].name());
                        System.out.println("Группа Ветрофон направилась на RedSquare\n");
                        streets[i].closeStreet("RedSquare");
                        rentAuto();
                        break;
                    }

                }

            } else {

                for (int i = 0; i < streets.length; i++) 
                {

                    if (streets[i].name().equals("BlueSquare")) 
                    {
                        streets[i] = new Street(true, streets[i].name());
                        System.out.println("Группа Ветрофон направилась на BlueSquare\n");
                        streets[i].closeStreet("BlueSquare");
                        rentAuto();
                        break;
                    }

                }

            }

        } else if (!super.popularity)
        {

            if (!drunk) {
                for (int i = 0; i < streets.length; i++) 
                {

                    if (streets[i].name().equals("GreenSquare")) 
                    {
                        streets[i] = new Street(true, streets[i].name());
                        System.out.println("Группа Ветрофон направилась на GreenSquare\n");
                        streets[i].closeStreet("GreenSquare");
                        rentAuto();
                        break;
                    }

                }

            } else {

                for (int i = 0; i < streets.length; i++) 
                {

                    if (streets[i].name().equals("YellowSquare")) 
                    {
                        streets[i] = new Street(true, streets[i].name());
                        System.out.println("Группа Ветрофон направилась на YellowSquare\n");
                        streets[i].closeStreet("YellowSquare");
                        rentAuto();
                        break;
                    }

                }

            }

        }

    }

    @Override
    public String toString() 
    {
        return "VetrofonBand{name='" + "Ветрофон" + "', type='" + type_local + "', popularity=" + popularity + "}";
    }

}
