package ljankai.Draw;

import java.awt.*;
import java.util.LinkedList;

public class EdgeDrawer {
    private Line firstLine;
    private Line lastLine;
    private LinkedList<Line> lines = new LinkedList<Line>();

    public void addEdge(Point start, Point end) {
        lines.add(new Line(start, end));
    }

    public void drawEdges(Graphics g, int unitSize, int centerX, int centerY) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(2));

        // Minden vonal kirajzolása
        for (Line line : lines) {
            int x1 = centerX + line.getStart().x * unitSize;
            int y1 = centerY - line.getStart().y * unitSize;
            int x2 = centerX + line.getEnd().x * unitSize;
            int y2 = centerY - line.getEnd().y * unitSize;

            g2.drawLine(x1, y1, x2, y2);
        }

        // Ha több mint egy vonal van, a legelső és legutolsó vonal összekötése
        if (lines.size() > 1) {
            firstLine = lines.getFirst();
            lastLine = lines.getLast();

            int firstX = centerX + firstLine.getStart().x * unitSize;
            int firstY = centerY - firstLine.getStart().y * unitSize;
            int lastX = centerX + lastLine.getEnd().x * unitSize;
            int lastY = centerY - lastLine.getEnd().y * unitSize;

            g2.drawLine(lastX, lastY, firstX, firstY);
        }
    }

    // Vonalak törlése
    public void clearLines() {
        lines.clear();
        firstLine = null;
        lastLine = null;
    }
}
