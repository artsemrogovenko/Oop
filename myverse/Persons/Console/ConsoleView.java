package Persons.Console;

import Persons.BaseHero;
import java.util.ArrayList;
import java.util.Collections;

public class ConsoleView {

    /** игровое поле */
    public static void showConsole(int iter, ArrayList<BaseHero> teamA, ArrayList<BaseHero> teamB) {
        ArrayList<BaseHero> teams = new ArrayList<>(teamA.size() + teamB.size());
        teams.addAll(teamA);
        teams.addAll(teamB);

        boolean empty = false;
        String delimeter = String.join("", Collections.nCopies((teams.size() / 2) * 3, "-"));

        StringBuilder table = new StringBuilder();
        table.append(String.format("\nШаг %d %50s %50s", iter, "команда А", "команда Б\n"));

        for (int x = 0; x < 10; x++) { // строки
            empty = true;
            table.append(delimeter + "\n");
            for (int y = 0; y < 10; y++) { // столбцы
                for (int i = 0; i < teams.size(); i++) {// пробежаться по списку на совпадение координат

                    if (teams.get(i).position.getPos()[0] == x && teams.get(i).position.getPos()[1] == y) {
                        if (teams.get(i).getStatus().equals("dead")) {

                            table.append(String.format(AnsiColors.BLACK_b + "%-2d" + AnsiColors.RESET,
                                    teams.get(i).getId()));// нарисовать игрока
                        } else
                            table.append(String.format(teams.get(i).teamColor() + "%-2d" + AnsiColors.RESET,
                                    teams.get(i).getId()));// нарисовать игрока
                        empty = false;
                        break;
                    }

                    empty = true;
                }
                if (empty) {
                    table.append("  ");
                }
                table.append("|");
            }

            String[] line = LineTeams.showlist(x, teamA, teamB);
            System.out.printf("%s\t   %-1s\t%1s\t\t%1s\t%-1s\n",table,line[0], line[1], line[2], line[3]);
            table.replace(0, table.capacity(), "");
        }
        System.out.println(delimeter);
        // for (BaseHero e : teamA) {// сброс значков
        //     e.resetIcon();
        // }
        // for (BaseHero e : teamB) {// сброс значков
        //     e.resetIcon();
        // }

    }   
}
