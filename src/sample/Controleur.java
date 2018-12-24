package sample;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Controleur implements Sujet {
    private static Controleur singleton;


    public static Controleur getControleur() {
        if (singleton == null)
            singleton = new Controleur(new FacadeModele());
        return singleton;
    }

    Animateur animateur;
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
        int itemToRedo=nextUndo+1;
        Command command = listMoves.get(itemToRedo);
        command.exec();
        notifie();
        nextUndo++;
    }



    public void solve(){
        reset();
        String solution= facadeModele.solve();
        if(solution.equals("No solution")){
            System.out.println(solution);
            return;
        }
        System.out.println(solution);
        ArrayList<Command> listCommandSolution=new ArrayList<>();
        for (int j = 0; j < solution.length(); j++) {
            listCommandSolution.add(new CommandMove(facadeModele,solution.substring(j,j+1)));
        }
        for(Command command : listCommandSolution)
                   listMoves.add(command);





    }
        public void replay(){
            for (int i = 0; i < listMoves.size(); i++) {
                undo();
            }
        }

    public void trimHistoryList(){
        if (listMoves.size()==0) return;

        if(nextUndo==listMoves.size()-1)return;
        for (int i = listMoves.size()-1; i >nextUndo ; i--) {
            listMoves.remove(i);
        }
    }


    private Controleur(FacadeModele facadeModele) {
        this.facadeModele = facadeModele;
        chargerNiveau(2);

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
        listMoves=new ArrayList<>();
        nextUndo=-1;
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
