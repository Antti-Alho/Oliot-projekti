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
        ArrayList<TappeluOhjaaja> paattyneet = new ArrayList<>();
        
        Human human;
        
        for (TappeluOhjaaja tappeluOhjaaja : map.getTappelut()) {
                tappeluOhjaaja.ihmistenLyönti();
            }
        
        for (int i = 0; i < ihmiset.size(); i++) {
            human = ihmiset.get(i);
            human = humalaAskel(human);
            iHaveThePower(human);
            
            
            for (int j = 0; j < ihmiset.size(); j++) {
                if (j!=i){
                    if(ihmiset.get(i).getX() == ihmiset.get(j).getX()){
                        if(ihmiset.get(i).getY() == ihmiset.get(j).getY()){
                            poistettavat.add(ihmiset.get(i));
                            poistettavat.add(ihmiset.get(j));
                            TappeluOhjaaja tappelu = new TappeluOhjaaja(poistettavat);
                            map.getTappelut().add(tappelu);
                        }
                    }
                }
            }
        }
        ihmiset.removeAll(poistettavat);
        
        for (TappeluOhjaaja tappeluOhjaaja : map.getTappelut()) {
            if (tappeluOhjaaja.getKoko() <= 1) {
                paattyneet.add(tappeluOhjaaja);
                if (tappeluOhjaaja.getKoko()== 1) {
                    ihmiset.add(tappeluOhjaaja.getHuman());
                }
            }
            
        }
        map.getTappelut().removeAll(paattyneet);
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
    //Tällä metodilla juodaan olutta
    public void iHaveThePower(Human human){
        ArrayList<Olut> oluet = map.getEsineet();
        ArrayList<Olut> juodutOluet = new ArrayList<>();
        for (Olut olut : oluet) {
            if (human.getX() == olut.getX() && human.getY() == olut.getY())
                juodutOluet.add(olut);
                human.setOlut(olut);
            
        }
        oluet.removeAll(juodutOluet);
        if (human.getOlut()!= null){
            human.setHumala(human.getHumala()+1);
            human.getOlut().setMaara(human.getOlut().getMaara() - 1);
        }
    }

}
