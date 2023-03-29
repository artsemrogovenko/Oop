package com.mygdx.game.Persons;

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

    public static double distance(int[] posA, int[] posB) { //
        return Math.sqrt(Math.pow(posA[0] - posB[0], 2) + Math.pow(posA[1] - posB[1], 2));
    }

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


    public void randomPlace(int maxCell) {
        int[] randomPos = { new Random().nextInt(maxCell),
                new Random().nextInt(maxCell) };
        if (repeats(randomPos)) {
            randomPlace(maxCell);
        } else {
            reserving(randomPos);
        }
    }

//
//     public void speedmove(int[] start, int[] end) {
//        double value=distance(start,end)  / this.speed;
//     System.out.println("время для новой позиции" + value);
//     }

}
