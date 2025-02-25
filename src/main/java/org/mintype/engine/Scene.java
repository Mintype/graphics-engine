package org.mintype.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class Scene extends JPanel implements Runnable {
    private ArrayList<Cube> cubes;
    private BufferedImage buffer;
    private boolean running = false;
    private final int TARGET_FPS = 60;

    public Scene(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        cubes = new ArrayList<>();
        start();
    }
    public void start() {
        if (!running) {
            running = true;
            Thread thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nsPerFrame = 1e9 / TARGET_FPS;

        while (running) {
            long now = System.nanoTime();
            if (now - lastTime >= nsPerFrame) {
                lastTime = now;
                update(); // Update game logic
                render(); // Render the scene
                repaint(); // Refresh the panel
            }
        }
    }

    public void addCube(Cube cube) {
        cubes.add(cube);
    }

    private void update() {

    }
    private void render() {
        Graphics2D g = buffer.createGraphics();

        // Clear the screen
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, buffer.getWidth(), buffer.getHeight());

        // Draw all triangles
        g.setColor(Color.BLUE);
        for (Cube cube : cubes) {
            Vertex2D[] vertices = cube.getVertices2D();
            int[] indices = cube.getIndices();
            for(int i = 0; i < indices.length - 3; i+=3) {
                Vertex2D v1 = vertices[indices[i]];
                Vertex2D v2 = vertices[indices[i+1]];
                Vertex2D v3 = vertices[indices[i+2]];

                int[] xPoints = new int[]{ v1.getX(), v2.getX(), v3.getX() };
                int[] yPoints = new int[]{ v1.getY(), v2.getY(), v3.getY() };

//                System.out.println(Arrays.toString(xPoints));
//                System.out.println(Arrays.toString(yPoints));
//                System.out.println();

//                g.setColor(v1.getColor());
                g.setColor(new Color(v1.getR(), v1.getG(), v1.getB()));
                g.fillPolygon(xPoints, yPoints, 3);
                g.setColor(Color.RED);
                g.drawPolygon(xPoints, yPoints, 3);
            }
        }

        g.dispose();
    }

    /**
     * Draws the buffered image to the screen.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(buffer, 0, 0, null);
    }

    /**
     * Handles resizing of the panel.
     */
    @Override
    public void doLayout() {
        super.doLayout();

        int width = getWidth();
        int height = getHeight();
        if (buffer.getWidth() != width || buffer.getHeight() != height) {
            buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        }
    }
}
