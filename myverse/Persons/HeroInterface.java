package Persons;

import java.util.ArrayList;

public interface HeroInterface {
    void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam) throws NotAliveExeption;
    String getinfo();
    int showPower();
    void addHp(int value); 
    int showPatrons();
}
