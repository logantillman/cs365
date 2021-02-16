import java.awt.Color;

public class Oval extends Shape {
    
    Oval() {

    }

    Oval(int left, int top, int width, int height, Color color) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public String toString() {
        String string = "Oval(" + left + ", " + top + ", " + width + ", " + height + ")";
        return string;
    }
}