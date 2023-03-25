package Persons.Wizards;

/**колдун */
public class Sorcerer extends Wizards{
    
    public Sorcerer(String name,int x,int y,String color) {
        super(name, 9, "магический фокус", x, y);
        super.kevlar=12;
        super.attacks=17; 
        super.power=5;
        super.speed=5;
        super.teamColor=color;
    }

    @Override
    public String getinfo() {
       return "колдун";
    }

}
