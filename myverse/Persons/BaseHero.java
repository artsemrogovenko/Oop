package Persons;

import java.util.Random;

/** нейтральный персонаж */
public class BaseHero { // нейтральный персонаж
    // например бот или наблюдатель
    protected String name; // имя
    protected String status;// живой, нет , наблюдатель
    protected int speed; // подвижность
    protected int id;
    protected int[] position = { 0, 0 };

    public BaseHero(String name, String status, int speed) {
        this.name = name;
        this.status = status;
        this.speed = speed;
        this.position[0] = random(0, 10);
        this.position[1] = random(0, 10);
    }

    public int random(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }

    public void getInfo() {
        System.out.println(String.format("%s статус %s id %d",
        this.name, this.status,++this.id)); 
    }

    public double distance(int newx, int newy) { //
        return Math.pow(newx - this.position[0], 2) + Math.pow(newy - this.position[1], 2);
    }

    public int[] getPos() {
        return this.position;
    }

    // public void move(int setx, int sety) {
    //     System.out.println("время для новой позиции" + distance(setx, sety) / this.speed);
    // }


    
}