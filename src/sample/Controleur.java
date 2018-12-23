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
    ArrayList<Command> listMoves=new ArrayList<>();
    int nextUndo=-1;



    public void executeCommand(Command command){
            this.trimHistoryList();
            command.exec();
            listMoves.add(command);
            nextUndo++;
            notifie();
    }

    public void undo(){
        if (nextUndo<0)return;
        Command command = listMoves.get(nextUndo);
        command.undo();
        nextUndo--;
        notifie();
    }

    public void redo(){
        if(nextUndo==listMoves.size()-1)return;
        int itemToredo=nextUndo+1;
        Command command = listMoves.get(itemToredo);
        command.exec();
        notifie();
        nextUndo++;
    }

    public void trimHistoryList(){
        if (listMoves.size()==0) return;

        if(nextUndo==listMoves.size()-1)return;
        for (int i = listMoves.size()-1; i >nextUndo ; i--) {
            listMoves.remove(i);

        }
    }



    public void move(String direction) {
        facadeModele.move(direction);
        notifie();
    }

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








    public void reset() {
        facadeModele.reset();
        notifie();
    }



    void chargerNiveau(int i){
        facadeModele.chargerNiveau(i);
        notifie();

    }

    public void AddLevel(String absolutePath) {
        ArrayList<String [][]>added=facadeModele.lireFichier(absolutePath);
        for (String[][] level : added)
            facadeModele.AddLevel(level);
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
