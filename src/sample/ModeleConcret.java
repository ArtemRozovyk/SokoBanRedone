package sample;


public class ModeleConcret implements Modele {
    private static String [][] map;//游戏操作的地图
    private static String [][] map2;//游戏操作的地图
    private static int x=0;//玩家当前在数组中的坐标
    private static int y=0;//玩家当前在数组中的坐标

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

    public String move(String direction) {
        switch (direction) {
            case "u":
                direction=ordinaryMove(-1,0,direction);
                break;
            case "d":
                direction=ordinaryMove(1,0,direction);
                break;
            case "l":
                direction=ordinaryMove(0,-1,direction);
                break;
            case "r":
                direction=ordinaryMove(0,1,direction);
                    break;
            case "xU":
               eraseMove(-1,0);
                break;
            case "xD":
                eraseMove(1,0);
                break;
            case "xL":
                eraseMove(0,-1);
                break;
            case "xR":
                eraseMove(0,1);
                break;
            default:
                break;
        }
        return direction;
    }

    public String ordinaryMove(int ix, int iy,String direction) {
        String tmp="";
        //if next is wall or after next is wall or box and next is non walkable space
        if (map[x+ix][y +iy].equals(("#")) || ((map[x+(ix*2)][y +(iy*2)].equals("#") ||
                map[x+(ix*2)][y +(iy*2)].equals("*") || map[x+(ix*2)][y +(iy*2)].equals("$")) && !(map[x+ix][y +iy].equals(".") || map[x+ix][y +iy].equals(" ")))) {
            System.out.println("hey");
            return "w";
        }
        if (map[x+ix][y +iy].equals("$") || map[x+ix][y +iy].equals("*")) {
            //we gona move a box
            if (map[x+ix][y +iy].equals("*"))
                tmp = "+";
            else
                tmp = "@";
            if (map[x+(ix*2)][y +(iy*2)].equals(" ")) {
                map[x+(ix*2)][y +(iy*2)] = "$";
            }
            if (map[x+(ix*2)][y +(iy*2)].equals(".")) {
                map[x+(ix*2)][y +(iy*2)] = "*";
            }
            map[x+ix][y +iy] = tmp;

            if (map2[x][y].equals("+")||map2[x][y].equals(".")||map2[x][y].equals("*"))
                map[x][y] = ".";
            else
                map[x][y] = " ";
            direction = direction.toUpperCase();

        } else {
            if (map[x+ix][y +iy] == ".")
                map[x+ix][y +iy] = "+";
            else
                map[x+ix][y +iy] = "@";

            if (map2[x][y].equals("+")||map2[x][y].equals(".")||map2[x][y].equals("*"))
                map[x][y] = ".";
            else
                map[x][y] = " ";


        }
        x+=ix;
        y+=iy;
        return direction;
    }

    public void eraseMove(int ix,int iy){
        if(map2[x+ix][y+iy].equals("+")||map2[x+ix][y+iy].equals(".")||map2[x+ix][y+iy].equals("*"))
            map[x+ix][y+iy]="+";
        else
            map[x+ix][y+iy]="@";

        if(map2[x][y].equals("+")||map2[x][y].equals(".")||map2[x][y].equals("*"))
            map[x][y]="*";
        else
            map[x][y]="$";
        if(map2[x+(ix*-1)][y+(iy*-1)].equals("+")||map2[x+(ix*-1)][y+(iy*-1)].equals(".")||map2[x+(ix*-1)][y+(iy*-1)].equals("*"))
            map[x+(ix*-1)][y+(iy*-1)]=".";
        else
            map[x+(ix*-1)][y+(iy*-1)]=" ";
        x+=ix;
        y+=iy;
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
