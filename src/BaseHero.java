import java.util.List;
public abstract class BaseHero implements Actions{
    protected static int number;
    private String name;
    private  int attack;
    private int protection;
    private int shots;
    protected Vector2 damage;
    protected float health;
    protected int maxHealth;
    private int speed;
    private String status;
    protected List<BaseHero> band;
    protected Vector2 position;

    static {
        number = 0;
    }

    public Vector2 getPosition() {
        return position;
    }

    protected void setBand(List<BaseHero> band) {
        this.band = band;
    }
    public BaseHero(String name, int health) {
        this.name = name;
        this.health = this.maxHealth = health;
        this.health--;
        status = "stand";
    }
    public BaseHero(String name, int health, int attack,
                    int protection, int shots, int[] damage, int speed){
        this(name, health);
        this.attack = attack;
        this.protection = protection;
        this.shots = shots;
        this.damage = new Vector2(damage[0], damage[1]);
        this.speed = speed;
    }
    @Override
    public void step(List<BaseHero> side) {}
    @Override
    public String getInfo(){
        return String.format("%s: %s hlth: %d attk: %d protect: %d shot: %d dmg: %d-%d speed: %d",
                this.getClass().getSimpleName(), name, health, attack, protection, shots, damage.x, damage.y, speed);
    }

    public String getName() { return name; }
    public int getAttack() { return attack; }
    public int getProtection() { return protection; }
    public float getHealth() { return health; }
    public int getShots() { return shots; }
    public int getSpeed() { return speed; }
    public String getStatus() { return status; }

    public static int getNumber(){return  number;}

    @Override
    public void strike(BaseHero hero){
    }
    @Override
    public void getDamage(float damagePower){
        health -=damagePower;
    }
    @Override
    public boolean changePosition(){return false;}
    @Override
    public String indicateStatus(){return null;}
    @Override
    public String returnCondition() {
        return name +
                " H:" + Math.round(health) +
                " D:" + protection +
                " A:" + attack +
                " Dmg:" + (int)(Math.abs((damage.x+damage.y)/2)) +
                (shots>0?" Shots:" + shots:"") + " " + status;
    }
}
