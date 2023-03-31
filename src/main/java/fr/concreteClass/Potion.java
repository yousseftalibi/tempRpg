package fr.concreteClass;

import lombok.Getter;

import java.util.Random;

public class Potion {

    @Getter
    private final double health_marck_gain;

    public Potion() {
        this.health_marck_gain = new Random().nextInt(15);
    }
}
