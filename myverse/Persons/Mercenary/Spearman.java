package Persons.Mercenary;

import java.util.ArrayList;

import Persons.BaseHero;
import Persons.Peasant;
/**копейщик  */
public class Spearman extends Peasant {

    public Spearman(String name) {
        super(name, 8, "копьё");
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
