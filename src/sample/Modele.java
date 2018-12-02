package sample;

import javafx.scene.input.KeyCode;

public interface Modele {
     int[][] getEtat();


     void move(KeyCode code);
     void reset();
}
