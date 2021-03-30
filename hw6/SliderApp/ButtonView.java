package SliderApp;

import javax.swing.JPanel;
import java.util.Observer;
import java.util.Observable;
import java.awt.Font;

class ButtonView extends JPanel implements View {

    private javax.swing.ButtonGroup animalGroup;

    private javax.swing.JRadioButton dog;
    private javax.swing.JRadioButton horse;
    private javax.swing.JRadioButton rabbit;
    private javax.swing.JRadioButton tiger;
    private javax.swing.JRadioButton unicorn;

    private Model model;

    private Font buttonFont = new Font(Font.SANS_SERIF, Font.PLAIN, 24);

    public ButtonView(Model parentModel) {
	model = parentModel;
	model.addObserver(this);

	// radio buttons for the view
	animalGroup = new javax.swing.ButtonGroup();
	dog = new javax.swing.JRadioButton();
	dog.setFont(buttonFont);

	rabbit = new javax.swing.JRadioButton();
	rabbit.setFont(buttonFont);

	horse = new javax.swing.JRadioButton();
	horse.setFont(buttonFont);

	tiger = new javax.swing.JRadioButton();
	tiger.setFont(buttonFont);

	unicorn = new javax.swing.JRadioButton();
	unicorn.setFont(buttonFont);

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        animalGroup.add(dog);
        dog.setSelected(true);
        dog.setText("dog");
        dog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dogActionPerformed(evt);
            }
        });
        add(dog);

        animalGroup.add(rabbit);
        rabbit.setText("rabbit");
        rabbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rabbitActionPerformed(evt);
            }
        });
        add(rabbit);

        animalGroup.add(horse);
        horse.setText("horse");
        horse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horseActionPerformed(evt);
            }
        });
        add(horse);

        animalGroup.add(tiger);
        tiger.setText("tiger");
        tiger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tigerActionPerformed(evt);
            }
        });
        add(tiger);

        animalGroup.add(unicorn);
        unicorn.setText("unicorn");
        unicorn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unicornActionPerformed(evt);
            }
        });
        add(unicorn);
    }

    private void dogActionPerformed(java.awt.event.ActionEvent evt) {
        model.setChoice(1);      
    }

    private void rabbitActionPerformed(java.awt.event.ActionEvent evt) {
        model.setChoice(3);        
    }

    private void horseActionPerformed(java.awt.event.ActionEvent evt) {
        model.setChoice(2); 
    }

    private void tigerActionPerformed(java.awt.event.ActionEvent evt) {
        model.setChoice(4);        
    }

    private void unicornActionPerformed(java.awt.event.ActionEvent evt) {
        model.setChoice(5);       
    }

    public void update(int oldChoice) {
	int choice = model.getChoice();
        switch(choice) {
            case 1: 
                dog.setSelected(true);
                break;
            case 2:
                horse.setSelected(true);
                break;
            case 3:
                rabbit.setSelected(true);
                break;
            case 4:
                tiger.setSelected(true);
                break;
            case 5:
                unicorn.setSelected(true);
                break;
            default: // do nothing
        }
    }
}