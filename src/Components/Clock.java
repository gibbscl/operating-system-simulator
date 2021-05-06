package Components;

public class Clock {
    
	private static int time = 0;
	private static int prevTime = 0;
	
    //Each tick of the clock will be one 'looped-cycle'
    public static int getClock(){
    	return time;
    }
    
    public static int tickClock() {
    	prevTime = time;
        return time++;
    }

    public static int getPrevClock(){
    	return prevTime;
    }
    
    public static void resetClock() {
        time = 0;
    }
    
    public static void setClock(int t){
    	time = t;
    }
}