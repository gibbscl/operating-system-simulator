package Components;

import java.util.Random;

public class IO {
    Random random = new Random();

    
    //This returns the time the process will be released
    public int randomIO() {
        return Clock.getClock() + ((random.nextInt(25) + 1) + 25);  // 25-50 cycles
    }
    
    
}