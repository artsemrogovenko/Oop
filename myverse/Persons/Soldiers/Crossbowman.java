package Persons.Soldiers;

import java.util.ArrayList;

import Persons.BaseHero;
import Persons.Peasant;

/** арбалетчик */
public class Crossbowman extends Peasant {

    public Crossbowman(String name) {
        super(name, 5, "арбалет");
    }

    @Override
    public String getinfo() {
        return "арбалетчик";
    }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam) { //стрелять если жив и есть ли патроны
        if (super.patrons > 0 && super.status.equals("Жив")) {
            for (int i = 0; i < enemy.size(); i++) {
                if (enemy.get(i).getStatus().equals("Жив")) {//если враг не мертв
                    System.out.printf("Арбалетчик %s с патронами %d выстрелил в %s, Патронов осталось %d\n",
                    this.Info(),super.patrons--,enemy.get(i).Info(),super.patrons);
                }
                break;
            }
            for (int i = 0; i < myTeam.size(); i++) { //если есть в команде крестьянин, добавить стрелы
                if (myTeam.get(i).getinfo().equals("крестьянин")) {
                    ++super.patrons;
                    System.out.printf("%s пополнят запас, патронов %d\n",this.Info(),super.patrons);
                }
            }

        } else
            System.out.println("арбалетчик не выстрелит");
    }
    
}
