package Persons.Wizards;

/**колдун */
public class Sorcerer extends Wizards{

    private static int power=5;
    
    public Sorcerer(String name,int x,int y,String color) {
        super(name, 9, "магический фокус",power, x, y);
        super.kevlar=12;
        super.attacks=17; 
        super.teamColor=color;
    }

    @Override
    public String getinfo() {
       return "колдун";
    }

}
