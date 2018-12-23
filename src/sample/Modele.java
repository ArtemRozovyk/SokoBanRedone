package sample;

public interface Modele {
     String[][] getEtat();
     void chargerNiveau(String [][]mapTmp);
     String move(String direction);
     void reset();

}
