import ru.ifmo.se.pokemon.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import pockemons.*;


public class Main {

    public static void main(String[] arg) {

        if ((arg.length == 0) || Arrays.stream(arg).allMatch(element -> element.contains("Ally") && !element.contains("Foe")) || Arrays.stream(arg).allMatch(element -> element.contains("Foe") && !element.contains("Ally"))) {

            System.out.println("System antipolupoker activated\nEmpty | Curved input massive!");

        } else {

            Battle fight = new Battle();

            for (int i = 0; i < arg.length; i++) {

                if (arg[i].contains("Diencie")) {

                    String[] divided = arg[i].split("_");
                    Diancie a1 = new Diancie("Diencie", Integer.parseInt(divided[1]));
                    if ("Ally".equals(divided[2])) {

                        fight.addAlly(a1);

                    } else if ("Foe".equals(divided[2])) {

                        fight.addFoe(a1);

                    }

                } else if (arg[i].contains("Shelmet")) {

                    String[] divided = arg[i].split("_");
                    Shelmet a2 = new Shelmet("Shelmet", Integer.parseInt(divided[1]));
                    if ("Ally".equals(divided[2])) {

                        fight.addAlly(a2);

                    } else if ("Foe".equals(divided[2])) {

                        fight.addFoe(a2);

                    }

                } else if (arg[i].contains("Accelgor")) {
                    
                    String[] divided = arg[i].split("_");
                    Accelgor a3 = new Accelgor("Accelgor", Integer.parseInt(divided[1]));
                    if ("Ally".equals(divided[2])) {

                        fight.addAlly(a3);

                    } else if ("Foe".equals(divided[2])) {

                        fight.addFoe(a3);
                    }

                } else if (arg[i].contains("Oddish")) {

                    String[] divided = arg[i].split("_");
                    Oddish a4 = new Oddish("Oddish", Integer.parseInt(divided[1]));
                    if ("Ally".equals(divided[2])) {

                        fight.addAlly(a4);
                    } else if ("Foe".equals(divided[2])) {

                        fight.addFoe(a4);

                    }

                } else if (arg[i].contains("Gloom")) {

                    String[] divided = arg[i].split("_");
                    Gloom a5 = new Gloom("Gloom", Integer.parseInt(divided[1]));
                    if ("Ally".equals(divided[2])) {

                        fight.addAlly(a5);

                    } else if ("Foe".equals(divided[2])) {

                        fight.addFoe(a5);

                    }

                } else if (arg[i].contains("Vileplume")) {

                    String[] divided = arg[i].split("_");
                    Vileplume a6 = new Vileplume("Vileplume", Integer.parseInt(divided[1]));
                    if ("Ally".equals(divided[2])) {

                        fight.addAlly(a6);

                    } else if ("Foe".equals(divided[2])) {

                        fight.addFoe(a6);

                    }

                }

            }

            fight.go();

        }

    }
    
}