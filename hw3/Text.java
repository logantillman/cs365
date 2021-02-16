import java.awt.Color;

public class Text extends Shape {
    String string = "";

    Text() {

    }

    Text(int left, int top, Color color, String string) {
        this.left = left;
        this.top = top;
        this.width = 7 * string.length();
        this.height = 16;
        this.color = color;
        this.string = string;
    }

    public String getString() {
        return this.string;
    }

    private void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        String string = "Text(" + left + ", " + top + ", " + width + ", " + height + ")";
        return string;
    }
}