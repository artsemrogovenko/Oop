package Persons.Soldiers;

import Persons.Peasant;

/** арбалетчик */
public class Crossbowman extends Peasant {

    public Crossbowman(String name) {
        super(name, 5, "арбалет");
    }

    @Override
    public String getinfo() {
        return "арбалетчик";
    }

    @Override
    public void step() {
        System.out.println("выстрелил");
    }
    
}
