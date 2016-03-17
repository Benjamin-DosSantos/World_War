package com.blackpensoftware.world_war.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class Land {
	public void drawLand(Graphics2D g2d){
		// draw GeneralPath (polygon)
		
		int x1Points[] = {0, 100, 0, 100};
		int y1Points[] = {0, 50, 50, 0};
		GeneralPath polygon = 
		        new GeneralPath(GeneralPath.WIND_EVEN_ODD,
		                        x1Points.length);
		polygon.moveTo(x1Points[0], y1Points[0]);

		for (int index = 1; index < x1Points.length; index++) {
		        polygon.lineTo(x1Points[index], y1Points[index]);
		};

		polygon.closePath();
		g2d.setColor(Color.GREEN);
		g2d.fill(polygon);
		
		polygon.moveTo(0, 0);
		polygon.lineTo(500, 0);
		polygon.lineTo(500, 500);
		polygon.lineTo(0, 500);
		polygon.closePath();
		
		g2d.setColor(Color.BLUE);
		g2d.fill(polygon);

	}// End of method
}// End of class