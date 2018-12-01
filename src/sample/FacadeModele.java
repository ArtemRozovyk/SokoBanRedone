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

    public int getX() {
        return modele.getX();
    }
    public int getY() {
        return modele.getY();
    }
    public String getDirection(){
        return modele.getDirection();
    }

}
