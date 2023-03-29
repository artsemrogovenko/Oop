package com.mygdx.game;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


import com.mygdx.game.Persons.BaseHero;
import com.mygdx.game.Persons.Console.*;
import com.mygdx.game.Persons.Wizards.Sorcerer;
import com.mygdx.game.Persons.Wizards.Monk;
import com.mygdx.game.Persons.Mercenary.Rogue;
import com.mygdx.game.Persons.Mercenary.Spearman;
import com.mygdx.game.Persons.Shooters.Sniper;
import com.mygdx.game.Persons.Shooters.Crossbowman;
import com.mygdx.game.Persons.Peasant;
import com.mygdx.game.Persons.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;


public class Game extends ApplicationAdapter{
    Texture fon;
    Music music;

   private static LinkedList<BaseHero> teams = new LinkedList<>();
    private static ArrayList<BaseHero> teamA = new ArrayList<>();
    private static ArrayList<BaseHero> teamB = new ArrayList<>();
    private static String colorA = AnsiColors.GREEN_b;
    private static String colorB = AnsiColors.RED_b;
    private static int step;
    private static String currentTeam;



    SpriteBatch batch;

    private static float dx, dy;

    @Override
    public void create () {
        batch = new SpriteBatch();
        fon = new Texture("fons/" + String.valueOf(new Random().nextInt(5)) + ".png");
        music = Gdx.audio.newMusic(
                Gdx.files.internal(
                        "music/paul-romero-rob-king-combat-theme-0" + String.valueOf(new Random().nextInt(4) + 1) + ".mp3"));
        music.setVolume(.125f);
        music.setLooping(true);
        music.play();

        init();//create teams

        dy = dx = 45;
    }

    @Override
    public void render () {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        batch.draw(fon, 0, 0); //

        show();
        batch.end();
        ///w (loop) {
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            ConsoleView.showConsole(step, teamA, teamB);
            try {
                next();
                step++;
                //sc.nextLine();
            } catch (NoPatronsException e) {
                System.out.println(e.getMessage());
                System.out.println("No patrons");
                batch.begin();
                show();
                //throw new NotAliveExeption("Конец игры");

            } catch (NotAliveExeption a) {
                System.out.println(a.getMessage());
                System.out.println("\nПобедила команда " + currentTeam);

                ConsoleView.showConsole(step, teamA, teamB);
                batch.begin();
                show();
                //dispose();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                batch.begin();
                show();
                //dispose();
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void dispose () {
        batch.dispose();
        //img.dispose();
    }

    public void show(){
        int offset=1;
        int width=50;
        int height=50;
        for(BaseHero n: teams ) {
            if (n.getStatus().equals("Жив")) {
                batch.draw(n.getSpr(), n.getPos()[0] * dx, ((n.getPos()[1]) - offset) * dy, width, height);
            }
        }
    }
    public static void init(){
        step = 1;
        currentTeam = "";
        for (int i=0; i < 11; i++) {
            switch (new Random().nextInt(8)) {
                case 3: teamA.add(new Peasant(setNames(),0,i,colorA)); break;
                case 2: teamA.add(new Sorcerer(setNames(),0,i,colorA)); break;
                case 1: teamA.add(new Rogue(setNames(),0,i,colorA)); break;
                case 0: teamA.add(new Sniper(setNames(),0,i,colorA)); break;
                default : teamA.add(new Spearman(setNames(),0,i,colorA)); break;
            }
            switch (new Random().nextInt(8)) {
                case 3: teamB.add(new Peasant(setNames(),9,i,colorB)); break;
                case 2: teamB.add(new Spearman(setNames(),9,i,colorB)); break;
                case 1: teamB.add(new Crossbowman(setNames(),9,i,colorB)); break;
                case 0: teamB.add(new Monk(setNames(),9,i,colorB)); break;
                default : teamB.add(new Spearman(setNames(),9,i,colorB)); break;
            }
        teams.add (teamA.get(i));
        teams.add (teamB.get(i));
        }

        teams.sort(new Comparator<BaseHero>() { // сортировать по id ..
            @Override
            public int compare(BaseHero b1, BaseHero b2) {
                return (b1.getId() - b2.getId());
            }
        });
        for (BaseHero e:teamB){ //повернуть изображение
            e.img.flip("left");
        }
    }

    public void next() throws Exception {

        for (BaseHero e : teams) {// сброс значков
            e.resetIcon();
        }


        for (BaseHero hero:teams) {
            if (teamA.contains(hero)) {
                currentTeam = "Команда А";
                teamnotpatrons(teamA);
                hero.step(teamB, teamA);
            } else {
                currentTeam = "Команда Б";
                teamnotpatrons(teamB);
                hero.step(teamA, teamB);
            }

        }

    }

    public static String setNames() { // генератор имен из enum
        return HeroNames.values()[new Random().nextInt(HeroNames.values().length)].toString();
    }

    private static void teamnotpatrons(ArrayList<BaseHero> team) throws NoPatronsException {
        int count = 0;
        for (BaseHero u : team) {
            if (u.showPatrons() == 0 ) {
                count++;
            }
        }
        if (count == team.size()) {
            System.out.println();
            throw new NoPatronsException("У команды " + currentTeam.charAt(currentTeam.length()-1) + " нет снарядов");
        }
    }

}


class NoPatronsException extends Exception {
    public  NoPatronsException(String str) {
        super(str);
    }
}

