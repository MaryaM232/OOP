import java.util.List;
public class Spearman extends BaseHero{
    public Spearman (List<BaseHero> side, int x, int y) {
        super(String.format("Spearman#%d", ++Spearman.number),
                30, 4, 5, 0, new int[]{1, 3}, 9);
        position = new Vector2(x, y);
    }
}