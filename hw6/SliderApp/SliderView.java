// Author: Logan Tillman

package SliderApp;

import javax.swing.BoundedRangeModel;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.Font;

class SliderView extends javax.swing.JPanel implements View {
    private Model model;

    private javax.swing.JSlider slider;
    private javax.swing.JButton decrement;
    private javax.swing.JButton increment;

    // Maybe font
    private Font sliderFont = new Font(Font.SANS_SERIF, Font.PLAIN, 24);

    private int minValue;
    private int maxValue;

    public SliderView(Model parentModel, int minValue, int maxValue, int startValue, int incrementValue) {
        model = parentModel;
        model.addObserver(this);

        this.minValue = minValue;
        this.maxValue = maxValue;

        setPreferredSize(new Dimension(250,100));
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        slider = new JSlider(minValue, maxValue, startValue);

        slider.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        slider.setMajorTickSpacing(1);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);

        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numberSliderHandler(evt);
            }
        });

        decrement = new JButton("-");
        decrement.setPreferredSize(new Dimension(60,60));

        decrement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                decrementPressed(incrementValue);
            }
        });

        increment = new JButton("+");
        increment.setPreferredSize(new Dimension(60,60));

        increment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                incrementPressed(incrementValue);
            }
        });

        add(decrement);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(slider);
        add(Box.createRigidArea(new Dimension(5,0)));
        add(increment);
    }

    private void numberSliderHandler(javax.swing.event.ChangeEvent evt) {
        BoundedRangeModel listModel = (BoundedRangeModel) slider.getModel();
        model.setChoice((int)listModel.getValue());
    }

    private void decrementPressed(int incrementValue) {
        BoundedRangeModel listModel = (BoundedRangeModel) slider.getModel();
        int value = (int) listModel.getValue();
        if (value == minValue) {
            javax.swing.JOptionPane.showMessageDialog(null, "Value cannot be further decremented");
        }
        else {
            model.setChoice(value - incrementValue);
        }
    }

    private void incrementPressed(int incrementValue) {
        BoundedRangeModel listModel = (BoundedRangeModel) slider.getModel();
        int value = (int) listModel.getValue();
        if (value == maxValue) {
            javax.swing.JOptionPane.showMessageDialog(null, "Value cannot be further incremented");
        }
        else {
            model.setChoice(value + incrementValue);
        }
    }

    public void update(int oldChoice) {
        int choice = model.getChoice();
        slider.setValue(choice);
    }
}