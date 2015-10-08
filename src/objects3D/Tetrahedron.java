package objects3D;

import org.lwjgl.opengl.GL11;

import GraphicsObjects.Point4f;
import GraphicsObjects.Vector4f;

/*
 * This class has not been removed to help you understand how to convert the pseudo code and maths
 *  in your lecture notes into the objects for this assignment. 
 * 
 */
public class Tetrahedron {

	public Tetrahedron() {

	}

	// I have implemented this for you as we have not covered enough openGL to allow you to complete the assignment without a reference class. 
	// This should be your reference to aid you in completing all the other Objects3D classes. 
	public void DrawTetrahedron() {

		Point4f vertices[] = { 	new Point4f(-1.0f, -1.0f, -1.0f,0.0f), 
								new Point4f(-1.0f, 1.0f, 1.0f,0.0f),
								new Point4f(1.0f, -1.0f, 1.0f,0.0f), 
								new Point4f(1.0f, 1.0f, -1.0f,0.0f), };

		int[][] faces = { 	{ 0, 1, 2 }, 
							{ 0, 1, 3 },
							{ 0, 2, 3 }, 
							{ 1, 2, 3 }, };
		 
		GL11.glBegin(GL11.GL_TRIANGLES);
		for (int face = 0; face < 4; face++) { // per face
			Vector4f v = vertices[faces[face][0]].minusPoint(vertices[faces[face][1]]); 
			Vector4f w = vertices[faces[face][0]].minusPoint(vertices[faces[face][2]]);
			Vector4f normal = v.cross(w).normal();
			
		 	GL11.glNormal3f(normal.x, normal.y, normal.z);
		 	
			GL11.glVertex3f(vertices[faces[face][0]].x, vertices[faces[face][0]].y, vertices[faces[face][0]].z);
			GL11.glVertex3f(vertices[faces[face][1]].x, vertices[faces[face][1]].y, vertices[faces[face][1]].z);
			GL11.glVertex3f(vertices[faces[face][2]].x, vertices[faces[face][2]].y, vertices[faces[face][2]].z);
		} // per face
		GL11.glEnd();
	}

}
