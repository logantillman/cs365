public class Roundtangle {
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

    int left = 0;
    int top = 0;
    int width = 20;
    int height = 20;
    int x1 = 0;
    int y1 = 0;
    int x2 = 20;
    int y2 = 20;
    // color = black;
    String string = "";
    ArcSize arcSize = ArcSize.MEDIUM;
}