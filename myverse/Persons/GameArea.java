package Persons;

import java.util.ArrayList;
import java.util.Arrays;

public class GameArea {

    public static ArrayList<String> area = new ArrayList<>();
    /** записать в журнал для след. проверки  */
    public static void reserving(int[] pos) {
        area.add(Arrays.toString(pos));
    }
    public static void showlist(){
        for (int i = 0; i < area.size(); i++) {
            System.out.println(area.get(i));
        }
    }
    /** проверка на повторы  */
    public static boolean repeats(int[] pos) {
        for (String point : area) {
            if (point.equals(Arrays.toString(pos))) {
                return true;
            }
        }
        return false;
    }

    /**игровое поле  */
    public static void showArea(ArrayList<BaseHero> teams) {
        boolean empty=false;
        for (int x = 0; x < 10; x++) { //строки
            empty=true;
            System.out.printf("\n------------------------------\n");
            for (int y = 0; y < 10; y++) {     //столбцы
                for (int i = 0; i < teams.size(); i++) {//пробежаться по списку на совпадение координат
                    if (teams.get(i).position[0] == x && teams.get(i).position[1] == y) {
                        System.out.printf("%-2d",teams.get(i).getId());
                        empty=false;
                        break;
                    }
                    empty=true;
                }
                if(empty) System.out.print("  ");
                System.out.print("|");
            }
        }
        System.out.println();
    }

}
