package Components;

import java.io.File;
import java.util.ArrayList;
import GUI.gui;
import ParseText.ParseText;
import java.util.Scanner;
import java.util.Random;
import ParseText.RandomJob;


public class newOS {

	Random gen = new Random();
	private final int mark = 5;
	private Scheduler scheduler=new Scheduler();
	private newCPU cpu = new newCPU();
	Scanner scan = new Scanner(System.in);
	//private String input = gui.CommandInput.getText();
	
	
	public int getWaitingQueueLength(){
			return scheduler.getWaitingQueue().size();
		}
	public void run(){
		
		Clock.tickClock();
		
		

		if(gen.nextInt(1)+999999999 == mark) {
			RandomJob.jobGenerator();
		}

			
		
		//If CPU empty and ready queue has process ready, send process to CPU.. else if the cpu has a process then execute
		if(cpu.getCurrentProcess(cpu.core1)==null&&Scheduler.getReadyQueue().size()>0){
			cpu.core1.setCurrentProcess(Scheduler.getNextProcess());
			if(cpu.core1.getCurrentProcess()!=null)
			cpu.core1.getCurrentProcess().taken();
			cpu.core1.getCurrentProcess().setArrivalTime(Clock.getClock());
			cpu.core1.getScheduler().resetTimer();		
		}
		if(cpu.getCurrentProcess(cpu.core2)==null&&Scheduler.getReadyQueue().size()>0){
			cpu.core2.setCurrentProcess(Scheduler.getNextProcess());
			if(cpu.core2.getCurrentProcess()!=null)
			cpu.core2.getCurrentProcess().taken();
			cpu.core2.getCurrentProcess().setArrivalTime(Clock.getClock());
			cpu.core2.getScheduler().resetTimer();
		}
		if(cpu.getCurrentProcess(cpu.core3)==null&&Scheduler.getReadyQueue().size()>0){
			cpu.core3.setCurrentProcess(Scheduler.getNextProcess());
			if(cpu.core3.getCurrentProcess()!=null)
			cpu.core3.getCurrentProcess().taken();
			cpu.core3.getCurrentProcess().setArrivalTime(Clock.getClock());
			cpu.core3.getScheduler().resetTimer();		
		}
		if(cpu.getCurrentProcess(cpu.core4)==null&&Scheduler.getReadyQueue().size()>0){
			cpu.core4.setCurrentProcess(Scheduler.getNextProcess());
			if(cpu.core4.getCurrentProcess()!=null)
			cpu.core4.getCurrentProcess().taken();
			cpu.core4.getCurrentProcess().setArrivalTime(Clock.getClock());
			cpu.core4.getScheduler().resetTimer();
		}
		
		//Updates the queues first, this should put next process first in ready queue
		scheduler.updateQueues();
		
		if(cpu.core1.getCurrentProcess()!=null || cpu.core2.getCurrentProcess()!=null || cpu.core3.getCurrentProcess()!=null || cpu.core4.getCurrentProcess()!=null){
			cpu.execute(scheduler);
			
		}
		
		scheduler.updateQueues();
		
		//Goes through ready queue to update IO flags
				for (int i=0;i<Scheduler.getReadyQueue().size();i++){
					if(Scheduler.getReadyQueue().get(i).getIOFlag()!=0){
						Scheduler.getReadyQueue().get(i).decrementIOFlag();
					}
					else if(Scheduler.getReadyQueue().get(i).getIOFlag()==0&&Scheduler.getReadyQueue().get(i).getProcessState()==ProcessState.WAIT){
							Scheduler.getReadyQueue().get(i).setState(ProcessState.READY);
						}
				}
		

		
		
		//Checks if process quantum time in CPU has been reached, if so, send to back of Ready Queue
		if(scheduler.checkQuant(cpu.core1)){
			cpu.core1.getCurrentProcess().setState(ProcessState.READY);
			cpu.core1.getCurrentProcess().free();
			Process temp = cpu.core1.getCurrentProcess();
			Scheduler.removeProcess(temp);
			Scheduler.getReadyQueue().add(temp);
			cpu.core1.setCurrentProcess(null);
		}
		else{
			return;
		}
		 
		if(scheduler.checkQuant(cpu.core2)){
			cpu.core2.getCurrentProcess().setState(ProcessState.READY);
			cpu.core2.getCurrentProcess().free();
			Process temp = cpu.core2.getCurrentProcess();
			scheduler.removeProcess(temp);
			scheduler.getReadyQueue().add(temp);
			cpu.core2.setCurrentProcess(null);
		}
		else{
			return;
		}
		
		if(scheduler.checkQuant(cpu.core3)){
			cpu.core3.getCurrentProcess().setState(ProcessState.READY);
			cpu.core3.getCurrentProcess().free();
			Process temp = cpu.core3.getCurrentProcess();
			scheduler.removeProcess(temp);
			scheduler.getReadyQueue().add(temp);
			cpu.core3.setCurrentProcess(null);
		}
		else{
			return;
		}
		 
		if(scheduler.checkQuant(cpu.core4)){
			cpu.core4.getCurrentProcess().setState(ProcessState.READY);
			cpu.core4.getCurrentProcess().free();
			Process temp = cpu.core4.getCurrentProcess();
			scheduler.removeProcess(temp);
			scheduler.getReadyQueue().add(temp);
			cpu.core4.setCurrentProcess(null);
		}
		else{
			return;
		}
	}

}
