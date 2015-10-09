package GraphicsObjects;

public class Vector4f {

	public float x = 0;
	public float y = 0;
	public float z = 0;
	public float a = 0;

	public Vector4f() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;
		a = 0.0f;
	}

	public Vector4f(float x, float y, float z, float a) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.a = a;
	}

	// implement Vector plus a Vector
	public Vector4f plusVector(Vector4f plusedVector) {
		Vector4f vector4f = new Vector4f();
		vector4f.x = this.x + plusedVector.x;
		vector4f.y = this.y + plusedVector.y;
		vector4f.z = this.z + plusedVector.z;
		vector4f.a = this.a + plusedVector.a;
		return vector4f;
	}

	// implement Vector minus a Vector
	public Vector4f minusVector(Vector4f minusedVector) {
		Vector4f vector4f = new Vector4f();
		vector4f.x = this.x - minusedVector.x;
		vector4f.y = this.y - minusedVector.y;
		vector4f.z = this.z - minusedVector.z;
		vector4f.a = this.a - minusedVector.a;
		return vector4f;
	}

	// implement Vector plus a Point
	public Point4f plusPoint(Point4f plusedVector) {
		Point4f point4f = new Point4f();
		point4f.x = this.x + plusedVector.x;
		point4f.y = this.y + plusedVector.y;
		point4f.z = this.z + plusedVector.z;
		point4f.a = this.a + plusedVector.a;
		return point4f;
	}

	// Do not implement Vector minus a Point as it is undefined

	// Implement a Vector * Scalar
	public Vector4f byScalar(float scale) {
		Vector4f vector4f = new Vector4f();
		vector4f.x = scale * this.x;
		vector4f.y = scale * this.y;
		vector4f.z = scale * this.z;
		vector4f.a = scale * this.a;
		return vector4f;
	}

	// implement returning the negative of a Vector
	public Vector4f negateVector() {
		Vector4f vector4f = new Vector4f();
		vector4f.x = -vector4f.x;
		vector4f.y = -vector4f.y;
		vector4f.z = -vector4f.z;
		vector4f.a = -vector4f.a;
		return vector4f;
	}

	// implement getting the length of a Vector
	public float length() {
		return (float) Math.sqrt(this.dot(this));
	}

	// implement getting the Normal of a Vector
	public Vector4f normal() {
		Vector4f vector4f = new Vector4f();
		vector4f.x = this.x/length();
		vector4f.y = this.y/length();
		vector4f.z = this.z/length();
		vector4f.a = this.a/length();
		return vector4f;
	}

	// implement getting the dot product of Vector.Vector
	public float dot(Vector4f v) {
		return (this.x * v.x + this.y * v.y + this.z * v.z + this.a * v.a);
	}

	// Implemented this for you to avoid confusion
	// as we will not normally be using 4 float vector
	public Vector4f cross(Vector4f v) {
		float u0 = (this.y * v.z - z * v.y);
		float u1 = (z * v.x - x * v.z);
		float u2 = (x * v.y - y * v.x);
		float u3 = 0; // ignoring this for now
		return new Vector4f(u0, u1, u2, u3);
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}

}

/*
 * 
 * MMMM MMMMMM MM MMMM MMI MMMM MMM MMMM MMM MMMM MM MMMMM MMM MMMMM MMM OMMMM
 * MM .MMMM MMMMMMMMMMMMMMM MMM .MMMM MM IMMMMMMMMMMMMMMMMMMMMMMMM MMM MMMM MM
 * ~MMMMMMMMMMMMMMMMMMMMM MMMM MM OMMMMM MMMMM MM MMMMM MM MMMMM MM ~MMMM MM
 * =MMMM MM MMMM MM 4 D MMMMMM MM MMMMMMMM MM :MMMMMMMM MM MMMMMMMMM MM
 * MMMMMMMMM MM ,MMMMMMMMMM MMMMMMMMM MM IMMMMMMMMMMMMMMMMMMMMMMMMM MMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM ZMMMMMMMM
 * MMMMMMMMMMMMMMMMMMMMMMMMMMMMM MM$ MMMMMMMMM MMMMMMMMMMMMMM MMM MMMMMMMMM MMM
 * MMMMMMMM MM~ IMMMMMMMM MM DMMMMMMMM MMM MMMMMMMMM MMD MMMMMMMM MMM MMMMMMMM
 * MMMMMMMMMM MMMMMMMM MMMM MM GlassGiant.com
 */