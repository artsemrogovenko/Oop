package Persons.Mercenary;

import java.util.ArrayList;

import Persons.BaseHero;
import Persons.Impact;
import Persons.NotAliveExeption;
import Persons.Peasant;

public class Mercenary extends Peasant {

    private static BaseHero hero2;
    private Impact targ = new Impact();
   
    public Mercenary(String name, int speed, String ammo, int x, int y) {
        super(name, speed, ammo, x, y);
        this.hp = 10;
        this.maxHp = 10;        
    }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam)throws NotAliveExeption  { // стрелять если жив и есть ли патроны
        if (super.status.equals("Жив")) {
     
            int power = this.showPower();
                hero2 = targ.nearestPoint(this, enemy);
 
           // System.out.printf("%s с %d %s нашел цель %s \n",
             //       this.getinfo()+" "+this.getName(), super.patrons,this.showAmmo(), hero2.Info());

                   
            if (distance(this.getPos(), hero2.getPos()) <= 1) {
                hero2.setIcon("♥-", power);
                this.setIcon("⚔-", 1);
                attack(hero2, power);
            }            
            else{
                move(this, hero2, myTeam);
            }

        } else {
            System.out.printf("%s не нападет\n", this.Info());
        }

    }

 


   
}