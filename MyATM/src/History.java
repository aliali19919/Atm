import javax.swing.*;
import java.awt.*;

public class History extends JFrame {
    public History(String title) {
        super(title);
    }

    public void Run() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setSize(1000, 1000);
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setVisible(true);

                frame.setLayout(new GridLayout(5, 1));

                JTextArea first = new JTextArea("first");
                first.setEditable(false);

                JTextArea second = new JTextArea("second");
                second.setEditable(false);

                JTextArea third = new JTextArea("third");
                third.setEditable(false);

                JTextArea fourth = new JTextArea("fourth");
                fourth.setEditable(false);

                JTextArea fifth = new JTextArea("fifth");
                fifth.setEditable(false);

                frame.add(first);
                frame.add(second);
                frame.add(third);
                frame.add(fourth);
                frame.add(fifth);

                int size = Main.user.transactionHistory.size();
                System.out.println(size);
                if (size < 5) {
                    switch (size) {
                        case 1:
                            first.setText(Main.user.transactionHistory.get(0));
                            break;
                        case 2:
                            first.setText(Main.user.transactionHistory.get(1));
                            second.setText(Main.user.transactionHistory.get(0));
                            break;
                        case 3:
                            first.setText(Main.user.transactionHistory.get(2));
                            second.setText(Main.user.transactionHistory.get(1));
                            third.setText(Main.user.transactionHistory.get(0));
                            break;
                        case 4:
                            first.setText(Main.user.transactionHistory.get(3));
                            second.setText(Main.user.transactionHistory.get(2));
                            third.setText(Main.user.transactionHistory.get(1));
                            fourth.setText(Main.user.transactionHistory.get(0));
                            break;
                    }
                } else {
                    first.setText(Main.user.transactionHistory.get(4));
                    second.setText(Main.user.transactionHistory.get(3));
                    third.setText(Main.user.transactionHistory.get(2));
                    fourth.setText(Main.user.transactionHistory.get(1));
                    fifth.setText(Main.user.transactionHistory.get(0));
                }

            }
        });
    }
}