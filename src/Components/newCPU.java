package Components;

import java.util.ArrayList;
import java.util.Random;

import GUI.GuiPrompt;
import GUI.gui;

public class newCPU{

	
	
	Random rand = new Random();
	Core core1 = new Core();
	Core core2 = new Core();
	Core core3 = new Core();
	Core core4 = new Core();
	
	
	 public static int tickClock(){
	        return Clock.tickClock();
	    }

	 //Sets current process to paramaterized core
	public void setCurrentProcess(Process p,Core core){
		if(p!=null){
		core.setCurrentProcess(p);
		core.getCurrentProcess().setState(ProcessState.RUN);
		}else core.setCurrentProcess(null);
	}
	
	//Retrieves the current process from the core you want 
	public Process getCurrentProcess(Core core){
			return core.getCurrentProcess();
		
	}
	
	public void setQueues(){
		this.core1.getScheduler().updateQueues();
		this.core2.getScheduler().updateQueues();
		this.core3.getScheduler().updateQueues();
		this.core4.getScheduler().updateQueues();
	}

	public void execute(Scheduler scheduler) {
		
		if(this.core1.getCurrentProcess()!=null){
		this.core1.execute();
		}scheduler.updateQueues();
		if(this.core2.getCurrentProcess()!=null){
			this.core2.execute();
		}scheduler.updateQueues();
		if(this.core3.getCurrentProcess()!=null){
			this.core3.execute();
		}scheduler.updateQueues();
		if(this.core4.getCurrentProcess()!=null){
			this.core4.execute();
		}scheduler.updateQueues();
	
	}
		
	
}
