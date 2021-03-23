// Author: Logan Tillman

package SliderApp;

import javax.swing.BoundedRangeModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;

class SliderView extends javax.swing.JSlider implements View {
    private Model model;
    private JPanel buttonPanel;
    private javax.swing.JButton decrement;
    private javax.swing.JButton increment;

    // Maybe font
    private Font sliderFont = new Font(Font.SANS_SERIF, Font.PLAIN, 24);

    public SliderView(Model parentModel, int minValue, int maxValue, int startValue) {
        model = parentModel;
        model.addObserver(this);

        buttonPanel = new JPanel();
        decrement = new JButton("-");
        increment = new JButton("+");

        buttonPanel.setPreferredSize(new Dimension(200,50));
        buttonPanel.add(decrement);
        buttonPanel.add(increment);

        buttonPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        decrement.setPreferredSize(new Dimension(60,60));
        increment.setPreferredSize(new Dimension(60,60));

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setFont(sliderFont);
        setMajorTickSpacing(1);
        setPaintLabels(true);
        setPaintTicks(true);

        BoundedRangeModel brm = getModel();
        // System.out.printf("%d %d %d %d%n", Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        brm.setMinimum(minValue);
        brm.setMaximum(maxValue);
        brm.setValue(startValue);
        brm.setExtent(0);
        setModel(brm);
        
        addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numberSliderHandler(evt);
            }
        });
    }

    private void numberSliderHandler(javax.swing.event.ChangeEvent evt) {
        BoundedRangeModel listModel = (BoundedRangeModel)getModel();
        model.setChoice((int)listModel.getValue());
    }

    public void update(int oldChoice) {
        int choice = model.getChoice();
        setValue(choice);
    }
}