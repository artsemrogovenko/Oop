package Persons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
/** нейтральный персонаж */
public abstract class BaseHero implements HeroInterface{ // нейтральный персонаж
    public static final int[] thishero = null;
    // например бот или наблюдатель
    protected String name; // имя
    protected String status;// живой, нет , наблюдатель
    protected int speed; // подвижность
    private final int id;
    protected Positions position;
    private static int count;
    protected int hp;

    public BaseHero(String name, String status, int speed) {
        this.name = name;
        this.status = status;
        this.speed = speed;
        count++;
        this.id = count;
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


    public int[] getPos() {
       return this.position.getPos();
    }

    public String showPos(){
        return this.position.showPos();
    }


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
        result = prime * result + Arrays.hashCode(position.getPos());
        result = prime * result + hp;
        return result;
    }

    /**ближайшая цель  */
    public BaseHero nearestPoint(BaseHero current,ArrayList<BaseHero> team) {
        int[] thispos= current.getPos();        
        LinkedHashMap<Double,Integer> result = new LinkedHashMap<>(team.size());
        for (BaseHero hero : team) {//добавление растояния
            if(hero.getStatus().equals("Жив") && (current.getId()!=hero.getId())){ // если персонаж жив и персонаж не является самим собой
            result.put(this.position.distance(thispos,hero.getPos()),hero.getId());}
        }

        result.entrySet().stream() //сортировка по растоянию
        .sorted(Map.Entry.<Double, Integer>comparingByKey())//.reversed())        
        .forEach(System.out::println); // вывод растояние = id
        
        Map.Entry<Double, Integer> minEntry = result.entrySet().stream()// поиск наименьшего ключа
        .min(Comparator.comparing(Map.Entry::getKey))
        .orElse(null);
        result.clear();

        for (BaseHero i : team) {// выбор обьекта по id
            if(minEntry.getValue()==i.getId()){               
                System.out.println("ближайший " + i.getId());
                return i;
            }
        }
        return null;
    }

}
