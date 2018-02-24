package oliot.liikkuvatOliot;
import java.util.ArrayList;
import oliot.projekti.kartta.Map;
import oliot.projekti.kartta.Ruutu;
import java.util.Random;

public class LiikkuvienOhjaaja {
    Random random = new Random();
    Map map;
    
    public LiikkuvienOhjaaja(Map kartta){
        this.map = kartta;
    }
    
    public ArrayList<Human> Liikuta(){
        ArrayList<Human> ihmiset = map.getIhmiset();
        ArrayList<Human> poistettavat = new ArrayList<>(); 
        Human human;
        for (int i = 0; i < ihmiset.size(); i++) {
            human = ihmiset.get(i);
            human = humalaAskel(human);
            
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
    
    public int kerroSuunta(Human ihminen){
        return 1;
    }
    
    public Human humalaAskel(Human human){
        int x = human.getX();
        int y = human.getY();
        int caseArvo = random.nextInt(4);
        switch (caseArvo){
            case 0: if (map.getKoordinaatisto().get(y)[x+1].isSeinä() == false)
                    x = x + 1;
                    break;
                    
            case 1: if (map.getKoordinaatisto().get(y+1)[x].isSeinä() == false)
                    y = y + 1;
                    break;
                    
            case 2: if (map.getKoordinaatisto().get(y)[x-1].isSeinä() == false)
                    x = x - 1;
                    break;
                    
            case 3: if (map.getKoordinaatisto().get(y-1)[x].isSeinä() == false)
                    y = y - 1;
                    break;
        }
        human.setX(x);
        human.setY(y);
        return human;
    }
    
    public Human yksiAskel(Human human){
        int x = human.getX();
        int y = human.getY();
        int suunta = kerroSuunta(human);
        switch (suunta){
            case 0: if (map.getKoordinaatisto().get(y)[x+1].isSeinä() == false)
                    x = x + 1;
                    break;
                    
            case 1: if (map.getKoordinaatisto().get(y+1)[x].isSeinä() == false)
                    y = y + 1;
                    break;
            
            case 2: if (map.getKoordinaatisto().get(y)[x-1].isSeinä() == false)
                    x = x - 1;
                    break;
            
            case 3: if (map.getKoordinaatisto().get(y-1)[x].isSeinä() == false)
                    y = y - 1;
                    break;
        }
        human.setX(x);
        human.setY(y);
        return human;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    
    public Human tappelunHävinnyt(Human a, Human b){
        if (a.getStr() > b.getStr() ){
            return b;
        } else return a;
    }

}
