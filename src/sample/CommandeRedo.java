package sample;

public class CommandeRedo implements Commande{
    FacadeModele facadeModele;

    public CommandeRedo(FacadeModele facadeModele) {
        this.facadeModele=facadeModele;
    }

    @Override
    public void execute() {
        facadeModele.redo();
    }
}
