package HomeWork_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Chat extends JFrame {

    Chat(){
        setTitle("Супер Чат!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(300, 300, 500, 500);
        JTextArea jta = new JTextArea();

        JScrollPane sp = new JScrollPane(jta);
        add(BorderLayout.CENTER, sp);

        JTextField jtx = new JTextField();
        JButton jbt = new JButton("Отправить");
        JPanel jbp = new JPanel(new GridLayout(1,2));
        jbp.add(jtx);
        jbp.add(jbt);

        add(BorderLayout.SOUTH, jbp);
        setVisible(true);

        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!jtx.getText().equals("")) {
                    jta.append(jtx.getText() + "\n");
                    jtx.setText("");
                }
            }
        });

        jtx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!jtx.getText().equals("")) {
                    jta.append(jtx.getText() + "\n");
                    jtx.setText("");
                }
            }
        });
    }
}
