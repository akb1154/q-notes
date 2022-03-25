# Der Spat

> a href: hon no peji- 112

````java

public Vector crossMultiply (Vector v) {
	double cx, cy, cz;
	cx = this.x * v.y - v.x * this.y;
	cy = this.y * v.z - v.y * this.z;
	cz = this.z * v.x - v.z * this.x;
	return new Vector (cx, cy, cz);
}

public double scaleMultiply (Vector v) {
	return v.z*this.z+v.x*this.x+v.y*this.y;
}
````
<!--markdownlint-disable-file-->

## peji 113 no 4

### A
````java
Point3D a = Point3D.ORIGIN, b = (1, 7, 3), c = (2, -3, 4), d = (6, 1, 10);
Vector3D AB = (1, 7, 3), AC = (2, -3, 4), AD = (6, 1, 10);
````

````java
double volume = 1/6 * AB.crossMultiply(AC).scaleMultiply(AD);
// sqrt (1662) * sqrt(137) = 477.1729 * 1/6 = 79.5288
````

	AB × AC	
	= (1, 7, 3) × (2, -3, 4)
	= (37, 2, -17)
	AB×AC*AD
	= (37, 2, -17) * (6, 1, 10)
	= (222, 2, -170)
	= 222+2-170
	= 54

	|AB×AC*AD|/6
	= 54 / 6
	= 9


### B

````java
Point3D a = (1, -2, 12), b = (11, 3, 5), c = (3, 5, 8), d = (19, 4, 4);
Vector3D AB = (10, 5, -7), AC = (2, 7, -4), AD = (18, 6, -8);
````
	/*
		cx = this.x * v.y - v.x * this.y;
		cy = this.y * v.z - v.y * this.z;
		cz = this.z * v.x - v.z * this.x;
	*/

	AB×AC 
	= (10, 5, -7) × (2, 7, -4)
	= (-69, -54, 60)
	AB×AC*AD
	= (-69, -54, 60) * (18, 6, -8)
	= (-1242, 324, -480)
	= 324 - 1242 -480
	= -1398
	Vspat
	= -233 // 33

//HW 113/5d, 114/13