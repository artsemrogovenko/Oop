package com.mygdx.game.Persons.Wizards;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.Persons.Textures;

/**монах */
public class Monk extends Wizards {
   
   public Monk(String name,int x,int y,String color) {
      super(name, 5, "дротики",x, y);
      super.kevlar=7;
      super.attacks=12;
      super.power=4;
      super.speed=5;
      super.teamColor=color;
      this.img=new Textures("units/Monk.png");
      this.image=new Texture ("units/Monk.png");
   }

   @Override
   public String getinfo() {
      return "монах";
   }
   
}
