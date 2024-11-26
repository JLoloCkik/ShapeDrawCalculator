package ljankai.Draw;

import java.awt.*;
import javax.swing.*;

public class GridDrawer {

    // Be rácsozás
    public void drawGrid(Graphics g, int width, int height, int unitSize) {
        Graphics2D g2 = (Graphics2D) g;
        int centerX = width / 2;
        int centerY = height / 2;

        g2.setColor(Color.LIGHT_GRAY);
        g2.setStroke(new BasicStroke(1));

        // Függőleges rácsvonalak
        for (int x = centerX % unitSize; x < width; x += unitSize) {
            g2.drawLine(x, 0, x, height);
        }

        // Vízszintes rácsvonalak
        for (int y = centerY % unitSize; y < height; y += unitSize) {
            g2.drawLine(0, y, width, y);
        }
    }

    // X Y tengely berajzolása
    public void drawCoordinates(Graphics g, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;
        int centerX = width / 2;
        int centerY = height / 2;

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));

        // X tengely
        g2.drawLine(0, centerY, width, centerY);

        // Y tengely
        g2.drawLine(centerX, 0, centerX, height);
    }
}
