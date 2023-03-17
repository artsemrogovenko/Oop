package Persons.Mercenary;

import java.util.ArrayList;

import Persons.BaseHero;

/**копейщик  */
public class Spearman extends Mercenary {
    private int power=random(1,3);
  
    public Spearman(String name,int x ,int y) {
        super(name, 4, "копьё",x, y);
        this.kevlar=5;
        this.hp=10;
        this.maxHp=10;
        this.attacks=4;
    }
    @Override
    public String getinfo() {
       return "копейщик";
    }

    @Override 
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam){
        System.out.println("бросил копье");
    }
}
