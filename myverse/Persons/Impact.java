package Persons;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.SortedMap;

public class Impact {
 
    /**ближайшая цель  */
    public BaseHero nearestPoint(BaseHero current,ArrayList<BaseHero> team) {
        int[] thispos= current.getPos();        
        LinkedHashMap<Double,Integer> result = new LinkedHashMap<>(team.size());
        for (BaseHero hero : team) {//добавление растояния
            if(hero.getStatus().equals("Жив") && (current.getId()!=hero.getId())){
            result.put(distance(thispos,hero.getPos()),hero.getId());}
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

    private static double distance(int[] posA,int[] posB) { //
        return Math.sqrt(Math.pow(posA[0] - posB[0], 2) + Math.pow(posA[1] - posB[1], 2));
    }

}
