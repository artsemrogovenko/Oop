package Persons.Soldiers;
/** арбалетчик */
public class Crossbowman extends Soldiers {
    private int power=random(2,3);

    public Crossbowman(String name,int x,int y) {
        super(name, 4, "стрелы",x, y);
        this.kevlar=3;
        this.hp=10;
        this.maxHp=10;
        this.attacks=6;
        this.patrons=16;
    }

    @Override
    public String getinfo() {
        return "арбалетчик";
    }
    
    @Override
    public int showPower() {
        return power;
    }
}