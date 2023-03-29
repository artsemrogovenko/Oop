package com.mygdx.game.Persons.Shooters;

import java.util.ArrayList;

import com.mygdx.game.Persons.BaseHero;
import com.mygdx.game.Persons.Impact;
import com.mygdx.game.Persons.NotAliveExeption;
import com.mygdx.game.Persons.Peasant;


public class Shooters extends Peasant {
    private Impact targ = new Impact();
    // protected int soldPow;
    private static BaseHero hero2;

    public Shooters(String name, int speed, String ammo, int x, int y) {
        super(name, speed, ammo, x, y);
    }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam) throws NotAliveExeption { // стрелять если жив и есть ли патроны
        if (super.patrons > 0 && super.status.equals("Жив")) {

            hero2 = targ.nearestPoint(this, enemy);

            if (super.patrons > 0) {
                this.setIcon("⚔-", 1);
                soundAttack();
                attack(hero2);
                int count = 0;
                if (super.patrons == 0 && hero2.getStatus().equals("Жив")) {
                    for (int i = 0; i < myTeam.size(); i++) { // если есть в команде крестьянин, добавить стрелы
                        if (myTeam.get(i).getinfo().equals("крестьянин")) {
                            ++super.patrons;
                            count++;
                        }
                    }
                    if (count > 0) {
                        this.setIcon("⚔+", count);
                        System.out.println(this.name + " пополнил стрелы ");
                    }
                }
                // return;
            }
        }
    }

}



