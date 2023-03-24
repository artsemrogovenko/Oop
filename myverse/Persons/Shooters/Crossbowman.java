package Persons.Shooters;
/** арбалетчик */
public class Crossbowman extends Shooters {
    private int power=random(2,3);


    public Crossbowman(String name,int x,int y,String color) {
        super(name, 4, "стрелы",x, y);
        super.kevlar=3;
        super.hp=10;
        super.maxHp=10;
        super.attacks=6;
        super.patrons=16;
        super.teamColor=color;
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