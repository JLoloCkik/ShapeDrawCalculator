package ljankai.Draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;

public class DrawPanel
        extends JPanel {
    ArrayList<Point> points = new ArrayList<>();

    public DrawPanel() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addPoint(e.getPoint());
            }
        });
    }

    private void addPoint(Point point) {
        int gridSize = getGridSpacing();
        int xIndex = point.x / gridSize; // Relatív rácspozíció kiszámítása
        int yIndex = point.y / gridSize;

        points.add(new Point(xIndex, yIndex));
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawCoordinates(g);

        g.setColor(Color.RED);
        int gridSize = getGridSpacing();

        for (Point point : points) {
            int x = point.x * gridSize;
            int y = point.y * gridSize;

            g.fillOval(x , y , 10, 10);
        }
    }

    private void drawGrid(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        int gridSize = getGridSpacing();

        g2.setColor(Color.LIGHT_GRAY);
        g2.setStroke(new BasicStroke(1));

        for (int i = 0; i < width; i += gridSize) {
            g2.drawLine(i, 0, i, height); // Függőleges rácsvonalak rajzolása
        }
        for (int i = 0; i < height; i += gridSize) {
            g2.drawLine(0, i, width, i); // Vízszintes rácsvonalak rajzolása
        }
    }


    private void drawCoordinates(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        int gridSize = getGridSpacing();
        int centerX = (width / 2 / gridSize) * gridSize;
        int centerY = (height / 2 / gridSize) * gridSize;

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));

        g2.drawLine(0, centerY, width, centerY);
        g2.drawLine(centerX, 0, centerX, height);
    }

    private int getGridSpacing() {
        return Math.max(1, getWidth() / 60);
    }

}
