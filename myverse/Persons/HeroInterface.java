package Persons;

import java.util.ArrayList;

public interface HeroInterface {
    void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam);
    String getinfo();

}
