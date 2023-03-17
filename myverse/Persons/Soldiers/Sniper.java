package Persons.Soldiers;
/** снайпер */
public class Sniper extends Soldiers {
    private int power=random(8,10);

    public Sniper(String name,int x,int y) {
        super(name, 9, "стрелы",x, y);
        this.kevlar=10;
        this.hp=15;
        this.maxHp=15;
        this.attacks=12;
        this.patrons=32;
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
