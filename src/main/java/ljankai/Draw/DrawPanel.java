package ljankai.Draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class DrawPanel extends JPanel {
    private ArrayList<Point> gridPoints = new ArrayList<>(); // Relatív koordináták tárolása
    // Konstruktor létre hoz egy új pontot minden katintásnál
    public DrawPanel() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addPoint(e.getPoint());
            }
        });
    }

    private void addPoint(Point mousePoint) {
        int unitSize = getUnitSize(); // Egységméret kiszámítása
        int centerX = getWidth() / 2; // Origó X koordinátája
        int centerY = getHeight() / 2; // Origó Y koordinátája

        // Origótól való relatív pozíció kerekítéssel
        int relX = (int) Math.round((double) (mousePoint.x - centerX) / unitSize);
        int relY = (int) Math.round((double) (centerY - mousePoint.y) / unitSize);

        Point newPoint = new Point(relX, relY);

        // Pont hozzáadása, ha még nem létezik
        if (!gridPoints.contains(newPoint)) {
            gridPoints.add(newPoint);
            repaint();
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        drawCoordinates(g);

        g.setColor(Color.RED);
        int unitSize = getUnitSize();
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        // Pontok kirajzolása
        for (Point gridPoint : gridPoints) {
            int x = centerX + gridPoint.x * unitSize;
            int y = centerY - gridPoint.y * unitSize; // Y tengely fordított

            g.fillOval(x - 5, y - 5, 10, 10);
        }
    }

    // Be rácsozás
    private void drawGrid(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        int unitSize = getUnitSize();
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
    private void drawCoordinates(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));

        // X tengely
        g2.drawLine(0, centerY, width, centerY);

        // Y tengely
        g2.drawLine(centerX, 0, centerX, height);
    }

    //Maximum távolság a koordináta rendszer elemei között
    private int getUnitSize() {
        return Math.max(40, getWidth() / 60);
    }
}
