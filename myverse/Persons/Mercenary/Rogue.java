package Persons.Mercenary;

import Persons.BaseHero;
import Persons.Peasant;
/**разбойник  */
public class Rogue extends Peasant {
    private int power=random(2,4);
    
    public Rogue(String name,int x ,int y,String color) {
        super(name, 6, "мачете",x, y);
        this.kevlar=3;
        this.attacks=8;
        this.teamColor=color;
    }
    @Override
    public String getinfo() {
       return "разбойник";
    }

   @Override
   public void attack(BaseHero target, int value) {
    System.out.println(this.name+" нападает на "+target.getName());  
       super.attack(target, random(2,4));
   }


}
