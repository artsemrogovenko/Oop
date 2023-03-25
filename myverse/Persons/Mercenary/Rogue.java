package Persons.Mercenary;

/**разбойник  */
public class Rogue extends Mercenary {

    
    public Rogue(String name,int x ,int y,String color) {
        super(name, 6, "мачете",x, y);
        super.kevlar=3;
        super.attacks=8;
        super.teamColor=color;
        super.minPower=2;
        super.maxPower=4;
    }

    @Override
    public String getinfo() {
       return "разбойник";
    }



}
