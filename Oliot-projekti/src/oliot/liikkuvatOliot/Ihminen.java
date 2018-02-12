
package oliot.liikkuvatOliot;
public class Ihminen {
    private int str;
    private int itell;
    private int cha;

    public Ihminen(int str, int itelligence, int cha) {
        this.str = str;
        this.itell = itell;
        this.cha = cha;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getItell() {
        return itell;
    }

    public void setItelligence(int itelligence) {
        this.itell = itelligence;
    }

    public int getCha() {
        return cha;
    }

    public void setCha(int cha) {
        this.cha = cha;
    }
    
}
