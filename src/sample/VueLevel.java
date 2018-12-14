package sample;

import javafx.scene.control.ComboBox;

import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;

public class VueLevel {
    CommandeTabInt commandeGetEtat;
    CommandeGetL commandeGetL;
    ComboBox comboBox;
    final FileChooser fileChooser = new FileChooser();

    public VueLevel (Controleur controleur)  {
        commandeGetEtat = controleur.commandeGetEtat();
        commandeGetL=controleur.commandeGetL();
        comboBox = new ComboBox();
        for (int i = 1; i < commandeGetL.exec().size()+1; i++) {
            comboBox.getItems().add("Choice "+i);
        }

        fileChooser.setTitle("Chose files");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("XSB", "*.xsb")
        );



    }




}
