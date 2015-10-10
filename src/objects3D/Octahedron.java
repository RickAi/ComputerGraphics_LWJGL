package objects3D;

import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Octahedron {

	public static final int OCTAHEDRON_FACES = 8;

	public Octahedron() {

	}

	// Implement using notes and examine Tetrahedron to aid in the coding look
	// at lecture 7 , 7b and 8
	public void DrawOctahedron() {
		Point4f[] vertices = { new Point4f(0.0f, 0.0f, -1.0f, 0.0f),
				new Point4f(0.0f, -1.0f, 0.0f, 0.0f),
				new Point4f(1.0f, 0.0f, 0.0f, 0.0f),
				new Point4f(0.0f, 0.0f, 1.0f, 0.0f),
				new Point4f(0.0f, 1.0f, 0.0f, 0.0f),
				new Point4f(-1.0f, 0.0f, 0.0f, 0.0f) };

		// 8 triangles for this octahedron
		int[][] faces = { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 5 },
				{ 0, 4, 5 }, { 0, 1, 5 }, { 1, 3, 5 }, { 0, 2, 4 } };

		GL11.glBegin(GL11.GL_TRIANGLES);
		for (int face = 0; face < OCTAHEDRON_FACES; face++) { // per face
			// define the normal of this triangle
			Vector4f v = vertices[faces[face][0]]
					.minusPoint(vertices[faces[face][1]]);
			Vector4f w = vertices[faces[face][0]]
					.minusPoint(vertices[faces[face][2]]);
			Vector4f normal = v.cross(w).normal();

			GL11.glNormal3f(normal.x, normal.y, normal.z);

			// link three points to get a triangle
			GL11.glVertex3f(vertices[faces[face][0]].x,
					vertices[faces[face][0]].y, vertices[faces[face][0]].z);
			GL11.glVertex3f(vertices[faces[face][1]].x,
					vertices[faces[face][1]].y, vertices[faces[face][1]].z);
			GL11.glVertex3f(vertices[faces[face][2]].x,
					vertices[faces[face][2]].y, vertices[faces[face][2]].z);
		} // per face
		GL11.glEnd();
	}
}
