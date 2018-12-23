package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;

import java.io.FileNotFoundException;

public class VueIHMFX {

    CommandeTabInt commandeGetEtat;
    CommandeDirection commandeGetDirection;
    Canvas canvas = new Canvas(400,200);
    //通过画布获取画笔

    GraphicsContext g2d = canvas.getGraphicsContext2D();

    public VueIHMFX(Controleur controleur)   {
        commandeGetEtat = controleur.commandeGetEtat();
        commandeGetDirection=controleur.commandeGetDirection();
        dessine();
    }

    public void f_alert_informationDialog(String p_header, String p_message){
        Alert _alert = new Alert(Alert.AlertType.INFORMATION);
        _alert.setTitle("win");
        _alert.setHeaderText(p_header);
        _alert.setContentText(p_message);
        _alert.show();
    }

    public void resetCanvas(){
        String [][] map = commandeGetEtat.exec();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                Image way1 =new Image(getClass().getResource("/Sokoban_pack/PNG/White.png").toString());
                g2d.drawImage(way1,j*50,i*50,50,50);
            }
        }
    }

    private void win(String[][] state) {
        for (int i = 0; i < state.length; i++)
            for (int j = 0; j < state[i].length; j++)
                if (state[i][j].equals("$"))
                    return;
        Alert _alert = new Alert(Alert.AlertType.INFORMATION);
        _alert.setTitle("Da");
        _alert.setHeaderText("We win  ");
        _alert.setContentText("Yes!");
        _alert.show();
    }

    public void dessine() {
        String [][] map = commandeGetEtat.exec();
        int width=map[0].length*50,height=map.length*50;
        canvas.setHeight(height);
        canvas.setWidth(width);

        String direction=commandeGetDirection.exec();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                /**
                 * Image img  图片
                 * double x	  开始放的X坐标
                 * double y  开始放的Y坐标
                 * double w  画多宽/压缩画
                 * double h  画多高/压缩画
                 */
                if (map[i][j]!=null)
                switch (map[i][j]) {
                    case " ":
                        Image way1 =new Image(getClass().getResource("/Sokoban_pack/PNG/GroundGravel_Grass.png").toString());
                        g2d.drawImage(way1,j*50,i*50,50,50);
                        break;
                    case "+":
                        Image way =new Image(getClass().getResource("/Sokoban_pack/PNG/Character1Finale.png").toString());
                        g2d.drawImage(way,j*50,i*50,50,50);
                        break;
                    case "#":
                        Image wall =new Image(getClass().getResource("/Sokoban_pack/PNG/Wall_Beige.png").toString());
                        g2d.drawImage(wall,j*50,i*50,50,50);
                        break;
                    case "$":
                        Image box_way =new Image(getClass().getResource("/Sokoban_pack/PNG/Crate_Beige.png").toString());
                        g2d.drawImage(box_way,j*50,i*50,50,50);
                        Image box =new Image(getClass().getResource("/Sokoban_pack/PNG/Crate_Beige.png").toString());
                        g2d.drawImage(box,j*50,i*50,50,50);
                        break;
                    case ".":
                        Image way2 =new Image(getClass().getResource("/Sokoban_pack/PNG/GroundGravel_Sand.png").toString());
                        g2d.drawImage(way2,j*50,i*50,50,50);
                        Image box_end =new Image(getClass().getResource("/Sokoban_pack/PNG/EndPoint_Red.png").toString());
                        g2d.drawImage(box_end,j*50+10,i*50+10,30,30);
                        break;
                    case "@":
                        Image way3 =new Image(getClass().getResource("/Sokoban_pack/PNG/EndPoint_Yellow.png").toString());
                        g2d.drawImage(way3,j*50,i*50,50,50);
                        Image player = new Image(getClass().getResource("/Sokoban_pack/PNG/Character1"+direction+".png").toString());
                        g2d.drawImage(player,j*50,i*50,50,50);
                        break;
                    case "*":
                        Image fBox =new Image(getClass().getResource("/Sokoban_pack/PNG/Crate_Red.png").toString());
                        g2d.drawImage(fBox,j*50,i*50,50,50);
                        break;
                    case "0":
                        Image vide =new Image(getClass().getResource("/Sokoban_pack/PNG/White.png").toString());
                        g2d.drawImage(vide,j*50,i*50,50,50);
                        break;
                    default:
                        break;
                }
            }
        }
        win(map);
    }




}
