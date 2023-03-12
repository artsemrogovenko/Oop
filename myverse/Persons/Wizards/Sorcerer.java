package Persons.Wizards;

import Persons.Peasant;
/**колдун */
public class Sorcerer extends Peasant{
    private final int mana=1;
    private int power=-5;
    
    public Sorcerer(String name) {
        super(name, 9, "магический фокус");
        super.kevlar=12;
        super.hp=30;
        super.maxHp=30;
        super.attacks=17;
    }

    @Override
    public String getinfo() {
       return "колдун";
    }

}
