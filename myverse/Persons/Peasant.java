package Persons;

/** крестьянин */
public class Peasant extends BaseHero { 
    protected  int hp;
    protected  int maxHp; 
    protected  int money;
    protected String ammo;
    protected int patrons;
    protected  int kevlar;
    
    public Peasant(String name){
        this(name, 8, "кирка");
    }

    public Peasant(String name, int speed, String ammo) {
        super(name, "Жив", speed);
        this.ammo = ammo;
        this.hp=100;
        this.maxHp=100;
        this.money=0;
        this.kevlar = 0;
        this.patrons=5;
        }

    public void info(){
        System.out.println(String.format("%s= здоровье: %d, оружие: %s, броня: %d",
        this.name,this.hp, this.ammo,this.kevlar));
    }

    public void attack(BaseHero target) {
        System.out.println(this.name+" атакует "+target.name);
        int damage =random(10, 20);
        ((Peasant) target).getDamage(damage);    
    }

    protected void getDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        // else { die(); }
    }

    protected void addHp(int addHp) {
        this.hp = addHp + this.hp > this.maxHp ? this.maxHp : addHp + this.hp;
    }

    protected void die() {
        super.status = "dead"; 
    }

}
