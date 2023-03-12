package Persons.Mercenary;

import java.util.ArrayList;

import Persons.BaseHero;
import Persons.Peasant;
/**разбойник  */
public class Rogue extends Peasant {
    private int power=random(2,4);
    public Rogue(String name) {
        super(name, 6, "мачете");
        super.kevlar=3;
        super.hp=10;
        super.maxHp=10;
        super.attacks=8;
    }
    @Override
    public String getinfo() {
       return "разбойник";
    }

    @Override 
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam){
        System.out.println("нападает");
    }
}
