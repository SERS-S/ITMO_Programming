package moves;

import ru.ifmo.se.pokemon.*;

public final class Absorb extends SpecialMove {

    public Absorb() {

        super(Type.GRASS, 20, 100);

    }

    @Override
    protected void applySelfDamage(Pokemon att, double damage) {

        att.setMod(Stat.HP, (int) (-damage / 2));

    }

    @Override
    protected String describe() {

        return "использует Absorb";
        
    }
    
}