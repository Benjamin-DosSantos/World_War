package com.blackpensoftware.world_war.generators;

import java.awt.Color;
import java.awt.Graphics;

import com.blackpensoftware.world_war.core.Hexagon;

public class SandGenerator {
	Hexagon hex = new Hexagon();
	
	
	Color color_1 = new Color(226, 215, 173),
		  color_2 = new Color(194, 178, 128),
		  color_3 = new Color(193, 154, 107);
	
	
	Color color_array[] = {color_1, color_2, color_3};
	
	int sandcolor_red = 226,
		sandcolor_green = 215,
		sandcolor_blue = 173;
	Color sandcolor = new Color(sandcolor_red, sandcolor_green, sandcolor_blue);
	
	int base_xPos = (hex.getSize() / 2) * -1,
		base_yPos = (hex.getDiameter()) * -1;
	int xPos = base_xPos,
		yPos = base_yPos;
	
	public void genSand(Graphics g2d){
		g2d.setColor(sandcolor);
	//	g2d.fillRect(0, 0, 1000, 1000);
	}
	
	public void checkNeighbors(){
		
	}// End of class
}// End of class
