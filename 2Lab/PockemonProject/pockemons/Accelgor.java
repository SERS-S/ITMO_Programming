package pockemons;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Accelgor extends Shelmet {

    public Accelgor(String name, int level) {

        super(name, level);
        setStats(80, 70, 40, 100, 60, 145);
        addMove(new Agility());

    }

}