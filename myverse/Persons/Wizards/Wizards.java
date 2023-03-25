package Persons.Wizards;
import Persons.BaseHero;
import Persons.Peasant;

import java.util.ArrayList;

public class Wizards extends Peasant{
    protected static int mana=1;
    protected int power;
    
    public Wizards(String name,int speed, String ammo,int x,int y) {
        super(name, speed, ammo, x, y);
        this.hp=30;
        this.maxHp=30;
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
            System.out.printf("%s %s id:%d лечит %s %s %d количество %d\n",
            this.getinfo(),this.name,this.getId(),target.getinfo(),target.getName(),target.getId(),value);       
            target.addHp(value);   //пополняет здоровье      
        }
    
}
