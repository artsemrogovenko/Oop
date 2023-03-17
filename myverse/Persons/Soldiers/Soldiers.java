package Persons.Soldiers;

import java.util.ArrayList;

import Persons.BaseHero;
import Persons.Impact;
import Persons.Peasant;

public class Soldiers extends Peasant {    
    private Impact targ = new Impact();
    protected int soldPow;

    public Soldiers(String name, int speed, String ammo, int x, int y) {
        super(name, speed, ammo, x, y);
    }


    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam) { //стрелять если жив и есть ли патроны
        if (super.patrons > 0 && super.status.equals("Жив")) {
            for (int i = 0; i < enemy.size(); i++) {
 
                BaseHero target= targ.nearestPoint(this, enemy);
                if(super.patrons > 0 && target!=null){
                System.out.println("Цель "+target.Info());
                System.out.printf("%s %s со стрелами %d выстрелил в %s сила урона %d\n",
                this.getinfo(),this.Info(),super.patrons,target.Info(),this.showPower());   
                attack(target, this.showPower());
                System.out.println(target.Info());
                System.out.printf("Стрел осталось %d\n",super.patrons);
                }
                break; 
            }
            for (int i = 0; i < myTeam.size(); i++) { //если есть в команде крестьянин, добавить стрелы
                if (myTeam.get(i).getinfo().equals("крестьянин")) {
                    ++super.patrons;
                    System.out.printf("%s пополнил запас, стрел %d\n",this.name,super.patrons);
                }
            }

        } else
        System.out.printf("%s не выстрелит: патроны=%d\n",this.Info(),this.patrons);
    }



}
