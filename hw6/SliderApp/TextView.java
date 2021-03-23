package SliderApp;

class TextView extends javax.swing.JLabel implements View {
    private Model model;

    public TextView(Model parentModel, int startValue) {
        model = parentModel;
        model.addObserver(this);
        
        setHorizontalAlignment(javax.swing.JLabel.CENTER);
        setVerticalAlignment(javax.swing.JLabel.CENTER);
        setText(Integer.toString(startValue));
    }

    public void update(int oldChoice) {
        int choice = model.getChoice();
        setText(Integer.toString(choice));
    }
}