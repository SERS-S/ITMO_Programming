package BandSection;

import StreetSection.Street;

public class SomeOtherGroup extends Orchestra implements BaseMusicBand {

    public String name;

    public SomeOtherGroup(int count_of_members, String type_music, boolean type_local, boolean popularity, String name) {

        super(count_of_members, type_music, type_local, popularity);
        this.name = name;
    }

    public void rentAuto() {

        if (super.popularity) 
        {
            System.out.println(name + " отвезли бесплатно, они популарити");

        } else if (!super.popularity) {

            System.out.println(name + " отвезли платно, они НЕ популарити");

        }

    }

    @Override
    public void goTo(Street[] streets) {

        if (super.popularity)
        {
            
            for (int i = 0; i < streets.length; i++) {
                if (!streets[i].full()) {
                    String CurrentStreetName = streets[i].name();
                    streets[i] = new Street(true, name);
                    System.out.println(name + " направилась на " + CurrentStreetName);
                    streets[i].closeStreet(name);
                    rentAuto();
                    break;
                }
            }

        } else if (!super.popularity)
        {

            for (int i = streets.length - 1; i >= 0; i--) {
                if (!streets[i].full()) {
                    String CurrentStreetName = streets[i].name();
                    streets[i] = new Street(true, name);
                    System.out.println(name + " направилась на " + CurrentStreetName);
                    streets[i].closeStreet(name);
                    rentAuto();
                    break;
                }
            }

        }

    }

    @Override
    public String toString() 
    {
        return "VetrofonBand{name='" + name + "', type='" + type_local + "', popularity=" + popularity + "}";
    }

}
