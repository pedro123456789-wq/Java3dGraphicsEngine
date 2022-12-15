import java.awt.Color;


//3D polygon object
public class Polygon3D {
	Color color;
	double[] x;
	double[] y;
	double[] z;
	
	public Polygon3D(double[] x, double[] y, double[] z, Color color) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.color = color;
	}
	
	public void createPolygon() {
		double[] projectedX = new double[x.length];
		double[] projectedY = new double[x.length];
		
		for (int i = 0; i < x.length; i ++) {
			//project every point in the polygon to the 2D plane			
			projectedX[i] = MathematicalEngine.calculatePositionX(Screen.viewFrom, Screen.viewTo, this.x[i], this.y[i], this.z[i]);
			projectedY[i] = MathematicalEngine.calculatePositionY(Screen.viewFrom, Screen.viewTo, this.x[i], this.y[i], this.z[i]);
		}
		
		//add new entry to the array which contains all polygons and
		//project the 3D polygon into the 2D plane
		Screen.drawableObjects[Screen.polygonNumber] = new PolygonObject(this.x, this.y, this.color); 
	}
}
