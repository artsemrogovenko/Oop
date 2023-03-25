package Persons.Shooters;
/** арбалетчик */
public class Crossbowman extends Shooters {
  
    public Crossbowman(String name,int x,int y,String color) {
        super(name, 4, "стрелы",x, y);
        super.kevlar=3;
        super.hp=10;
        super.maxHp=10;
        super.attacks=6;
        super.minPower=2;
        super.maxPower=3;
        super.patrons=16;
        super.teamColor=color;
    }

    @Override
    public String getinfo() {
        return "арбалетчик";
    }

 
}