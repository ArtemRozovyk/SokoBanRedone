package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ControleurIHMFX {
    Controleur controleur;

    VueIHMFX vue;
    VueLevel vueLevel;
    Button reset;
    Button chose;
    Button nextLevel;
    Button prevLevel;
    Button openMultipleButton ;
    Button undo;
    Button redo;
    Stage primaryStage;

    EventHandler<Event>event;


    ControleurIHMFX(Controleur controleur, VueIHMFX vue, VueLevel vueLevel, Stage primaryStage) {
        this.controleur = controleur;
        this.vue = vue;
        this.vueLevel=vueLevel;
        this.primaryStage=primaryStage;

        event= event -> {
            //获取键码
            KeyEvent ke = (KeyEvent) event;
            //强转
            KeyCode code = ke.getCode();
            String direction="";
            switch (code){
                case UP:
                    direction = "u";
                    break;
                case DOWN:
                    direction = "d";
                    break;
                case LEFT:
                    direction = "l";
                    break;
                case RIGHT:
                    direction = "r";
                    break;
            }
            controleur.executeCommand(new CommandMove(controleur.facadeModele,direction));
        };

        chose = new Button("Ok");
        nextLevel=new Button("NextLevel");
        prevLevel=new Button("PrevLevel");
        openMultipleButton = new Button("Charger niveaux...");
        reset = new Button("Reset");
        undo=new Button("Undo");
        redo=new Button("Redo");
        reset.setOnAction(new ActionReset());
        chose.setOnAction(new ActionChoose());
        openMultipleButton.setOnAction(new ActionLoadFiles());
        nextLevel.setOnAction(new ActionNext());
        prevLevel.setOnAction(new ActionPrev());
        undo.setOnAction(new ActionUndo());
        redo.setOnAction(new ActionRedo());
    }



    public int getLevelNumber(String value){
        int i;
        if(value.substring(value.length()-2).charAt(0)==' ')
            i=Integer.parseInt(value.substring(value.length()-1));
        else
            i=Integer.parseInt(value.substring(value.length()-2));
        return i;
    }

    class ActionReset implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            vue.resetCanvas();
            controleur.reset();
        }

    }
    class ActionLoadFiles implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            List<File> list =
                    vueLevel.fileChooser.showOpenMultipleDialog(primaryStage);
            if (list != null) {
                for (File file : list) {
                    controleur.AddLevel(file.getAbsolutePath());
                }
            }
        }

    }

    class ActionChoose implements EventHandler<ActionEvent> {

        public void handle(ActionEvent event) {
            int i;
            String value = (String) vueLevel.comboBox.getValue();
            i=getLevelNumber(value);
            vueLevel.label.setText(value);
            vue.resetCanvas();
            controleur.chargerNiveau(i-1);

        }

    }
    class ActionPrev implements EventHandler<ActionEvent> {

        public void handle(ActionEvent event) {
            int i;
            String value =vueLevel.label.getText();
            i=getLevelNumber(value);
            if(i==1)return;
            vue.resetCanvas();
            controleur.chargerNiveau(i-2);
            controleur.notifie();
        }

    }
    class ActionUndo implements EventHandler<ActionEvent> {

        public void handle(ActionEvent event) {
            controleur.undo();
        }

    }
    class ActionRedo implements EventHandler<ActionEvent> {

        public void handle(ActionEvent event) {
           controleur.redo();
        }

    }
    class ActionNext implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            int i;
            String value =vueLevel.label.getText();
            i=getLevelNumber(value);
            vue.resetCanvas();
            controleur.chargerNiveau(i);
            controleur.notifie();

        }

    }




}