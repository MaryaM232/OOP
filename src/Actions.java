import java.util.List;
public interface Actions {
    String getInfo();
    void step (List<BaseHero> side);
    String returnCondition();
}
