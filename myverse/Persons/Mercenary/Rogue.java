package Persons.Mercenary;

import java.util.ArrayList;

import Persons.BaseHero;
import Persons.Peasant;
/**разбойник  */
public class Rogue extends Peasant {
    private int power=random(2,4);
    
    public Rogue(String name,int x ,int y) {
        super(name, 6, "мачете",x, y);
        this.kevlar=3;
        this.hp=10;
        this.maxHp=10;
        this.attacks=8;
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
