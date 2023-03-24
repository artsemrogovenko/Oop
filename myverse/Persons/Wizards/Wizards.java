package Persons.Wizards;
import Persons.BaseHero;
import Persons.Peasant;

import java.util.ArrayList;

public class Wizards extends Peasant{
    protected static int mana=1;
    protected int power;
    
    public Wizards(String name,int speed, String ammo,int power,int x,int y) {
        super(name, speed, ammo, x, y);
        this.hp=30;
        this.maxHp=30;
        this.power=power;
    }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam) {
        if (mana > 0 && super.status.equals("Жив")) {
            this.setIcon("⚔-", mana);
            for (BaseHero u : myTeam) {
                if(this.getId()!=u.getId()){
                u.setIcon("♥+", power);
                healed(u, power);
            }
            }
            mana=0;
        }
        }
        
        private void healed(BaseHero target,int value) {
            System.out.printf("%s %s лечит %s %s количество %d\n",this.getinfo(),this.name,target.getinfo(),target.getName(),value);       
            target.addHp(value);   //враг получает урон       
        }
    
}
