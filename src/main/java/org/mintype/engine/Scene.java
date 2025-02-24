package org.mintype.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
            for(int i = 0; i < vertices.length; i++) {

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
