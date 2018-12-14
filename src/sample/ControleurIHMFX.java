package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControleurIHMFX {
    Controleur controleur;
    VueIHMFX vue;
    VueLevel vueLevel;
    Button reset;
    Button chose;

    EventHandler<Event>event;


    ControleurIHMFX(Controleur controleur, VueIHMFX vue, VueLevel vueLevel) {
        this.controleur = controleur;
        this.vue = vue;
        this.vueLevel=vueLevel;
        //ICI
        event=new EventHandler<Event>() {
            public void handle(Event event) {
                //获取键码
                KeyEvent ke = (KeyEvent) event;
                //强转
                KeyCode code = ke.getCode();


                controleur.move(code);
            }
        };
        for (int i = 0; i < 3; i++) {
            //vueLevel.myButton[i].setOnAction();
        }


        reset = new Button("Reset");
        reset.setOnAction(new ActionReset());
        chose = new Button("Ok");
        chose.setOnAction(new ActionChoose());
    }

    class ActionReset implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
            controleur.reset();
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
            controleur.chargerNiveau(i);
            //charger niveaucontroleur.reset();
        }

    }




}