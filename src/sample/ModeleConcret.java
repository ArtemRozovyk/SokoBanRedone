package sample;


import javafx.scene.input.KeyCode;
import javafx.scene.control.Alert;

import java.util.ArrayList;

public class ModeleConcret implements Modele {
    private static String [][] map;//游戏操作的地图
    private static String [][] map2;//游戏操作的地图
    private static int x=0;//玩家当前在数组中的坐标
    private static int y=0;//玩家当前在数组中的坐标



    public void f_alert_informationDialog(String p_header, String p_message){
        Alert _alert = new Alert(Alert.AlertType.INFORMATION);
        _alert.setTitle("win");
        _alert.setHeaderText(p_header);
        _alert.setContentText(p_message);
        _alert.show();
    }

    private void win() {
        boolean win = true;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map2[i][j].equals(".")&&!map[i][j].equals("$")) {
                    win = false;
                }
            }
        }

        if (win) {
            f_alert_informationDialog("win","win");
        }
    }

     public void chargerNiveau(String [][]mapTmp){

         map2=new String[mapTmp.length][mapTmp[0].length];
         map=new String[mapTmp.length][mapTmp[0].length];

         for(int a=0;a<mapTmp.length;a++){
            for (int b=0;b<mapTmp[a].length;b++){
                map2[a][b]=""+mapTmp[a][b];
            }
         }
         reset();

    }

    public String [][] getEtat() {
        return map;
    }

    public  void afficher(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public void move(KeyCode code) {
        int f=0;
        int fb=0;
        switch (code) {

            case UP:
                //通道和目标点
                if (map[x - 1][y].equals(" ")  || map[x - 1][y].equals(".") ) {
                    if(map[x-1][y].equals(".")){
                        f=1;
                    }
                    //1.将玩家当前位置还原
                    if (map2[x][y].equals(".") ){
                        map[x][y] = ".";
                    } else {
                        map[x][y] = " ";
                    }
                    //3.将玩家移动过去
                    if (f==1){
                        map[x - 1][y] = "+";
                    }else {
                        map[x - 1][y] = "@";
                    }
                    //4.记录玩家的当前坐标
                    x -= 1;
                    f=0;
                    break;
                }
                //如果是箱子
                if (map[x - 1][y].equals("$")||map[x - 1][y].equals("*")) {
                    //继续判断箱子的上边
                    //如果是通道或目标点
                    if (map[x - 2][y].equals(" ") || map[x - 2][y].equals(".") ){
                        if(map[x - 1 - 1][y].equals(".")){
                            fb=0;
                        }
                        //移动玩家
                        if (map2[x][y].equals(".")) {
                            map[x][y] = ".";
                        } else {
                            map[x][y] = " ";
                        }
                        //3.将玩家移动过去
                        map[x - 1][y] = "@";
                        //4.记录玩家的当前坐标
                        x -= 1;
                        //移动箱子
                        //1.将箱子当前的位子不需要还原
                        //3.移动箱子
                        if(fb==1){
                            map[x - 1][y] ="*";
                        }else {
                            map[x - 1][y] = "$";
                        }
                        fb=0;
                        win();
                    }
                }
                break;
            case DOWN:
                //通道和目标点
                if (map[x + 1][y].equals(" ") || map[x + 1][y].equals(".") ){
                    if( map[x + 1][y].equals(".")){
                        f=1;
                    }
                    if (map2[x][y].equals(".") ){
                        map[x][y] = ".";
                    } else {
                        map[x][y] = " ";
                    }
                    //3.将玩家移动过去
                    if(f==1){
                        map[x + 1][y] = "+";
                    }else {
                        map[x + 1][y] = "@";
                    }
                    //4.记录玩家的当前坐标
                    x += 1;
                    f=0;
                    break;                }
                //如果是箱子
                if (map[x + 1][y].equals("$")||map[x + 1][y].equals("*")) {
                    //继续判断箱子的上边
                    //如果是通道或目标点
                    if ((x+2<map.length)&&map[x + 2][y].equals(" ") || map[x + 2][y].equals(".")) {
                        if( map[x + 1 + 1][y].equals(".")){
                            fb=1;
                        }
                        //移动玩家
                        if (map2[x][y].equals(".")) {
                            map[x][y] = ".";
                        } else {
                            map[x][y] = " ";
                        }
                        //3.将玩家移动过去
                        map[x + 1][y] = "@";
                        //4.记录玩家的当前坐标
                        x += 1;
                        //移动箱子
                        //1.将箱子当前的位子不需要还原
                        //3.移动箱子
                        if(fb==1){
                            map[x + 1 ][y] = "*";
                        }else {
                            map[x + 1 ][y] = "$";
                        }
                        fb=0;
                        win();
                    }
                }
                break;
            case LEFT:

                //通道和目标点
                if (map[x][y - 1].equals(" " )|| map[x][y - 1].equals(".") ){
                    if(map[x][y - 1].equals(".")){
                        f=1;
                    }
                    if (map2[x][y].equals(".") ){
                        map[x][y] = ".";
                    } else {
                        map[x][y] = " ";
                    }
                    //3.将玩家移动过去
                    if(f==1){
                        map[x][y - 1] = "+";
                    }else {
                        map[x][y - 1] = "@";
                    }
                    //4.记录玩家的当前坐标
                    y -= 1;
                    f=0;
                    break;
                }
                //如果是箱子
                if (map[x][y - 1].equals("$")|| map[x][y - 1].equals("*")){
                    //继续判断箱子的上边
                    //如果是通道或目标点
                    if ((y-2>0)&&map[x][y - 1 - 1].equals(" " )|| map[x][y - 1 - 1].equals(".")) {
                        if(map[x][y - 1 - 1].equals(".")){
                            fb=1;
                        }
                        //移动玩家
                        if (map2[x][y].equals(".") ){
                            map[x][y] = ".";
                        } else {
                            map[x][y] = " ";
                        }
                        //3.将玩家移动过去
                        map[x][y - 1] = "@";
                        //移动箱子
                        //1.将箱子当前的位子不需要还原
                        //3.移动箱子
                        if(fb==1){
                            map[x][y - 1 - 1] = "*";
                        }else {
                            map[x][y - 1 - 1] = "$";
                        }
                        //4.记录玩家的当前坐标
                        y -= 1;
                        fb=0;
                        //重画
                        win();
                    }
                }
                break;
            case RIGHT:
                //通道和目标点
                if (map[x][y + 1].equals(" " )|| map[x][y + 1].equals(".")) {
                    if( map[x][y + 1].equals(".")){
                        f=1;
                    }
                    if (map2[x][y].equals(".")) {
                        map[x][y] = ".";
                    } else {
                        map[x][y] = " ";
                    }
                    //3.将玩家移动过去
                    if(f==1){
                        map[x][y + 1] = "@";
                    }else {
                        map[x][y + 1] = "@";
                    }
                    //4.记录玩家的当前坐标
                    y += 1;
                    f=0;
                    break;
                }
                //如果是箱子
                if (map[x][y + 1].equals("$")|| map[x][y + 1].equals("*")){
                    //继续判断箱子的上边
                    //如果是通道或目标点
                    if ((x+2<map.length)&&map[x][y + 1 + 1].equals(" " )|| map[x][y + 1 + 1].equals(".") ){
                        if (map[x][y + 1 + 1].equals(".")){
                            fb=1;
                        }
                        //移动玩家
                        if (map2[x][y].equals(".")) {
                            map[x][y] = ".";
                        } else {
                            map[x][y] = " ";
                        }
                        //3.将玩家移动过去
                        map[x][y + 1] = "@";

                        //移动箱子
                        //1.将箱子当前的位子不需要还原
                        //3.移动箱子
                        if(fb==1){
                            map[x][y + 1 + 1] = "*";
                        }else {
                            map[x][y + 1 + 1] = "$";
                        }
                        //4.记录玩家的当前坐标
                        y += 1;
                        fb=0;
                        win();
                    }
                }
                break;
            default:
                break;
        }
        afficher();

    }

    @Override
    public void reset() {

        for (int i = 0; i < map2.length; i++) {
            for (int j = 0; j < map2[i].length; j++) {
                map[i][j]=""+map2[i][j];
                if (map2[i][j]!=null && (map2[i][j].equals("@")||map2[i][j].equals("+"))){
                    x=i;
                    y=j;
                }

            }
            }

    }




}
