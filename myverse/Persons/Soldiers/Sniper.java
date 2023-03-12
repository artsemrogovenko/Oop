package Persons.Soldiers;

import java.util.ArrayList;

import Persons.BaseHero;
import Persons.Impact;
import Persons.Peasant;
/** снайпер */
public class Sniper extends Peasant {
private int power=random(8,10);

    public Sniper(String name) {
        super(name, 9, "стрелы");
        super.kevlar=10;
        super.hp=15;
        super.maxHp=15;
        super.attacks=12;
        super.patrons=32;
    }

    @Override
    public String getinfo() {
        return "снайпер";
    }

    private Impact targ = new Impact();
    
    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam) { //стрелять если жив и есть ли патроны
        if (super.patrons > 0 && super.status.equals("Жив")) {
            for (int i = 0; i < enemy.size(); i++) {
              /*   if (enemy.get(i).getStatus().equals("Жив")) {//если враг не мертв
                    System.out.println(enemy.get(i).Info()+" hp: "+enemy.get(i).gethp());
                    System.out.printf("Снайпер %s со стрелами %d выстрелил в %s, Стрел осталось %d\n",
                    this.Info(),super.patrons,enemy.get(i).Info(),super.patrons);
                    attack(enemy.get(i), power);
                    System.out.println(enemy.get(i).Info()+" hp: "+enemy.get(i).gethp());
                    BaseHero target= targ.nearestPoint(this, enemy);
                }
                */
                BaseHero target= targ.nearestPoint(this, enemy);
                if(super.patrons > 0 && target!=null){
                System.out.println("Цель "+target.Info());
                System.out.printf("Снайпер %s со стрелами %d выстрелил в %s сила урона %d\n",
                this.Info(),super.patrons,target.Info(),power);   
                attack(target, power);
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
