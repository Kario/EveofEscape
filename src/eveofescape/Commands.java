package eveofescape;

import java.awt.Window;

import eveofescape.gui.main_gui;

public class Commands {
	
	public static String runCmd (String command) {
		String cmd, vars = null;
		String [] arr = command.split(" ", 2);
		if (command.indexOf(' ') > -1) { // Check if there is more than one word.
	      cmd = command.substring(0, command.indexOf(' ')); // Extract first word.
	    } else {
	      cmd = command.toString(); // Text is the first word itself.
	    }
		
		switch (arr[0]) {
			case "say": return "You say: " + arr[1];
			case "north": return "There is no exit there!";
			case "makeroom": return Room.create(arr[1]);
			case "removegui": main.window.frame.remove(main_gui.main_scroller); main.window.frame.repaint();  return "Gui's gone, Dave.";
			case "addgui" : main.window.frame.add(main_gui.main_scroller); main.window.frame.repaint(); return "Dave? How did you get here?!";
				
		
			default: return "Not a Command";
		}
		
	}
}
