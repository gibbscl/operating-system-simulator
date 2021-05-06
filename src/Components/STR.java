package Components;

import java.util.ArrayList;

//Shortest Time Remaining scheduler
public class STR {

	
	private static ProcessQueue queue = new ProcessQueue();
	
	
	public int getRemainingTime(Process p){
		p.getTimeLeft();
		return 0;
	}
	
	//Method returns the next process to send to the CPU based on the shortest calculation time next
	public static Process getNextProcess(){
		Process temp = queue.getReadyQueue().get(0);
		for(int i=0;i<queue.getReadyQueue().size();i++){
			if(queue.getReadyQueue().get(i).getTimeLeft()<temp.getTimeLeft() && queue.getReadyQueue().get(i).getProcessState()==ProcessState.READY){
					temp = queue.getReadyQueue().get(i);
			}
		}
		return temp;
	}
	

	//Inserts process to either ready queue or waiting queue, wherever it can 'fit'
		public static void insertProcess(Process p){
			if(queue.getFreeMemory()>p.getProcessMemory()){
				queue.enqueueReadyProcess(p);
			}
			else
				queue.enqueueWaitingProcess(p);
		}
		
		
		//Removes process from top of readyQueue, can be used to pop to CPU
		public static void removeProcess(Process p){
			queue.removeProcess(p);
		}
		
		
		//Returns the arrival time of the process
		public int getArrivalTime(Process p){
			return p.getArrivalTime();
		}
		//Sets the arrival time of the process to the current reading of the clock
		public void setArrivalTime(Process p){
			p.setArrivalTime(Clock.getClock());
		}
		
		
		//Returns readyQueue
		public static ArrayList<Process> getReadyQueue() {
	        return queue.getReadyQueue();
	    }
		
		//Returns waitingQueue
	    public static ArrayList<Process> getWaitingQueue() {
	        return queue.getWaitingQueue();
	    }
	   
	    //Updates queues based on ProcessQueue.updateQeueus()
	    public void updateQueues(){
	    	queue.updateQueues();
	    }
	    
	    public static int getFreeMemory(){
	    	return queue.getFreeMemory();
	    }
	    public static int getUsedMemory(){
	    	return queue.getUsedMemory();
	    }
	    
	    public static void resetScheduler(){
	    	queue.resetQueues();
	    }
	
	
}
