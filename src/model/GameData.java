package model;

import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Queue;

public class GameData{
    public static ArrayList<ArrayList<Circle>> gameFieldGUI = new ArrayList<ArrayList<Circle>>();
    private boolean turn=false;//player 1 is false,player 2 is true
    private int[][]gameField={
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}
    };
    private int id=-1;

    public GameData(){

    }

    public GameData(boolean t){
        turn=t;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getId(){
        return id;
    }

    public void setTurn(boolean t){
        turn=t;
    }

    public void nextTurn(){
        if(turn){
            turn=false;
        }else{
            turn=true;
        }
    }

    public boolean getTurn(){
        return turn;
    }

    public void fillGameFieldFromString(String s){
        String[]firstSplit=s.split(";");
        String[][]secondSplit={
                firstSplit[0].split(","),
                firstSplit[1].split(","),
                firstSplit[2].split(","),
                firstSplit[3].split(","),
                firstSplit[4].split(",")
        };

        for(int ia=0;ia<5;ia++){
            for(int ib=0;ib<5;ib++){
                gameField[ia][ib]=Integer.parseInt(secondSplit[ia][ib]);
            }
        }
    }

    public String getGameFieldAsText(){
        String returnString="";

        for(int ia=0;ia<5;ia++){
            for(int ib=0;ib<5;ib++){
               returnString+=gameField[ia][ib];
               if(ib<4){
                   returnString+=",";
               }
            }
            if(ia<5){
                returnString+=";";
            }
        }

        return returnString;
    }

    public int getGameCell(int a,int b){
        return gameField[a][b];
    }
    public void setGameCell(int a,int b, int c){
        gameField[a][b] = c;
    }
}