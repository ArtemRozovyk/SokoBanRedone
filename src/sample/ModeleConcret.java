package sample;


import javafx.scene.input.KeyCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import javafx.scene.control.Alert;

import java.util.Arrays;
import java.util.List;
public class ModeleConcret implements Modele {
    private static String [][] map;//游戏操作的地图
    private static String [][] map2;//游戏操作的地图
    private static String [][] map3;//map for reset
    private static ArrayList<String[][]> levels=lect_fichier("lol.txt");
    private static String direction = "bottom";//玩家朝向  默认向下
    private static int x=0;//玩家当前在数组中的坐标
    private static int y=0;//玩家当前在数组中的坐标

    static {
        chargerNiveau(1);
        }

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

     public static   void   chargerNiveau(int k){

         map=levels.get(k);
         map2 = new String[map.length][100] ;
         map3= new String[map.length][100];
        for(int a=0;a<map.length;a++){
            for (int b=0;b<map[a].length;b++){
                map2[a][b]=map[a][b];
                map3[a][b]=map[a][b];
            }
        }
         for (int i = 0; i < map.length; i++) {
             for (int j = 0; j <map[0].length ; j++) {
                 if (map[i][j]!=null && map[i][j].equals("@")){
                     x=i;
                     y=j;
                 }
             }
         }
    }

    public String [][] getEtat() {
        return map;
    }

    public ArrayList<String[][]> getL(){
        return levels;
    }

    public  void afficher(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    public static ArrayList<String[][]> lect_fichier(String nom_fichier)  {
            File file = new File(nom_fichier);
            BufferedReader br1 = null;
            try {
                br1 = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            ArrayList<String [][]> levels = new ArrayList<>();
            String str;

            ArrayList<String> l = new ArrayList<>();

            int max = 0;

            while (true){
                try {
                    str = br1.readLine();
                    if (str==null)break;
                    if (str.charAt(0)==';'){
                        //Création d'un nouveau noeud...
                        String [][] aux = new String[l.size()][max];

                        for (int i = 0; i < l.size(); i++) {

                            String [] arrTest = l.get(i).split("");
                            for (int j = 0; j < max; j++) {
                                if(j<arrTest.length)
                                aux[i][j]=arrTest[j];
                                else
                                    aux[i][j]="0";
                            }

                        }
                        max=0;
                        l = new ArrayList<>();
                        levels.add(aux);
                    }
                    else {
                        l.add(str);
                        if (str.length()>max) max = str.length();
                    }


                }catch(Exception e)
                {
                    System.out.print("");
                }
            }

            return levels;
        }

    public void move(KeyCode code) {
        int f=0;
        int fb=0;
        afficher();
        switch (code) {

            case UP:
                direction = "top";
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
                direction = "bottom";
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
                direction = "left";
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
                direction = "right";
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
        for (int i = 0; i < map3.length; i++) {
            for (int j = 0; j < map3[i].length; j++) {
                map[i][j]=map3[i][j];
                }
            }
        }

    public String getDirection() {
        return direction;
    }

}
