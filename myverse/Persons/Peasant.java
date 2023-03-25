package Persons;

import java.util.ArrayList;

import Persons.Console.IconsState;

/** крестьянин */
public class Peasant extends BaseHero { 
    protected int money;
    protected String ammo;
    protected int patrons;
    protected int kevlar;
    protected int attacks;
    //private int delivery=1;
    protected int minPower;
    protected int maxPower;
    private static int power;
    
    public Peasant(String name,int x,int y,String color){
        this(name, 3, "кирка",x,y);
        this.patrons=1;
        this.kevlar=1;
        super.hp=1;
        super.maxHp=1;
        this.minPower=1;
        this.maxPower=1;
        this.attacks=1;
        super.teamColor=color;
        //super.position=new Positions(10);
    }

    public Peasant(String name, int speed, String ammo,int x,int y) {
        super(name, "Жив", speed);
        this.ammo = ammo;
        super.position=new Positions(x,y);
        }

        public int[] getPos() {
            return this.position.getPos();
        }

        public String showPos() {
            return this.position.showPos();
        }

    public String advinfo(){
        return String.format("%s= здоровье: %d, патроны %d,оружие: %s, броня: %d",
        this.name,this.hp,this.patrons, this.ammo,this.kevlar);
    }

    public void attack(BaseHero target) {
        int value;
        if (this.attacks > ((Peasant) target).kevlar) {
            value = this.maxPower;
        } else {
            value = this.minPower;
        }
        System.out.printf("%s %s id:%d наносит урон с помощью %s %sу %s id:%d сила урона %d\n", 
        this.getinfo(), this.name,this.getId(), this.ammo, target.getinfo(),target.getName(),target.getId(), value);
        ((Peasant) target).getDamage(value); // враг получает урон
        --this.patrons;
    }

    
    @Override
    public int showPatrons() {
        return this.patrons;
    }

    public void move(BaseHero my, BaseHero target, ArrayList<BaseHero> friends) {
       Move pers = new Move();
       pers.move(my, target, friends);
    }

    private void getDamage(int damage) {
        if (((this.kevlar - damage) > 0 && (this.hp > 0)) && (this.kevlar > 0)) {
            this.kevlar -= damage;
            this.setIcon("\uD83D\uDEE1", damage);
            return;
        } else {
            if (((this.kevlar - damage) <= 0 && (this.hp > 0)) && (this.kevlar > 0)) {
                int value = Math.abs(this.kevlar - damage);

                this.iconState = new IconsState("\033[0;33m" + "\uD83D\uDEE1-" + (damage - value) +
                        "\033[0m\033[1;31m" + "♥-" + value + "\033[41m\033[1;30m");
                this.kevlar = 0;
                if (this.hp - value < 0) {
                    die();
                }
                if (this.hp - value > 0) {
                    this.hp -= value;
                }
            }
            if ((this.hp > 0 && this.kevlar == 0) && this.status.equals("Жив")) {
                this.setIcon("♥-", damage);
                if (this.hp - damage < 0) {
                    die();

                }
                if (this.hp - damage > 0) {
                    this.hp -= damage;
                }
            }
        }
        //else d
        
    }

    @Override
    public void addHp(int addHp) {
        this.hp = addHp + this.hp > this.maxHp ? this.maxHp : addHp + this.hp;
    }

    protected void die() {
        super.status = "dead"; 
        super.hp=0;
    }

    public String showAmmo(){
        return this.ammo;
    }

    @Override
    public String getinfo() {
        return "крестьянин";
    }

    @Override
    public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam) throws NotAliveExeption {
    }

    @Override
    public int showPower() {
        return power;
    }
}
