
package oliot.liikkuvatOliot;
public class Ihminen {
    private int str;
    private int itell;
    private int cha;
    private int rakko;

    public Ihminen(int str, int itelligence, int cha, int rakko) {
        this.str = str;
        this.itell = itell;
        this.cha = cha;
        this.rakko = rakko;
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

    public int getRakko() {
        return rakko;
    }

    public void setRakko(int rakko) {
        this.rakko = rakko;
    }
    
}