package eveofescape;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import eveofescape.gui.main_gui;

public class main {
	private static final long serialVersionUID = 0L;
	private static final int TIMER_DELAY = 35;
	public static main_gui window;
	
	public static void main(String[] args) {
		
		new javax.swing.Timer(TIMER_DELAY, new ActionListener() {
		     public void actionPerformed(ActionEvent e) {
		        gameLoop();
		     }
		  }).start();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new main_gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}
	
	public void init_screen() {
		
	}
	
	public static void gameLoop() {
	    //This is the game timer, automated things should be put here  
		//System.out.println("tick");
	}

}
