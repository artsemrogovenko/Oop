package Persons.Wizards;

/**монах */
public class Monk extends Wizards {
   private static int power=4;
   
   public Monk(String name,int x,int y,String color) {
      super(name, 5, "дротики",power,x, y);
      super.kevlar=7;
      super.attacks=12;
      super.hp=30;
      super.speed=5;
      super.teamColor=color;
   }

   @Override
   public String getinfo() {
      return "монах";
   }
   
}
