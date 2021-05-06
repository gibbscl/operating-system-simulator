package Components;

public class CriticalSection {
	
	
	private int turn = 0;
	private boolean flag;
	
	public static boolean criticalState(Process p){
		if (p.getProcessState().equals(ProcessState.CSECTION)){
			return true;
		}
		return false;
	}
	
	
	public int petersonsS(int t){
		if (this.flag == false && t == 1){
			return this.turn = 1;
		}else{
			return turn;
		}
	}
}
