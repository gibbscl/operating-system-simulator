package ParseText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import GUI.GuiPrompt;

import Components.Process;
import Components.Scheduler;

public class ParseText {
	
	private String orgInput;
	private String inputFile;
    private String command, file;
    private ArrayList<String> tokens = new ArrayList<>();
    private Scanner scan;

	public void parseJobFile(String jobFile){
		this.tokens.clear();
		File file = new File(jobFile);
        try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
            
        while (scan.hasNext()) {
                tokens.add(scan.next());
            }
       
        scan.close();
	}
	
	public void parseInput(String Input) {
		this.tokens.clear();
		scan = new Scanner(Input);
		while (scan.hasNext()){
			tokens.add(scan.next());
		}
	}
	
	public String orgInput(){
		return this.orgInput.substring(9,orgInput.length()-4);
	}
	
	
	
	public void parseFile(String filename) {
		
        this.inputFile = "programs/" + filename + ".txt";
        parseProgramFile();
    }
	
	public void parseProgramFile(){
		this.tokens.clear();
		File file = new File(inputFile);
        try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
            
        while (scan.hasNext()) {
                this.tokens.add(scan.next());
            }
       
        scan.close();
	}
	
	public void parseProgramFile(File f) throws IOException{
		this.tokens.clear();
        try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
            
        while (scan.hasNext()) {
                this.tokens.add(scan.next());
            }
       
        scan.close();
        this.orgInput = f.getPath();
	}
	
	//Breaks down the command entered and file (if presented) 
	 public void parseLine(String command) {
	        command = command.toLowerCase();
	        scan = new Scanner(command);
	        this.command = scan.next();
	        file = null;
	        if (scan.hasNext())
	            file = scan.next();
	        scan.close();
	    }

	 
	//Getter methods for the few fields of this class
	 public ArrayList<String> getQueue() {
	        return this.tokens;
	    }

	    public String getCommand() {
	        return this.command;
	    }

	    public String getFile() {
	        return this.file;
	    }
	    
	    
	    
	    
	
	  
}
