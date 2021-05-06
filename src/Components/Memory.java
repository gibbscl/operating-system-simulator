package Components;

public class Memory {

	private static final int totalMemory = 4096; 
	private static int usedMemory = 0;
	
	public void useMemory(int mem){
		usedMemory+=usedMemory + mem;
	}
	
	public int freeMemory(int mem) {
        usedMemory = usedMemory - mem;
        if(usedMemory < 0)
            usedMemory = 0;
        return usedMemory;
    }
}
