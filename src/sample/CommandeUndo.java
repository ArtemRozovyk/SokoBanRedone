package sample;

public class CommandeUndo implements Commande {
    FacadeModele facadeModele;

    public CommandeUndo(FacadeModele facadeModele) {
        this.facadeModele=facadeModele;
    }

    @Override
    public void execute() {
        facadeModele.undo();
    }
}
