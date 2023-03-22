package Persons.Mercenary;

import java.util.ArrayList;

import Persons.BaseHero;
import Persons.Impact;
import Persons.Peasant;
import Persons.Console.IconsState;

public class Mercenary extends Peasant {

    private static BaseHero hero, hero2;
    private Impact targ = new Impact();

    public Mercenary(String name, int speed, String ammo, int x, int y) {
        super(name, speed, ammo, x, y);
        super.hp = 10;
        super.maxHp = 10;
    }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam) { // стрелять если жив и есть ли патроны
        if (super.patrons > 0 && super.status.equals("Жив")) {

            int power = this.showPower();
            hero2 = targ.nearestPoint(this, enemy);

            System.out.printf("%s с %d %s нашел цель %s \n",
                    this.getinfo(),  super.patrons,this.showAmmo(), hero2.Info());

            hero2.setIcon("♥-", power);
            this.setIcon("⚔-", 1);
            attack(hero2, power);
            

        } else {
            System.out.printf("%s не выстрелит: патроны=%d\n", this.Info(), this.patrons);
        }

    }
}