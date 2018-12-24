package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;


public class Animateur {
    Controleur controleur;
    public Animateur(Controleur controleur) {
       this.controleur=controleur;
    }

    Timeline timer = new Timeline(new KeyFrame(Duration.millis(90),
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                   controleur.redo();
                   if(controleur.listMoves.size()-1==controleur.nextUndo)
                        timer.stop();
                }
            }));

    public void start() {
        timer.setCycleCount(Animation.INDEFINITE);
        timer.play();
    }






}