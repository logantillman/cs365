// Author: Logan Tillman

import java.awt.Color;
import java.awt.Graphics;

public class Text extends Shape {
    String string;

    Text() {
        this.left = 0;
        this.top = 0;
        this.width = 20;
        this.height = 20;
        this.color = Color.BLACK;
        this.string = "";
    }

    Text(int left, int top, Color color, String string) {
        this.left = left;
        this.top = top;
        this.width = 7 * string.length();
        this.height = 16;
        this.color = color;
        this.string = string;
    }

    final public String getString() {
        return this.string;
    }

    final private void setString(String string) {
        this.string = string;
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.drawString(this.string, this.left, this.top);
    }

    public String toString() {
        String string = "Text(" + left + ", " + top + ", " + width + ", " + height + ")";
        return string;
    }
}