// Author: Logan Tillman

package graphics;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Shape {
    
    public Oval() {
        this.left = 0;
        this.top = 0;
        this.width = 20;
        this.height = 20;
        this.color = Color.BLACK;
    }

    public Oval(int left, int top, int width, int height, Color color) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillOval(this.left, this.top, this.width, this.height);
    }

    public String toString() {
        String string = "Oval(" + left + ", " + top + ", " + width + ", " + height + ")";
        return string;
    }
}