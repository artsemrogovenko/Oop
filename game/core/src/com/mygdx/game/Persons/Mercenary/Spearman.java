package com.mygdx.game.Persons.Mercenary;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Persons.Textures;

/**копейщик  */
public class Spearman extends Mercenary {
Sound sound;
    public Spearman(String name,int x ,int y,String color) {
        super(name, 4, "копьё",x, y);
        super.kevlar=5;
        super.attacks=4;
        super.teamColor=color;
        super.minPower=1;
        super.maxPower=3;
        this.img=new Textures("units/SpearMan.png");
        this.image=new Texture ("units/SpearMan.png");
    }

    @Override
    public String getinfo() {
       return "копейщик";
    }
    @Override
    public void soundAttack(){
        sound= Gdx.audio.newSound(Gdx.files.internal("sounds/axehit.mp3" ) );
        sound.setVolume(0,.125f);
        sound.play();
    }
}
