import java.awt.Color;

public class Line extends Base {
    int x1 = 0;
    int y1 = 0;
    int x2 = 20;
    int y2 = 20;

    Line() {

    }

    Line(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    public int getX1() {
        return this.x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return this.y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return this.x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return this.y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public String toString() {
        String string = "Line(" + x1 + ", " + y1 + ", " + x2 + ", " + y2 + ")";
        return string;
    }
}