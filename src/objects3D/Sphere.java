package objects3D;

import org.lwjgl.opengl.GL11;

public class Sphere {

	public static final float PI = (float) Math.PI;

	public Sphere() {

	}

	// Implement using notes and examine Tetrahedron to aid in the coding look
	// at lecture 7 , 7b and 8
	// 7b should be your primary source, we will cover more about circles in
	// later lectures to understand why the code works
	public void DrawSphere(float radius, float nSlices, float nSegments) {
		float inctheta = (2.0f * PI) / nSlices;
		float incphi = PI / nSegments;
		float x = 0.0f;
		float y = 0.0f;
		float z = 0.0f;

		GL11.glBegin(GL11.GL_QUADS);
		for (float theta = -PI; theta < PI; theta += inctheta) {
			for (float phi = -(PI / 2.0f); phi < (PI / 2.0f); phi += incphi) {
				x = (float) (radius * Math.cos(phi) * Math.cos(theta));
				y = (float) (radius * Math.cos(phi) * Math.sin(theta));
				z = (float) (radius * Math.sin(phi));
				
				GL11.glNormal3f(x, y, z);
				GL11.glVertex3f(x, y, z);
			}
		}
		GL11.glEnd();
	}
}
