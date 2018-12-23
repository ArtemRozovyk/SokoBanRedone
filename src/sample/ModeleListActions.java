package sample;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class ModeleListActions implements  Modele {

    Modele m;
    ArrayList<String> actions ;
    int currentAction;

    public ModeleListActions(Modele m){
        this.m=m;
        currentAction=0;
    }

    @Override
    public String[][] getEtat() {
        return m.getEtat();
    }

    @Override
    public void chargerNiveau(String[][] mapTmp) {
        m.chargerNiveau(mapTmp);
    }

    @Override
    public String move(String code) {
        return m.move(code);
    }

    @Override
    public void reset() {
        m.reset();
    }

    public void redo() {


    }
    public void undo() {


    }
}
