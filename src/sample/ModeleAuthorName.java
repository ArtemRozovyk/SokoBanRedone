package sample;

import javafx.scene.input.KeyCode;

public class ModeleAuthorName implements Modele {
    String nameAuthor;
    Modele modele;

    public ModeleAuthorName(Modele modele) {
        this.modele = modele;
    }


    public String getNameAuthor(){
        return nameAuthor;
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
        modele.move(code);
    }

    @Override
    public void reset() {
        modele.reset();
    }
}
