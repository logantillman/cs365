// Author: Logan Tillman

package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Line2D;

public class Line extends GraphicalObject {
    int x1;
    int y1;
    int x2;
    int y2;

    public Line() {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 20;
        this.y2 = 20;
        this.color = Color.BLACK;
    }

    public Line(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    final public int getX1() {
        return this.x1;
    }

    final public void setX1(int x1) {
        this.x1 = x1;
    }

    final public int getY1() {
        return this.y1;
    }

    final public void setY1(int y1) {
        this.y1 = y1;
    }

    final public int getX2() {
        return this.x2;
    }

    final public void setX2(int x2) {
        this.x2 = x2;
    }

    final public int getY2() {
        return this.y2;
    }

    final public void setY2(int y2) {
        this.y2 = y2;
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.drawLine(this.x1, this.y1, this.x2, this.y2);
    }

    public boolean containsPt(int x, int y) {
        Line2D.Double line = new Line2D.Double(this.x1, this.y1, this.x2, this.y2);
        if (line.ptSegDist(x, y) <= 5) {
            return true;
        }
        return false;
    }

    public String toString() {
        String string = "Line(" + x1 + ", " + y1 + ", " + x2 + ", " + y2 + ")";
        return string;
    }
}