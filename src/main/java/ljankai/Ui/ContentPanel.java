package ljankai.Ui;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawCoordinates(g);
    }

    private void drawCoordinates(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        int cmInPixels = width / 100;
        int centerX = ((width / 2) / cmInPixels) * cmInPixels; // Igazítjuk a középpontot a rácshoz
        int centerY = ((height / 2) / cmInPixels) * cmInPixels; // Igazítjuk a középpontot a rácshoz

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));

        g2.drawLine(0, centerY, width, centerY); // Horizontális tengely
        g2.drawLine(centerX, 0, centerX, height); // Vertikális tengely
    }

    private void drawGrid(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        int cmInPixels = Math.max(1, width / 100);
        g2.setColor(Color.LIGHT_GRAY);
        g2.setStroke(new BasicStroke(1));

        for (int i = 0; i < width; i += cmInPixels) {
            g2.drawLine(i, 0, i, height); // Vertikális rácsvonalak
        }

        for (int i = 0; i < height; i += cmInPixels) {
            g2.drawLine(0, i, width, i); // Horizontális rácsvonalak
        }
    }
}
