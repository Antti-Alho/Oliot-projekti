package oliot.liikkuvatOliot;


public enum Direction {
    NORTH (0),
    EAST (1),
    SOUTH (2),
    WEST (3),  
    STILL (4);
    
    private final int a;
    Direction(int a){
        this.a = a;
    }
    public int direction(){
        return a;
    }
}
