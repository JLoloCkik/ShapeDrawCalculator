package ljankai.Ui;

import ljankai.Draw.PointDrawer;
import ljankai.Ui.Hotbar.Hotbar;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    private final int initialWidth = 2660;
    private final int initialHeight = 1540;

    JFrame frame = new JFrame();

    public void window() {
        frame = new JFrame("ShapeDrawCalculator");
        frame.setSize(initialWidth, initialHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PointDrawer pointDrawer = new PointDrawer(); // Létrehozzuk a DrawPanel példányát
        Hotbar hotbar = new Hotbar();

        // A DrawPanel-t átadjuk a Hotbar-nak
        frame.setLayout(new BorderLayout());
        frame.add(hotbar.addHotbar(pointDrawer), BorderLayout.NORTH); // Hotbar-t itt hívjuk meg
        frame.add(pointDrawer, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
