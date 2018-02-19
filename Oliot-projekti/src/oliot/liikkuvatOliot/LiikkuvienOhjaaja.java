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
        ArrayList<Ihminen> poistettavat = new ArrayList<>(); 
        Ihminen a;
        for (int i = 0; i < ihmiset.size(); i++) {
            a = ihmiset.get(i);
            a = yksiAskel(a);
            
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
    
    public void humalaAskel(Ihminen ihminen){
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
    public Ihminen yksiAskel(Ihminen ihminen){
        int x = ihminen.getX();
        int y = ihminen.getY();
        int caseArvo = random.nextInt(4);
        switch (caseArvo){
            case 0: x = x + 1;
                    break;
            case 1: y = y + 1;
                    break;
            case 2: x = x - 1;
                    break;
            case 3: y = y - 1;
                    break;
        }
        //niin kauan kuin kartta on neliö, kartta.getKoordinaatisto().size() toimii
        if(x > kartta.getKoordinaatisto().size() - 2){
            x = x - 1;
        }
        else if(y > kartta.getKoordinaatisto().size() - 2){
            y = y - 1;
        }
        else if(x < 1){
            x = x + 1;
        }
        else if(y < 1){
            y = y + 1;
        }
        ihminen.setX(x);
        ihminen.setY(y);
        return ihminen;
        
    }
}
