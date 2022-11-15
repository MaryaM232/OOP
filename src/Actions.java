import java.util.List;
public interface Actions {
    void strike(BaseHero hero);
    void getDamage(float damagePower);
    boolean changePosition();
    String indicateStatus();
    String getInfo();
    void step (List<BaseHero> side);
    String returnCondition();
}
