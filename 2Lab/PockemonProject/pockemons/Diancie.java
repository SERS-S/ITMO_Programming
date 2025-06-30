package pockemons;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Diancie extends Pokemon {

    public Diancie(String name, int level) {

        super(name, level);
        setType(Type.ROCK, Type.FAIRY);
        setStats(50, 100, 150, 100, 150, 50);
        setMove(new Psychic(), new AncientPower(), new RockPolish(), new Moonblast());

    }

}