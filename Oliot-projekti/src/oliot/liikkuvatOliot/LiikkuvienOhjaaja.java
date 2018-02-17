package oliot.liikkuvatOliot;
import java.util.ArrayList;
import oliot.projekti.kartta.Kartta;
import oliot.projekti.kartta.Ruutu;
import java.util.Random;

public class LiikkuvienOhjaaja {
    Random random = new Random();
    Kartta kartta;
    
    public LiikkuvienOhjaaja(Kartta kartta){
        this.kartta = kartta;
    }
    
    public ArrayList<Ihminen> Liikuta(){
        ArrayList<Ihminen> ihmiset = kartta.getIhmiset();
        ArrayList<Ihminen> poistettavat = kartta.getIhmiset();
        Ihminen a;
        for (int i = 0; i < ihmiset.size(); i++) {
            a = ihmiset.get(i);
            a.setX(random.nextInt(10));
            a.setY(random.nextInt(10));
            for (int j = 0; j < ihmiset.size(); j++) {
                if (j!=i){
                    if(ihmiset.get(i).getX() == ihmiset.get(j).getX()){
                        if(ihmiset.get(i).getY() == ihmiset.get(j).getY()){
                            poistettavat.add(tappelunHävinnyt(ihmiset.get(i), ihmiset.get(j)));
                        }
                    }
                }
            }
        }
        ihmiset.removeAll(poistettavat);
        return ihmiset;
    }
    
    public void humalaAskel(){
        
    }

    public Kartta getKartta() {
        return kartta;
    }

    public void setKartta(Kartta kartta) {
        this.kartta = kartta;
    }
    
    public Ihminen tappelunHävinnyt(Ihminen a, Ihminen b){
        if (a.getStr() > b.getStr() ){
            return b;
        } else return a;
    }
}
