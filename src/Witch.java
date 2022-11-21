import java.util.List;
public class Witch extends BaseHero{
    private boolean magic;
    public Witch(List<BaseHero> band, int x, int y) {
        super("Witch", 30, 17, 12, 0, new int[]{-5, 0}, 9);
        magic = true;
        position = new Vector2(x, y);
        super.setBand(band);
    }

    @Override
    public void step(List<BaseHero> side) {
        boolean flag = true;
        int cnt = 0;
        while (flag){
            if (band.get(cnt).health < band.get(cnt).maxHealth*2){
                band.get(cnt).getDamage(damage.x);
                if (band.get(cnt).health > band.get(cnt).maxHealth*2) band.get(cnt).health = band.get(cnt).maxHealth;
                flag = false;
                cnt = 0;
            }
            if (++cnt == band.size()) flag = false;
        }
    }

    @Override
    public String getInfo() {
        return String.format("%s  magic: %b", super.getInfo(), magic);
    }
}