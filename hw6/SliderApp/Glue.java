// Author: Logan Tillman

package SliderApp;

import javax.swing.JPanel;

public class Glue extends javax.swing.JFrame {

    Model model = new Model();

    public Glue() {
        initializeComponents();
    }

    private void initializeComponents() {
        JPanel buttonView = new ButtonView(model);
        javax.swing.JSlider sliderView = new SliderView(model);
        // javax.swing.JSpinner spinnerView = new SpinnerView(model);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(0, 1));

        getContentPane().add(buttonView);
        getContentPane().add(sliderView);
        // getContentPane().add(spinnerView);

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Glue().setVisible(true);
            }
        });
    }
}