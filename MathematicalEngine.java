////https://www.youtube.com/watch?v=2ztUz3ahA8g&list=PLsRmsZm0xMNogPyRn6gNWq4OM5j22FkAU&index=8
//
//
//public class MathematicalEngine {
//	static double outputX, outputY;
//	
//	static double calculatePositionX(double[] viewFrom, double viewTo[], double x, double y, double z) {
//		makeProjection(viewFrom, viewTo, x, y, z);
//		return outputX;
//	}
//	
//	static double calculatePositionY(double[] viewFrom, double viewTo[], double x, double y, double z) {
//		makeProjection(viewFrom, viewTo, x, y, z);
//		return outputY;
//	}
//	
//	static void makeProjection(double[] viewFrom, double[] viewTo, double x, double y, double z) {
//		//Mathematical break down:
//		//1) calculate vector that connects 'viewFrom' and 'viewTo' vectors called displacement vector
//		//2) calculate cross product between displacement vector and (1, 1, 1) vector to get one plane vector
//		//3) calculate cross prodct between displacement vector and this new plane vector to get second plane vector
//		//4) the two plance vectors create a 2-d plane with the displacement vector as a normal
//		//5) calculate vector between point in question (x, y, z) and 'viewFrom' vector, this is the 'line of sight' vector called 'pointVector'
//		//6) project the 'pointVector' onto the plane created using basic linear algebra. 
//		
//		
//		//calculate vector that connects the point where the camera is and the point to which character is looking	
//		Vector displacementVector = new Vector(viewTo[0] - viewFrom[0],
//				                               viewTo[1] - viewFrom[1], 
//				                               viewTo[2] - viewFrom[2]);
//		
//		Vector viewToVec = new Vector(viewTo[0], viewTo[1], viewTo[2]);
//		Vector viewFromVec = new Vector(viewFrom[0], viewFrom[1], viewFrom[2]);
//		
//		//vector in the diagonal direction out of the origin, acts as reference		
//		Vector directionVector = new Vector(1, 1, 1);
//		
//		//create plane of two vectors that are perpendicular to the direction vector and the displacement vector
//		//this is the plane where all points are going to be projected to
//		Vector planeVector1 = displacementVector.crossProduct(directionVector);
//		Vector planeVector2 = displacementVector.crossProduct(planeVector1);
//		
//		//create vector connection point from which landscape is being viewed from and point being viewed		
//		Vector pointVector = new Vector(x - viewFrom[0], y - viewFrom[1], z - viewFrom[2]);
//		
//		//project point vector onto plane created with the two plane vectors		
//		double lambda = (displacementVector.dot(viewToVec) - displacementVector.dot(viewFromVec)) / displacementVector.dot(pointVector);
//		Vector output = viewFromVec.add(pointVector.mulitply(lambda));
//		
//		//check if point being projected is in front of position vector so can be seen		
//		if (lambda > 0) {
//			outputX = planeVector2.dot(output);
//			outputY = planeVector1.dot(output);
//		}
//	}
//}



public class MathematicalEngine {
	static double DrawX = 0, DrawY = 0, t = 0;
	
	static double calculatePositionX(double[] ViewFrom, double[] ViewTo, double x, double y, double z)
	{
		projectVector(ViewFrom, ViewTo, x, y, z);
		return DrawX;
	}

	static double calculatePositionY(double[] ViewFrom, double[] ViewTo, double x, double y, double z)
	{
		projectVector(ViewFrom, ViewTo, x, y, z);
		return DrawY;		
	}
	
	
	static void projectVector(double[] ViewFrom, double[] ViewTo, double x, double y, double z)
	{
		Vector ViewVector = new Vector(ViewTo[0] - ViewFrom[0], ViewTo[1] - ViewFrom[1], ViewTo[2] - ViewFrom[2]);
		Vector DirectionVector = new Vector(1, 1, 1);
		Vector PlaneVector1 = ViewVector.crossProduct(DirectionVector);
		Vector PlaneVector2 = ViewVector.crossProduct(PlaneVector1);	
		
		Vector ViewToPoint = new Vector(x - ViewFrom[0], y - ViewFrom[1], z - ViewFrom[2]);
		
		t = (ViewVector.x * ViewTo[0] + ViewVector.y*ViewTo[1] + ViewVector.z*ViewTo[2]
			   	-  (ViewVector.x * ViewFrom[0] + ViewVector.y*ViewFrom[1] + ViewVector.z*ViewFrom[2]))
				/  (ViewVector.x * ViewToPoint.x + ViewVector.y*ViewToPoint.y + ViewVector.z*ViewToPoint.z);
		
		x = ViewFrom[0] + ViewToPoint.x * t;
		y = ViewFrom[1] + ViewToPoint.y * t;
		z = ViewFrom[2] + ViewToPoint.z * t;
		
		
		if(t > 0)
		{
			DrawX = PlaneVector2.x * x + PlaneVector2.y * y + PlaneVector2.z * z;
			DrawY = PlaneVector1.x * x + PlaneVector1.y * y + PlaneVector1.z * z;
		}
	}
}
