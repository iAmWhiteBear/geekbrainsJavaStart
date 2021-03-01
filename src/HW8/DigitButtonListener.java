package HW8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitButtonListener implements ActionListener {
    private final JTextField input;

    public DigitButtonListener(JPanel panel) {
        input = (JTextField) panel.getComponent(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder sb = new StringBuilder(input.getText());
        sb.append(((JButton) e.getSource()).getText());
        input.setText(sb.toString());
    }
}
