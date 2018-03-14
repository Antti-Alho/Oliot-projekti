package oliot.liikkuvatOliot;

import java.util.ArrayList;

public class fightController {
   ArrayList<Human> ihmiset;
   int x, y;
   
    public fightController(ArrayList<Human> ihmiset) {
        this.ihmiset=ihmiset;
        this.x=ihmiset.get(0).getX();
        this.y=ihmiset.get(0).getY();
    }
    
    public void ihmistenLyönti() {
        int a = 0; 
        ArrayList<Human> kuolleet= new ArrayList<>();
        
        if (ihmiset.size() > 1) {
            for (Human human : ihmiset) {
                a = a + human.getStr();
            }
            for (Human human : ihmiset) {
                human.setEnu(human.getEnu() - a);
            if (human.getEnu() <= 0) {
                kuolleet.add(human);
            }
        }
            ihmiset.removeAll(kuolleet);
        }
    }
    
    public Human getWinner() {
        return ihmiset.get(0);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getKoko() {
        return ihmiset.size();
    }

    public ArrayList<Human> getIhmiset() {
        return ihmiset;
    }

    public void setIhmiset(ArrayList<Human> ihmiset) {
        this.ihmiset = ihmiset;
    }

}   

