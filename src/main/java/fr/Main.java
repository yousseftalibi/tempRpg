package fr;

import fr.abstractClass.AbstractEnemy;
import fr.concreteClass.*;
import fr.enumClass.Core;
import fr.enumClass.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Harry Potter at Home, the wizarding RPG. Do you have what it takes to be the greatest\n" +
            "wizards? Can you meet all the challenges? Let's get started!\n" +
            "Your goal is to complete your education at Hogwarts. Each year will be filled with challenges.");
        Scanner sc = new Scanner(System.in);
        Wizard wizard = new Wizard("Cabrel",Pet.CAT,new Wand(30, Core.PHOENIX_FEATHER));

        do {
            switch (wizard.getLevel()){
                case 1:
                    level1(wizard, sc);
                    break;
                case 2:
                    level2(wizard, sc);
                    break;
                case 3:
                    level3(wizard, sc);
                    break;
                case 4:
                    level4(wizard, sc);
                    break;
                case 5:
                    level5(wizard, sc);
                    break;
                case 6:
                    level6(wizard, sc);
                    break;
                case 7:
                    level7(wizard, sc);
                    break;
                default:
                    System.out.println("Congratulations on your graduation \uD83C\uDF89!");
            }
        }while (wizard.getLevel() < 8);
    }

    static void level1( Wizard wizard, Scanner sc ){
        System.out.println("Welcome to Hogwarts " + wizard.getName());
        System.out.println("You are you are currently at level " + wizard.getLevel());
        System.out.println("Are you ready to continue? ");
        sc.nextLine();
        Enemy troll = new Enemy("Troll");
        boolean retry = true;
        System.out.println("Notice: Use Wingardium Leviosa to make objects\n" + "to drop objects on the troll's head!");
        System.out.println("You will learn a new spell, the Wingardium Leviosa!");
        System.out.println("press enter for a new attempt!");
        for(int i = 0; i< 5; i++){
            System.out.println("You are almost there, one more attempt");
            sc.nextLine();
        }
        wizard.setKnownSpells(new Spell("Wingardium Leviosa", 60));
        System.out.println("Congratulations, you have a new spell, it will be very useful for the rest of the adventure");
        System.out.println("It's time for you to face the dungeon toilet troll");
        while (retry){
            do {
                System.out.println("Wingardium Leviosa");
                sc.nextLine();
                wizard.attack(troll);
                troll.attack(wizard);
            }while(troll.getDomage_marck() < troll.getHealth_marck() && wizard.getHealth_marck() > wizard.getDomage_marck());
            if (troll.getDomage_marck() < troll.getHealth_marck()) {
                System.out.println("Game over!");
                troll.setDomage_marck(0);
                System.out.println("Do you want to play again? 0/1 (1 for yes or 0 for NO)");
                if(sc.nextInt() == 0) {
                    wizard.setDomage_marck(0);
                    retry = false;
                }

            }else {
                wizard.setLevel();
                wizard.setDomage_marck(0);
                System.out.println("Level 2 unlocked \uD83C\uDF89!");
                retry = false;
            }
        }
    }
    static void level2( Wizard wizard, Scanner sc  ){
        System.out.println("Welcome back to Hogwarts " + wizard.getName());
        System.out.println("You are you are currently at level " + wizard.getLevel());
        System.out.println("Are you ready to continue? ");
        sc.nextLine();
        Enemy basilic = new Enemy("Basilic");
        boolean retry = true;while (retry){
            do {
                System.out.println("Attact the basilic ");
                sc.nextLine();
                wizard.attack(basilic);
                basilic.attack(wizard);
            }while(basilic.getDomage_marck() < basilic.getHealth_marck() && wizard.getHealth_marck() > wizard.getDomage_marck());
            if (basilic.getDomage_marck() < basilic.getHealth_marck()) {
                System.out.println("Game over!");
                basilic.setDomage_marck(0);
                System.out.println("Do you want to play again? 0/1 (1 for yes or 0 for NO)");
                if(sc.nextInt() == 0) {
                    wizard.setDomage_marck(0);
                    retry = false;
                }
            }else {
                wizard.setLevel();
                wizard.setDomage_marck(0);
                System.out.println("Level 3 unlocked \uD83C\uDF89!");
                retry = false;
            }
        }
    }
    static void level3( Wizard wizard, Scanner sc  ){
        System.out.println("Welcome back to Hogwarts " + wizard.getName());
        System.out.println("You are you are currently at level " + wizard.getLevel());
        System.out.println("Are you ready to continue? ");
        sc.nextLine();
        System.out.println("Notice: Use your Patronus ( Expecto\n" +
            "Patronum) to put the Destroyers\n" +
            "on the run!");
        System.out.println("You will learn a new spell, the Expecto Patronum!");
        System.out.println("press enter for a new attempt!");
        for(int i = 0; i< 5; i++){
            System.out.println("You are almost there, one more attempt");
            sc.nextLine();
        }
        wizard.setKnownSpells(new Spell("Expecto Patronum", 75));
        List<AbstractEnemy> detachers = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            detachers.add(new Enemy("Detachers " + (i+1) ));
        }
        boolean retry = true;while (retry){
            long startTime = System.currentTimeMillis();
            do {
                System.out.println("Expecto Patronum");
                sc.nextLine();
                int i = (int) (Math.random() * detachers.size());
                wizard.attack(detachers.get(i));
                if (detachers.get(i).getDomage_marck() > detachers.get(i).getHealth_marck())
                    detachers.remove(i);
            }while(!detachers.isEmpty() && (System.currentTimeMillis() - startTime) != 30000);
            if (!detachers.isEmpty()) {
                System.out.println("Game over!");
                System.out.println("Do you want to play again? 0/1 (1 for yes or 0 for NO)");
                if(sc.nextInt() == 0) {
                    wizard.setDomage_marck(0);
                    retry = false;
                }
            }else {
                wizard.setLevel();
                wizard.setDomage_marck(0);
                System.out.println("Level 4 unlocked \uD83C\uDF89!");
                retry = false;
            }
        }
    }
    static void level4( Wizard wizard, Scanner sc  ){
        System.out.println("Welcome back to Hogwarts " + wizard.getName());
        System.out.println("You are you are currently at level " + wizard.getLevel());
        System.out.println("Are you ready to continue? ");
        sc.nextLine();
        AbstractEnemy Voldemort = new Boss("Voldemort");
        AbstractEnemy Peter_Pettigrow = new Boss("Peter Pettigrow");
        boolean retry = true;while (retry){
            do {
                System.out.println("Wingardium Leviosa");
                sc.nextLine();
                wizard.attack(Voldemort);
                Voldemort.attack(wizard);
                wizard.attack(Peter_Pettigrow);
                Peter_Pettigrow.attack(wizard);
            }while(Voldemort.getDomage_marck() < Voldemort.getHealth_marck() && Peter_Pettigrow.getDomage_marck() < Peter_Pettigrow.getHealth_marck() && wizard.getHealth_marck() > wizard.getDomage_marck());
            if (Voldemort.getDomage_marck() < Voldemort.getHealth_marck()) {
                System.out.println("Game over!");
                Voldemort.setDomage_marck(0);
                Peter_Pettigrow.setDomage_marck(0);
                System.out.println("Do you want to play again? 0/1 (1 for yes or 0 for NO)");
                if(sc.nextInt() == 0) {
                    wizard.setDomage_marck(0);
                    retry = false;
                }
            }else {
                wizard.setLevel();
                wizard.setDomage_marck(0);
                System.out.println("Level 5 unlocked \uD83C\uDF89!");
                retry = false;
            }
        }
    }
    static void level5( Wizard wizard, Scanner sc  ){
        System.out.println("Welcome back to Hogwarts " + wizard.getName());
        System.out.println("You are you are currently at level " + wizard.getLevel());
        System.out.println("Are you ready to continue? ");
        sc.nextLine();
        AbstractEnemy Dolores_Ombrage = new Boss("Dolores Ombrage");
        boolean retry = true;while (retry){
            do {
                System.out.println("Wingardium Leviosa");
                sc.nextLine();
                wizard.attack(Dolores_Ombrage);
                Dolores_Ombrage.attack(wizard);
            }while(Dolores_Ombrage.getDomage_marck() < Dolores_Ombrage.getHealth_marck() && wizard.getHealth_marck() > wizard.getDomage_marck());
            if (Dolores_Ombrage.getDomage_marck() < Dolores_Ombrage.getHealth_marck()) {
                System.out.println("Game over!");
                Dolores_Ombrage.setDomage_marck(0);
                System.out.println("Do you want to play again? 0/1 (1 for yes or 0 for NO)");
                if(sc.nextInt() == 0) {
                    wizard.setDomage_marck(0);
                    retry = false;
                }
            }else {
                wizard.setLevel();
                wizard.setDomage_marck(0);
                System.out.println("Level 6 unlocked \uD83C\uDF89!");
                retry = false;
            }
        }
    }
    static void level6( Wizard wizard, Scanner sc  ){
        System.out.println("Welcome back to Hogwarts " + wizard.getName());
        System.out.println("You are you are currently at level " + wizard.getLevel());
        System.out.println("Are you ready to continue? ");
        sc.nextLine();
        AbstractEnemy Mangemorts = new Boss("Mangemorts");
        boolean retry = true;while (retry){
            do {
                System.out.println("Wingardium Leviosa");
                sc.nextLine();
                wizard.attack(Mangemorts);
                Mangemorts.attack(wizard);
            }while(Mangemorts.getDomage_marck() < Mangemorts.getHealth_marck() && wizard.getHealth_marck() > wizard.getDomage_marck());
            if (Mangemorts.getDomage_marck() < Mangemorts.getHealth_marck()) {
                System.out.println("Game over!");
                Mangemorts.setDomage_marck(0);
                System.out.println("Do you want to play again? 0/1 (1 for yes or 0 for NO)");
                if(sc.nextInt() == 0) {
                    wizard.setDomage_marck(0);
                    retry = false;
                }
            }else {
                wizard.setLevel();
                wizard.setDomage_marck(0);
                System.out.println("Level 7 unlocked \uD83C\uDF89!");
                retry = false;
            }
        }
    }
    static void level7(  Wizard wizard, Scanner sc  ){
        System.out.println("Welcome back to Hogwarts " + wizard.getName());
        System.out.println("You are you are currently at level " + wizard.getLevel());
        System.out.println("Are you ready to continue? ");
        sc.nextLine();
        AbstractEnemy Voldemort = new Boss("Voldemort");
        AbstractEnemy Bellatrix_Lestrange = new Boss("Bellatrix Lestrange");
        boolean retry = true;while (retry){
            do {
                System.out.println("Wingardium Leviosa");
                sc.nextLine();
                wizard.attack(Voldemort);
                Voldemort.attack(wizard);
                wizard.attack(Bellatrix_Lestrange);
                Bellatrix_Lestrange.attack(wizard);
            }while(Voldemort.getDomage_marck() < Voldemort.getHealth_marck() && Bellatrix_Lestrange.getDomage_marck() < Bellatrix_Lestrange.getHealth_marck() && wizard.getHealth_marck() > wizard.getDomage_marck());
            if (Voldemort.getDomage_marck() < Voldemort.getHealth_marck()) {
                System.out.println("Game over!");
                Voldemort.setDomage_marck(0);
                Bellatrix_Lestrange.setDomage_marck(0);
                System.out.println("Do you want to play again? 0/1 (1 for yes or 0 for NO)");
                if(sc.nextInt() == 0) {
                    wizard.setDomage_marck(0);
                    retry = false;
                }
            }else {
                wizard.setLevel();
                wizard.setDomage_marck(0);
                System.out.println("Congratulations on your graduation \uD83C\uDF89!");
                retry = false;
            }
        }
    }
}
