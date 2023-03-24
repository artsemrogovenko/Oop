package Persons.Console;
import Persons.BaseHero;
import java.util.ArrayList;

public class LineTeams {

    public static String[] showlist(int line, ArrayList<BaseHero> teamA, ArrayList<BaseHero> teamB) {
       // Icons state = new Icons();
        String tA;
        String tB;
        if (teamA.get(line).getStatus() == "Жив") {       
            tA =  teamA.get(line).Info();
        } else {
           
            tA=String.format("%s %s","☠ ",teamA.get(line).Info());
            //tA = AnsiColors.BLACK_back + teamA.get(line).Info();
        }
        if (teamB.get(line).getStatus() == "Жив") {
            tB = teamB.get(line).Info();
        } else {
            
            tB=String.format("%s%s","☠ ",teamB.get(line).Info());
            //tB = AnsiColors.BLACK_back + teamB.get(line).Info();
        }
        return new String[] {teamA.get(line).geticon(), tA+teamA.get(line).showPos() + AnsiColors.RESET, teamB.get(line).geticon(),  tB+teamB.get(line).showPos() + AnsiColors.RESET };
}


}