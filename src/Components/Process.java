package Components;
import GUI.GuiPrompt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class Process {

	
	private ProcessState processState;
	private String processName;
	private int calcTime=0;
	private int processMemory;
	private int processTime;
	private int processID;
	private int processPriority;
	private int timeSpent=0;
	private int timeLeftToComplete=0;
	private int ioRequestsPerformed=0;
	private int arrivalTime;
	private int ioFlag=0;
	private ArrayList <String> processCommands = new ArrayList<>();
	private boolean tag=false;
	
	
	public void taken(){
		tag=true;
	}
	public void free(){
		tag=false;
	}
	public boolean getTag(){
		return this.tag;
	}
	//Initializes process with the name, memory size, and array list of operation strings within process
	public Process(String processName, int mem, ArrayList<String>operationString){
		this.processName = processName;
		this.processMemory = mem;
		this.processCommands=operationString;
		this.processState = ProcessState.NEW;
		for (int i=0;i<operationString.size();i++){
			if(operationString.get(i).equals("CALCULATE")){
				this.timeLeftToComplete+=Integer.parseInt(operationString.get(i+1));
			}
		}
	}
	

	//Setter methods for all fields of Process
	public void setState(ProcessState state){
		this.processState = state;
	}
	public void setMemory(int mem){
		this.processMemory = mem;
	}
	public void setProcessID(int id){
		this.processID = id;
	}
	public void setTime(int time){
		this.processTime = time;
	}
	public void setPriority(int p){
		this.processPriority = p;
	}
	public void setArrivalTime(int time){
		this.arrivalTime = time;
	}
	public void setCalcTime(int t){
		this.calcTime = t;
	}
	public void setIOFlag(int t){
		this.ioFlag = t;
		this.setState(ProcessState.WAIT);
	}
	

	//Getter methods for all fields of Process()
	public int getPriority(){
		return this.processPriority;
	}
	public ProcessState getProcessState(){
		return this.processState;
	}
	public int getTimeLeft(){ 
		return this.timeLeftToComplete-this.timeSpent;
	}
	public int getProcessMemory(){
		return this.processMemory;
	}
	public String getProcessName(){
		return this.processName;
	}
	public int getRequestsPerformed(){//returns # of IO requests performed
		return this.ioRequestsPerformed;
	}
	public int getArrivalTime(){
		return arrivalTime;
	}
	public int getWait(){
		return Clock.getClock()-this.arrivalTime;
	}
	public int getCalcTime(){
		return this.calcTime;
	}
	public int getTimeSpent(){
		return this.timeSpent;
	}
	public ArrayList<String> getProcessCommands(){
		return this.processCommands;
	}
	public String getNextCommand(){
		if(this.processCommands.size()>0){
		return this.processCommands.remove(0);
		}else return null;
	}
	
	
	//Incrementing methods for process
	public void incrementTime(){
		this.timeSpent++;
	}
	public void incrementIORequests(){
		this.ioRequestsPerformed++;
	}
	public void decrementCalcTime(){
		this.calcTime--;
	}
	
	public int getIOFlag(){
		return this.ioFlag;
	}
	
	public void decrementIOFlag(){
		this.ioFlag--;
	}
	
	
	public void printProcessInfo(){
		GuiPrompt.println("______________________________________");
		GuiPrompt.println("\n" + "PROCESS NAME: " + processName); 
		GuiPrompt.println("\n" + "PROCESS STATE: " + processState);
		GuiPrompt.println("\n" + "CPU TIME LEFT FOR PROCESS COMPLETION: " + this.timeLeftToComplete);
		GuiPrompt.println("\n" + "Arrival Time: " + this.arrivalTime);
		GuiPrompt.println("\n" + "PCB: " + this.getProcessCommands().toString());
		GuiPrompt.println("\n" + "______________________________________");

		
	}
	
	
	
}
