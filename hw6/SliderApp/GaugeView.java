// Author: Logan Tillman

package SliderApp;

import java.awt.Graphics;
import java.awt.Color;

class GaugeView extends javax.swing.JPanel implements View {
    private Model model;

    private static final int DIM_WIDTH = 640;
    private static final int DIM_HEIGHT = 640;
    private static final int SQ_SIZE = 80;

    private int value;
    private int maxValue;


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        g.drawRect(50, 0, 375, 90);

        g.setColor(Color.ORANGE);
        g.fillArc(145, 0, 180, 180, -180, -180);

        g.setColor(Color.BLUE);
        g.drawLine(235, 89, (180 * (maxValue/(value+1))) + 50, 1);
    }

    public GaugeView(Model parentModel, int minValue, int maxValue, int startValue) {
        model = parentModel;
        model.addObserver(this);

        this.value = startValue;
        this.maxValue = maxValue;
    }

    public void update(int oldChoice) {
        int choice = model.getChoice();
        this.value = choice;
        repaint();
    }
}