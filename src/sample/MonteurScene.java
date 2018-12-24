package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import javafx.scene.layout.*;
import javafx.scene.text.Font;


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








    public MonteurScene ajoutRight(Region node, ComboBox comboBox,
                                   Button choose, Button openMultipleButton, Label nameAuthor,Button nexTL,Button preVL,Button undo,Button redo,Button solve,Button replay) {

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

        nameAuthor.setText("MICROCOSMOS 3");
        nameAuthor.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, new CornerRadii(2), new Insets(2))));
        nameAuthor.setFont(Font.font("AnjaliOldLipi", 24));
        AnchorPane.setBottomAnchor(nameAuthor,80.0);
        AnchorPane.setRightAnchor(nameAuthor,50.0);
        root.getChildren().add(nameAuthor);

        AnchorPane.setBottomAnchor(nexTL,80.0);
        AnchorPane.setRightAnchor(nexTL,320.0);
        root.getChildren().add(nexTL);

        AnchorPane.setBottomAnchor(preVL,80.0);
        AnchorPane.setRightAnchor(preVL,500.0);
        root.getChildren().add(preVL);

        AnchorPane.setBottomAnchor(undo,120.0);
        AnchorPane.setRightAnchor(undo,320.0);
        root.getChildren().add(undo);

        AnchorPane.setBottomAnchor(redo,120.0);
        AnchorPane.setRightAnchor(redo,500.0);
        root.getChildren().add(redo);

        AnchorPane.setBottomAnchor(solve,120.0);
        AnchorPane.setRightAnchor(solve,400.0);
        root.getChildren().add(solve);

        AnchorPane.setBottomAnchor(replay,150.0);
        AnchorPane.setRightAnchor(replay,400.0);
        root.getChildren().add(replay);



        return this;
    }


    Scene retourneScene() {
        Scene scene;
        scene= new Scene (root,largeur,hauteur);

        scene.setOnKeyPressed(event);
        return scene;
    }


}
