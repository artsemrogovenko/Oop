package com.mygdx.game.Persons.Shooters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Persons.Textures;

/** снайпер */
public class Sniper extends Shooters {
    //private int power=random(8,10);
    Sound sound;
    public Sniper(String name,int x,int y,String color) {
        super(name, 9, "стрелы",x, y);
        super.kevlar=10;
        super.hp=15;
        super.maxHp=15;
        super.attacks=12;
        super.minPower=8;
        super.maxPower=10;
        super.patrons=32;
        super.teamColor=color;
        this.img=new Textures("units/Sniper.png");
        this.image=new Texture ("units/Sniper.png");
    }

    @Override
    public String getinfo() {
        return "снайпер";
    }

    // @Override
    // public int showPower() {
    //     return power;
    // }
    @Override
    public void soundAttack(){
        sound= Gdx.audio.newSound(Gdx.files.internal("sounds/arrowshoot1.mp3" ) );
        sound.setVolume(0,.125f);
        sound.play();
    }
}
