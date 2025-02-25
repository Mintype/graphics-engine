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
                new Vertex(-1, 1, -1-2),
                new Vertex(1, 1, -1-2),
                new Vertex(1, -1, -1-2),
                new Vertex(-1, -1, -1-2),
                new Vertex(-1, 1, 1-2),
                new Vertex(1, 1, 1-2),
                new Vertex(1, -1, 1-2),
                new Vertex(-1, -1, 1-2)
        };

        int[] indices = new int[]{
                0, 1, 2, 2, 3, 0, // Front face
                4, 5, 6, 6, 7, 4, // Back face
                0, 1, 5, 5, 4, 0, // Top face
                2, 3, 7, 7, 6, 2, // Bottom face
                0, 3, 7, 7, 4, 0, // Left face
                1, 2, 6, 6, 5, 1  // Right face
        };

        Cube cube = new Cube(cubeVertices, indices);

        scene.addCube(cube);

        Window window = new Window(scene);
        window.setVisible(true);

        while (true) {
            cube.rotateY(1);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}