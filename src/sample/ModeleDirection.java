package sample;

import javafx.scene.input.KeyCode;

public class ModeleDirection implements Modele {
    String direction= "bottom";;
    Modele modele;


    public ModeleDirection(Modele modele) {
        this.modele = modele;
    }

    public String getDirection(){
        return direction;
    }
    @Override
    public String[][] getEtat() {
        return modele.getEtat();
    }

    @Override
    public void chargerNiveau(String[][] mapTmp) {
        modele.chargerNiveau(mapTmp);
    }

    @Override
    public void move(KeyCode code) {
        switch (code){
            case UP:
                direction = "top";
                break;
            case DOWN:
                direction = "bottom";
                break;
            case LEFT:
                direction = "left";
                break;
            case RIGHT:
                direction = "right";
                break;
        }
        modele.move(code);
    }

    @Override
    public void reset() {
        modele.reset();
    }
}
