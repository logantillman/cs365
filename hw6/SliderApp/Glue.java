// Author: Logan Tillman

package SliderApp;

import javax.swing.JPanel;

public class Glue extends javax.swing.JFrame {

    Model model = new Model();

    public Glue(String[] args) {
        initializeComponents(args);
    }

    private void initializeComponents(String[] args) {
        int minValue = Integer.parseInt(args[0]);
        int maxValue = Integer.parseInt(args[1]);
        int startValue = Integer.parseInt(args[2]);
        int other = Integer.parseInt(args[3]);

        JPanel buttonView = new ButtonView(model);
        JPanel sliderView = new SliderView(model, minValue, maxValue, startValue);
        // javax.swing.JSpinner spinnerView = new SpinnerView(model);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(0, 1));

        getContentPane().add(buttonView);
        getContentPane().add(sliderView);
        // getContentPane().add(spinnerView);

        pack();
    }

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java Glue minValue maxValue startValue increment");
            return;
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Glue(args).setVisible(true);
            }
        });
    }
}