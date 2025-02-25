package org.mintype.engine;

import java.awt.*;

public class Cube {
    private Vertex[] vertices;
    private Vertex2D[] vertices2D;

    private int[] indices;

    private int scale, shift;

    float centerX = 0;
    float centerY = 0;
    float centerZ = 0;


    public Cube(Vertex[] vertices, int[] indices) {
        this.vertices = vertices;
        vertices2D = new Vertex2D[vertices.length];
        this.indices = indices;

        scale = 100;
        shift = 200;


        for (Vertex vertex : vertices) {
            centerX += vertex.getX();
            centerY += vertex.getY();
            centerZ += vertex.getZ();
        }
        centerX /= vertices.length;
        centerY /= vertices.length;
        centerZ /= vertices.length;

        generate2DVertices();
    }

    public void generate2DVertices() {

        System.out.println("Vertex:\n" + vertices[0] + "\n\n");

        for (int i = 0; i < vertices.length; i++) {
            float z = vertices[i].getZ() == 0 ? 0.0001f : vertices[i].getZ(); // Avoid division by zero
            Color color = vertices[i].getColor();
//            if(color != null)
//                System.out.println(color.toString());
            vertices2D[i] = new Vertex2D((int) (vertices[i].getX() / z * scale + shift), (int) (vertices[i].getY() / z * scale + shift), Color.GREEN);
        }
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public Vertex2D[] getVertices2D() {
        return vertices2D;
    }

    public int[] getIndices() {
        return indices;
    }

    public void rotateX(int _angle) {
        double angle = Math.toRadians(_angle);  // Convert degrees to radians
        double cosAngle = Math.cos(angle);
        double sinAngle = Math.sin(angle);

        // Translate each vertex to the origin (cube's center)
        for (int i = 0; i < vertices.length; i++) {
            Vertex vertex = vertices[i];

            // Translate to the origin
            double x = vertex.getX() - centerX;  // centerX is the cube's center X
            double y = vertex.getY() - centerY;  // centerY is the cube's center Y
            double z = vertex.getZ() - centerZ;  // centerZ is the cube's center Z

            // Apply X-axis rotation
            double newY = cosAngle * y - sinAngle * z;
            double newZ = sinAngle * y + cosAngle * z;

            // Translate back to original position
            vertex.setX((float) (x + centerX));
            vertex.setY((float) (newY + centerY));
            vertex.setZ((float) (newZ + centerZ));
        }

        this.generate2DVertices();
    }

    public void rotateY(int _angle) {
        double angle = Math.toRadians(_angle);  // Convert degrees to radians
        double cosAngle = Math.cos(angle);
        double sinAngle = Math.sin(angle);

        // Translate each vertex to the origin (cube's center)
        for (int i = 0; i < vertices.length; i++) {
            Vertex vertex = vertices[i];

            // Translate to the origin
            double x = vertex.getX() - centerX;  // centerX is the cube's center X
            double y = vertex.getY() - centerY;  // centerY is the cube's center Y
            double z = vertex.getZ() - centerZ;  // centerZ is the cube's center Z

            // Apply Y-axis rotation
            double newX = cosAngle * x + sinAngle * z;
            double newZ = -sinAngle * x + cosAngle * z;

            // Translate back to original position
            vertex.setX((float) (newX + centerX));
            vertex.setY((float) (y + centerY));  // Y remains unchanged for Y-axis rotation
            vertex.setZ((float) (newZ + centerZ));
        }

        this.generate2DVertices();
    }

    public void rotateZ(int _angle) {
        double angle = Math.toRadians(_angle);  // Convert degrees to radians
        double cosAngle = Math.cos(angle);
        double sinAngle = Math.sin(angle);

        // Translate each vertex to the origin (cube's center)
        for (int i = 0; i < vertices.length; i++) {
            Vertex vertex = vertices[i];

            // Translate to the origin
            double x = vertex.getX() - centerX;  // centerX is the cube's center X
            double y = vertex.getY() - centerY;  // centerY is the cube's center Y
            double z = vertex.getZ() - centerZ;  // centerZ is the cube's center Z

            // Apply Z-axis rotation
            double newX = cosAngle * x - sinAngle * y;
            double newY = sinAngle * x + cosAngle * y;

            // Translate back to original position
            vertex.setX((float) (newX + centerX));
            vertex.setY((float) (newY + centerY));
            vertex.setZ((float) (z + centerZ));  // Z remains unchanged for Z-axis rotation
        }

        this.generate2DVertices();
    }

}