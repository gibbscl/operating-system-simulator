package ParseText;

import java.io.File;

import Components.Process;
import Components.Scheduler;
import java.util.Random;
public class RandomJob {
	
	 public static void jobGenerator() {      
	      File f = null;
	      File[] paths;
	      ParseText job = new ParseText();
	  	  Random indicies = new Random();
	      try {  
	         // create new file
	         f = new File("programs/");
	         
	         // returns pathnames for files and directory
	         paths = f.listFiles();
	         job.parseProgramFile(paths[indicies.nextInt(3)]);
	         String name = job.orgInput();
	         int size = Integer.valueOf(job.getQueue().remove(0));
	         Process temp = new Process(name, size, job.getQueue());
	         Scheduler.insertProcess(temp);
	         Scheduler.setArrivalTime(temp);
	      
	         
	      } catch(Exception e) {
	         
	         //if any error occurs
	        e.printStackTrace();
	     }
	     
	   }
	 
}

