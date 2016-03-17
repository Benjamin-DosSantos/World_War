package com.blackpensoftware.world_war.generators;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.Random;

import com.blackpensoftware.world_war.core.Hexagon;

public class BorderGenerator {
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		// Gets the dimension of the whole screen 
	static double screenwidth = screenSize.getWidth();	// Creates a double with the value of the screen width
	static double screenheight = screenSize.getHeight();	// Creates a double with the value of the screen height 

	
	public void genBorder(Graphics2D g){
		Hexagon hex = new Hexagon();
		Random ran = new Random();
		
		int starting_xPos = (hex.getSize() / 2) * -1;
		int starting_yPos = (hex.getDiameter()) * -1;
		
		int xPos = starting_xPos;
		int yPos = starting_yPos;
		
		Color hex_color = Color.ORANGE;
		Color hex_outline = Color.BLACK;
		
		int number_of_countries = 5;
		
		for(int i = 1; i < number_of_countries; i++){
			while(yPos <= (int)screenheight){
				g.setColor(hex_color);
				hex.fillHex(g, xPos, yPos);
				g.setColor(hex_outline);
				hex.drawHex(g, xPos, yPos);
				
				int dir_x = ran.nextInt(2);		// 0 or 1
				// 0 = Left
				// 1 = Right
				
				if(dir_x == 0){
					xPos -= (hex.getSize() / 2);
				}else{
					xPos += (hex.getSize() / 2);
				}
				yPos += hex.getDiameter();
			}// End of while ypos
		}// End of for number of countries
	}// End of genBorder method
}// End of class
