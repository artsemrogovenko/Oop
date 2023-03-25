package Persons.Mercenary;

/**копейщик  */
public class Spearman extends Mercenary {

  
    public Spearman(String name,int x ,int y,String color) {
        super(name, 4, "копьё",x, y);
        super.kevlar=5;
        super.attacks=4;
        super.teamColor=color;
        super.minPower=1;
        super.maxPower=3;
    }

    @Override
    public String getinfo() {
       return "копейщик";
    }

}
