package Persons.Soldiers;

import java.util.ArrayList;

import Persons.BaseHero;
import Persons.Peasant;
import Persons.Impact;
/** арбалетчик */
public class Crossbowman extends Peasant {
    private int power=random(2,3);

    public Crossbowman(String name) {
        super(name, 4, "стрелы");
        super.kevlar=3;
        super.hp=10;
        super.maxHp=10;
        super.attacks=6;
        super.patrons=16;
    }

    @Override
    public String getinfo() {
        return "арбалетчик";
    }    
    private Impact targ = new Impact();

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam) { //стрелять если жив и есть ли патроны
        if (super.patrons > 0 && super.status.equals("Жив")) {
            for (int i = 0; i < enemy.size(); i++) {
                //if (enemy.get(i).getStatus().equals("Жив")) {//если враг не мертв
                    //System.out.println(enemy.get(i).Info());
                    //System.out.printf("Арбалетчик %s со стрелами %d выстрелил в %s сила урона %d\n",
                    //this.Info(),super.patrons,enemy.get(i).Info(),power);                  
                    //System.out.printf("дистанция %.1f \n",distance(this.getPos(),enemy.get(i).getPos())); 
                    BaseHero target= targ.nearestPoint(this, enemy);
                    if(super.patrons > 0 && target!=null){
                    System.out.println("Цель "+target.Info());
                    System.out.printf("Арбалетчик %s со стрелами %d выстрелил в %s сила урона %d\n",
                    this.Info(),super.patrons,target.Info(),power);   
                    attack(target, power);
                    System.out.println(target.Info());
                    System.out.printf("Стрел осталось %d\n",super.patrons);
                    }
               // }
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
