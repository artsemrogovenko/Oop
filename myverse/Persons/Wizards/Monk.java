package Persons.Wizards;

import Persons.Positions;

/**монах */
public class Monk extends Wizards {
   private int power=-4;
   
   public Monk(String name,int x,int y) {
      super(name, 5, "дротики",x, y);
      this.kevlar=7;
      this.attacks=17;
   }

   @Override
   public String getinfo() {
      return "монах";
   }
   
}
