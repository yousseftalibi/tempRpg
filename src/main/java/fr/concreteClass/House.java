package fr.concreteClass;

import lombok.Getter;
import lombok.Setter;

public class House {

    @Getter
    @Setter
    private final String houseName;
    @Getter
    @Setter
    private final int potions_power;
    @Getter
    @Setter
    private final int damage;
    @Getter
    @Setter
    private final int domage_resistance;
    @Getter
    @Setter
    private final int précision;

    public House(String houseName, int potions_power, int damage, int domage_resistance, int précision) {
        this.houseName = houseName;
        this.potions_power = potions_power;
        this.damage = damage;
        this.domage_resistance = domage_resistance;
        this.précision = précision;
    }

    public House(House house){
        this.houseName = house.getHouseName();
        this.potions_power = house.getPotions_power();
        this.damage = house.getDamage();
        this.domage_resistance = house.getDomage_resistance();
        this.précision = house.getPrécision();
    }

    @Override
    public String toString() {
        return "House{" +
            "houseName='" + houseName + '\'' +
            ", potions_power=" + potions_power +
            ", damage=" + damage +
            ", domage_resistance=" + domage_resistance +
            ", précision=" + précision +
            '}';
    }
}
