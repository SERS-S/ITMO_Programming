package moves;

import ru.ifmo.se.pokemon.*;

public final class AncientPower extends SpecialMove {

    public AncientPower() {

        super(Type.ROCK, 60, 100);

    }

    @Override
    protected void applySelfEffects(Pokemon p) {

        if (Math.random() <= 0.1) {

            Effect effect = new Effect().turns(1);
            effect.stat(Stat.ATTACK, 1);
            effect.stat(Stat.DEFENSE, 1);
            effect.stat(Stat.SPECIAL_ATTACK, 1);
            effect.stat(Stat.SPECIAL_DEFENSE, 1);
            effect.stat(Stat.SPEED, 1);
            p.addEffect(effect);

        }

    }

    @Override
    protected String describe() {

        return "использует Ancient Power";

    }

}