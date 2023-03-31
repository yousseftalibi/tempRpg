package fr.abstractClass;

import lombok.Getter;
import lombok.Setter;

public abstract class Character {

    protected Character(String name) {
        this.name = name;
        this.health_marck = 50;
        this.domage_marck = 0.0;
        this.level = 1;
    }

    public void setDomage_marck(double domage_marck) {
        this.domage_marck = domage_marck;
    }

    @Override
    public String toString() {
        return "Character{" +
            "name='" + name + '\'' +
            ", health_marck=" + health_marck +
            ", domage_marck=" + domage_marck +
            ", level=" + level +
            '}';
    }

    public void setLevel() {
        this.level++;
    }

    public abstract void attack(Character c);

    @Getter
    @Setter
    private final String name;
    @Getter
    @Setter
    private double health_marck;
    @Getter
    private double domage_marck;
    @Getter
    private int level;

}
