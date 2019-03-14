import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class SignIn extends JFrame {
    private static String title;

    public SignIn(String title) {
        this.title = title;
    }

    public void Run() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = new JFrame(title);
                frame.setSize(1000, 1000);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);

                frame.setLayout(new GridLayout(2, 1));

                JTextArea cardNumberInput = new JTextArea("Enter Card Number");

                JButton checker = new JButton("Validate!");
                frame.add(cardNumberInput);
                frame.add(checker);

                checker.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String enteredCardNumber = cardNumberInput.getText();
                        if (enteredCardNumber.equals(Main.user.getCardNumber())) {
                            ATM atm = new ATM("ATM");
                            atm.Run();
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid Card Number!");
                        }
                    }
                });
            }
        });
    }

    private void close() {
        WindowEvent windowEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowEvent);
    }
}
