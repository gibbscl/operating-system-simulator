package GUI;

import java.util.ArrayList;

public class GuiPrompt extends gui {
	
	public static ArrayList<String> output = new ArrayList<>();

    public static void println(String string) {
        textArea.appendText(string + "\n");
        output.add(string);
    }

    public static void print(String string) {
        textArea.appendText(string);
        output.add(string);
    }
    
    public static void clear() {
    	textArea.clear();
    }
	

}
