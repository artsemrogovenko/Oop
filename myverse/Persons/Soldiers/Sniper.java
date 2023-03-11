package Persons.Soldiers;

import Persons.Peasant;

/** снайпер */
public class Sniper extends Peasant {

    public Sniper(String name) {
        super(name, 4, "лук");
    }

    @Override
    public String getinfo() {
        return "снайпер";
    }

    @Override
    public void step() {
        System.out.println("выстрелил");
    }
}
