package com.mygdx.game.Persons.Wizards;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Persons.Textures;

/**колдун */
public class Sorcerer extends Wizards{

    public Sorcerer(String name,int x,int y,String color) {
        super(name, 9, "магический фокус", x, y);
        super.kevlar=12;
        super.attacks=17; 
        super.power=5;
        super.speed=5;
        super.teamColor=color;
        this.img=new Textures("units/Sorcerer.png");
        this.image=new Texture ("units/Sorcerer.png");
    }

    @Override
    public String getinfo() {
       return "колдун";
    }


}
