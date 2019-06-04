package Lesson_07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeWork_01_07_SW {

    static public void main(String[] args) {
        FirstWindow firstWindow = new FirstWindow();

    }
}

class FirstWindow extends JFrame {
    SecondWindow sc;

    FirstWindow() {
        setTitle("Первое окно");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(300, 300, 500, 500);
        JTextField jtf = new JTextField();
        jtf.setText("Фамилия, Имя, отчество");
        jtf.setEditable(false);
        add(jtf);
        JButton jbt = new JButton("Изменить");
        add(BorderLayout.SOUTH, jbt);
        setVisible(true);

        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(sc == null) {
                    sc = new SecondWindow(jtf);
                } else {
                    sc.clearText();
                    sc.setVisible(true);
                }
            }
        });
    }
}

class SecondWindow extends JFrame {
    JTextField jff = new JTextField();
    JTextField jfn = new JTextField();
    JTextField jfo = new JTextField();

    SecondWindow(JTextField jtf) {
        setTitle("Второе окно");
        setResizable(false);
        setBounds(350, 350, 100, 200);
        JPanel jp = new JPanel(new GridLayout(4,1));

        JButton btn = new JButton("OK");
        jp.add(jff);
        jp.add(jfn);
        jp.add(jfo);
        jp.add(btn);
        add(jp);
        setVisible(true);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jtf.setText(jff.getText() + ", " + jfn.getText() + ", " + jfo.getText());
                setVisible(false);
            }
        });
    }

    void clearText(){
        jff.setText("");
        jfn.setText("");
        jfo.setText("");
    }
}
