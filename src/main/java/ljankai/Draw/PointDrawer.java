package ljankai.Draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PointDrawer extends JPanel {
    private ArrayList<Point> gridPoints = new ArrayList<>(); // Relatív koordináták tárolása
    private ArrayList<Point> undoList = new ArrayList<>();
    private GridDrawer gridDrawer;  // Új GridDrawer példány hozzáadása

    // Konstruktor létre hoz egy új pontot minden kattintásnál
    public PointDrawer() {
        gridDrawer = new GridDrawer();  // Inicializáljuk a GridDrawer-t

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

    public void clearPoints() {
        gridPoints.clear();
    }

    public void undoPoints() {
        if (!gridPoints.isEmpty()) {
            undoList.add(gridPoints.remove(gridPoints.size() - 1));
        }
    }

    public void redoPoints() {
        if (!undoList.isEmpty()) {
            gridPoints.add(undoList.remove(undoList.size() - 1));
        }
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int unitSize = getUnitSize();
        int width = getWidth();
        int height = getHeight();

        // Rács és koordináták kirajzolása
        gridDrawer.drawGrid(g, width, height, unitSize);
        gridDrawer.drawCoordinates(g, width, height);

        g.setColor(Color.RED);

        // Pontok kirajzolása
        for (Point gridPoint : gridPoints) {
            int x = width / 2 + gridPoint.x * unitSize;
            int y = height / 2 - gridPoint.y * unitSize; // Y tengely fordított

            g.fillOval(x - 5, y - 5, 10, 10);
        }
    }

    // Maximum távolság a koordináta rendszer elemei között
    private int getUnitSize() {
        return Math.max(40, getWidth() / 60);
    }
}
