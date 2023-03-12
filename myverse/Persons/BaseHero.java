package Persons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
/** нейтральный персонаж */
public abstract class BaseHero implements HeroInterface{ // нейтральный персонаж
    public static final int[] thishero = null;
    // например бот или наблюдатель
    protected String name; // имя
    protected String status;// живой, нет , наблюдатель
    protected int speed; // подвижность
    private final int id;
    protected int[] position = { 0, 0 };
    private static int count;
    protected int hp;

    public BaseHero(String name, String status, int speed) {
        this.name = name;
        this.status = status;
        this.speed = speed;
        placeHero();
        count++;
        this.id = count;
    }

    public void placeHero(){
        this.position[0] = random(0, 10);
        this.position[1] = random(0, 10);
        if (GameArea.repeats(this.position)){
            placeHero();
        }
        else {
            GameArea.reserving(this.position);
        }
    }

    public String getStatus(){
        return this.status;
    }

    public int random(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }

    public String Info() {
        return(String.format("%s статус-%s hp:%d id:%d",
        this.name,this.status,this.hp,this.id)); 
    } 

    public double distance(int[] posA,int[] posB) { //
        return Math.sqrt(Math.pow(posA[0] - posB[0], 2) + Math.pow(posA[1] - posB[1], 2));
    }

    public int[] getPos() {
       return this.position;
    }

    public String showPos(){
        return ""+this.position[0]+","+this.position[1];
    }
    // public void move(int setx, int sety) {
    //     System.out.println("время для новой позиции" + distance(setx, sety) / this.speed);
    // }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam) {
    }

    @Override
    public String getinfo() {
        return "";
    }

    public String getName() {
        return name;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + speed;
        result = prime * result + id;
        result = prime * result + Arrays.hashCode(position);
        result = prime * result + hp;
        return result;
    }

}
