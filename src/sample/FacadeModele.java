package sample;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class FacadeModele {
    ModeleConcret modele = new ModeleConcret();

    public void move(KeyCode keyCode) {
        modele.move(keyCode);
    }

    public void reset() {
        modele.reset();
    }

    public String[][] getEtat() {
        return modele.getEtat();
    }


    public String getDirection(){
        return modele.getDirection();
    }

    public void chargerNiveau(int i){
        modele.chargerNiveau(i);
    }
    public ArrayList<String[][]> getL(){
        return modele.getL();
    }

}
