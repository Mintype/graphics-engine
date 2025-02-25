package org.mintype.engine;

import java.awt.*;

public class Vertex2D {
    private int x, y;      // Position (xyz)
    private int r, g, b, a;   // Color (rgba)

    public Vertex2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vertex2D(int x, int y, Color color) {
        this.x = x;
        this.y = y;

        this.r = color.getRed();
        this.g = color.getGreen();
        this.b = color.getBlue();
        this.a = color.getAlpha();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return new Color(r, g, b, a);
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public int getA() {
        return a;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
