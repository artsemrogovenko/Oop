package Persons.Shooters;
/** снайпер */
public class Sniper extends Shooters {
    //private int power=random(8,10);


    public Sniper(String name,int x,int y,String color) {
        super(name, 9, "стрелы",x, y);
        super.kevlar=10;
        super.hp=15;
        super.maxHp=15;
        super.attacks=12;
        super.minPower=8;
        super.maxPower=10;
        super.patrons=32;
        super.teamColor=color;
    }

    @Override
    public String getinfo() {
        return "снайпер";
    }

    // @Override
    // public int showPower() {
    //     return power;
    // }
}
