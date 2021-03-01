package HW8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateListener implements ActionListener {
    private final JPanel panel;
    private final JTextField display;

    public CalculateListener(JPanel panel) {
        this.panel = panel;
        display = (JTextField) panel.getComponent(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Controller controller = new Controller();
        JButton source = (JButton) e.getSource();
        if (source.getText().equals("=")){
            display.setText(controller.doOperation(display.getText()));
        } else {
            display.setText(String.valueOf(
                    Math.sqrt(
                            Double.parseDouble(
                                    controller.doOperation(display.getText())))));
        }

    }

}
