public class Point3D {

	double x, y, z;
	Vector3D point;

	public static final Point3D ORIGIN = new Point3D(0, 0, 0);


	public Point3D (int z, int x, int y) {
		new Point3D((double)z, (double)x, (double)y);
	}

	public Point3D (double z, double x, double y) {
		this.y = y;
		this.x = x;
		this.z = z;

		point = new Vector3D (ORIGIN, this);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}
}