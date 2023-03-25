package Persons.Wizards;

/**монах */
public class Monk extends Wizards {

   
   public Monk(String name,int x,int y,String color) {
      super(name, 5, "дротики",x, y);
      super.kevlar=7;
      super.attacks=12;
      super.power=4;
      super.speed=5;
      super.teamColor=color;
   }

   @Override
   public String getinfo() {
      return "монах";
   }
   
}
