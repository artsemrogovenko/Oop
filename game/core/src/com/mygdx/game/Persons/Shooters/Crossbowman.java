package com.mygdx.game.Persons.Shooters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Persons.Textures;

/** арбалетчик */
public class Crossbowman extends Shooters {
  Sound sound;
    public Crossbowman(String name,int x,int y,String color) {
        super(name, 4, "стрелы",x, y);
        super.kevlar=3;
        super.hp=10;
        super.maxHp=10;
        super.attacks=6;
        super.minPower=2;
        super.maxPower=3;
        super.patrons=16;
        super.teamColor=color;
        this.img=new Textures("units/CrossBowMan.png");
        this.image=new Texture("units/CrossBowMan.png");
    }

    @Override
    public String getinfo() {
        return "арбалетчик";
    }
    @Override
    public void soundAttack(){
        sound= Gdx.audio.newSound(Gdx.files.internal("sounds/cbow.mp3" ) );
        sound.setVolume(0,.125f);
        sound.play();
    }
 
}