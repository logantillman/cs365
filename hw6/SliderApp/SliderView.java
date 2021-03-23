// Author: Logan Tillman

package SliderApp;

import javax.swing.BoundedRangeModel;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Font;

class SliderView extends javax.swing.JPanel implements View {
    private Model model;

    private javax.swing.JSlider slider;
    private javax.swing.JButton decrement;
    private javax.swing.JButton increment;

    // Maybe font
    private Font sliderFont = new Font(Font.SANS_SERIF, Font.PLAIN, 24);

    public SliderView(Model parentModel, int minValue, int maxValue, int startValue) {
        model = parentModel;
        model.addObserver(this);

        slider = new JSlider(minValue, maxValue, startValue);
        decrement = new JButton("-");
        increment = new JButton("+");

        setPreferredSize(new Dimension(200,50));
        add(decrement);
        add(increment);

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        decrement.setPreferredSize(new Dimension(60,60));
        increment.setPreferredSize(new Dimension(60,60));

        slider.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        slider.setFont(sliderFont);
        slider.setMajorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);

        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numberSliderHandler(evt);
            }
        });

        add(decrement);
        add(slider);
        add(increment);
    }

    private void numberSliderHandler(javax.swing.event.ChangeEvent evt) {
        BoundedRangeModel listModel = (BoundedRangeModel) slider.getModel();
        model.setChoice((int)listModel.getValue());
    }

    public void update(int oldChoice) {
        int choice = model.getChoice();
        slider.setValue(choice);
    }
}