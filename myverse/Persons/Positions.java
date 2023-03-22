package Persons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class Positions {

    protected int x;
    protected int y;

    public Positions(int x, int y) {
            this.x = x;
            this.y = y;
    }

    public double distance(int[] posA, int[] posB) { //
        return Math.sqrt(Math.pow(posA[0] - posB[0], 2) + Math.pow(posA[1] - posB[1], 2));
    }

    // public double distance(int[] posB) { //
    //     return Math.sqrt(Math.pow(this.x - posB[0], 2) + Math.pow(this.y - posB[1], 2));
    // }

    
    public int[] getPos() {
        return new int[] { this.x, this.y };
    }

    public String showPos() {
        return Arrays.toString(getPos());
    }

    public Positions(int maxCell) {
        randomPlace(maxCell);
    }
    private static ArrayList<String> area = new ArrayList<>();
        /** проверка на повторы */
        public static boolean repeats(int[] vales) {
            for (String point : area) {
                if (point.equals(Arrays.toString(vales))) {
                    return true;
                }
            }
            return false;
        }
    /** записать в журнал для след. проверки */
    private void reserving(int[] pos) {
        area.add(Arrays.toString(pos));
    }

    private void showlist() {
        for (int i = 0; i < area.size(); i++) {
            System.out.println(area.get(i));
        }
    }

    public void randomPlace(int maxCell) {
        int[] randomPos = { new Random().nextInt(maxCell),
                new Random().nextInt(maxCell) };
        if (repeats(randomPos)) {
            randomPlace(maxCell);
        } else {
            reserving(randomPos);
        }
    }




    // public void move(int setx, int sety) {
    // System.out.println("время для новой позиции" + distance(setx, sety) /
    // this.speed);
    // }

    /**игровое поле  */
    // public static void showArea(ArrayList<BaseHero> teams) {
    //     boolean empty=false;      
    //     String delimeter =String.join("", Collections.nCopies((teams.size()/2)*3, "-"));
    //     for (int x = 0; x < 10; x++) { //строки
    //         empty=true;
    //         //System.out.printf("\n------------------------------\n");            
    //         System.out.printf("\n%s\n",delimeter);
    //         for (int y = 0; y < 10; y++) {     //столбцы
    //             for (int i = 0; i < teams.size(); i++) {//пробежаться по списку на совпадение координат
                    
    //                 if (teams.get(i).position.getPos()[0] == x && teams.get(i).position.getPos()[1] == y) {
    //                     String Backgr=teams.get(i).teamColor();
    //                     System.out.printf(Backgr+"%-2d"+ AnsiColors.RESET,teams.get(i).getId());//нарисовать игрока

    //                     empty=false;
    //                 break;
    //                 }
    //                 empty=true;                    
    //             }
    //              if(empty) System.out.print("  ");{{
    //              System.out.print("|");}}
    //         }
    //     }
    //     System.out.println();
    // }


}
