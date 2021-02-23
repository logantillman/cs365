// Author: Logan Tillman

package graphics;

import java.awt.Color;
import java.awt.Graphics;

public class Roundtangle extends Rectangle {
    public enum Arcsize {
        SMALL (10),
        MEDIUM (20),
        LARGE (30);

        final private int pixels;

        Arcsize(int pixels) {
            this.pixels = pixels;
        }

        public int getSize() {
            return this.pixels;
        }
    }

    Arcsize arcType;
    int arcSize;

    public Roundtangle() {
        super();
        this.arcType = Arcsize.MEDIUM;
        this.arcSize = arcType.getSize();
    }

    public Roundtangle(int left, int top, int width, int height, Color color, int arcSize) {
        super(left, top, width, height, color);
        this.arcSize = arcSize;
        setArcType(arcSize);
    }

    final public int getArcSize() {
        return this.arcSize;
    }

    final public void setArcSize(int arcSize) {
        this.arcSize = arcSize;
        setArcType(arcSize);
    }

    final private void setArcType(int arcSize) {
        if (arcSize == Arcsize.SMALL.getSize()) {
            this.arcType = Arcsize.SMALL;
        }
        else if (arcSize == Arcsize.MEDIUM.getSize()) {
            this.arcType = Arcsize.MEDIUM;
        }
        else if (arcSize == Arcsize.LARGE.getSize()) {
            this.arcType = Arcsize.LARGE;
        }
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRoundRect(this.left, this.top, this.width, this.height, this.arcSize, this.arcSize);
    }

    public String toString() {
        String arc = this.arcType != null ? this.arcType.toString() : String.valueOf(this.arcSize);
        String string = "Roundtangle(" + left + ", " + top + ", " + width + ", " + height + ", " +  arc + ")";
        return string;
    }
}