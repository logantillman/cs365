// Author: Logan Tillman

package graphics;

abstract public class Shape extends GraphicalObject {
    int left;
    int top;
    int width;
    int height;

    final public int getLeft() {
        return this.left;
    }

    final public void setLeft(int left) {
        this.left = left;
    }

    final public int getTop() {
        return this.top;
    }

    final public void setTop(int top) {
        this.top = top;
    }

    final public int getWidth() {
        return this.width;
    }

    final public void setWidth(int width) {
        this.width = width;
    }

    final public int getHeight() {
        return this.height;
    }

    final public void setHeight(int height) {
        this.height = height;
    }

    final public boolean containsPt(int x, int y) {
        int leftBoundary = this.left;
        int rightBoundary = this.left + this.width;
        int upperBoundary = this.top;
        int lowerBoundary = this.top + this.height;
        if (x >= leftBoundary && x <= rightBoundary) {
            if (y >= upperBoundary && y <= lowerBoundary) {
                return true;
            }
        }
        return false;
    }

    abstract public String toString();
}
