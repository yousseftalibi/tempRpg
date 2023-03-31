package fr.concreteClass;

import fr.abstractClass.AbstractEnemy;
import fr.abstractClass.Character;
import fr.enumClass.Pet;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Wizard extends Character {

    public Wizard(String name, Pet pet, Wand wand) {
        super(name);
        this.pet = pet;
        this.wand = new Wand(wand);
        this.house = new House(SortingHat.assign_house());
        this.knownSpells = new ArrayList<>();
        this.potions = new ArrayList<>();
    }

    @Override
    public String toString() {
        return  super.toString() + "Wizard{" +
            "pet=" + pet +
            ", wand=" + wand +
            ", house=" + house +
            ", knownSpells=" + knownSpells +
            ", potions=" + potions +
            "} ";
    }

    public void defend(){
        if (!this.potions.isEmpty()){
            double plus = this.potions.get(this.potions.size()-1).getHealth_marck_gain();
            if((this.getHealth_marck() + plus) > 50.0)
                this.setHealth_marck(50.0);
            else
                this.setHealth_marck(this.getHealth_marck() + plus);
        }
    }

    @Override
    public void attack(Character c) {
        if (this instanceof Wizard){
            Scanner sc = new Scanner(System.in);
            switch (this.getLevel()) {
                case 1:
                    c.setDomage_marck(c.getDomage_marck() + this.getNewHealth_marck(10.0, this.knownSpells.get(0)));
                    System.out.println("You have inflicted a damage of " + c.getDomage_marck() + " life points" );
                    break;
                case 2:
                    if(this.getHouse().getHouseName().equals("Gryffindor")){
                        System.out.println("Ah Ah you are from you have access to the Sword of Griffondor");
                        c.setDomage_marck(c.getDomage_marck() + 50.0);
                    }else {
                        System.out.println( this.getNewHealth_marck(10.0, this.knownSpells.get(0)));
                        c.setDomage_marck(c.getDomage_marck() + this.getNewHealth_marck(10.0, this.knownSpells.get(0)));
                    }
                    System.out.println("You have inflicted a damage of " + c.getDomage_marck() + " life points" );
                    break;
                case 3:
                    c.setDomage_marck(c.getDomage_marck() + this.getNewHealth_marck(30.0, this.knownSpells.get(1)));
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Congratulations on your graduation \uD83C\uDF89!");
            }
        }else {
            System.out.println("not wizard");
        }
  }

    private double getNewHealth_marck(double domage, Spell spell){
        double succes_rate_precision;
        if(spell.getSuccess_rate() * this.house.getPrécision() >= 100.0)
            succes_rate_precision = 1;
        else
            succes_rate_precision = (spell.getSuccess_rate() * this.house.getPrécision()) /100.0;
       return (domage * succes_rate_precision * this.house.getDamage());
    }
    public void setKnownSpells(Spell spell) {
        this.knownSpells.add(spell);
    }

    public void setPotions(Potion potion) {
        this.potions.add(potion);
    }

    @Getter
    @Setter
    private Pet pet;
    @Getter
    @Setter
    private Wand wand;
    @Getter
    @Setter
    private House house;
    @Getter
    @Setter
    private List<Spell> knownSpells;
    @Getter
    @Setter
    private List<Potion> potions;
}
