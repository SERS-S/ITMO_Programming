package pockemons;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Oddish extends Pokemon {

    public Oddish(String name, int level) {

        super(name, level);
        setType(Type.GRASS, Type.POISON);
        setStats(45, 50, 55, 75, 65, 30);
        setMove(new Rest(), new SwordsDance());
        
    }

}