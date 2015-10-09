package objects3D;

import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Cube {

	public static final int FACE_NUMBER = 6;

	public Cube() {

	}

	// Implement using notes and examine Tetrahedron to aid in the coding look
	// at lecture 7 , 7b and 8
	// new Point4f(-1.0f, -1.0f, -1.0f, 0.0f)
	public void DrawCube() {
		// 8 points for the cube
		Point4f[] vertices = { new Point4f(1.0f, 1.0f, 1.0f, 0.0f),
				new Point4f(1.0f, 1.0f, -1.0f, 0.0f),
				new Point4f(-1.0f, 1.0f, 1.0f, 0.0f),
				new Point4f(-1.0f, 1.0f, -1.0f, 0.0f),
				new Point4f(-1.0f, -1.0f, 1.0f, 0.0f),
				new Point4f(-1.0f, -1.0f, -1.0f, 0.0f),
				new Point4f(1.0f, -1.0f, 1.0f, 0.0f),
				new Point4f(1.0f, -1.0f, -1.0f, 0.0f), };

		// 6 faces for the cube
		int[][] faces = { { 0, 1, 2, 3 }, { 2, 3, 4, 5 }, { 4, 5, 6, 7 },
				{ 1, 7, 0, 6 }, { 1, 3, 7, 5 }, { 2, 4, 0, 6 } };

		GL11.glBegin(GL11.GL_TRIANGLES);
		for (int face = 0; face < FACE_NUMBER; face++) {
			// get the normal form three points
			Vector4f v = vertices[faces[face][1]]
					.minusPoint(vertices[faces[face][0]]);
			Vector4f w = vertices[faces[face][2]]
					.minusPoint(vertices[faces[face][0]]);
			Vector4f normal = v.cross(w).normal();
			GL11.glNormal3f(normal.x, normal.y, normal.z);

			// two triangle can merge to a square/rectangle
			GL11.glVertex3f(vertices[faces[face][0]].x,
					vertices[faces[face][0]].y, vertices[faces[face][0]].z);
			GL11.glVertex3f(vertices[faces[face][1]].x,
					vertices[faces[face][1]].y, vertices[faces[face][1]].z);
			GL11.glVertex3f(vertices[faces[face][2]].x,
					vertices[faces[face][2]].y, vertices[faces[face][2]].z);

			GL11.glVertex3f(vertices[faces[face][3]].x,
					vertices[faces[face][3]].y, vertices[faces[face][3]].z);
			GL11.glVertex3f(vertices[faces[face][1]].x,
					vertices[faces[face][1]].y, vertices[faces[face][1]].z);
			GL11.glVertex3f(vertices[faces[face][2]].x,
					vertices[faces[face][2]].y, vertices[faces[face][2]].z);
		}
		GL11.glEnd();
	}
}

/*
 * 
 * 
 * }
 */
