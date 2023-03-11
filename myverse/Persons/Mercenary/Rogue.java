package Persons.Mercenary;

import java.util.ArrayList;

import Persons.BaseHero;
import Persons.Peasant;
/**разбойник  */
public class Rogue extends Peasant {

    public Rogue(String name) {
        super(name, 6, "мачете");
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
