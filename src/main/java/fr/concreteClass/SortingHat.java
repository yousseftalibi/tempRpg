package fr.concreteClass;

public class SortingHat {

    public static House assign_house(){
        String[] houses = {"Hufflepuff", "Slytherin", "Gryffindor", "Ravenclaw"};
        int i = (int) (Math.random() * 4);
        switch (i){
            case 0:
                return new House(houses[i], 2, 1, 1, 1);
            case 1:
                return new House(houses[i], 1, 2, 1, 1);
            case 2:
                return new House(houses[i], 1, 1, 2, 1);
            case 3:
                return new House(houses[i], 1, 1, 1,2);
            default:
                return new House(houses[2], 1, 1, 2, 1);
        }
    }
}
