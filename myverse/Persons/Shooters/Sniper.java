package Persons.Shooters;
/** снайпер */
public class Sniper extends Shooters {
    private int power=random(8,10);

    public Sniper(String name,int x,int y,String color) {
        super(name, 9, "стрелы",x, y);
        this.kevlar=10;
        this.hp=15;
        this.maxHp=15;
        this.attacks=12;
        this.patrons=32;
        this.teamColor=color;
    }

    @Override
    public String getinfo() {
        return "снайпер";
    }

    @Override
    public int showPower() {
        return power;
    }
}
