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
        for(int i = 0; i < vertices.length; i++) {
            vertices2D[i] = new Vertex2D((int) (vertices[i].getX() / vertices[i].getZ() * scale + shift), (int) (vertices[i].getY() / vertices[i].getZ() * scale + shift));
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
}
