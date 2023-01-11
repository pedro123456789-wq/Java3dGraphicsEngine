import java.awt.Color;

//3D polygon object
public class Polygon3D {
	private Color color;
	private double[] x;
	private double[] y;
	private double[] z;
	private int polygonNumber = 0;
	
	public Polygon3D(double[] x, double[] y, double[] z, Color color) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.color = color;
		this.createPolygon();
	}
	
	
	private double getAverageDistance() {
		double total = 0;
		
		for (int i = 0; i < x.length; i++) {
			total += Math.sqrt(Math.pow(Screen.viewFrom[0] - x[i], 2) + 
					           Math.pow(Screen.viewFrom[1] - y[i], 2) + 
					           Math.pow(Screen.viewFrom[2] - z[i], 2));
		}
		
		return total / this.x.length;
	}
	
	public void createPolygon() {
		//add new entry to the array which contains all polygons and
		//project the 3D polygon into the 2D plane
		this.polygonNumber = Screen.polygonNumber;
		Screen.drawableObjects[Screen.polygonNumber] = new PolygonObject(new double[] {}, new double[] {}, this.color, this.getAverageDistance()); 
		this.updatePolygon();
	}
	
	
	public void updatePolygon() {
		//generate new projection of vertices from new 'viewFrom' vector
		
		//add offset to every point to ensure that they are centered around the viewToPoint
		double dx = - 50 * MathematicalEngine.calculatePositionY(Screen.viewFrom, Screen.viewTo, Screen.viewTo[0], Screen.viewTo[1], Screen.viewTo[2]);
		double dy = - 50 * MathematicalEngine.calculatePositionY(Screen.viewFrom, Screen.viewTo, Screen.viewTo[0], Screen.viewTo[1], Screen.viewTo[2]);
		
		double[] newX = new double[x.length];
		double[] newY = new double[y.length];
		
		for (int i = 0; i < x.length; i ++) {
			//add screen width and height over two to translate origin to middle of the screen
			newX[i] = dx + (Constants.screenSize.getWidth() / 2) + 
					  (50 * MathematicalEngine.calculatePositionX(Screen.viewFrom, Screen.viewTo, this.x[i], this.y[i], this.z[i]));
			newY[i] = dy + (Constants.screenSize.getHeight() / 2) + 
					  (50 * MathematicalEngine.calculatePositionY(Screen.viewFrom, Screen.viewTo, this.x[i], this.y[i], this.z[i]));
		}
		
		Screen.drawableObjects[this.polygonNumber] = new PolygonObject(newX, newY, this.color, this.getAverageDistance()); 
		Screen.polygonNumber --; //polygon number is automatically incremented when new instance of PolygonObject is created, so decrement it to counteract this
	}
}
