package org.mintype;

import org.mintype.engine.*;

public class Main {
    public static void main(String[] args) {
        Scene scene = new Scene(400, 400);

//        Triangle triangle = new Triangle(
//                new Vertex(100, 100, 1),
//                new Vertex(200, 100, 1),
//                new Vertex(150, 200, 1)
//        );
//
//        scene.addTriangle(triangle);

        Vertex[] cubeVertices = new Vertex[]{
                new Vertex(-1, 1, -1),
                new Vertex(1, 1, -1),
                new Vertex(1, -1, -1),
                new Vertex(-1, -1, -1),
                new Vertex(-1, 1, 1),
                new Vertex(1, 1, 1),
                new Vertex(1, -1, 1),
                new Vertex(-1, -1, 1)
        };

        int[] indices = new int[]{

        };

        Cube cube = new Cube(cubeVertices, indices);

        scene.addCube(cube);

        Window window = new Window(scene);
        window.setVisible(true);
    }
}
