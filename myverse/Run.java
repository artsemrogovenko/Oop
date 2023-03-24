import java.util.*;
import Persons.Console.AnsiColors;

import Persons.Console.ConsoleView;
import Persons.BaseHero;
import Persons.HeroNames;
import Persons.NotAliveExeption;
import Persons.Peasant;

import Persons.Wizards.*;
import Persons.Mercenary.*;
import Persons.Shooters.*;

public class Run {

    private static ArrayList<BaseHero> teamA = new ArrayList<>();
    private static ArrayList<BaseHero> teamB = new ArrayList<>();
    private static String colorA = AnsiColors.GREEN_b;
    private static String colorB = AnsiColors.RED_b;
    private static int step;
    private static String currentTeam;

    public static void main(String[] args) throws Exception {

    //     System.out.println("\t%-3s\t⚔️ %-3d\t\uD83D\uDEE1 %-3d\t♥️%-3d%%\t☠️%-3d\t ");

    Scanner sc = new Scanner(System.in);
    init();
    boolean loop= true;
    
    while (loop) {
        ConsoleView.showConsole(step, teamA, teamB);
        try {
            next();
            step++;
            sc.nextLine();
        } catch (NoPatronsException e) {
            System.out.println(e.getMessage()); 
            throw new NotAliveExeption("Конец игры");
                   
        } catch (NotAliveExeption e) {
            System.out.println(e.getMessage()); 
            System.out.println("\nПобедила команда " + currentTeam);
            sc.close();
            ConsoleView.showConsole(step, teamA, teamB);
            loop=false;
        }         
        // System.out.println("Победила команда " + currentTeam);
        // sc.close();
    }
    }
    
   public static void init(){
       step = 1;
       currentTeam = "";
    for (int i = 0; i < 10; i++) {
        switch (new Random().nextInt(6)) {
            case 0: teamA.add(new Peasant(setNames(),i,0,colorA)); break;
            case 1: teamA.add(new Sorcerer(setNames(),i,0,colorA)); break;
            case 2: teamA.add(new Rogue(setNames(),i,0,colorA)); break;
            case 3: teamA.add(new Sniper(setNames(),i,0,colorA)); break;
            default : teamA.add(new Spearman(setNames(),i,0,colorA)); break;    
        }
        switch (new Random().nextInt(6)) {
            case 0: teamB.add(new Peasant(setNames(),i,9,colorB)); break;
            case 1: teamB.add(new Spearman(setNames(),i,9,colorB)); break;
            case 2: teamB.add(new Crossbowman(setNames(),i,9,colorB)); break;
            case 3: teamB.add(new Monk(setNames(),i,9,colorB)); break;
            default : teamB.add(new Spearman(setNames(),i,9,colorB)); break;    
        }
    }

}

 public static void next() throws Exception{
     ArrayList<BaseHero> teams = new ArrayList<>();
     teams.addAll(teamA);
     teams.addAll(teamB);

     teams.sort(new Comparator<BaseHero>() { //сортировать по id ..
        @Override
        public int compare(BaseHero b1, BaseHero b2) {
            return (b1.getId() - b2.getId());
        }
    });

     for (BaseHero e : teams) {//сброс значков пепед показом
         e.resetIcon();
     }

    for (BaseHero hero: teams)
     {
         if (teamA.contains(hero)) {
             currentTeam = "teamA";
             teamnotpatrons(teamA);
             hero.step(teamB, teamA);

            } else {
                currentTeam = "teamB";
                teamnotpatrons(teamB);
                hero.step(teamA, teamB);
         }
     }   
    
    

 }

    public static String setNames() { // генератор имен из enum
        return HeroNames.values()[new Random().nextInt(HeroNames.values().length)].toString();
    }
  
    public static void teamnotpatrons(ArrayList<BaseHero> team) throws NoPatronsException  {
        int count = 0;
        for (BaseHero u : team) {
            if (u.showPatrons() == 0) {
                count++;
            }
        }
        if (count == team.size()) {
            System.out.println();
           throw new NoPatronsException("У команды "+team.toString()+"нет снарядов");
        }
    }


}


 class NoPatronsException extends Exception {
    public  NoPatronsException(String str) {
        super(str);
    }
}