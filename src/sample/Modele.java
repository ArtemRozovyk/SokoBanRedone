package sample;

import javafx.scene.input.KeyCode;

public interface Modele {
     String[][] getEtat();


     void move(KeyCode code);
     void reset();
}
