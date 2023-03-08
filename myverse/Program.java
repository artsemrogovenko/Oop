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
        Peasant three = new Peasant("крестьянин");
        Crossbowman one = new Crossbowman("арбалетчик");
        Sniper two = new Sniper("снайпер");
        Monk four = new Monk("монах");
        Sorcerer five = new Sorcerer("колдун");
        Rogue six = new Rogue("разбойник");
        Spearman seven = new Spearman("копейщик");
        six.info();
        one.attack(six);
        six.info();

        // one.getInfo();
        // two.getInfo();
        // three.getInfo();
        // four.getInfo();
        // five.getInfo();
        // six.getInfo();
        // seven.getInfo();
        // one.getInfo();
    }
}
