package WorkCode;

import java.util.Random;
import java.util.ArrayList;

import BandSection.*;
import ShortySection.*;
import StreetSection.*;

public class CreateObjects {

    public static SomeOtherGroup[] generateSomeLocalBands() {

        int count = new Random().nextInt(5) + 1;
        ArrayList<String> bandArray = new ArrayList<>();

        SomeOtherGroup[] stackBands = new SomeOtherGroup[count];

        for (int i = 0; i < count; ++i) 
        {

            BandTypes[] types = BandTypes.values();

            stackBands[i] = new SomeOtherGroup(
                (new Random().nextInt(10) + 1), 
                types[(new Random().nextInt(types.length))].name(), 
                false, 
                (i % 2 == 0),
                ("Группа номер " + i)
            );
            bandArray.add("Группа номер " + i);

        }

        System.out.println("В городе появились следуюшие группы: " + bandArray);

        return stackBands;

    }

    public static ShortyMusician[][] generateShortyMusician(int VetrofonCount_of_members, int bandListLength) {

        ShortyMusician[][] stackShortyBands = new ShortyMusician[bandListLength + 1][];
        InstrumentList[] types = InstrumentList.values();

        for (int j = 0; j < bandListLength + 1; ++j) 
        {

            int innerArrayLength;
            if (j == 0) {innerArrayLength = VetrofonCount_of_members;}
            else {innerArrayLength = new Random().nextInt(11) + 1;}
            stackShortyBands[j] = new ShortyMusician[innerArrayLength];

            for (int jj = 0; jj < innerArrayLength; ++jj) 
            {

                stackShortyBands[j][jj] = new ShortyMusician(
                    (jj % 2 == 0), 
                    types[(new Random().nextInt(types.length))].name()
                    );

            }

        }

        return stackShortyBands;
        
    }

    public static Street[] generateStreets() {

        Street[] streets = new Street[6];
        StreetList[] streetNames = StreetList.values();

        for (int i = 0; i < 6; i++) 
        {

            String randomStreetName = streetNames[new Random().nextInt(streetNames.length)].name();
            streets[i] = new Street(false, randomStreetName);

        }

        return streets;

    }
    
}
