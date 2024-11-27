package ljankai.Draw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.LinkedList;

public class PointDrawer extends JPanel {
    private LinkedList<Point> gridPoints = new LinkedList<>(); // Relatív koordináták tárolása
    private LinkedList<Point> undoList = new LinkedList<>(); // Undo eredményét tárolja
    private GridDrawer gridDrawer;  // Új GridDrawer példány hozzáadása
    private EdgeDrawer edgeDrawer;

    // Konstruktor létre hoz egy új pontot minden kattintásnál
    public PointDrawer() {
        gridDrawer = new GridDrawer();  // Inicializáljuk a GridDrawer-t
        edgeDrawer = new EdgeDrawer();
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

        gridPoints.add(newPoint);
        if(gridPoints.size() > 1){
            Point lastPoint = gridPoints.get(gridPoints.size() - 2);
            edgeDrawer.addEdge(lastPoint, newPoint);
        }

        repaint();

    }

    public void clearPoints() {
        gridPoints.clear();
    }

    public void undoPoints() {
        if (!gridPoints.isEmpty()) {
            undoList.addLast(gridPoints.removeLast());
        }
    }

    public void redoPoints() {
        if (!undoList.isEmpty()) {
            gridPoints.addLast(undoList.removeLast());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int unitSize = getUnitSize();
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;

        // Rács és koordináták kirajzolása
        gridDrawer.drawGrid(g, width, height, unitSize);
        gridDrawer.drawCoordinates(g, width, height);

        if (gridPoints.size() > 1) {
            edgeDrawer.drawEdges(g, unitSize, centerX, centerY);
        }
        g.setColor(Color.RED);

        // Pontok kirajzolása
        for (Point gridPoint : gridPoints) {
            int x = width / 2 + gridPoint.x * unitSize;
            int y = height / 2 - gridPoint.y * unitSize; // Y tengely fordított

            g.fillOval(x - 5, y - 5, 15, 15);
        }
    }

    // Maximum távolság a koordináta rendszer elemei között
    private int getUnitSize() {
        return Math.max(30, getWidth() / 60);
    }
}
