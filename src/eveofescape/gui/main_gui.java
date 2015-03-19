package eveofescape.gui;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import eveofescape.Commands;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class main_gui {
	static Font main_font;
	static JTextArea main_text = new JTextArea();

	public JFrame frame;
	private JTextField main_input;
	private JTextField init_input;
	private JTextArea title_screen;
	public static JScrollPane main_scroller;
	/**
	 * Create the application.
	 */
	public main_gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		System.out.println("Loading Font...");
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    try {
	    	main_font = Font.createFont(Font.TRUETYPE_FONT, new File("gui/Terminus.ttf")).deriveFont(Font.BOLD, 14f);
			ge.registerFont(main_font);
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setTitle("Eve of Escape");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFont(main_font);
		// frame.setExtendedState(Frame.MAXIMIZED_BOTH);
	    // frame.setUndecorated(true);
		
		loadInitScreen();
		//loadMainScreen();
		
		
		main_text.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				main_input.requestFocus();
			}
		});
		main_text.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				updateScroll();				
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				updateScroll();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				updateScroll();
			}
			
			private void updateScroll() {
				main_scroller.scrollRectToVisible(main_text.getVisibleRect());
				
			
			} 
		});

		
	}
	
	public void loadInitScreen () {
		init_input = new JTextField();
		init_input.setForeground(Color.WHITE);
		init_input.setBackground(Color.BLACK);
		init_input.setFont(main_font);
		frame.getContentPane().add(init_input, BorderLayout.PAGE_END);
		
		title_screen = new JTextArea();
		title_screen = setDefaults(title_screen);
		title_screen.setText("                                                       \r\n _____                ___     _____                     \r\n|   __|_ _ ___    ___|  _|   |   __|___ ___ ___ ___ ___ \r\n|   __| | | -_|  | . |  _|   |   __|_ -|  _| .'| . | -_|\r\n|_____|\\_/|___|  |___|_|    |_____|___|___|__,|  _|___|\r\n                                              |_|      ");
		title_screen.append("\n\nWelcome to Eve of Escape\n\n Choose an Option:\n1.\tNew Game\n2.\tLoad Game\n3.\tDevelopment mode\n");
		
		JScrollPane title_scroller = new JScrollPane(title_screen, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		frame.add(title_scroller);
		
		//request the pointer on open
		init_input.requestFocus();
		
		init_input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = init_input.getText();
				init_input.setText("");
				loadGui(str);
			}
		});
		
	}
	
	protected void loadGui(String str) {
		switch (str) {
		case "1":
		case "2":
		case "3":
			System.out.println("loading main screen...");
			frame.getContentPane().removeAll();

			loadMainScreen();
			frame.getContentPane().add(main_input, BorderLayout.PAGE_END);
			frame.revalidate();
			frame.repaint();
		default:
			
			break;
		}
	}

	private JTextArea setDefaults(JTextArea text_area) {
		text_area.setBackground(Color.BLACK);
		text_area.setForeground(Color.WHITE);
		text_area.setEditable(false);
		text_area.setLineWrap(true);
		text_area.setFont(main_font);
		text_area.setHighlighter(null);
		return text_area;
		
	}

	public void loadMainScreen () {
		
		main_input = new JTextField();
		main_input.setForeground(Color.WHITE);
		main_input.setBackground(Color.BLACK);
		frame.getContentPane().add(main_input, BorderLayout.PAGE_END);
		//main_input.setColumns(10);
		main_input.setFont(main_font);
		
		main_text = setDefaults(main_text);
		main_scroller = new JScrollPane(main_text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		//set the focus to the text input by default
		main_input.requestFocusInWindow();
		main_text.setText("Entered into Development mode");
		frame.getContentPane().add(main_scroller);
		//Listeners
		
		frame.addWindowListener( new WindowAdapter() {
			   public void windowOpened( WindowEvent e ){
			        main_input.requestFocus();
			     }
			   } );
		
		main_input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = main_input.getText();
				main_input.setText("");
				main_text.append("\n" +str);
				main_text.setSelectionEnd(main_text.getText().length());
				String result = Commands.runCmd(str);
				main_text.append("\n" +result + "\n");
			}
		});
		
		frame.repaint();
	}

}
