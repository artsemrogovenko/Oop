package Persons.Mercenary;

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
    public void step(){
        System.out.println("бросил копье");
    }
}
