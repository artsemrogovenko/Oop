package com.mygdx.game.Persons;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
    

public class Impact {

    /**ближайшая цель  */
    public BaseHero nearestPoint(BaseHero current, ArrayList<BaseHero> team) throws NotAliveExeption   {
        double tempdistance = 0.0;
        int[] thispos= current.getPos();
        LinkedHashMap<Double, BaseHero> result = new LinkedHashMap<>(team.size());
        for (BaseHero hero : team) {//добавление растояния
            if (hero.getStatus().equals("Жив") && (current.getId() != hero.getId())) { // если персонаж жив и персонаж не является самим собой

                result.put(current.distance(thispos, hero.getPos()), hero);
                tempdistance = current.distance(thispos, hero.getPos());
            }
        }

        int id=-1; //поиск наименьшего
        for (Map.Entry<Double, BaseHero> unit: result.entrySet()) {
            if(unit.getKey()<tempdistance){
                tempdistance=unit.getKey();
                id=unit.getValue().getId();
            }
        }

        BaseHero unit= result.get(tempdistance);

        switch (current.direction) {
            case ("right"): {
                    if (current.getPos()[0] < result.get(tempdistance).getPos()[0]){
                    current.img.flip("");
                    current.direction = "left";
                }
            }
            break;
            case ("left"):
                if (current.getPos()[0] > result.get(tempdistance).getPos()[0]) {
                    current.img.flip("");
                    current.direction = "right";
                }
                break;
        }
        System.out.println(unit.Info());


        int countAlive=0;
        for (BaseHero e : team) {
            if(e.getStatus().equals("Жив")){
                countAlive++;
            }
        }  
        if(countAlive==0){
          throw new NotAliveExeption("Нет живых противников");
        }
        
        for (BaseHero i : team) {// выбор обьекта по id
            if(id==i.getId() ){
                //System.out.println("ближайший " + i.getId());
                return i;
            }
        }
        return unit;
    }
}
/*
public class Impact {

    */
/**ближайшая цель  *//*

    public BaseHero nearestPoint(BaseHero current, ArrayList<BaseHero> team) throws NotAliveExeption {
        double tempdistance = 0.0;
        int[] thispos = current.getPos();
        LinkedHashMap<Double, BaseHero> result = new LinkedHashMap<>(team.size());
        for (BaseHero hero : team) {//добавление растояния
            if (hero.getStatus().equals("Жив") && (current.getId() != hero.getId())) { // если персонаж жив и персонаж не является самим собой
                result.put(current.distance(thispos, hero.getPos()), hero);
                tempdistance = current.distance(thispos, hero.getPos());
            }
        }

        int id = -1; //поиск наименьшего
        for (Map.Entry<Double, BaseHero> unit : result.entrySet()) {
            if (unit.getKey() < tempdistance) {
                tempdistance = unit.getKey();
                id = unit.getValue();
            }
        }

        BaseHero unit = result.get(tempdistance);


        System.out.println(unit.Info());


        int countAlive = 0;
        for (BaseHero e : team) {
            if (e.getStatus().equals("Жив")) {
                countAlive++;
            }
        }
        //if(countAlive==0){
        if (unit == null || countAlive == 0) {
            throw new NotAliveExeption("Нет живых противников");
        }

        for (BaseHero i : team) {// выбор обьекта по id
            if (id == i.getId()) {
                //System.out.println("ближайший " + i.getId());
                return i;
            }
        }
        return unit;
    }
}*/
