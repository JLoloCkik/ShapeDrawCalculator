package ljankai.Draw;

import java.awt.*;

public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public void clear() {
        start = null;
        end = null;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Line{start=" + start + ", end=" + end + "}";
    }
}
