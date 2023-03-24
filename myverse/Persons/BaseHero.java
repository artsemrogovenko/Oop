package Persons;


import java.util.Random;

import Persons.Console.IconsState;
/** нейтральный персонаж */
public abstract class BaseHero implements HeroInterface{ // нейтральный персонаж
   // public static final int[] thishero = null;
    // например бот или наблюдатель
    protected String name; // имя
    protected String status;// живой, нет , наблюдатель
    protected int speed; // подвижность
    private final int id;
    public Positions position;
    private static int count;
    protected int hp;
    protected String teamColor;
    protected IconsState iconState;

    public BaseHero(String name, String status, int speed) {
        this.name = name;
        this.status = status;
        this.speed = speed;
        count++;
        this.id = count;       
        this.iconState=new IconsState(); 
    }

    public void resetIcon(){
        this.iconState.resState();       
    }

    public void setIcon(String s, int v){
        resetIcon();
        this.iconState=new IconsState(s,v);       
    }

    public String geticon() {
        try {
            return iconState.getState();
        } catch (Exception e) {
            return "";
        }
    }

    public String teamColor(){
        return this.teamColor;
    }

    public String getStatus(){
        return this.status;
    }

    public static int random(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }

    public String Info() {
        return(String.format("%s %s hp:%d id:%d",
        this.name,this.getinfo(),this.hp,this.id));
    } 

    // @Override
    // public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam) {
    // }

     @Override
     public String getinfo() {
         return "";
     }

    public String getName() {
        return this.name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getId() {
        return id;
    }

    
    public int gethp(){
        return hp;
    }

    public int[] getPos() {
        return position.getPos();
    }

    public String showPos() {
        return position.showPos();
    }

    public double distance(int[] thispos, int[] pos) {
        return Positions.distance(thispos, pos);
    }


    // @Override    
    // public void addHp(int value) {
    // }


}
