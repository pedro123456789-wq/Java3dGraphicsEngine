import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Screen extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	// declare static variables so they can be used by other classes
	// static variables are shared across all instances of a class, when edited they
	// change across all instances
	// since there is only one instance of the screen class, using static variables
	// is cleaner than passing an instance if the screen class into
	// multiple functions
	static double[] viewFrom = new double[] { 10, 10, 10 };
	static double[] viewTo = new double[] { 1, 1, 1.5 };
	static int polygonNumber = 0;
	static PolygonObject[] drawableObjects = new PolygonObject[100];
	static Polygon3D[] polygons3D = new Polygon3D[100];
	
	private Timer timer;

	public Screen() {
		ScreenController screenController = new ScreenController();
		setFocusable(true);
		addKeyListener(screenController);

		this.addPolygons();

		this.timer = new Timer((int) (1000 / Constants.FPS), this);
		this.timer.start();
	}

	private void addPolygons() {
		// add polygons to the screen
		polygons3D[0] = new Polygon3D(new double[] { 0, 2, 2, 0 }, new double[] { 0, 0, 2, 2 },
				new double[] { 0, 0, 0, 0 }, Color.gray);
		polygons3D[1] = new Polygon3D(new double[] { 0, 2, 2, 0 }, new double[] { 0, 0, 2, 2 },
				new double[] { 3, 3, 3, 3 }, Color.gray);
		polygons3D[2] = new Polygon3D(new double[] { 0, 2, 2, 0 }, new double[] { 0, 0, 0, 0 },
				new double[] { 0, 0, 3, 3 }, Color.gray);
		polygons3D[3] = new Polygon3D(new double[] { 0, 2, 2, 0 }, new double[] { 2, 2, 2, 2 },
				new double[] { 0, 0, 3, 3 }, Color.gray);
		polygons3D[4] = new Polygon3D(new double[] { 0, 0, 0, 0 }, new double[] { 0, 2, 2, 0 },
				new double[] { 0, 0, 3, 3 }, Color.gray);
		polygons3D[5] = new Polygon3D(new double[] { 2, 2, 2, 2 }, new double[] { 0, 2, 2, 0 },
				new double[] { 0, 0, 3, 3 }, Color.gray);
	}

	private void sortPolygons() {
		// use bubble sort algorithm to sort polygons in descending order of distance to
		// ensure that polygons closer to the user are drawn first
		// function sorts the drawable objects array in place
		
		boolean isSorted = false;
		while (!isSorted) {
			for (int i = 0; i < polygonNumber - 1; i++) {
				isSorted = true;

				if (drawableObjects[i + 1].averageDistance < drawableObjects[i].averageDistance) {
					isSorted = false;
					PolygonObject temp = drawableObjects[i];
					drawableObjects[i] = drawableObjects[i + 1];
					drawableObjects[i + 1] = temp;
				}
			}
		}
	}

	public void paintComponent(Graphics g) {
		// clear previous polygons off screen
		g.clearRect(0, 0, 2000, 1200);
		this.sortPolygons();

		for (int i = 0; i < polygonNumber; i++) {
			polygons3D[i].updatePolygon();
		}

		for (int i = 0; i < polygonNumber; i++) {
			drawableObjects[i].drawPolygon(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
