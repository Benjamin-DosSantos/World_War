package com.blackpensoftware.world_war.handlers;

import java.awt.Graphics2D;

import com.blackpensoftware.world_war.generators.LandGenerator;
import com.blackpensoftware.world_war.generators.SeaGenerator;

public class MapHandler {
	LandGenerator land = new LandGenerator();
	SeaGenerator sea = new SeaGenerator();
	StatHandler stat = new StatHandler();
	
	public void genMap(Graphics2D g2d){
		sea.genSea(g2d);
		land.genLand(g2d);
		stat.displayStats(g2d, 10, 20);
	}// End of gen map method
}// End of class
