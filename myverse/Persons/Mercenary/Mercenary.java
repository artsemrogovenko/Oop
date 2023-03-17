package Persons.Mercenary;

import Persons.Peasant;

public class Mercenary extends Peasant{

    public Mercenary(String name, int speed, String ammo,int x ,int y) {
        super(name, speed, ammo,x, y);
        super.hp=10;
        super.maxHp=10;
    }

}
