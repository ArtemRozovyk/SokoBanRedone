package sample;

import javafx.scene.input.KeyCode;

public class FacadeModele {
    ModeleConcret modele = new ModeleConcret();

    public void move(KeyCode keyCode) {
        modele.move(keyCode);
    }

    public void reset() {
        modele.reset();
    }

    public int[][] getEtat() {
        return modele.getEtat();
    }


    public String getDirection(){
        return modele.getDirection();
    }

}
