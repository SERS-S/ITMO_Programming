import BandSection.*;
import ShortySection.*;
import StreetSection.*;
import WorkCode.*;

public class Main {

    public static void main(String[] args) {

        try
        {

            VetrofonBand vetrofon = new VetrofonBand(10, "Pop", true, true, false);

            SomeOtherGroup[] stackBands = CreateObjects.generateSomeLocalBands();
            ShortyMusician[][] stackShortyBands = CreateObjects.generateShortyMusician(vetrofon.count_of_members, stackBands.length);

            Street[] streets = CreateObjects.generateStreets();

            // Начало действий

            vetrofon.goTo(streets);
            for (int i = 0; i < stackBands.length; ++i) {stackBands[i].goTo(streets);}

            vetrofon.playMusic(
                "Ветрофон", 
                stackShortyBands[0], 
                vetrofon.type_local, 
                vetrofon.count_of_members, 
                vetrofon.popularity
                );
            for (int i = 1; i < stackBands.length; ++i) 
            {
                stackBands[i].playMusic(
                    stackBands[i].name, 
                    stackShortyBands[i], 
                    stackBands[i].type_local, 
                    stackBands[i].count_of_members, 
                    stackBands[i].popularity
                    );
            }

        } catch (TooManyMembersException e) {

            System.out.println("Обнаружено unchecked исключение: " + e.getMessage());

        } catch (InvalidVetrofonBandException e)
        {

            System.err.println("Ошибка создания объекта VetrofonBand: " + e.getMessage());

        }

        
    }

}