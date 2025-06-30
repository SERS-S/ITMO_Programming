package moves;

import ru.ifmo.se.pokemon.*;

public final class Psychic extends SpecialMove {

    public Psychic() {

        super(Type.PSYCHIC, 90, 100);

    }

    @Override
    protected void applyOppEffects(Pokemon p) {

        if (Math.random() <= 0.1) {

            p.addEffect(new Effect().stat(Stat.SPECIAL_DEFENSE, -1));

        }

    }

    @Override
    protected String describe() {

        return "использует Psychic";

    }
    
}
