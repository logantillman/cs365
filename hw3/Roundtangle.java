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

    public int getArcSize() {
        return this.arcSize;
    }

    public void setArcSize(int arcSize) {
        this.arcSize = arcSize;
        //ArcSize(arcSize);
    }
}