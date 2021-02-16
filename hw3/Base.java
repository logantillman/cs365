import java.awt.Graphics;
import java.awt.Color;

abstract public class Base {
    Color color = Color.BLACK;

    //abstract public void draw(Graphics g);

    //abstract public boolean containsPt(int x, int y);

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}