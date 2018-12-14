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
    final Button openMultipleButton = new Button("Charger niveaux...");
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
            controleur.move(code);
        };
        reset = new Button("Reset");
        reset.setOnAction(new ActionReset());
        chose = new Button("Ok");
        chose.setOnAction(new ActionChoose());
        openMultipleButton.setOnAction(new ActionLoadFiles());
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
            if(value.substring(value.length()-2).charAt(0)==' ')
                i=Integer.parseInt(value.substring(value.length()-1));
            else
                i=Integer.parseInt(value.substring(value.length()-2));
            vue.resetCanvas();
            controleur.chargerNiveau(i-1);
        }

    }




}