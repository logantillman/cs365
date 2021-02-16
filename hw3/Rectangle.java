import java.awt.Color;

public class Rectangle extends Shape {
    
    Rectangle() {

    }

    Rectangle(int left, int top, int width, int height, Color color) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public String toString() {
        String string = "Rectangle(" + left + ", " + top + ", " + width + ", " + height + ")";
        return string;
    }
}