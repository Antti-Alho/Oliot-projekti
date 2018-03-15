package oliot.liikkuvatOliot;
import java.util.ArrayList;
import java.util.Queue;
import oliot.projekti.kartta.Map;
import oliot.projekti.kartta.Tile;
import java.util.Random;
import java.util.HashMap;
import java.util.LinkedList;

public class mapController {
    Random random;
    Map map;
    
    
    public mapController(Map kartta){
        this.map = kartta;
        this.random = new Random();
        resetRoute();
    }
    
    // liikuttaa ihmisiä ja tappeluita
    public ArrayList<Human> move(){
        ArrayList<Human> humans = map.getHumans();
        ArrayList<Human> humansToBeDeleted = new ArrayList<>(); 
        ArrayList<fightController> fightsToBeDeleted = new ArrayList<>();
        
        Human human;
        
        for (fightController fc : map.getTappelut()) {
            fc.ihmistenLyönti();
        }
        
        map.fillTheBar();
        
        for (int i = 0; i < humans.size(); i++) {
            human = humans.get(i);
            iHaveThePower(human);
            yksiAskel(human);
            resetRoute();
            if(human.getHumala() >= random.nextInt(100)){
                drunkStep(human);
            }
            //sit(human);
            //stand(human);
            //timeToPee(human);
            //allOutOfPee(human);
            for (int j = 0; j < humans.size(); j++) {
                if (j!=i){
                    if(humans.get(i).getX() == humans.get(j).getX()){
                        if(humans.get(i).getY() == humans.get(j).getY()){
                            humansToBeDeleted.add(humans.get(i));
                            humansToBeDeleted.add(humans.get(j));
                            fightController tappelu = new fightController(humansToBeDeleted);
                            map.getTappelut().add(tappelu);
                        }
                    }
                }
            }
        }
        humans.removeAll(humansToBeDeleted);
        
        for (fightController tappeluOhjaaja : map.getTappelut()) {
            if (tappeluOhjaaja.getKoko() <= 1) {
                fightsToBeDeleted.add(tappeluOhjaaja);
                if (tappeluOhjaaja.getKoko()== 1) {
                    humans.add(tappeluOhjaaja.getWinner());
                }
            }
        }
        map.getTappelut().removeAll(fightsToBeDeleted);
        
        boolean lisataan = false;
        for (int i = 0; i < map.getBaaritiskit().size(); i++) {
            int x = map.getBaaritiskit().get(i).getX();
            int y = map.getBaaritiskit().get(i).getY();
            for (int j = 0; j < map.getBeers().size(); j++) {
                if (lisataan){
                    
                }
            }
            if(lisataan){
                
            }
            lisataan = false;
        }
        return humans;
    }
    
    public int kerroSuunta(Human ihminen){
        int xStart = ihminen.getX();
        int yStart = ihminen.getY();
        int caseValue = ihminen.getTavoite();
        int minDistannce = map.getMaxZize()^2;
        int goalX;
        int goalY;
        Tile start = map.getCoordinates().get(yStart)[xStart];
        Tile goalR = start;
        
        int direction = 4;
        
        //haluaa olutta
        if (caseValue == 1) {
            Beer goal = ihminen.getOlut();
            for (int i = 0; i < map.getBeers().size(); i++) {
                Tile end = map.getCoordinates().get(map.getBeers().get(i).getY())[map.getBeers().get(i).getX()];
                if (distance(start,end) <= minDistannce) {
                    resetRoute();
                    minDistannce = distance(start,end);
                    resetRoute();
                    goal = map.getBeers().get(i);
                    goalX = goal.getX();
                    goalY = goal.getY();
                    goalR = map.getCoordinates().get(goalY)[goalX];
                }
            }
            if (goal != null){
                direction = direction(start, goalR);
                resetRoute();
                return direction;
            } else return 4;
        }
        //haluaa istua
        if (caseValue == 2) {
            Chair goal = ihminen.getTuoli();
            for (int i = 0; i < map.getTuolit().size(); i++) {
                Tile end = map.getCoordinates().get(map.getTuolit().get(i).getY())[map.getTuolit().get(i).getX()];
                if (distance(start,end) <= minDistannce) {
                    resetRoute();
                    minDistannce = distance(start,end);
                    resetRoute();
                    goal = map.getTuolit().get(i);
                    goalX = goal.getX();
                    goalY = goal.getY();
                    goalR = map.getCoordinates().get(goalY)[goalX];
                }
            }
            if (goal != null){
                direction = direction(start, goalR);
                resetRoute();
                return direction;
            } else return 4;
        }    
        // haluaa kuselle
        if (caseValue == 3) {
            Pisuaari goal = ihminen.getPisuaari();
            for (int i = 0; i < map.getPisuaarit().size(); i++) {
                Tile end = map.getCoordinates().get(map.getPisuaarit().get(i).getY())[map.getPisuaarit().get(i).getX()];
                if (distance(start,end) <= minDistannce) {
                    resetRoute();
                    minDistannce = distance(start,end);
                    resetRoute();
                    goal = map.getPisuaarit().get(i);
                    goalX = goal.getX();
                    goalY = goal.getY();
                    goalR = map.getCoordinates().get(goalY)[goalX];
                }
            }
            if (goal != null){
                direction = direction(start, goalR);
                resetRoute();
                return direction;
            } else return 4;
        } else return 4;
    }

