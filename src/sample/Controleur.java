package sample;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;

public class Controleur implements Sujet {
    private static Controleur singleton;


    public static Controleur getControleur() {
        if (singleton == null)
            singleton = new Controleur(new FacadeModele());
        return singleton;
    }

    FacadeModele facadeModele;
    ArrayList<Observateur> observateurs = new ArrayList<Observateur>();



    private Controleur(FacadeModele facadeModele) {
        this.facadeModele = facadeModele;
        chargerNiveau(0);

    }

    public void abonne(Observateur observateur) {
        observateurs.add(observateur);
    }

    @Override
    public void notifie() {
        for (Observateur observateur:observateurs)
            observateur.actualise();
    }

    public void move(KeyCode keyCode) {
        facadeModele.move(keyCode);
        notifie();
    }

    public void reset() {
        facadeModele.reset();
        notifie();
    }
    void chargerNiveau(int i){
        facadeModele.chargerNiveau(i);
        notifie();

    }

    public void AddLevel(String absolutePath) {
        facadeModele.AddLevel(absolutePath);
        notifie();

    }





    public CommandeTabInt commandeGetEtat() {
        return new CommandeTabInt() {
            @Override
            public String[][] exec() {
                return facadeModele.getEtat();
            }
        };
    }
    public CommandeRedo commandeRedo() {
        return new CommandeRedo(facadeModele) ;
    }
    public CommandeUndo commandeUndo() {
        return new CommandeUndo(facadeModele) ;
    }


    public CommandeDirection commandeGetDirection() {
        return new CommandeDirection() {
            @Override
            public String exec() {
                return facadeModele.getDirection();
            }
        };
    }

    public CommandeAuthors commandeAuthors() {
        return new CommandeAuthors() {
            @Override
            public ArrayList<String> exec() {
                return facadeModele.getNameAuthor();
            }
        };
    }
    public CommandeCurrentLevelInt commandeCurrentLevelInt() {
        return new CommandeCurrentLevelInt() {
            @Override
            public int exec() {
                return facadeModele.getCurrentLevel();
            }
        };
    }



}
