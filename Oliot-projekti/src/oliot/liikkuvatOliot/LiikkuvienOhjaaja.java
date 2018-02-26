package oliot.liikkuvatOliot;
import java.util.ArrayList;
import java.util.Queue;
import oliot.projekti.kartta.Map;
import oliot.projekti.kartta.Ruutu;
import java.util.Random;
import java.lang.Math;
import java.util.HashMap;
import java.util.LinkedList;

public class LiikkuvienOhjaaja {
    Random random = new Random();
    Map map;
    
    public LiikkuvienOhjaaja(Map kartta){
        this.map = kartta;
    }
    
    // liikuttaa ihmisiä ja tappeluita
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
            yksiAskel(human);
            humalaAskel(human);
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
        int xStart = ihminen.getX();
        int yStart = ihminen.getY();
        int caseValue = ihminen.getTavoite();
        int pieninEtaisyys = map.getMaxZize()^2;
        
        //haluaa olutta
        if (caseValue == 1) {
            Olut maali = ihminen.getOlut();
            for (int i = 0; i < map.getOluet().size(); i++) {
                Ruutu start = map.getKoord().get(xStart)[yStart];
                Ruutu end = map.getKoord().get(map.getOluet().get(i).getX())[map.getOluet().get(i).getX()];
                if (etaisyys(start,end) <= pieninEtaisyys) {
                    maali = map.getOluet().get(i);
                }
            }
            if (maali != null){
                return suunta(maali);
            } else return 4;
        }
        //haluaa istua
        if (caseValue == 2) {
            System.out.println("joku haluaa istua vaikka tuolia ei ole keksitty");
            return 4;
        }
        // haluaa kuselle
        if (caseValue == 3) {
            System.out.println("joku laski alleen");
            return 4;
        } else return 4;
    }

    // 0 = E
    // 1 = S
    // 2 = W
    // 3 = N
    // 4 = pysyy paikallaan
    public int suunta(Olut olut){
        return 4;
    }
    
    public int etaisyys(Ruutu StartNode, Ruutu goalNode){
        Queue<Ruutu> que = new LinkedList<>(); //tarkastelujono
        HashMap<Ruutu,Integer> z = new HashMap<>(); //etäisyydet solmuihin
        int syvyys = 0;
        que.add(StartNode);
        while (!que.isEmpty()) {
            Ruutu s = que.poll();
            ArrayList<Ruutu> sNaapurit = s.getNaapuritMP();
            for (Ruutu ruutu : sNaapurit) {
                if(!z.containsKey(ruutu)){
                que.add(ruutu);
                }
            }
            z.put(s, syvyys);
            syvyys++;
        }
        return z.get(goalNode);
    }
    
    public void humalaAskel(Human human){
        int x = human.getX();
        int y = human.getY();
        int caseArvo = random.nextInt(4);
        switch (caseArvo){
            case 0: if (map.getKoord().get(y)[x+1].isSeinä() == false)
                    x = x + 1;
                    break;
                    
            case 1: if (map.getKoord().get(y+1)[x].isSeinä() == false)
                    y = y + 1;
                    break;
                    
            case 2: if (map.getKoord().get(y)[x-1].isSeinä() == false)
                    x = x - 1;
                    break;
                    
            case 3: if (map.getKoord().get(y-1)[x].isSeinä() == false)
                    y = y - 1;
                    break;
        }
        human.setX(x);
        human.setY(y);
    }
    
    // 0 = E
    // 1 = S
    // 2 = W
    // 3 = N
    // 4 = pysyy paikallaan
    //liikuttaa yhden askeleen ihmisen tavoitteen suuntaan
    public void yksiAskel(Human human){
        int x = human.getX();
        int y = human.getY();
        int suunta = kerroSuunta(human);
        switch (suunta){
            case 0: if (map.getKoord().get(y)[x+1].isSeinä() == false)
                    x = x + 1;
                    break;
                    
            case 1: if (map.getKoord().get(y+1)[x].isSeinä() == false)
                    y = y + 1;
                    break;
            
            case 2: if (map.getKoord().get(y)[x-1].isSeinä() == false)
                    x = x - 1;
                    break;
            
            case 3: if (map.getKoord().get(y-1)[x].isSeinä() == false)
                    y = y - 1;
                    break;
            case 4: break;
        }
        human.setX(x);
        human.setY(y);
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
        ArrayList<Olut> oluet = map.getOluet();
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
