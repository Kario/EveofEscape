package eveofescape;

import java.awt.Window;

import eveofescape.gui.main_gui;

public class Commands {
	
	public static String runCmd (String command) {
		String cmd, vars = null;
		if (command.indexOf(' ') > -1) { // Check if there is more than one word.
		  int i = command.indexOf(' ');
		  cmd = command.substring(0, i); // Extract first word.
		  vars = command.substring(i); 
	    } else {
	      cmd = command.toString(); // Text is the first word itself.
	    }
		
		switch (cmd) {
			case "say": return "You say: " + vars;
			case "north": return "There is no exit there!";
			case "makeroom": return Room.create(vars);
			case "removegui": main.window.frame.remove(main_gui.main_scroller); main.window.frame.repaint();  return "Gui's gone, Dave.";
			case "addgui" : main.window.frame.add(main_gui.main_scroller); main.window.frame.repaint(); return "Dave? How did you get here?!";
			case "loaddb" : return Database.loadDatabase(vars);
				
		
			default: return "Not a Command";
		}
		
	}
}
