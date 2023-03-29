package com.mygdx.game.Persons;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.Persons.Console.IconsState;
/** нейтральный персонаж */
public abstract class BaseHero implements HeroInterface{ // нейтральный персонаж    
    // например бот или наблюдатель
    protected String name; // имя
    protected String status;// живой, нет , наблюдатель
    protected int speed; // подвижность
    private final int id;
    public Positions position;
    private static int count;
    protected int hp;
    protected int maxHp;
    protected String teamColor;
    protected IconsState iconState;
    public Textures img;
    protected Texture image;
    protected double time;
    protected String direction;

    public BaseHero(String name, String status, int speed) {
        this.name = name;
        this.status = status;
        this.speed = speed;
        count++;
        this.id = count;       
        this.iconState=new IconsState();
        this.img=new Textures("units/empty.png");
        this.direction="right";
    }

    public Sprite getSpr(){
        return img.getSpr();
    }
    public Texture gettex(){
        return this.img.getTex();
    }
    public Texture getPath(){
        return this.image;
    }

    public void setTexture(String s){
         this.img=new Textures(s);
    }
    public void resetIcon(){
        this.iconState.resState();       
    }

    public void setIcon(String s, int v){
        resetIcon();
        this.iconState=new IconsState(s,v);       
    }

    public String geticon() {
    return iconState.getState();
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
    public double getTime(){ return this.time;}
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


}
