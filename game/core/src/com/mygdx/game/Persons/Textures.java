package com.mygdx.game.Persons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Textures {
    BitmapFont font = new BitmapFont(); //or use alex answer to use custom font
    private  String direction;
    private   Sprite sprite;
    private  Texture tex;


    public Textures(String location) {
        direction="right";
        this.tex=new Texture(location);
        sprite=new Sprite(tex);
    }

    private void rotate(String dir){
        if(dir.equals("left") & direction.equals("right")){
            sprite.flip(true, false);
            direction="left";
        }
        if(dir.equals("right") & direction.equals("left")){
            this.sprite.flip(true, false);
            direction="right";
        }
    }
   //    private void rotate(String dir){
   //         this.sprite.flip(true, false);
   // }

    public Sprite getSpr(){
        return sprite;
    }
    public  Texture getTex(){
        return this.tex;
    }

    public void flip(String dir){
        rotate(dir);
    }

//    public void window(int hp,int kevlar,int patrons){
//        batch.begin();
//        batch.draw(fon, 0, 0);
//        String outStr = String.format("\t%-3s\t⚔%-3d\t\uD83D\uDEE1 %-3d\t♥%-3d%%\t"☠"
//                font.draw(batch, "Hello World!", 10, 10);
//    }

}
