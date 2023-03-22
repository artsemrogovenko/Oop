package Persons.Wizards;

/**монах */
public class Monk extends Wizards {
   private int power=-4;
   
   public Monk(String name,int x,int y,String color) {
      super(name, 5, "дротики",x, y);
      this.kevlar=7;
      this.attacks=17;
      this.teamColor=color;
   }

   @Override
   public String getinfo() {
      return "монах";
   }
   
}
