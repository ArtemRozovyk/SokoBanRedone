package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class VueIHMFX {

    CommandeTabInt commandeGetEtat;
    CommandeDirection commandeGetDirection;
    Canvas canvas = new Canvas(500,350);
    //通过画布获取画笔
    GraphicsContext g2d = canvas.getGraphicsContext2D();


    public VueIHMFX(Controleur controleur) throws FileNotFoundException {
        commandeGetEtat = controleur.commandeGetEtat();
        commandeGetDirection=controleur.commandeGetDirection();
        dessine();
    }

    public void dessine() {

        int [][] map = commandeGetEtat.exec();
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
                switch (map[i][j]) {
                    case 0:
                        Image land =new Image(getClass().getResource("/Sokoban_pack/PNG/Ground_Grass.png").toString());
                        g2d.drawImage(land,j*50,i*50,50,50);
                        break;
                    case 1:
                        Image way =new Image(getClass().getResource("/Sokoban_pack/PNG/GroundGravel_Grass.png").toString());
                        g2d.drawImage(way,j*50,i*50,50,50);
                        break;
                    case 2:
                        Image wall =new Image(getClass().getResource("/Sokoban_pack/PNG/Wall_Beige.png").toString());
                        g2d.drawImage(wall,j*50,i*50,50,50);
                        break;
                    case 3:
                        Image box_way =new Image(getClass().getResource("/Sokoban_pack/PNG/Crate_Beige.png").toString());
                        g2d.drawImage(box_way,j*50,i*50,50,50);
                        Image box =new Image(getClass().getResource("/Sokoban_pack/PNG/Crate_Beige.png").toString());
                        g2d.drawImage(box,j*50,i*50,50,50);
                        break;
                    case 4:
                        Image way2 =new Image(getClass().getResource("/Sokoban_pack/PNG/GroundGravel_Sand.png").toString());
                        g2d.drawImage(way2,j*50,i*50,50,50);
                        Image box_end =new Image(getClass().getResource("/Sokoban_pack/PNG/EndPoint_Red.png").toString());
                        g2d.drawImage(box_end,j*50+10,i*50+10,30,30);
                        break;
                    case 5:
                        Image way3 =new Image(getClass().getResource("/Sokoban_pack/PNG/EndPoint_Yellow.png").toString());
                        g2d.drawImage(way3,j*50,i*50,50,50);
                        Image player = new Image(getClass().getResource("/Sokoban_pack/PNG/Character1"+direction+".png").toString());
                        g2d.drawImage(player,j*50,i*50,50,50);
                        break;
                    default:
                        break;
                }
            }
        }
    }




}
