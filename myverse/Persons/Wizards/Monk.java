package Persons.Wizards;

import Persons.Peasant;
/**монах */
public class Monk extends Peasant {
   private final int mana=1;
   private int power=-4;
   public Monk(String name) {
      super(name, 5, "дротики");
      super.kevlar=7;
      super.hp=30;
      super.maxHp=30;
      super.attacks=17;
   }

   @Override
   public String getinfo() {
      return "монах";
   }
   
}
