package Persons.Wizards;
import Persons.Peasant;

public class Wizards extends Peasant{
    private final int mana=1;
    
    public Wizards(String name,int speed, String ammo,int x,int y) {
        super(name, speed, ammo, x, y);
        this.hp=30;
        this.maxHp=30;
    }

}
