package HW8;

import javax.swing.*;
import java.awt.*;

public class TopFrame {
    private final JPanel panel;

    public TopFrame() {
        panel  = new JPanel();
        panel.setLayout((new BorderLayout()));
        JTextField input = new JTextField();
        input.setEditable(false);
        input.setHorizontalAlignment(SwingConstants.RIGHT);
        panel.add(input,BorderLayout.CENTER);
    }

    public JPanel getPanel(){
        return panel;
    }

}
