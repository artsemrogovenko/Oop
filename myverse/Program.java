import java.util.ArrayList;
import java.util.Random;

import Persons.*;
import Persons.Mercenary.*;
import Persons.Soldiers.*;
import Persons.Wizards.*;
/*Крестьянин, разбойник, снайпер, колдун, копейщик, арбалетчик, монах. 
Для каждого сформировать список свойств и возможных действий. 
Напрнимер свойство скорость, действие нанести удар. 
Проанализировать получившиеся свойства и действия персонажей и создать 
Обобщённый класс описывающий свойства и действия имеющиеся у всех персонажей.
Создать этот класс. Создать классы для каждого типа персонажей наследующие и расширяющие абстрактный(обобщённый) класс.
В основной программе создать по одному экземпляру каждого типа персонажей.  */
public class Program {
    public static void main(String[] args) {
        // Peasant three = new Peasant("крестьянин");
        // Crossbowman one = new Crossbowman("арбалетчик");
        // Sniper two = new Sniper("снайпер");
        // Monk four = new Monk("монах");
        // Sorcerer five = new Sorcerer("колдун");
        // Rogue six = new Rogue("разбойник");
        // Spearman seven = new Spearman("копейщик");
        // six.info();
        // one.attack(six);
        // six.info();

        // one.getInfo();
        // two.getInfo();
        // three.getInfo();
        // four.getInfo();
        // five.getInfo();
        // six.getInfo();
        // seven.getInfo();
        // one.getInfo();

        /* Добавить файл с описанием интерфейса. В котором описать два метода, void step(); и String getInfo(); 
        Реализовать интерфейсs в абстрактном классе и в наследниках так, чтобы getInfo возвращал тип персонажа.
        Создать два списка в классе main. В кждый из списков добавить по десять экземнляров наследников BaseHero. 
        Удалить ненужные методы из абстрактного класса, если такие есть. 
        В main пройти по спискам и вызвать у всех персонажей getInfo. */
        ArrayList<BaseHero> list = new ArrayList<>();
        ArrayList<BaseHero> list2 = new ArrayList<>();     
        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(6)) {
                case 0: list.add(new Peasant(setNames())); break;
                case 1: list.add(new Sorcerer(setNames())); break;
                case 2: list.add(new Rogue(setNames())); break;
                case 3: list.add(new Spearman(setNames())); break;
                case 4: list.add(new Crossbowman(setNames())); break;
                case 5: list.add(new Monk(setNames())); break;
                default:list.add(new Sniper(setNames())); break;
            }
            switch (new Random().nextInt(6)) {
                case 0: list2.add(new Peasant(setNames())); break;
                case 1: list2.add(new Sorcerer(setNames())); break;
                case 2: list2.add(new Rogue(setNames())); break;
                case 3: list2.add(new Spearman(setNames())); break;
                case 4: list2.add(new Crossbowman(setNames())); break;
                case 5: list2.add(new Monk(setNames())); break;
                default:list2.add(new Sniper(setNames())); break;
            }
        }

        System.out.println("*****Команда 1******");
        for (BaseHero heroes : list) {
            System.out.println(heroes.getinfo());
        }

        System.out.println("*****Команда 2******");
        for (BaseHero heroes : list2) {
            System.out.println(heroes.getinfo());
        }
    }


    public static String setNames() { // генератор имен из enum
        return HeroNames.values()[new Random().nextInt(HeroNames.values().length)].toString();
    }
}