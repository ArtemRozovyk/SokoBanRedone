package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.canvas.*;

import java.awt.*;
import java.util.ArrayList;

public class MonteurScene {
    //ArrayList<Region> bas = new ArrayList<Region>();
    AnchorPane root=new AnchorPane();
    EventHandler<Event>event;
    int largeur = 800;
    int hauteur = 400;


    public MonteurScene setLargeur(int l){
        largeur=l;
        return this;
    }

    public MonteurScene setHauteur(int l) {
        hauteur=l;
        return this;
    }

    public MonteurScene setMoveEvent(Controleur controleur) {
        event=new EventHandler<Event>() {
            public void handle(Event event) {
                //获取键码
                KeyEvent ke = (KeyEvent) event;
                //强转
                KeyCode code = ke.getCode();
                controleur.move(code);
            }
        };
        return this;
    }

    public MonteurScene setCentre(Canvas node) {
        root.getChildren().add(node);
        return this;
    }

    public MonteurScene ajoutRight(Region node) {
        AnchorPane.setBottomAnchor(node,10.0);
        AnchorPane.setRightAnchor(node,25.0);
        root.getChildren().add(node);
        return this;
    }

    Scene retourneScene() {

        Scene scene = new Scene(root,largeur,hauteur);
        scene.setOnKeyPressed(event);
        return scene;

    }
}
