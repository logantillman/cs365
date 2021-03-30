// Author: Logan Tillman

package SliderApp;

import java.awt.Dimension;

class TextView extends javax.swing.JLabel implements View {
    private Model model;

    public TextView(Model parentModel, int startValue) {
        model = parentModel;
        model.addObserver(this);
        
        setHorizontalAlignment(javax.swing.JLabel.CENTER);
        setVerticalAlignment(javax.swing.JLabel.CENTER);
        setText("Value: " + Integer.toString(startValue));
    }

    public void update(int oldChoice) {
        int choice = model.getChoice();
        setText("Value: " + Integer.toString(choice));
    }
}