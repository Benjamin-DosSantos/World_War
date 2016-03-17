package com.blackpensoftware.world_war.handlers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LandHandler extends JPanel{
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		// Gets the dimension of the whole screen 
	static double width = screenSize.getWidth();	// Creates a double with the value of the screen width
	static double height = screenSize.getHeight();	// Creates a double with the value of the screen height 
	
	@Override
	public void paint(Graphics g) {
		this.setBackground(FrameHandler.game_panel_color);	// Sets the background color for the panel to be drawn 
		Graphics2D g2d = (Graphics2D) g;	// Converts the graphics to the Graphics2D system
		g2d.setColor(Color.RED);	// Sets the active debug color to red
		
		/**
		 *  
		 * Creates instances of main classes to 
		 * be used for generation later on 
		 * 
		 **/
		
		MapHandler map = new MapHandler();
		
		/** 
		 *
		 * Calling of methods that generate the individual portion 
		 * 
		 **/
		
		map.genMap(g2d);
		
	}//	End of paint method
	
	public boolean dispatchKeyEvent(KeyEvent e) {
	    if (e.getID() == KeyEvent.KEY_PRESSED) {
	        if (e.getKeyCode() == KeyEvent.VK_R) {
	            this.repaint();
	        }
	    }
	    return false;
	}
}// End of class
