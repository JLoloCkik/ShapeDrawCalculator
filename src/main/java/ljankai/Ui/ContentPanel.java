package ljankai.Ui;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCoordinates(g);
        drawGrid(g);
    }

    private void drawCoordinates(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();  // Aktuális panel szélessége
        int height = getHeight(); // Aktuális panel magassága
        int centerX = width / 2;
        int centerY = height / 2;

        g2.setColor(Color.BLACK);
        g2.drawLine(0, centerY, width, centerY); // Horizontális tengely
        g2.drawLine(centerX, 0, centerX, height); // Vertikális tengely
    }

    private void drawGrid(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();  // Aktuális panel szélessége
        int height = getHeight(); // Aktuális panel magassága

        int cmInPixels = width / 100;
        g2.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < width; i += cmInPixels) {
            g2.drawLine(i, 0, i, height); // Vertikális rácsvonalak
        }

        for (int i = 0; i < height; i += cmInPixels) {
            g2.drawLine(0, i, width, i); // Horizontális rácsvonalak
        }
    }
}
