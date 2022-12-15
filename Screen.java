import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;



public class Screen extends JPanel{
	private static final long serialVersionUID = 1L;
	static double[] viewFrom = new double[] {10, 10, 10};
	static double[] viewTo = new double[] {0, 0, 0};
	static int polygonNumber = 0;
	static PolygonObject[] drawableObjects = new PolygonObject[100];
	
	Polygon3D poly1 = new Polygon3D(new double[]{2, 4, 2}, new double[]{2, 4, 6},  new double[]{5, 5, 5}, Color.black); 
	
	
	public Screen() {
		
		
	}
	
	
	public void paintComponent(Graphics g) {
		for (int i = 0; i < polygonNumber; i ++) {
			drawableObjects[i].drawPolygon(g);
		}	
	}
}
