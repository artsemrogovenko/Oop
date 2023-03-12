package Persons.Mercenary;

import java.util.ArrayList;

import Persons.BaseHero;
import Persons.Peasant;
/**копейщик  */
public class Spearman extends Peasant {
    private int power=random(1,3);
    public Spearman(String name) {
        super(name, 4, "копьё");
        super.kevlar=5;
        super.hp=10;
        super.maxHp=10;
        super.attacks=4;
    }
    @Override
    public String getinfo() {
       return "копейщик";
    }

    @Override 
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam){
        System.out.println("бросил копье");
    }
}
