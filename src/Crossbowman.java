import java.util.List;
public class Crossbowman extends BaseHero{
    public Crossbowman(List<BaseHero> band, int x, int y){
        super("Crossbowman",10, 6, 3, 16, new int[]{2, 3}, 4);
        position = new Vector2(x, y);
        super.setBand(band);
    }

    @Override
    public void step(List<BaseHero> side){
        float tmpH = side.get(0).health;
        int index = 0;
        for (int i = 1; i < side.size(); i++){
            if (tmpH > side.get(i).health){
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
