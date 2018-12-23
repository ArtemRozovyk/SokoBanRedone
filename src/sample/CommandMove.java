package sample;

public class CommandMove  implements Command{
    String direction;
    FacadeModele facadeModele;



    CommandMove(FacadeModele facadeModele,String direction ){
        this.direction=direction;
        this.facadeModele=facadeModele;
    }

    @Override
    public void exec(){
        System.out.println("we go "+direction);
        //mis a jour enventuelement maj pour move avec la box
        direction=facadeModele.move(direction);
        System.out.println("returned "+direction);
    }

    @Override
    public void undo() {
        switch (direction){
            case "u":
                facadeModele.move("d");
                break;
            case "d":
                facadeModele.move("u");
                break;
            case "l":
                facadeModele.move("r");
                break;
            case "r":
                facadeModele.move("l");
                break;
            case "U":
                break;
            case "D":
                break;
            case "L":
                break;
            case "R":
                break;
        }
    }

}
