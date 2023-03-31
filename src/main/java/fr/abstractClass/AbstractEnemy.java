package fr.abstractClass;

import fr.concreteClass.Boss;
import fr.concreteClass.Enemy;
import fr.concreteClass.Wizard;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public abstract class AbstractEnemy extends  Character{

    public AbstractEnemy(String name) {
        super(name);
    }


    @Override
    public void attack(Character c) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Le code à exécuter toutes les 1000 millisecondes
                if(getDomage_marck() >= getHealth_marck() || c.getDomage_marck() >= c.getHealth_marck())
                {
                    timer.cancel();
                }else {
                    System.out.println("The enemy has inflicted damage of " + c.getDomage_marck());
                    switch (getLevel()) {
                        case 1:
                            c.setDomage_marck(c.getDomage_marck() + 7);
                            if (c instanceof Wizard && new Random().nextInt(5) % 2 == 0) {
                                ((Wizard) c).defend();
                            }
                            break;
                        case 2:
                            c.setDomage_marck(c.getDomage_marck() + 9);
                            if (c instanceof Wizard && new Random().nextInt(5) % 2 == 0) {
                                ((Wizard) c).defend();
                            }
                            break;
                        case 4:
                            c.setDomage_marck(c.getDomage_marck() + 9);
                            if (c instanceof Wizard && new Random().nextInt(5) % 2 == 0) {
                                ((Wizard) c).defend();
                            }
                            break;
                        case 6:
                            c.setDomage_marck(c.getDomage_marck() + 10);
                            if (c instanceof Wizard && new Random().nextInt(5) % 2 == 0) {
                                ((Wizard) c).defend();
                            }
                            break;
                        case 7:
                            c.setDomage_marck(c.getDomage_marck() + 12);
                            if (c instanceof Wizard && new Random().nextInt(5) % 2 == 0) {
                                ((Wizard) c).defend();
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }, 0, 5000);

    }
}
