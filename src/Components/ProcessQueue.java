package Components;

import java.util.ArrayList;

public class ProcessQueue {

	 private ArrayList<Process> readyQueue = new ArrayList<>();
	 private ArrayList<Process> waitingQueue = new ArrayList<>();
	 private int freeMemory = 4096;
	 
	 
	 //Adds a process to the ready queue if there is enough space, if there isn't enough space its added to the waiting queue
	 public void enqueueReadyProcess(Process p){
		 if(p.getProcessMemory()<this.freeMemory){
		 this.readyQueue.add(p);
		 p.setState(ProcessState.READY);
		 p.setArrivalTime(Clock.getClock());
		 this.freeMemory = this.freeMemory - p.getProcessMemory();

		 }else
			 enqueueWaitingProcess(p);
	 }
	 
	 public Process dequeueReadyProcess(){
		 Process temp;
		 temp = this.readyQueue.remove(0);
		 this.freeMemory+=this.freeMemory+temp.getProcessMemory(); 
		 return temp;
	 }
	 
	
	 public void enqueueWaitingProcess(Process p){
		 this.waitingQueue.add(p);
	 }
	 
	 public void dequeueWaiting(){
		 this.waitingQueue.remove(0);
	 }
	 
	 public void removeProcess(Process process) {
	      readyQueue.remove(process);
	      this.freeMemory+=process.getProcessMemory();
	    }
	 
	 
	 public int getFreeMemory(){
		 return this.freeMemory;
	 }
	 public int getUsedMemory(){
		 return 4096-this.freeMemory;
	 }
	 
	 //Pops process from front of array list, sends it to the back
	 public void preemptedProcess(Process p){
		 Process temp = this.readyQueue.get(0);
		 this.readyQueue.remove(0);
		 this.readyQueue.add(temp);
	 }
	 
	 public ArrayList<Process> getReadyQueue(){
		 return this.readyQueue;
	 }
	 public ArrayList<Process> getWaitingQueue(){
		 return this.waitingQueue;
	 }
	 
	 
	public void setWait(Process p){
		p.setState(ProcessState.WAIT);
	}
	
	
	public void updateQueues(){

		for (int i=0;i<this.readyQueue.size();i++){
			if(this.readyQueue.get(i).getProcessState()==ProcessState.EXIT){
				this.freeMemory+=this.readyQueue.get(i).getProcessMemory();
				this.readyQueue.remove(i);
		}
		}
			if(this.freeMemory>0 && this.waitingQueue.size()>0){
			for(int k = 0;k<this.waitingQueue.size();k++){
				if(this.waitingQueue.get(k).getProcessMemory()<this.freeMemory){
					Process temp = this.waitingQueue.remove(k);
					this.enqueueReadyProcess(temp);
				}
			
			}
			}
		}
	

	public void resetQueues(){
		this.readyQueue.clear();
		this.waitingQueue.clear();
	}
	
	public void addReadyProcess(Process p){
		this.readyQueue.add(p);
	}
	
	
	  
}
