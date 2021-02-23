// Author: Logan Tillman

package graphics;

import java.awt.Graphics;
import java.awt.Color;

abstract public class GraphicalObject {
    Color color;

    abstract public void draw(Graphics g);

    abstract public boolean containsPt(int x, int y);

    final public Color getColor() {
        return this.color;
    }

    final public void setColor(Color color) {
        this.color = color;
    }
}