package moves;

import ru.ifmo.se.pokemon.*;

public final class SwordsDance extends StatusMove {

    public SwordsDance() {

        super(Type.NORMAL, 0, 0);

    }

    @Override
    protected void applySelfEffects(Pokemon p) {

        p.addEffect(new Effect().stat(Stat.ATTACK, +2));

    }

    @Override
    protected String describe() {

        return "использует Swords Dance";

    }
    
}