    // 0 = E
    // 1 = S
    // 2 = W
    // 3 = N
    // 4 = pysyy paikallaan
    public int direction(Tile StartNode, Tile goalNode){
        Queue<Tile> que = new LinkedList<>(); //tarkastelujono
        HashMap<Tile,Integer> z = new HashMap<>(); //etäisyydet solmuihin
        
        int syvyys = 0;
        que.add(StartNode);
        while (!que.isEmpty()) {
            Tile s = que.remove();
            ArrayList<Tile> sNaapurit = s.getNaapuritMP();
            for (Tile ruutu : sNaapurit) {
                if(que.contains(ruutu) == false && z.containsKey(ruutu) == false){
                    ruutu.setRoute(s);
                    ruutu.setD(s.getD()+1);
                    syvyys = s.getD()+1;
                    que.add(ruutu);
                }
            }
            z.put(s, syvyys);
        }
        syvyys = z.get(goalNode);
        for (int i = 0; i < syvyys-2; i++) {
            goalNode = goalNode.getRoute();
        }
        if (goalNode.getRoute() == goalNode.getNaapuriS()){
            return 3;
        } else if (goalNode.getRoute() == goalNode.getNaapuriE()){
            return 2;
        } else if (goalNode.getRoute() == goalNode.getNaapuriN()){
            return 1;
        } else if (goalNode.getRoute() == goalNode.getNaapuriW()){
            return 0;
        } else return 4;
    }
    
    public int distance(Tile StartNode, Tile goalNode){
        Queue<Tile> que = new LinkedList<>(); //tarkastelujono
        HashMap<Tile,Integer> z = new HashMap<>(); //etäisyydet solmuihin
        
        int syvyys = 0;
        que.add(StartNode);
        while (!que.isEmpty()) {
            Tile s = que.remove();
            ArrayList<Tile> sNaapurit = s.getNaapuritMP();
            for (Tile ruutu : sNaapurit) {
                if(que.contains(ruutu) == false && z.containsKey(ruutu) == false){
                    ruutu.setRoute(s);
                    ruutu.setD(s.getD()+1);
                    syvyys = s.getD()+1;
                    que.add(ruutu);
                }
            }
            z.put(s, s.getD());
        }
        return z.get(goalNode);
    }
    
    public void resetRoute(){
        for (Tile[] ruudut : map.getCoordinates()) {
            for (Tile ruutu : ruudut) {
                ruutu.setRoute(new Tile(1000, 1000, true));
                ruutu.setD(0);
            }
        }
    }
    
    public void drunkStep(Human human){
        int x = human.getX();
        int y = human.getY();
        int caseArvo = random.nextInt(4);
        switch (caseArvo){
            case 0: if (map.getCoordinates().get(y)[x+1].isSeinä() == false) x = x + 1;
                    break;
            case 1: if (map.getCoordinates().get(y+1)[x].isSeinä() == false) y = y + 1;
                    break;
            case 2: if (map.getCoordinates().get(y)[x-1].isSeinä() == false) x = x - 1;
                    break;
            case 3: if (map.getCoordinates().get(y-1)[x].isSeinä() == false) y = y - 1;
                    break;
        }
        human.setX(x);
        human.setY(y);
    }

