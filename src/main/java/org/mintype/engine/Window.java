package org.mintype.engine;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private Scene scene;

    public Window(Scene scene) throws HeadlessException {
        this.scene = scene;
        add(scene);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
