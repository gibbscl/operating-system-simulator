package Components;

import java.util.ArrayList;
import java.util.Random;

import GUI.GuiPrompt;
import GUI.gui;
/*
public class CPU extends Thread{

	
	private String text;
	private Process currentProcess;
	Random rand = new Random();
	
	
	
	 public static int tickClock(){
	        return Clock.tickClock();
	    }

	 
	public void setCurrentProcess(Process p){
		if(p!=null){
		currentProcess = p;
		this.currentProcess.setState(ProcessState.RUN);
		}else currentProcess=null;
	}
	public Process getCurrentProcess(){
		if(this.currentProcess != null)
		return this.currentProcess;
		else return null;
	}
	
	
	
	public void execute() {
		
		if(currentProcess.getCalcTime()==0){
			String text = currentProcess.getNextCommand();
			if(text==null){
				currentProcess.setState(ProcessState.EXIT);
				currentProcess=null;
			}
			switch (text){
			case "CALCULATE":
				currentProcess.setState(ProcessState.RUN);
				currentProcess.setCalcTime(Integer.parseInt(currentProcess.getNextCommand()));
				break;
			case "IO":
				currentProcess.setState(ProcessState.WAIT);
				currentProcess.incrementIORequests();
				currentProcess.setIOFlag(rand.nextInt(26)+25);
				break;
			case "YIELD":
				currentProcess.setState(ProcessState.WAIT);
				break;
			case "OUT":
				currentProcess.printProcessInfo();
				break;
			
			}
		}
		else{
			currentProcess.decrementCalcTime();
			currentProcess.incrementTime();
			Scheduler.incrementTimer();
		}
		
		if(currentProcess.getProcessCommands().size()==0){
			currentProcess.setState(ProcessState.EXIT);
			this.currentProcess=null;
		}
				

	}
	
	@Override
	public void run(){
		execute();
	}

	
	
}*/
