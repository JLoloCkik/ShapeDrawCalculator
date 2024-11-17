package ljankai.Ui;

import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    private final int width = (int) (3840 / 1.4);
    private final int height = (int) (2160 / 1.4);


    public void window() {
        JFrame frame = new JFrame("ShapeDrawCalculator");
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawCoordinates(g);
                drawGrid(g);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }

    private void drawCoordinates(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int centerX = width / 2;
        int centerY = height / 2;

        g2.setColor(Color.BLACK);
        g2.drawLine(0, centerY,width, centerY);
        g2.drawLine(centerX, 0, centerX, height);
    }

    private void drawGrid(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        int cmInPixels = width / 100;
        g2.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < width; i += cmInPixels) {
            g2.drawLine(i, 0, i, height);
        }

        for (int i = 0; i < height; i += cmInPixels) {
            g2.drawLine(0, i, width, i);
        }
    }
}
