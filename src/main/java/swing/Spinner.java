package swing;

import javax.swing.JSpinner;

public class Spinner extends JSpinner {

    public Spinner() {
        setOpaque(false);
        setUI(new SpinnerUI());
    }
}
