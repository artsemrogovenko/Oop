package Persons.Wizards;
/**колдун */
public class Sorcerer extends Wizards{

    private int power=-5;
    
    public Sorcerer(String name,int x,int y) {
        super(name, 9, "магический фокус", x, y);
        this.kevlar=12;
        this.attacks=17; 
    }

    @Override
    public String getinfo() {
       return "колдун";
    }

}
