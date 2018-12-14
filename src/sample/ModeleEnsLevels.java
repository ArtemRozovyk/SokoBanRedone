package sample;

import javafx.scene.input.KeyCode;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class ModeleEnsLevels implements Modele {
    Modele modele;
    private static ArrayList<String[][]> levels;
    int currentLevel;

    public int getCurrentLevel() {
        return currentLevel;
    }

    public ModeleEnsLevels (Modele modele){
        levels=lect_fichier("1234-MICROCOSMOS.txt");
        this.modele=modele;
    }

    public  ArrayList<String[][]> lect_fichier(String nom_fichier)  {
        File file = new File(nom_fichier);
        BufferedReader br1 = null;
        try {
            br1 = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String [][]> levels = new ArrayList<>();
        String str;

        ArrayList<String> l = new ArrayList<>();

        int max = 0;

        while (true){
            try {
                str = br1.readLine();

                if (str==null||str.charAt(0)==';'){
                    if(l.size()<2)break;
                    //Création d'un nouveau noeud...
                    String [][] aux = new String[l.size()][max];

                    for (int i = 0; i < l.size(); i++) {

                        String [] arrTest = l.get(i).split("");
                        for (int j = 0; j < max; j++) {
                            if(j<arrTest.length)
                                aux[i][j]=arrTest[j];
                            else
                                aux[i][j]="0";
                        }

                    }
                    max=0;
                    l = new ArrayList<>();
                    levels.add(aux);
                }
                else {
                    l.add(str);
                    if (str.length()>max) max = str.length();
                }


            }catch(Exception e)
            {
                System.out.print("");
            }
        }

        return levels;
    }

    public void chargerNiveau(int i){
        currentLevel=i+1;
        if(i<levels.size()&&i>=0)
        chargerNiveau(levels.get(i));
    }

    public ArrayList<String[][]> getL(){
        return levels;
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

    public void AddLevel(String[][] level) {
        levels.add(level);
    }
}
