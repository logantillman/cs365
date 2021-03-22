// Author: Logan Tillman

package SliderApp;

class SliderView extends javax.swing.JSlider implements View {
    private Model model;

    // Maybe font
    private Font sliderFont = new Font(Font.SANS_SERIF, Font.PLAIN, 24);

    public SliderView(Model parentModel) {
        model = parentModel;
        model.addObserver(this);

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setFont(sliderFont);

        setModel(new javax.swing.SliderListModel(new int[] {1, 2, 3, 4, 5}));

        addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                numberSliderHandler(evt);
            }
        });
    }

    private void numberSliderHandler(javax.swing.event.ChangeEvent evt) {
        SliderModel listModel = (SliderListModel)getModel();
        model.setChoice((int)listModel.getValue());
    }

    public void update(int oldChoice) {
        int choice = model.getChoice();
        setValue(choice);
    }
}