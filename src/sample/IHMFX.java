package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class IHMFX extends Application implements Observateur {

    VueIHMFX vue;
    VueLevel vueL;

    public void actualise(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

            vue.dessine();
            vueL.miseAjourListe();
            }
        });
    };

    @Override
    public void start(Stage primaryStage) throws Exception{
        Controleur controleur = Controleur.getControleur();
        controleur.abonne(this);
        vue = new VueIHMFX(controleur);
        vueL=new VueLevel(controleur);

        ControleurIHMFX controleurIHMFX = new ControleurIHMFX(controleur,vue,vueL,primaryStage);
        /* montage de la scene */
        MonteurScene monteurScene = new MonteurScene();

        Scene scene1 = monteurScene.
                setCentre(vue.canvas).
                ajoutRight(controleurIHMFX.reset, vueL.comboBox,controleurIHMFX.chose,controleurIHMFX.openMultipleButton,vueL.label,controleurIHMFX.nextLevel,controleurIHMFX.prevLevel).
                setMoveEvent(controleurIHMFX.event).
                setLargeur(850).
                setHauteur(650).
                retourneScene();
        //

        primaryStage.setScene(scene1);

        primaryStage.setTitle("Sokoban^");
        primaryStage.show();



    }

    public void lance() {
        launch(new String[]{});
    }

}

