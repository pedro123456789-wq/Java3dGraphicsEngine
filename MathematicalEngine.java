//https://www.youtube.com/watch?v=2ztUz3ahA8g&list=PLsRmsZm0xMNogPyRn6gNWq4OM5j22FkAU&index=8


public class MathematicalEngine {
	static double calculatePositionX(double[] viewFrom, double viewTo[], double x, double y, double z) {
		return 0;
	}
	
	static double calculatePositionY(double[] viewFrom, double viewTo[], double x, double y, double z) {
		makeProjection(viewFrom, viewTo);
		return 0;
	}
	
	static void makeProjection(double[] viewFrom, double[] viewTo) {
		//calculate vector that connects the point where the camera is and the location of the object		
		Vector displacementVector = new Vector(viewTo[0] - viewFrom[0],
				                               viewTo[1] - viewFrom[1], 
				                               viewTo[2] - viewFrom[2]);
		
		//vector in the diagonal direction out of the origin, acts as reference		
		Vector directionVector = new Vector(1, 1, 1);
		
		//create plane of two vectors that are perpendicular to the direction vector and the displacement vector
		//this is the plane where all points are going to be projected to
		Vector planeVector1 = displacementVector.crossProduct(directionVector);
		Vector planeVector2 = displacementVector.crossProduct(planeVector1);
		
		//hard mathematical part		
	}
}
