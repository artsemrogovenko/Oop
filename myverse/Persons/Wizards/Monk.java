package Persons.Wizards;

import Persons.Peasant;
/**монах */
public class Monk extends Peasant {

   public Monk(String name) {
      super(name, 3, "дротики");
   }

   @Override
   public String getinfo() {
      return "монах";
   }
   
}
