package com.blackpensoftware.world_war.handlers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StatHandler {
	
	Random ran = new Random();
	
	int oil_value = 1000, 
		military_value = 2000, 
		navy_value = 100, 
		total_value = oil_value + military_value + navy_value;
	
	String country_name = "Base Country";
	
	int font_size = 20;
	Color font_color = Color.WHITE;
	public void displayStats(Graphics g, int xPos, int yPos){
		g.setColor(font_color);
		Font country_font = new Font("Times", Font.BOLD, font_size);
		g.setFont(country_font);
		displayIcon(g, yPos, yPos);
		displayCountryName(g, yPos, yPos);
		displayOilIcon(g, yPos, yPos);
		displayOilValue(g, yPos, yPos);
		displayMilitaryIcon(g, yPos, yPos);
		displayMilitaryValue(g, yPos, yPos);
		displayNavyIcon(g, yPos, yPos);
		displayNavyValue(g, yPos, yPos);
		displayTotalValue(g, yPos, yPos);
	}// End of displayStats method
	
	public void displayIcon(Graphics g, int xPos, int yPos){
		
	}// End of displayIcon method
	
	public void setCountryName(){
		File country_names_file = new File("/cn.txt");
			
		Scanner cn = null;
		try {
			cn = new Scanner(country_names_file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		List<String> country_name_list = new ArrayList<String>();
		//List<String> lnline = new ArrayList<String>();
			
		Random ran = new Random();
			
		while(cn.hasNextLine()){
			country_name_list.add(cn.nextLine());
		}
			country_name = country_name_list.get(ran.nextInt(country_name_list.size()));
	}
	
	public int ShiftNorth(int p, int distance) {
		   return (p - distance);
		   }
	public int ShiftSouth(int p, int distance) {
		   return (p + distance);
		   }
	public int ShiftEast(int p, int distance) {
		   return (p + distance);
		   }
	public int ShiftWest(int p, int distance) {
		   return (p - distance);
		   }
	
	public void displayCountryName(Graphics g, int xPos, int yPos){
		g.setColor(Color.WHITE);
		g.drawString(country_name, ShiftWest(xPos, 1), ShiftNorth(yPos, 1));
		g.drawString(country_name, ShiftWest(xPos, 1), ShiftSouth(yPos, 1));
		g.drawString(country_name, ShiftEast(xPos, 1), ShiftNorth(yPos, 1));
		g.drawString(country_name, ShiftEast(xPos, 1), ShiftSouth(yPos, 1));
		g.setColor(Color.BLACK);
		g.drawString(country_name, xPos, yPos);
	}// End of displayCountryName method
	
	public void displayOilIcon(Graphics g, int xPos, int yPos){
		
	}// End of displayOilIcon method
	
	public void displayOilValue(Graphics g, int xPos, int yPos){
		g.setColor(Color.WHITE);
		g.drawString("Oil: " + oil_value, ShiftWest(xPos, 1), ShiftNorth(yPos + 20, 1));
		g.drawString("Oil: " + oil_value, ShiftWest(xPos, 1), ShiftSouth(yPos + 20, 1));
		g.drawString("Oil: " + oil_value, ShiftEast(xPos, 1), ShiftNorth(yPos + 20, 1));
		g.drawString("Oil: " + oil_value, ShiftEast(xPos, 1), ShiftSouth(yPos + 20, 1));
		g.setColor(Color.BLACK);
		g.drawString("Oil: " + oil_value, xPos, yPos + 20);
	}// End of displayOilValue method
	
	public void displayMilitaryIcon(Graphics g, int xPos, int yPos){
		
	}// End of displayMilitaryIcon method
	
	public void displayMilitaryValue(Graphics g, int xPos, int yPos){
		g.setColor(Color.WHITE);
		g.drawString("Military: " + military_value, ShiftWest(xPos, 1), ShiftNorth(yPos + 40, 1));
		g.drawString("Military: " + military_value, ShiftWest(xPos, 1), ShiftSouth(yPos + 40, 1));
		g.drawString("Military: " + military_value, ShiftEast(xPos, 1), ShiftNorth(yPos + 40, 1));
		g.drawString("Military: " + military_value, ShiftEast(xPos, 1), ShiftSouth(yPos + 40, 1));
		g.setColor(Color.BLACK);
		g.drawString("Military: " + military_value, xPos, yPos + 40);
	}// End of displayMilitaryValue method
	
	public void displayNavyIcon(Graphics g, int xPos, int yPos){
		
	}// End of displayNavyIcon method
	
	public void displayNavyValue(Graphics g, int xPos, int yPos){
		g.setColor(Color.WHITE);
		g.drawString("Navy: " + navy_value, ShiftWest(xPos, 1), ShiftNorth(yPos + 60, 1));
		g.drawString("Navy: " + navy_value, ShiftWest(xPos, 1), ShiftSouth(yPos + 60, 1));
		g.drawString("Navy: " + navy_value, ShiftEast(xPos, 1), ShiftNorth(yPos + 60, 1));
		g.drawString("Navy: " + navy_value, ShiftEast(xPos, 1), ShiftSouth(yPos + 60, 1));
		g.setColor(Color.BLACK);
		g.drawString("Navy: " + navy_value, xPos, yPos + 60);
	}// End of displayNavyValue method
	
	public void displayTotalValue(Graphics g, int xPos, int yPos){
		g.setColor(Color.WHITE);
		g.drawString("Total Points: " + total_value, ShiftWest(xPos, 1), ShiftNorth(yPos + 80, 1));
		g.drawString("Total Points: " + total_value, ShiftWest(xPos, 1), ShiftSouth(yPos + 80, 1));
		g.drawString("Total Points: " + total_value, ShiftEast(xPos, 1), ShiftNorth(yPos + 80, 1));
		g.drawString("Total Points: " + total_value, ShiftEast(xPos, 1), ShiftSouth(yPos + 80, 1));
		g.setColor(Color.BLACK);
		g.drawString("Total Points: " + total_value, xPos, yPos + 80);
	}// End of displayTotalValue method
	
	public int getOilValue(){
		return oil_value;
	}
	
	public int getMilitaryValue(){
		return military_value;
	}
	
	public int getNavyValue(){
		return navy_value;
	}
	
	public void setOilValue(int valueToSet){
		oil_value = valueToSet;
	}
	
	public void setMilitaryValue(int valueToSet){
		military_value = valueToSet;
	}
	
	public void setNavyValue(int valueToSet){
		navy_value = valueToSet;
	}
}// End of class