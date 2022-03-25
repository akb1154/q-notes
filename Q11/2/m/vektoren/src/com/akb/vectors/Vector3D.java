import java.util.Vector;

public class Vector3D {

	Point3D head, foot;
	double length, unitFactor, z, x, y;
	
	public static final Vector3D NULLVECTOR = new Vector3D(0, 0, 0);

	public Vector3D (Point3D from, Point3D to) {
		foot = from;
		head = to; 
	}

	public Vector3D (double z, double x, double y) {

	}

	public Vector3D add (Vector3D a) {
		return new Vector3D(this.z + a.z, this.x + a.x, this.y + a.y);
	}

	public Vector3D sub (Vector3D a) {
		return new Vector3D(this.z - a.z, this.x - a.x, this.y - a.y);
	} 

	public Vector3D crossMultiply (Vector3D v) {
		// TODO
		return new Vector3D(0, 0, 0);
	}

	public double scaleMultiply (Vector3D v)  {
		//TODO
		return 0;
	}

	public Vector3D scale (double factor) {
		return new Vector3D(this.z*factor, this.x*factor, this.y*factor);
	}

	public double length () {
		return Math.sqrt (z*z+x*x+y*y);
	}
}
