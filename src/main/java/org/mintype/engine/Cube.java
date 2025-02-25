package org.mintype.engine;

public class Cube {
    private Vertex[] vertices;
    private Vertex2D[] vertices2D;

    private int[] indices;

    private int scale, shift;

    public Cube(Vertex[] vertices, int[] indices) {
        this.vertices = vertices;
        vertices2D = new Vertex2D[vertices.length];
        this.indices = indices;

        scale = 100;
        shift = 200;

        generate2DVertices();
    }

    public void generate2DVertices() {
        for (int i = 0; i < vertices.length; i++) {
            float z = vertices[i].getZ() == 0 ? 0.0001f : vertices[i].getZ(); // Avoid division by zero
            vertices2D[i] = new Vertex2D((int) (vertices[i].getX() / z * scale + shift), (int) (vertices[i].getY() / z * scale + shift));
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

        // Rotate each vertex around the X-axis
        for (int i = 0; i < vertices.length; i++) {
            Vertex vertex = vertices[i];

            // Apply X-axis rotation
            double newY = cosAngle * vertex.getY() - sinAngle * vertex.getZ();
            double newZ = sinAngle * vertex.getY() + cosAngle * vertex.getZ();

            // Update the vertex (keeping X unchanged as it's a rotation around the X-axis)
            vertices[i].setY((float) newY);
            vertices[i].setZ((float) newZ);
        }
        this.generate2DVertices();
    }

    public void rotateY(int _angle) {
        double angle = Math.toRadians(_angle);  // Convert degrees to radians
        double cosAngle = Math.cos(angle);
        double sinAngle = Math.sin(angle);

        // Rotate each vertex around the Y-axis
        for (int i = 0; i < vertices.length; i++) {
            Vertex vertex = vertices[i];

            // Apply Y-axis rotation
            double newX = cosAngle * vertex.getX() + sinAngle * vertex.getZ();
            double newZ = -sinAngle * vertex.getX() + cosAngle * vertex.getZ();

            // Update the vertex (keeping Y unchanged as it's a rotation around the Y-axis)
            vertices[i].setX((float) newX);
            vertices[i].setZ((float) newZ);
        }
        this.generate2DVertices();
    }

    public void rotateZ(int _angle) {
        double angle = Math.toRadians(_angle);  // Convert degrees to radians
        double cosAngle = Math.cos(angle);
        double sinAngle = Math.sin(angle);

        // Rotate each vertex around the Z-axis
        for (int i = 0; i < vertices.length; i++) {
            Vertex vertex = vertices[i];

            // Apply Z-axis rotation
            double newX = cosAngle * vertex.getX() - sinAngle * vertex.getY();
            double newY = sinAngle * vertex.getX() + cosAngle * vertex.getY();

            // Update the vertex (keeping Z unchanged as it's a rotation around the Z-axis)
            vertices[i].setX((float) newX);
            vertices[i].setY((float) newY);
        }
        this.generate2DVertices();
    }
}