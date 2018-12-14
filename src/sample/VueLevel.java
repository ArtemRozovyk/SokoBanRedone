package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.util.ArrayList;

public class VueLevel {
    CommandeAuthors commandeAuthors;
    CommandeCurrentLevelInt commandeCurrentLevelInt;
    ComboBox comboBox;
    ArrayList<String> authors;
    final FileChooser fileChooser = new FileChooser();
    Label label ;
    int levelNumber;


    public VueLevel (Controleur controleur)  {
        label=new Label();
        commandeCurrentLevelInt=controleur.commandeCurrentLevelInt();
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
        levelNumber=commandeCurrentLevelInt.exec();
        authors=commandeAuthors.exec();
        ObservableList<String> list=comboBox.getItems();
        int x=1;
        for (String nameA : authors){
            if(x==levelNumber)
                if(!nameA.substring(0,3).equals("MIC"))
                    label.setText(nameA+" "+x);
                else
                    label.setText(nameA);
            if(!nameA.substring(0,3).equals("MIC") && !comboBox.getItems().contains(nameA+" "+x)){
                list.add(nameA+" "+x);
            }
            x++;
        }
        comboBox.setItems(list);
    }


}
