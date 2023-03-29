package com.mygdx.game.Persons.Mercenary;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Persons.Textures;

/**разбойник  */
public class Rogue extends Mercenary {
    Sound sound;
    public Rogue(String name,int x ,int y,String color) {
        super(name, 6, "мачете",x, y);
        super.kevlar=3;
        super.attacks=8;
        super.teamColor=color;
        super.minPower=2;
        super.maxPower=4;
        this.img=new Textures("units/Rogue.png");
        this.image=new Texture ("units/Rogue.png");
    }

    @Override
    public String getinfo() {
       return "разбойник";
    }

    @Override
    public void soundAttack(){
        sound= Gdx.audio.newSound(Gdx.files.internal("sounds/spearbasic_02.mp3" ) );
        sound.setVolume(0,.125f);
        sound.play();
    }

}
