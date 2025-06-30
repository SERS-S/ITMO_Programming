package moves;

import ru.ifmo.se.pokemon.*;

public final class Moonblast extends SpecialMove {

    public Moonblast() {

        super(Type.FAIRY, 95, 100);

    }

    @Override
    protected void applyOppEffects(Pokemon p) {

        if (Math.random() <= 0.3) {

            p.addEffect(new Effect().stat(Stat.SPECIAL_ATTACK, -1));

        }

    }

    @Override
    protected String describe() {

        return "использует Moonblast";

    }
    
}
