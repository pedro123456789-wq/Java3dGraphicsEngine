import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class PolygonObject {
	private Polygon polygon;
	private Color color;
	double averageDistance;
	
	public PolygonObject(double[] x, double[] y, Color color, double averageDistance) {
		this.averageDistance = averageDistance;
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
		g.fillPolygon(this.polygon);
		g.setColor(Color.black);
		g.drawPolygon(this.polygon);
	}
}
