package Components;
import java.awt.TextField;
import Components.Process;
import GUI.GuiPrompt;
import GUI.gui;
import ParseText.ParseText;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import javafx.scene.control.*;
import ParseText.ParseText;


public class CommandLine {
		
	//Takes job file and stores each token in our array list 
	 private static final ParseText userInput = new ParseText();
	 private static final ParseText requestFile = new ParseText();
	

	//Function for determining next action based on input
	  public static boolean storeInputs(String input) {
	        userInput.parseLine(input);
	        boolean valid = Commands(userInput.getCommand());
	        if (valid) {
	            if (!(userInput.getCommand() == null)) {
	                chooseCommand(userInput.getCommand(), userInput.getFile());
	            }
	        }
	        return valid;
	    }

	    
	    public static boolean Commands(String command) {
	    	switch(userInput.getCommand()) {
	    	case "proc": return true;
	    	case "mem": return true;
	    	case "exe": return true;
	    	case "reset": return true;
	    	case "exit": return true;
	    	case "clear": return true;
	    	case "load": return true;
	    	}
	    	return false;
	    	}
	    	
   		
	    
	    private static void chooseCommand(String command, String file) {
	        switch(command) {
	        	case "load": load(file); break;
	            case "proc": proc(); break;
	            case "mem": mem(); break;
	            case "exe": 
	            	if(file!=(null)){
	            		exe(Integer.parseInt(file));
	            	}else
	            	exe(); break;
	            case "reset": reset(); break;
	            case "exit": exit(); break;
	            default: break;
	        } 
	    }
	    
	    //Starts parsing through the actual file defined by user input(Function-Stores input)
	    private static void load(String file) {
	        requestFile.parseFile(file);
	        if(requestFile.getQueue()!=null) {
	            int size = Integer.valueOf(requestFile.getQueue().remove(0));
	            //System.out.println(requestFile.getQueue().remove(0));
	            Process temp = new Process(file,size,requestFile.getQueue());
	            Scheduler.insertProcess(temp);
	           
	        }
	        GuiPrompt.print("Load Successful \n");
	    }
	    
	    
	    public static void proc(){
  	    	ArrayList<Process> ready = Scheduler.getReadyQueue();
  	    	ArrayList <Process>wait = Scheduler.getWaitingQueue();
  	    	
  	    	if(ready.size()==0 && wait.size()==0){
  	    		GuiPrompt.println("No process are currently loaded onto system.");
  	    	}else
  	    	{
  	    	for(int i=0;i<ready.size();i++){
  	    		ready.get(i).printProcessInfo();
  	    	}
  	    	for(int k=0;k<wait.size();k++){
  	    		wait.get(k).printProcessInfo();
  	    	}
  	    	}
  	    	
  	    }
	    
	    public static boolean exit(){
	    	return true;
	    }
  	    
	    public static void mem(){
  	    	int i = Scheduler.getUsedMemory();
  	    	System.out.println("Current memory usage: " + i);
  	    	
  	    }
  	    
	    public static void reset(){
  	    	Clock.resetClock();
  	    	Scheduler.resetScheduler();
  	    	GuiPrompt.clear();
  	  
  	    }
  	    
  	   
  	    
	    public static void exe(int cycles){
  	    	Simulator.executeSolo=false;
  	    	Simulator.executionCycles=cycles;
  	    }
	    public static void exe(){
  	    	Simulator.executeSolo=true;
  	    	Simulator.executionCycles=0;
  	    }
	    

  	    
	    
	    
	
}