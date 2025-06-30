package moves;

import ru.ifmo.se.pokemon.*;

public final class RockPolish extends StatusMove {

    public RockPolish() {

        super(Type.ROCK, 0, 0);

    }

    @Override
    protected void applySelfEffects(Pokemon p) {

        p.addEffect(new Effect().stat(Stat.SPEED, 2));

    }

    @Override
    protected String describe() {

        return "использует Rock Polish";

    }
    
}
