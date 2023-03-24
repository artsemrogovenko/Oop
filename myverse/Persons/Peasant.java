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
  
    
    public Peasant(String name,int x,int y,String color){
        this(name, 3, "кирка",x,y);
        this.kevlar=1;
        this.hp=1;
        this.maxHp=1;
        this.attacks=1;
        this.teamColor=color;
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

        public int[] getPos() {
            return this.position.getPos();
        }

        public String showPos() {
            return this.position.showPos();
        }

    public String advinfo(){
        return String.format("%s= здоровье: %d, патроны %d,оружие: %s, броня: %d",
        this.name,this.hp,this.patrons, this.ammo,this.kevlar);
        // return(String.format("%s статус-%s id:%d",
        // super.name,super.status,getId())); 
    }

    public void attack(BaseHero target,int value) {
        System.out.printf("%s %s атакует %s %s сила урона %d\n",this.getinfo(),this.name,this.getinfo(),target.getName(),value);       
        ((Peasant) target).getDamage(value);   //враг получает урон
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

    protected void getDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
         else die(); 
    }
    @Override
    public void addHp(int addHp) {
        this.hp = (addHp*-1) + this.hp > this.maxHp ? this.maxHp : (addHp*-1) + this.hp;
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
