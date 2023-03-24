package Persons;

import java.util.ArrayList;
import java.util.HashMap;

public class Move {
    private static int x;
    private static int y;

    private static HashMap<String, Boolean> map=new HashMap<>();
    public Move() {
        map.put("right", true);
        map.put("left", true);
        map.put("up", true);
        map.put("down", true);
    }

  
    public void move(BaseHero me, BaseHero target, ArrayList<BaseHero> friens) {
        selectDirection(me, target, friens);    
        me.position.x=x;
        me.position.y=y;
    }

    private void selectDirection(BaseHero me, BaseHero target, ArrayList<BaseHero> team) {
        x=me.getPos()[0];
        y=me.getPos()[1];
        checkFilled(team);
        int targX=target.getPos()[0];
        int targY=target.getPos()[1];
        float dx = Math.abs(x - targX);
        float dy = Math.abs(y - targY);

        if (dx > dy) {
            if (x < targX ){
                direction("right");}
                if (x > targX){
                direction("left");}
        } else {
            if (y < targY){
                direction("up");}
                if (y > targY){
                direction("down");}
        }
    }

    private void direction(String direction) {
        switch (direction) {
            case ("left"):
            case ("right"):
                if (map.get(direction)) {// если true                  
                    if (direction.equals("left")) {
                        x--;                        
                    }
                    else {
                        x++;
                    }
                    break;
                } else {
                    if (map.get("up")) {
                        y++;   
                    }
                    if (map.get("down")) {
                        y--;
                    }
                    break;
                }
          
            case ("up"):
            case ("down"):
                if (map.get(direction)) {
                    if (direction.equals("down")) {
                        y--;                       
                    } else {
                        y++;
                    }
                    break;
                } else {
                    if (map.get("right")) {
                        x++;                
                    }
                    if (map.get("left")) {
                        x--;
                    }
                    break;
                }
        }
   
    }

    private void checkFilled(ArrayList<BaseHero> team) {       
        for (BaseHero u : team) {
            if((u.getPos()[0] == x+1) & (u.getPos()[1]  == y)) map.replace("right", false) ;
            if((u.getPos()[0] == x-1) & (u.getPos()[1] == y)) map.replace("left", false);
            if((u.getPos()[0]== x) & (u.getPos()[1] == y+1)) map.replace("up", false);
            if((u.getPos()[0] == x) & (u.getPos()[1] == y-1)) map.replace("down", false);
        }    
    }
}
