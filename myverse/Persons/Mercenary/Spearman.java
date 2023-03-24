package Persons.Mercenary;

import Persons.BaseHero;

/**копейщик  */
public class Spearman extends Mercenary {
    private int power=random(1,3);
  
    public Spearman(String name,int x ,int y,String color) {
        super(name, 4, "копьё",x, y);
        this.kevlar=5;
        this.attacks=4;
        this.teamColor=color;
    }
    @Override
    public String getinfo() {
       return "копейщик";
    }

    @Override
    public void attack(BaseHero target, int value) {
     System.out.println(this.name+" кидает копье в " +target.getName()+" сила урона "+value);  
        super.attack(target, random(1,3));
    }


}
