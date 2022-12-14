import java.util.List;
public class Sniper extends BaseHero {
    public Sniper(List<BaseHero> band, int x, int y) {
        super("Sniper",15, 12, 10, 32, new int[]{8, 10}, 9);
        position = new Vector2(x, y);
        super.setBand(band);
    }

    @Override
    public void step(List<BaseHero> side){
        float tmpH = side.get(0).health;
        int index = 0;
        for (int i = 1; i < side.size(); i++){
            if (!side.get(i).getStatus().equals("Die") && tmpH > side.get(i).health){
                tmpH = side.get(i).health;
                index = i;
            }
        }
        if(--shots > 0){
            shots--;
            band.get(index).getDamage((damage.x+ damage.y)/2);
        }
        for (BaseHero p: band){
            if (p.getName().equals("Peasant")) shots++;

        }
    }
}
