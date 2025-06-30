package pockemons;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Shelmet extends Pokemon {

    public Shelmet(String name, int level) {

        super(name, level);
        setType(Type.BUG);
        setStats(50, 40, 85, 40, 65, 25);
        setMove(new EnergyBall(), new BugBuzz(), new SludgeBomb());

    }

}