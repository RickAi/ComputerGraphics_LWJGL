package objects3D;

import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;
import java.math.*;

public class Cylinder {

	public static final float PI = (float) Math.PI;

	public Cylinder() {
	}

	// remember to use Math.PI isntead PI
	// Implement using notes and examine Tetrahedron to aid in the coding look
	// at lecture 7 , 7b and 8
	public void DrawCylinder(float radius, float height, int nSegments) {
		GL11.glBegin(GL11.GL_TRIANGLES);
		for (float i = 0.0f; i < nSegments; i += 1.0f) {
			float angle = PI * i * 2.0f / nSegments;
			float nextAngle = PI * (i + 1.0f) * 2.0f / nSegments;
			float x1 = (float) Math.sin(angle), y1 = (float) Math.cos(angle);
			float x2 = (float) Math.sin(nextAngle), y2 = (float) Math
					.cos(nextAngle);

			// upper
			glNormal(new Vector4f(x1, y1, 0.0f, 0.0f), new Vector4f(x2, y2, 0.0f, 0.0f));
			GL11.glVertex3f(0.0f, 0.0f, 0.0f);
			GL11.glVertex3f(x1, y1, 0.0f);
			GL11.glVertex3f(x2, y2, 0.0f);

			// upper triangle
//			glNormal(new Vector4f(x1, y1, 0.0f, 0.0f), new Vector4f(x2, y2, 1.0f, 0.0f));
			GL11.glNormal3f(x1, y1, 0.0f);
			GL11.glVertex3f(x1, y1, 0.0f);
			GL11.glNormal3f(x2, y2, 0.0f);
			GL11.glVertex3f(x2, y2, 1.0f);
			GL11.glNormal3f(x1, y1, 0.0f);
			GL11.glVertex3f(x1, y1, 1.0f);

			// down triangle
			GL11.glNormal3f(x1, y1, 0.0f);
			GL11.glVertex3f(x1, y1, 0.0f);
			GL11.glNormal3f(x2, y2, 0.0f);
			GL11.glVertex3f(x2, y2, 0.0f);
			GL11.glNormal3f(x2, y2, 0.0f);
			GL11.glVertex3f(x2, y2, 1.0f);

			// down
			glNormal(new Vector4f(x1, y1, 1.0f, 0.0f), new Vector4f(x2, y2, 1.0f, 0.0f));
			GL11.glVertex3f(0.0f, 0.0f, 1.0f);
			GL11.glVertex3f(x1, y1, 1.0f);
			GL11.glVertex3f(x2, y2, 1.0f);
		}
		GL11.glEnd();
	}

	private void glNormal(Vector4f vector1, Vector4f vector2){
		Vector4f normal = vector1.cross(vector2).normal();
		GL11.glNormal3f(normal.x, normal.y, normal.z);
	}
}
