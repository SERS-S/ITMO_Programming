package ShortySection;

public class ShortyMusician extends ShortyShow implements Musician {

    protected String an_instrument;

    public ShortyMusician(boolean drunk, String an_instrument) {
        super(drunk);
        this.an_instrument = an_instrument;
    }

    public void play_an_instrument(String nameGroup) {

        System.out.println("Коротыш группы " + nameGroup + " начал играть на инструменте со звуком " + an_instrument);
        
    }

}