package fr.graphique;
import fr.concreteClass.Enemy;
import fr.concreteClass.Wand;
import fr.concreteClass.Wizard;
import fr.enumClass.Core;
import fr.enumClass.Pet;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;

public class graphique extends Application{
    ImagePattern background = new ImagePattern(new Image("background.jpg"));
    ImageView wizard = new ImageView(new Image("wizard.png"));
    ImageView enemy = new ImageView(new Image("enemy.png"));
    Button attack = new Button("Attack");
    Button defend = new Button("Defend");
    double W = 780, H = 300;
    Wand maWand = new Wand(10, Core.PHOENIX_FEATHER);
    Wizard monWizard = new Wizard( "Cabrel", Pet.CAT, maWand);
    Enemy unEnemie = new Enemy("Enemy");
    @Override
    public void start(Stage harryPotterStage)  {
        Group root = new Group();
        enemy.setLayoutX(500);
        enemy.setLayoutY(0);

        harryPotterStage.setTitle("Harry Potter Adventures!");
        attack.relocate(W / 2, 80);
        attack.relocate(W / 2, 140);
        defend.relocate(W / 2, 200);
        wizard.relocate(500, 25);
        enemy.relocate(30, 25);
        root.getChildren().addAll(wizard, enemy, attack, defend);

        attack.setOnMouseClicked(Event -> {
            //change la fonction attack pour prendre en compte qu'elle va être utilisée graphiquement et pas dans la console.
            monWizard.attack(unEnemie);
            attaquer();
        });

        defend.setOnMouseClicked(Event -> {
            monWizard.defend();
            defendre();
        });

        Scene harryPotterScene = new Scene(root, W, H);
        harryPotterScene.setFill(background);
        harryPotterStage.setScene(harryPotterScene);
        harryPotterStage.show();
    }
    private void defendre(){
        System.out.println("character a defendu");
        // change l'image ou la position, fait le traitement que tu veux après la défense du character
    }
    private void attaquer(){
        System.out.println("character a attaqué");
        // change l'image ou la position, fait le traitement que tu veux après lattaque du character
    }
    public static void main(String[] args) {
        launch(args);
    }
}
