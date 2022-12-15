
public class Vector {
	public double x;
	public double y;
	public double z;
	
	public Vector(double x, double y, double z) {
		double length = Math.sqrt((x * x) + (y * y) + (z * z)); //3d-pythagoras
		
		//normalise input vector		
		if (length > 0) {
			this.x = x/length;
			this.y = y/length;
			this.z = z/length;
		}
	}
	
	
	public Vector crossProduct(Vector other) {
		Vector output = new Vector((this.y * other.z) - (this.z * other.y), 
				                   (this.z * other.x) - (this.x * other.z), 
				                   (this.x * other.y) - (this.y * other.z));
		
		return output;             
	}
}
