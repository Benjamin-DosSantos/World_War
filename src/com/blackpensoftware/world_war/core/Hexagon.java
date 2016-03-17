package com.blackpensoftware.world_war.core;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.GeneralPath;

public class Hexagon{
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		// Gets the dimension of the whole screen 
	double screenwidth = screenSize.getWidth();	// Creates a double with the value of the screen width
	double screenheight = screenSize.getHeight();	// Creates a double with the value of the screen height 
	
	int size_apothem = 1;	// Sets the apothm size for the hexagons to be generated
	int diameter = size_apothem * 2;		// Creates and sets the value for the diameter of the hexagons 
	int side_length = diameter + (size_apothem / 2);	// Creates and sets the value for the side length of the hexagon to be generated
	int height = diameter * 2;	// Creates and sets the value of the total height of the hexagons
	int width = (size_apothem * 2) + side_length;	// Calculates the total width of the hexagons 
	int number_to_gen_width = (int)screenwidth / diameter;		// Calculates the number of hexagons to be generated in the frame on the x axis
	int number_to_gen_height = (int)screenheight / size_apothem;	// Calculates the number of hexagons to be generated on the y axis
	
	int[] xPoints = new int[6];		// Creates an integer array for the x points of the hexagons to be generated
	int[] yPoints = new int[6];		// Creates an integer array for the y points of the hexagons to be generated 
	
	int xPos = 0;	// Sets the base x Position 
	int yPos = 0;	// Sets the base y Position 
	
	public void drawHex(Graphics2D g, int xPos, int yPos){
		
		this.xPos = xPos;	// Sets the xPos in the class to equal the xPos of the method for hexagon generation 
		this.yPos = xPos;	// Sets the xPos in the class to equal the xPos of the method for hexagon generation 
		
		
		Point points[] = new Point[6];
		
		points[0] = new Point(xPos + size_apothem, yPos);
		points[1] = new Point(xPos + (size_apothem + side_length), yPos);
		points[2] = new Point(xPos + (2 * size_apothem + side_length), yPos + diameter);
		points[3] = new Point(xPos + (size_apothem + side_length), yPos + height);
		points[4] = new Point(xPos + size_apothem, yPos + height);
		points[5] = new Point(xPos, yPos + diameter);
		
		GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);
		polygon.moveTo(points[0].getX(), points[0].getY());
		
		for (int index = 1; index < xPoints.length; index++) {
	        polygon.lineTo(points[index].getX(), points[index].getY());
		}
		
		g.draw(polygon);
	}// End of Hexagon method
	
	public void fillHex(Graphics2D g, int xPos, int yPos){
		
		
		Point points[] = new Point[6];
		
		points[0] = new Point(xPos + size_apothem, yPos);
		points[1] = new Point(xPos + (size_apothem + side_length), yPos);
		points[2] = new Point(xPos + (2 * size_apothem + side_length), yPos + diameter);
		points[3] = new Point(xPos + (size_apothem + side_length), yPos + height);
		points[4] = new Point(xPos + size_apothem, yPos + height);
		points[5] = new Point(xPos, yPos + diameter);
		
		GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);
		polygon.moveTo(points[0].getX(), points[0].getY());
		
		for (int index = 1; index < xPoints.length; index++) {
	        polygon.lineTo(points[index].getX(), points[index].getY());
		};
		
		g.fill(polygon);
	}// End of Hexagon method
	
	
	
	public int getSize(){
		return side_length;		// Returns the value of side_length
	}
	
	public int getSizeApothem(){
		return size_apothem;		// Returns the value of side_apothum
	}
	
	public int getDiameter(){
		return diameter;	//	Returns the value of diameter
	}
	
	public int getHeight(){
		return height;	// Returns the value of height
	}
	
	public int getHex_xPos(){
		return xPos;	// Returns the value of xPos
	}
	
	public int getHex_yPos(){
		return yPos;	// Returns the value of yPos
	}
	
	public int getNumberToGenX(){
		return number_to_gen_width;
	}
	
	public int getNumberToGenY(){
		return number_to_gen_height;
	}
	
	public int getWidth(){
		return side_length+ 2 * diameter;
	}
}// End of class