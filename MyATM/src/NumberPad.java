import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberPad extends JFrame {
    private Listener listener;

    public NumberPad(Listener listener, String title) {
        super(title);
        this.listener = listener;
    }

    public void Run(int operation) {
                JFrame frame = new JFrame();
                frame.setSize(1000, 1000);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);

                frame.setLayout(new GridLayout(5, 3));

                JTextArea enteredNumber = new JTextArea();
                enteredNumber.setEditable(false);

                JButton one = new JButton("1");
                JButton two = new JButton("2");
                JButton three = new JButton("3");
                JButton four = new JButton("4");
                JButton five = new JButton("5");
                JButton six = new JButton("6");
                JButton seven = new JButton("7");
                JButton eight = new JButton("8");
                JButton nine = new JButton("9");
                JButton zero = new JButton("0");
                JButton reset = new JButton("RESET");
                JButton accept = new JButton("Accept");

                frame.add(one);
                frame.add(two);
                frame.add(three);
                frame.add(four);
                frame.add(five);
                frame.add(six);
                frame.add(seven);
                frame.add(eight);
                frame.add(nine);
                frame.add(reset);
                frame.add(zero);
                frame.add(enteredNumber);
                frame.add(accept);

                accept.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (operation == 1) {
                            Main.numberHolder = enteredNumber.getText();
                            if (Long.parseLong(Main.numberHolder) <= Long.parseLong(Main.updatedBalance))
                                listener.updateMe(String.valueOf(Long.parseLong(Main.updatedBalance) - Long.parseLong(Main.numberHolder)));
                            else {
                                JOptionPane.showMessageDialog(null, "You don't have enough money to perform the withdraw");
                            }
                        } else if (operation == 2) {
                            Main.numberHolder = enteredNumber.getText();
                            listener.updateMe(String.valueOf(Long.parseLong(Main.updatedBalance) + Long.parseLong(Main.numberHolder)));
                        }
                    }
                });


                one.addActionListener(new ActionListener() {
                    @Override
                    public
                    void actionPerformed(ActionEvent e) {
                        enteredNumber.setText(enteredNumber.getText() + "1");
                    }
                });

                two.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enteredNumber.setText(enteredNumber.getText() + "2");
                    }
                });

                three.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enteredNumber.setText(enteredNumber.getText() + "3");
                    }
                });

                four.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enteredNumber.setText(enteredNumber.getText() + "4");
                    }
                });

                five.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enteredNumber.setText(enteredNumber.getText() + "5");
                    }
                });

                six.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enteredNumber.setText(enteredNumber.getText() + "6");
                    }
                });

                seven.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enteredNumber.setText(enteredNumber.getText() + "7");
                    }
                });

                eight.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enteredNumber.setText(enteredNumber.getText() + "8");
                    }
                });

                nine.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enteredNumber.setText(enteredNumber.getText() + "9");
                    }
                });

                zero.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enteredNumber.setText(enteredNumber.getText() + "0");
                    }
                });

                reset.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        enteredNumber.setText(null);
                    }
                });
    }
}