package sample;

import javafx.scene.input.KeyCode;

public interface Modele {
     int[][] getEtat();
     int getX();
     int getY();

     void move(KeyCode code);
     void reset();
}
