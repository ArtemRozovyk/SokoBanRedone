package sample;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VueLevel {
    CommandeTabInt commandeGetEtat;
    Button[] myButton;
    GridPane gridPane = new GridPane();

    Image[] chameau = new Image[]{ new Image(new FileInputStream(
            "1.png"),80,80,false,false),
            new Image(new FileInputStream(
                    "2.png"),80,80,false,false),
            new Image(new FileInputStream(
                    "3.png"),80,80,false,false)};


    public VueLevel (Controleur controleur) throws FileNotFoundException {
        commandeGetEtat = controleur.commandeGetEtat();
        myButton = new Button[commandeGetEtat.exec().length];
        for (int i=0;i<commandeGetEtat.exec().length;i++) {
            myButton[i] = new Button();
            myButton[i].setMinSize(80,80);
            gridPane.add(myButton[i],i,0);
        }
        dessine();
    }

    public void dessine() {
        for (int i=0;i<3;i++) {
            myButton[i].setGraphic(new ImageView(chameau[i]));
        }
    }
}
