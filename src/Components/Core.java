package Components;

import java.util.Random;

public class Core {

	Scheduler schedule = new Scheduler();
	private String text;
	private Process currentProcess;
	Random rand = new Random();
	private int timer=0;

	
	
	public void setScheduler(Scheduler s){
		this.schedule = s;
	}
	public void setCurrentProcess(Process p){
		this.currentProcess=p;
	}
	public int getTimer(){
		return this.timer;
	}
	
	
	public void incrementTimer(){
		this.timer++;
	}
	public void decrementTimer(){
		this.timer--;
	}
	public void resetTimer(){
		this.timer=0;
	}
	
	public Scheduler getScheduler(){
		return this.schedule;
	}
	public Process getCurrentProcess(){
		return this.currentProcess;
	}
	
	
	
	
public void execute() {
		

		if(this.getCurrentProcess().getCalcTime()==0){
			String text = this.getCurrentProcess().getNextCommand();
			if(text==null){
				this.getCurrentProcess().setState(ProcessState.EXIT);
				this.setCurrentProcess(null);
			}
			switch (text){
			case "CALCULATE":
				this.getCurrentProcess().setState(ProcessState.RUN);
				this.getCurrentProcess().setCalcTime(Integer.parseInt(this.getCurrentProcess().getNextCommand()));
				break;
			case "IO":
				this.getCurrentProcess().setState(ProcessState.WAIT);
				this.getCurrentProcess().free();
				this.getCurrentProcess().incrementIORequests();
				this.getCurrentProcess().setIOFlag(rand.nextInt(26)+25);
				break;
			case "YIELD":
				this.getCurrentProcess().setState(ProcessState.WAIT);
				this.currentProcess.free();
				break;
			case "OUT":
				this.getCurrentProcess().printProcessInfo();
				break;
			
			}
		}
		else{
			this.getCurrentProcess().decrementCalcTime();
			this.getCurrentProcess().incrementTime();
			//This is only for schedulers that use a timer
			this.incrementTimer();
		}
		
		if(this.getCurrentProcess().getProcessCommands().size()==0){
			this.getCurrentProcess().setState(ProcessState.EXIT);
			this.getCurrentProcess().free();
			this.setCurrentProcess(null);
			
		}
	
	
		}
	
		
}


