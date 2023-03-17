package Persons;

import java.util.ArrayList;

/** крестьянин */
public class Peasant extends BaseHero { 
    protected int maxHp;
    protected int money;
    protected String ammo;
    protected int patrons;
    protected int kevlar;
    protected int attacks;
    private int delivery=1;
    private int power=1;
    
    public Peasant(String name,int x,int y){
        this(name, 3, "кирка",x,y);
        this.kevlar=1;
        this.hp=1;
        this.maxHp=1;
        this.attacks=1;
        //super.position=new Positions(10);
    }

    public Peasant(String name, int speed, String ammo,int x,int y) {
        super(name, "Жив", speed);
        this.ammo = ammo;
        //this.hp=100;
        //this.maxHp=100;
        this.money=0;
        this.kevlar = 0;
        this.patrons=2;
        super.position=new Positions(x,y);
        }


    public String advinfo(){
        return String.format("%s= здоровье: %d, патроны %d,оружие: %s, броня: %d",
        this.name,this.hp,this.patrons, this.ammo,this.kevlar);
        // return(String.format("%s статус-%s id:%d",
        // super.name,super.status,getId())); 
    }

    public void attack(BaseHero target,int value) {
        //System.out.println(this.name+" атакует "+target.getName());       
        ((Peasant) target).getDamage(value);   //враг получает урон
        --this.patrons;
    }

    protected void getDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
         else die(); 
    }

    protected void addHp(int addHp) {
        this.hp = addHp + this.hp > this.maxHp ? this.maxHp : addHp + this.hp;
    }

    protected void die() {
        super.status = "dead"; 
        super.hp=0;
    }


@Override
public String getinfo(){
    return "крестьянин";
}

@Override
public void step(ArrayList<BaseHero> enemy, ArrayList<BaseHero> myTeam) {
}

@Override
public int showPower() {
    return power;
}
}
