package com.mygdx.game.Persons.Wizards;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.mygdx.game.Persons.BaseHero;
import com.mygdx.game.Persons.Peasant;

import java.util.ArrayList;

public abstract class Wizards extends Peasant{
    //protected static int mana=1;
    protected int power;
    Sound sound;
    
    public Wizards(String name,int speed, String ammo,int x,int y) {
        super(name, speed, ammo, x, y);
        this.hp=30;
        this.maxHp=30;
        super.patrons=1;
    }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam) {
        if (patrons > 0 && super.status.equals("Жив")) {
            this.setIcon("⚔-", patrons);
                    soundAttack();
            for (BaseHero u : myTeam) {
                if(this.getId()!=u.getId()){
                u.setIcon("♥+", power);
                healed(u, power);
            }
            }
            this.patrons=0;
        }
        }
        
        private void healed(BaseHero target,int value) {
            System.out.printf("%s %s id:%d лечит %s %s %d количество %d\n",
            this.getinfo(),this.name,this.getId(),target.getinfo(),target.getName(),target.getId(),value);       
            target.addHp(value);   //пополняет здоровье      
        }

    @Override
    public String getinfo() {
        return "монах";
    }

    @Override
    public void soundAttack(){
        sound= Gdx.audio.newSound(Gdx.files.internal("sounds/heal.mp3" ) );
        sound.setVolume(0,.125f);
        sound.play();
    }
}
