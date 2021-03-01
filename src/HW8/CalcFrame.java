package HW8;

import javax.swing.*;
import java.awt.*;

public class CalcFrame extends JFrame {
    public CalcFrame(){
        setTitle("calc 1.0");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100,100,500,300);


//        setLayout(new GridLayout(3,3));
//        for (int i = 0; i < 9; i++) {
//            add(new JButton(String.valueOf(i)));
//        }


//        setLayout(new BorderLayout());
//        add(new JButton("submit"), BorderLayout.CENTER);
//        add(new JButton("delete"),BorderLayout.SOUTH);


//        setLayout(new FlowLayout());
//                for (int i = 0; i < 9; i++) {
//            add(new JButton(String.valueOf(i)));
//        }

        TopFrame top = new TopFrame();
        add(top.getPanel(),BorderLayout.NORTH);


        BotFrame bot = new BotFrame(top.getPanel());
        add(bot.getPanel(),BorderLayout.CENTER);

        setVisible(true);
    }


}
