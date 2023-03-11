package Persons.Mercenary;

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
    public void step(){
        System.out.println("нападает");
    }
}
