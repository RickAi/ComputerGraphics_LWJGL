package objects3D;

import org.lwjgl.opengl.GL11;
import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

public class Cube {
	
	public static final int FACE_NUMBER = 12;

	public Cube() {

	}

	// Implement using notes and examine Tetrahedron to aid in the coding look
	// at lecture 7 , 7b and 8
	// new Point4f(-1.0f, -1.0f, -1.0f,0.0f)
	public void DrawCube() {
		Point4f[] vertices = {
				new Point4f(1.0f, 1.0f, 1.0f, 0.0f),
				new Point4f(1.0f, 1.0f, -1.0f, 0.0f),
				new Point4f(-1.0f, 1.0f, 1.0f, 0.0f),
				new Point4f(-1.0f, 1.0f, -1.0f, 0.0f),
				new Point4f(-1.0f, -1.0f, 1.0f, 0.0f),
				new Point4f(-1.0f, -1.0f, -1.0f, 0.0f),
				new Point4f(1.0f, -1.0f, 1.0f, 0.0f),
				new Point4f(1.0f, -1.0f, -1.0f, 0.0f),};
		
		int[][] triangles = {
				   {0, 1, 2}, {3, 1, 2}, {2, 3, 4}, {5, 3, 4}, {4, 5, 6}, {7, 5, 6}, {6, 0, 7},
				   {1, 0, 7}, {5, 3, 7}, {1, 3, 7}, {2, 0, 4}, {6, 0, 4}};
		
		GL11.glBegin(GL11.GL_TRIANGLES);
		for(int face = 0; face < FACE_NUMBER; face++){
			Vector4f v = vertices[triangles[face][0]].minusPoint(vertices[triangles[face][1]]); 
			Vector4f w = vertices[triangles[face][0]].minusPoint(vertices[triangles[face][2]]);
			Vector4f normal = v.cross(w).normal();
			
			GL11.glNormal3f(normal.x, normal.y, normal.z);
			GL11.glVertex3f(vertices[triangles[face][0]].x, vertices[triangles[face][0]].y, vertices[triangles[face][0]].z);
			GL11.glVertex3f(vertices[triangles[face][1]].x, vertices[triangles[face][1]].y, vertices[triangles[face][1]].z);
			GL11.glVertex3f(vertices[triangles[face][2]].x, vertices[triangles[face][2]].y, vertices[triangles[face][2]].z);
		}
		GL11.glEnd();
	}
}

/*
 * 
 * 
 * }
 */
