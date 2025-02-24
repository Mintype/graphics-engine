package org.mintype.engine;

public class Cube {
    private Vertex[] vertices;
    private Vertex2D[] vertices2D;

    public Cube(Vertex[] vertices) {
        this.vertices = vertices;
        vertices2D = new Vertex2D[vertices.length];
        generate2DVertices();
    }
    public void generate2DVertices() {
        for(int i = 0; i < vertices.length; i++) {
            vertices2D[i] = new Vertex2D((int) (vertices[i].getX() / vertices[i].getZ()), (int) (vertices[i].getY() / vertices[i].getZ()));
        }
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public Vertex2D[] getVertices2D() {
        return vertices2D;
    }
}
