import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class PolygonObject {
	Polygon polygon;
	Color color;
	
	public PolygonObject(double[] x, double[] y, Color color) {
		Screen.polygonNumber ++; //increment the number of polygons in the screen
		
		//create new AWT polygon object with coordinates passed
		this.polygon = new Polygon();
		
		for (int i = 0; i < x.length; i ++) {
			this.polygon.addPoint((int)x[i], (int)y[i]);
		}
		
		this.color = color;
	}
	
	
	void drawPolygon(Graphics g) {
		g.setColor(this.color);
		g.drawPolygon(this.polygon);
	}
}
