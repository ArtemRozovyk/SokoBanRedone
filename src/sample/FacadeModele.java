package sample;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class FacadeModele {
    Modele m=new ModeleConcret();
    ModeleEnsLevels modele = new ModeleEnsLevels(m);
    ModeleDirection modeleDirection =new ModeleDirection(m);
    ModeleAuthorName modeleAuthorName= new ModeleAuthorName(modele);
    ModeleSolution modeleSolution= new ModeleSolution(modele);

    public String move(String direction) {
        return modeleDirection.move(direction);
    }

    public void reset() {
        modele.reset();
    }


    public String[][] getEtat() {
        return modele.getEtat();
    }

    public ArrayList<String> getNameAuthor(){ return modeleAuthorName.getNameAuthor() ;}
    public String getDirection(){
        return modeleDirection.getDirection();
    }
    public void chargerNiveau(int i){
        modele.chargerNiveau(i);
    }
    public ArrayList<String[][]> lireFichier(String nomFichier){
       return modeleAuthorName.lect_fichier(nomFichier);
    }
    public String solve(){ return modeleSolution.resoudre();}

    public void AddLevel(String[][] added) {
        modele.AddLevel(added);
    }


    public int getCurrentLevel() {
        return modele.getCurrentLevel();
    }
}
