package sample;

import javafx.scene.input.KeyCode;


import java.util.ArrayList;

public class ModeleAuthorName implements Modele {
    ArrayList<String> nameAuthor;
    ModeleEnsLevels modele;

    public ModeleAuthorName(ModeleEnsLevels modele) {
        nameAuthor=new ArrayList<>();
        for (int i = 1; i <41 ; i++) {
            nameAuthor.add("MICROCOSMOS "+i);
            
        }
        this.modele = modele;
    }

    public ArrayList<String[][]> lect_fichier(String nom_fichier)  {
        String[]name=nom_fichier.split("/");
        String toAdd=name[name.length-1].substring(5,name[name.length-1].length()-4);
        nameAuthor.add(""+toAdd);
        return modele.lect_fichier(nom_fichier);
    }

    public  ArrayList<String>  getNameAuthor(){
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
