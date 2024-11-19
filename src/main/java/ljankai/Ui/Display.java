package ljankai.Ui;

import ljankai.Ui.Hotbar.Hotbar;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    private int initialWidth = (int) (3840 / 1.4);
    private int initialHeight = (int) (2160 / 1.4);

    JFrame frame = new JFrame();

    public void window() {
        frame = new JFrame("ShapeDrawCalculator");
        frame.setSize(initialWidth, initialHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ContentPanel contentPanel = new ContentPanel();
        Hotbar hotbar = new Hotbar();


        frame.setLayout(new BorderLayout());
        frame.add(hotbar.addHotbar(), BorderLayout.NORTH);
        frame.add(contentPanel, BorderLayout.CENTER);


        frame.setVisible(true);
    }
}
