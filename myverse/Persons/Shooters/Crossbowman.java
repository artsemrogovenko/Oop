package Persons.Shooters;
/** арбалетчик */
public class Crossbowman extends Shooters {
    private int power=random(2,3);

    public Crossbowman(String name,int x,int y,String color) {
        super(name, 4, "стрелы",x, y);
        this.kevlar=3;
        this.hp=10;
        this.maxHp=10;
        this.attacks=6;
        this.patrons=16;
        this.teamColor=color;
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