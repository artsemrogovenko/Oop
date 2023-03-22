
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Persons.Console.AnsiColors;

import Persons.Console.ConsoleView;
import Persons.BaseHero;
import Persons.HeroNames;
import Persons.Peasant;

import Persons.Wizards.*;
import Persons.Mercenary.*;
import Persons.Shooters.*;

public class Run {
     
    public static void main(String[] args)    {

        ArrayList<BaseHero> teamA = new ArrayList<>();
        ArrayList<BaseHero> teamB = new ArrayList<>();
        String tA = AnsiColors.GREEN_b;
        String tB = AnsiColors.RED_b;

         for (int i = 0; i < 10; i++) {
             switch (new Random().nextInt(4)) {
                 case 0: teamA.add(new Peasant(setNames(),i,0,tA)); break;
                 case 1: teamA.add(new Sorcerer(setNames(),i,0,tA)); break;
                 case 2: teamA.add(new Rogue(setNames(),i,0,tA)); break;
                 case 3: teamA.add(new Sniper(setNames(),i,0,tA)); break;
             }
             switch (new Random().nextInt(4)) {
                 case 0: teamB.add(new Peasant(setNames(),i,9,tB)); break;
                 case 1: teamB.add(new Spearman(setNames(),i,9,tB)); break;
                 case 2: teamB.add(new Crossbowman(setNames(),i,9,tB)); break;
                 case 3: teamB.add(new Monk(setNames(),i,9,tB)); break;                
             }
         }
    
       
         ArrayList<BaseHero> result = new ArrayList<>();
         result.addAll(teamA);
         result.addAll(teamB);

    //     System.out.println("\t%-3s\t⚔️ %-3d\t\uD83D\uDEE1 %-3d\t♥️%-3d%%\t☠️%-3d\t ");
 
    Scanner sc = new Scanner(System.in);
  
    int step=1;

    String currentTeam="";
    while (true) {
        for (BaseHero hero : result) { // выстрелить по тем у кто жив и есть ли стрелы
             for (BaseHero e : result) {
                 e.resetIcon();
             };

             try {
                 if (teamA.contains(hero)) {
                     hero.step(teamB, teamA);
                     currentTeam = "teamB";
                 } else {
                     hero.step(teamA, teamB);
                     currentTeam = "teamA";
                 }

             } catch (NullPointerException e) {
                 System.out.println("Победила команда " + currentTeam);
                 sc.close();
                 break;
             }

            ConsoleView.showConsole(step,teamA, teamB);
            sc.nextLine();
            step++;
        } 

    }

}

    public static String setNames() { // генератор имен из enum
        return HeroNames.values()[new Random().nextInt(HeroNames.values().length)].toString();
    }
  

}
 

