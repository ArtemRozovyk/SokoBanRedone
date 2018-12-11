package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    GridPane gridPane;
    EventHandler<Event>event;
    int largeur = 0;
    int hauteur = 0;


    public MonteurScene setLargeur(int l){
        largeur=l;
        return this;
    }

    public MonteurScene setHauteur(int l) {
        hauteur=l;
        return this;
    }

    public MonteurScene setMoveEvent(EventHandler<Event> move) {
        event=move;
        return this;
    }

    public MonteurScene setCentre(Node node) {
        root.getChildren().add(node);
        return this;
    }

    public MonteurScene ajoutRight(Region node,ComboBox comboBox,Button choose) {
        AnchorPane.setBottomAnchor(node,10.0);
        AnchorPane.setRightAnchor(node,25.0);
        root.getChildren().add(node);

        AnchorPane.setBottomAnchor(comboBox,20.0);
        AnchorPane.setRightAnchor(comboBox,320.0);
        root.getChildren().add(comboBox);


        AnchorPane.setBottomAnchor(choose,20.0);
        AnchorPane.setRightAnchor(choose,250.0);
        root.getChildren().add(choose);



        return this;
    }
    public MonteurScene setNiveau(GridPane gridPane) {
        this.gridPane=gridPane;
        return this;
    }

    Scene retourneScene() {
        Scene scene;
        if(gridPane!=null)
            scene = new Scene(gridPane,largeur,hauteur);
        else
            scene= new Scene (root,largeur,hauteur);

        scene.setOnKeyPressed(event);

        return scene;
    }


}
