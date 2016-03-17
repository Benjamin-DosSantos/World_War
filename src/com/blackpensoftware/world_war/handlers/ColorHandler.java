package com.blackpensoftware.world_war.handlers;

import java.awt.Color;
import java.util.Random;

public class ColorHandler {
	
	public Color hex_color = Color.BLACK;	// Sets the base hex color
	
	Random ran = new Random();	// Random instance 
	
	public void generateColor(){
		int color_red = 0,	// Sets the value for the amount of red
			color_green = ran.nextInt(156) + 100,	// Generates the amount of green from 100 to 255
			color_blue = 0;	// Sets the amount of blue in the color to be generated
		
		hex_color = new Color(color_red, color_green, color_blue);	// Sets the hex_color to the new color that is generated
	}
	
	public Color getColor(){
		return hex_color;	// Returns the hex color
	}
}
