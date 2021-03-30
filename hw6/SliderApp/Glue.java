// Author: Logan Tillman

package SliderApp;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;

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
        JPanel sliderView = new SliderView(model, minValue, maxValue, startValue, incrementValue);
        JPanel gaugeView = new GaugeView(model, minValue, maxValue, startValue);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 250));

        textView.setPreferredSize(new Dimension(200, 30));
        sliderView.setPreferredSize(new Dimension(200, 80));
        gaugeView.setPreferredSize(new Dimension(200, 100));
        getContentPane().add(textView, BorderLayout.NORTH);
        getContentPane().add(sliderView, BorderLayout.CENTER);
        getContentPane().add(gaugeView, BorderLayout.SOUTH);

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