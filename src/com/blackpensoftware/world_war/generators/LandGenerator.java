package com.blackpensoftware.world_war.generators;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.Toolkit;
import java.util.Random;

import com.blackpensoftware.world_war.core.Hexagon;
import com.blackpensoftware.world_war.handlers.ColorHandler;

public class LandGenerator {
	
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		// Gets the dimension of the whole screen 
	static double screenwidth = screenSize.getWidth();	// Creates a double with the value of the screen width
	static double screenheight = screenSize.getHeight();	// Creates a double with the value of the screen height 
	
	public void genLand(Graphics2D g2d){
		Random ran = new Random();	// Random instance call
		
		Hexagon hex = new Hexagon();	// Hexagon instance Call
		ColorHandler selector = new ColorHandler();
			
		int number_of_strands = 1;	// Sets the number of strands that will be sent out form the origin point
		
		for(int i = 0; i < number_of_strands; i++){
			int xPos = (hex.getSize() / 2) * -1;	// Sets the x origin point for the master Hexagon 
			int yPos = (hex.getDiameter()) * -1;	// Sets the y origin point for the master hexagon 
			while(yPos <= screenheight){	// while the yPosition of the hexagons to be generated is not equal to the bottom of the screen 
				int dir_x = ran.nextInt(2);		// Directional call for the x axis, left (0) or right (1) 
				int dir_y = ran.nextInt(3);		// Directional call for the y axis, up(0), no change (1), or down(2)
				
				if(xPos <= -20){
					xPos = (hex.getSize() / 2) * -1;
				}else if(xPos >= ((int)screenwidth * 3) + 20){
					xPos = ((int)screenwidth / hex.getDiameter()) * ((hex.getSize() / 2) * -1);
				}else if(yPos <= -20){
					yPos = (hex.getDiameter()) * -1;
				}
				
				if(dir_x == 0){		// if the directional call is 0 
					xPos -= hex.getSizeApothem() * 2 + hex.getSize() * 2;	// Moves the x Position left
					selector.generateColor();
					g2d.setColor(selector.getColor());	// Sets the color of the hexagon to be drawn 
					hex.fillHex(g2d, xPos, yPos);	// Fills the hexagon 
					g2d.setColor(Color.BLACK);	// Sets the outline color
					hex.drawHex(g2d, xPos, yPos);	// Draws the outline 
					selector.generateColor();
					g2d.setColor(selector.getColor());	// Sets the color for the hexagon to be drawn 
					hex.fillHex(g2d, xPos + hex.getSize() + hex.getSizeApothem(), yPos - hex.getDiameter());	// Draws the hexagon up and to the right 
					g2d.setColor(Color.BLACK);	// Sets the outline color of the hexagon 
					hex.drawHex(g2d, xPos, yPos);	// Outlines the hexagon 
				}else{	
					xPos += hex.getSizeApothem() * 2 + hex.getSize() * 2;	// Moves the x axis to the right
					selector.generateColor();
					g2d.setColor(selector.getColor());	// Sets the color of the hexgon to be drawn
					hex.fillHex(g2d, xPos, yPos);	// Draws the hexagon
					g2d.setColor(Color.BLACK);	// Sets the outline color of the hexagon 
					hex.drawHex(g2d, xPos, yPos);	// Outlines the hexagon 
					selector.generateColor();
					g2d.setColor(selector.getColor());	// Sets the color of the hexagon to be generated
					hex.fillHex(g2d, xPos + hex.getSize() + hex.getSizeApothem(), yPos - hex.getDiameter());	// Fills the hexagon on space up and to the right
					g2d.setColor(Color.BLACK);	// Sets the outline color of the hexagon 
					hex.drawHex(g2d, xPos, yPos);	// Outlines the hexagon 
				}	// End of if 0
				
				if(dir_y == 0){		// if 0
					yPos -= hex.getHeight();	// Move the y pos to the left
					selector.generateColor();
					g2d.setColor(selector.getColor());	// Set the color of the hexagon to be drawn 
					hex.fillHex(g2d, xPos, yPos);	// Draw the hexagon 
					g2d.setColor(Color.BLACK);	// Set the color of the outline 
					hex.drawHex(g2d, xPos, yPos);	// Draw the hexagon outline 
				}else if(dir_y == 1){	// if 1
					yPos += 0;	// Do not change the y 
				}else{
					yPos += hex.getHeight();	// Move the y to the right 
				}// End of else	
			}// End of if 0
		}// End of while
	}// End of GenerateBoarders method
	
	public void fillOther(Graphics2D g2d, int start_xPos, int start_yPos) throws AWTException{
		Robot rob = new Robot();
		
		while(start_yPos != screenwidth){
			if(rob.getPixelColor(start_xPos, start_xPos) == Color.WHITE){
				System.out.println("Point: " + start_xPos + ", " + start_yPos + " is White");
			}
			start_xPos += 10;
			start_yPos += 10;
		}
	}// End of fill other method
}// End of Class