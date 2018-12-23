package sample;

public class ModeleDirection implements Modele {
    String directionImage= "bottom";
    Modele modele;


    public ModeleDirection(Modele modele) {
        this.modele = modele;
    }

    public String getDirection(){
        return directionImage;
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
    public String move(String direction) {
        switch (direction){
            case "d":
                directionImage="bottom";
                break;
            case "u":
                directionImage="top";
                break;
            case "r":
                directionImage="right";
                break;
            case "l":
                directionImage="left";
                break;
        }
        return modele.move(direction);
    }

    @Override
    public void reset() {
        modele.reset();
    }
}
