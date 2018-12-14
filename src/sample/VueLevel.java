package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.stage.FileChooser;

import java.util.ArrayList;

public class VueLevel {
    CommandeAuthors commandeAuthors;
    ComboBox comboBox;
    ArrayList<String> authors;
    final FileChooser fileChooser = new FileChooser();

    public VueLevel (Controleur controleur)  {
        commandeAuthors=controleur.commandeAuthors();
        comboBox = new ComboBox();
        authors=commandeAuthors.exec();
        for (String nameA : authors)
            comboBox.getItems().add(nameA);

        fileChooser.setTitle("Chose files");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("XSB", "*.xsb")
        );



    }


    public void miseAjourListe() {
        authors=commandeAuthors.exec();
        ObservableList<String> list=comboBox.getItems();
        int x=1;
        for (String nameA : authors){
            if(!nameA.substring(0,3).equals("MIC") && !comboBox.getItems().contains(nameA+" "+x))
                list.add(nameA+" "+x);
            x++;
        }

         comboBox.setItems(list);
    }
}
