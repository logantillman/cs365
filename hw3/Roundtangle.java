import java.awt.Color;

public class Roundtangle extends Shape {
    public enum ArcSize {
        SMALL (10),
        MEDIUM (20),
        LARGE (30);

        private final int pixels;

        ArcSize(int pixels) {
            this.pixels = pixels;
        }

        public int getSize() {
            return this.pixels;
        }
    }
    
    int arcSize = ArcSize.MEDIUM.getSize();

    Roundtangle() {

    }

    Roundtangle(int left, int top, int width, int height, Color color, int arcSize) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
        this.color = color;
        this.arcSize = arcSize;
    }

    public int getArcSize() {
        return this.arcSize;
    }

    public void setArcSize(int arcSize) {
        this.arcSize = arcSize;
        //ArcSize(arcSize);
    }

    @Override
    public String toString() {
        String string = "Roundtangle(" + left + ", " + top + ", " + width + ", " + height + ", "+  arcSize + ")";
        return string;
    }
}