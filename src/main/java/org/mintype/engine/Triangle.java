package org.mintype.engine;

public class Triangle {
    private Vertex v1, v2, v3;
    private Vertex2D v4, v5, v6;

    public Triangle(Vertex v1, Vertex v2, Vertex v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        generate2DVertices();
    }

    public Vertex[] getVertices() {
        return new Vertex[]{v1, v2, v3};
    }
    public Vertex2D[] get2DVertices() {
        return new Vertex2D[]{v4, v5, v6};
    }
    public void generate2DVertices() {
        v4 = new Vertex2D((int) (v1.getX() / v1.getZ()), (int) (v1.getY() / v1.getZ()));
        v5 = new Vertex2D((int) (v2.getX() / v2.getZ()), (int) (v2.getY() / v2.getZ()));
        v6 = new Vertex2D((int) (v3.getX() / v3.getZ()), (int) (v3.getY() / v3.getZ()));
    }
}
