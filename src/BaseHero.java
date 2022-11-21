import java.util.List;
public abstract class BaseHero implements Actions{
    protected static int number;
    private String name;
    private  int attack;
    private int protection;
    protected int shots;
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

    protected Vector2 getPosition() {return position;}

    protected void setBand(List<BaseHero> band) {this.band = band;}
    public BaseHero(String name, int health) {
        this.name = name;
        this.health = this.maxHealth = health;
        this.health--;
        status = "stand";
        number++;
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

    public String getName() { return name; }
    protected String getStatus() { return status; }
    protected void getDamage(float damagePower){health -=damagePower;}
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
