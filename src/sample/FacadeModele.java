package sample;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class FacadeModele {
    Modele m=new ModeleConcret();
    ModeleEnsLevels modele = new ModeleEnsLevels(m);
    ModeleDirection modeleDirection =new ModeleDirection(m);
    ModeleAuthorName modeleAuthorName= new ModeleAuthorName(m);
    public void move(KeyCode keyCode) {
        modele.move(keyCode);
    }

    public void reset() {
        modele.reset();
    }

    public String[][] getEtat() {
        return modele.getEtat();
    }

    public String getNameAuthor(){ return modeleAuthorName.nameAuthor ;}
    public String getDirection(){
        return modeleDirection.getDirection();
    }
    public void chargerNiveau(int i){
        modele.chargerNiveau(i);
    }
    public ArrayList<String[][]> lireFichier(String nomFichier){
       return modele.lect_fichier(nomFichier);
    }

    public ArrayList<String[][]> getL() {
        return modele.getL();
    }

    public void AddLevel(String[][] added) {
        modele.AddLevel(added);
    }
}
