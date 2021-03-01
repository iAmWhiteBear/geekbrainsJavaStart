package HW8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotFrame {
    private final JPanel panel;

    public BotFrame(JPanel topPanel) {
        panel = new JPanel();
        JPanel digits = new JPanel(); // что бы было покрасивее, цифры отдельно, операции отдельно
        digits.setLayout(new GridLayout(3,4));
        DigitButtonListener listener = new DigitButtonListener(topPanel);
        for (int i = 9; i > -1; i--) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(listener);
            digits.add(btn);
        }
        digits.add(createOperationButton(topPanel,"."));
        panel.add(digits,BorderLayout.WEST);

        JPanel oper = new JPanel();
        oper.setLayout(new GridLayout(2,4));
        oper.add(createOperationButton(topPanel,"+"));
        oper.add(createOperationButton(topPanel,"-"));
        oper.add(createOperationButton(topPanel,"*"));
        oper.add(createOperationButton(topPanel,"/"));
        CalculateListener calculateListener = new CalculateListener(topPanel);
        JButton sqrt = new JButton("SQRT");
        sqrt.addActionListener(calculateListener);
        oper.add(sqrt);
        JButton calculate = new JButton("=");
        calculate.addActionListener(calculateListener);
        oper.add(calculate);
        JButton clear = new JButton("C");
        clear.addActionListener(e -> ((JTextField) topPanel.getComponent(0)).setText(""));
        oper.add(clear);
        panel.add(oper, BorderLayout.EAST);


    }

    public JPanel getPanel() {
        return panel;
    }

    private JButton createOperationButton(JPanel inputPanel, String symbol){
        JButton button = new JButton(symbol);
        button.addActionListener(e -> {
            StringBuilder sb = new StringBuilder(((JTextField) inputPanel.getComponent(0)).getText());
            sb.append(symbol);
            ((JTextField) inputPanel.getComponent(0)).setText(sb.toString());
        });
        return button;
    }
}
