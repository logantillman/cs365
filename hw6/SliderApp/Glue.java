// Author: Logan Tillman

package SliderApp;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class Glue extends javax.swing.JFrame {

    Model model = new Model();

    public Glue(String[] args) {
        initializeComponents(args);
    }

    private void initializeComponents(String[] args) {
        int minValue;
        int maxValue;
        int startValue;
        int incrementValue;

        try {
            minValue = Integer.parseInt(args[0]);
            maxValue = Integer.parseInt(args[1]);
            startValue = Integer.parseInt(args[2]);
            incrementValue = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            throw (e);
        }

        JLabel textView = new TextView(model, startValue);
        JPanel buttonView = new ButtonView(model);
        JPanel sliderView = new SliderView(model, minValue, maxValue, startValue, incrementValue);
        // javax.swing.JSpinner spinnerView = new SpinnerView(model);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        getContentPane().add(textView, BorderLayout.PAGE_START);
        getContentPane().add(buttonView, BorderLayout.PAGE_END);
        getContentPane().add(sliderView, BorderLayout.CENTER);
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