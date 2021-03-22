package SliderApp;

import java.util.List;
import java.util.ArrayList;
import java.util.Observable;

class Model {
    int choice = 0;
    List<View> observers = new ArrayList<View>();

    int getChoice() {
        return this.choice;
    }

    void setChoice(int newChoice) {
        int oldChoice = this.choice;
        this.choice = newChoice;
        for (View view : observers) {
            view.update(oldChoice);
        }
    }

    void addObserver(View view) {
        observers.add(view);
    }
}