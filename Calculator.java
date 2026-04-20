import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField tf;
    String operator = "";
    double num1 = 0, num2 = 0, result = 0;

    Calculator() {
        setTitle("Swing Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());

        tf = new JTextField();
        tf.setFont(new Font("Arial", Font.BOLD, 20));
        tf.setHorizontalAlignment(JTextField.RIGHT);
        add(tf, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String buttons[] = {
                "7","8","9","/",
                "4","5","6","*",
                "1","2","3","-",
                "0",".","=","+",
                "C"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.matches("[0-9.]")) {
            tf.setText(tf.getText() + command);
        }
        else if (command.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(tf.getText());
            operator = command;
            tf.setText("");
        }
        else if (command.equals("=")) {
            num2 = Double.parseDouble(tf.getText());

            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num1 / num2; break;
            }

            tf.setText(String.valueOf(result));
        }
        else if (command.equals("C")) {
            tf.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}