    public void yksiAskel(Human human){
        int x = human.getX();
        int y = human.getY();
        int suunta = kerroSuunta(human);
        switch (suunta){
            case 0: if (map.getCoordinates().get(y)[x+1].isSeinä() == false) x = x + 1;
                    break;        
            case 1: if (map.getCoordinates().get(y+1)[x].isSeinä() == false) y = y + 1;
                    break;
            case 2: if (map.getCoordinates().get(y)[x-1].isSeinä() == false) x = x - 1;
                    break;
            case 3: if (map.getCoordinates().get(y-1)[x].isSeinä() == false) y = y - 1;
                    break;
            case 4: break;
        }
        human.setX(x);
        human.setY(y);
    }
   
    public Human tappelunHävinnyt(Human a, Human b){
        if (a.getStr() > b.getStr() ){
            return b;
        } else return a;
    }
    //Tällä metodilla juodaan olutta
    public void iHaveThePower(Human human){
        ArrayList<Beer> beers = map.getBeers();
        ArrayList<Beer> beersToBeDeleted = new ArrayList<>();
        for (Beer beer : beers) {
            if (human.getX() == beer.getX() && human.getY() == beer.getY()) {
                beersToBeDeleted.add(beer);
            }
            human.setOlut(beer);    
        }
        beers.removeAll(beersToBeDeleted);
        if (human.getOlut()!= null || human.getOlut().getMaara() != 0){
            human.setHumala(human.getHumala()+1);
            human.getOlut().setMaara(human.getOlut().getMaara() - 1);
            if (human.getOlut().getMaara() <= 0 && human.getOlut().isEmpty() == false){
                //human.tavoiteSaavutettu();
            }
        }
    }
    public void sit(Human human){
        ArrayList<Chair> tuolit = map.getTuolit();
        ArrayList<Human> istuvatIhmiset = map.getIstuvatIhmiset();
        ArrayList<Human> ihmiset = map.getHumans();
        for (Chair tuoli : tuolit) {
            if (human.getX() == tuoli.getX() && human.getY() == tuoli.getY() && human.getTavoite() == 2){
                    ihmiset.remove(human);
                    istuvatIhmiset.add(human);
            }
        }
    }
    public void stand(Human human){
        ArrayList<Human> istuvatIhmiset = map.getIstuvatIhmiset();
        ArrayList<Human> ihmiset = map.getHumans();
        if (human.getOlut().getMaara() > 0){
            human.getOlut().setMaara(human.getOlut().getMaara() - 1);
        } else {
            istuvatIhmiset.remove(human);
            ihmiset.add(human);
        }
    }
    //tällä komennolla ihmiset menevät pisuaarille
    public void timeToPee(Human human){
        ArrayList<Pisuaari> pisuaarit = map.getPisuaarit();
        ArrayList<Human> peeingPeople = map.getKusevatIhmiset();
        ArrayList<Human> ihmiset = map.getHumans();
        ArrayList<Human> poistettavat = map.getPoistettavatIhmiset();
        for(Pisuaari pisuaari:pisuaarit){
            if(human.getX() == pisuaari.getX()&& human.getY() == pisuaari.getY()&& human.getTavoite() == 3){
                ihmiset.remove(human);
                peeingPeople.add(human);
            }
        }
    }
    //tällä komennolla ihmiset käyttävät pisuaaria ja lähtevät pois pisuaarilta,
    //humalatila laskee myös puoleen aiemmasta.
    public void allOutOfPee(Human human){
        ArrayList<Human> peeingPeople = map.getKusevatIhmiset();
        ArrayList<Human> ihmiset = map.getHumans();
        for(Human ihminen:ihmiset){
            if(human.getHumala()>1){
                human.setHumala(human.getHumala()/2);
                peeingPeople.remove(human);
                ihmiset.add(human);
            } else {
                peeingPeople.remove(human);
                ihmiset.add(human);
            }
        }
    }
    
    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}


