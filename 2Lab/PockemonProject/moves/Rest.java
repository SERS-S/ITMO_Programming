package moves;

import moves.*;
import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {
    
    public Rest() {

        super(Type.PSYCHIC, 0, 0);

    }

    @Override
    protected void applySelfEffects(Pokemon p) {

        p.setMod(Stat.HP, (int) (p.getStat(Stat.HP) - p.getHP()));
        Effect sleep = new Effect().condition(Status.SLEEP).turns(2);
        p.setCondition(sleep);

    }

    @Override
    protected String describe() {

        return "использует Rest";

    }
    
}