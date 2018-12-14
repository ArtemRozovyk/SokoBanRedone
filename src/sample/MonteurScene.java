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
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.canvas.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

public class MonteurScene {
    AnchorPane root=new AnchorPane();
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








    public MonteurScene ajoutRight(Region node, ComboBox comboBox, Button choose, Button openMultipleButton, Label nameAuthor,Button nexTL,Button preVL) {

        node.setFocusTraversable(false);
        comboBox.setFocusTraversable(false);
        choose.setFocusTraversable(true);
        openMultipleButton.setFocusTraversable(false);
        AnchorPane.setBottomAnchor(node,10.0);
        AnchorPane.setRightAnchor(node,25.0);
        root.getChildren().add(node);

        AnchorPane.setBottomAnchor(comboBox,50.0);
        AnchorPane.setRightAnchor(comboBox,320.0);
        root.getChildren().add(comboBox);


        AnchorPane.setBottomAnchor(choose,50.0);
        AnchorPane.setRightAnchor(choose,250.0);
        root.getChildren().add(choose);

        AnchorPane.setBottomAnchor(openMultipleButton,20.0);
        AnchorPane.setRightAnchor(openMultipleButton,320.0);
        root.getChildren().add(openMultipleButton);

        nameAuthor.setText("MICROCOSMOS 1");
        nameAuthor.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, new CornerRadii(2), new Insets(2))));
        nameAuthor.setFont(Font.font("AnjaliOldLipi", 24));
        System.out.println(javafx.scene.text.Font.getFamilies());
        AnchorPane.setBottomAnchor(nameAuthor,80.0);
        AnchorPane.setRightAnchor(nameAuthor,50.0);
        root.getChildren().add(nameAuthor);

        AnchorPane.setBottomAnchor(nexTL,80.0);
        AnchorPane.setRightAnchor(nexTL,320.0);
        root.getChildren().add(nexTL);

        AnchorPane.setBottomAnchor(preVL,80.0);
        AnchorPane.setRightAnchor(preVL,500.0);
        root.getChildren().add(preVL);



        return this;
    }


    Scene retourneScene() {
        Scene scene;
        scene= new Scene (root,largeur,hauteur);
        scene.setOnKeyPressed(event);
        return scene;
    }


}
