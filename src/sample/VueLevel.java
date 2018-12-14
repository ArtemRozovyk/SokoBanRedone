package sample;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VueLevel {
    CommandeTabInt commandeGetEtat;
    CommandeGetL commandeGetL;
    ComboBox comboBox;

    public VueLevel (Controleur controleur) throws FileNotFoundException {
        commandeGetEtat = controleur.commandeGetEtat();
        commandeGetL=controleur.commandeGetL();
        comboBox = new ComboBox();
        for (int i = 1; i < commandeGetL.exec().size()+1; i++) {
            comboBox.getItems().add("Choice "+i);
        }



    }




}
