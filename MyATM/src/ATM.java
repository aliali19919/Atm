import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ATM extends JFrame implements Listener{
    private static String title;
    public JFrame frame;
    JTextArea displayedTextArea;

    public ATM(String title) {
        ATM.title = title;
    }

    public void Run(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                frame = new JFrame(title);
                frame.setSize(1000, 1000);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                //set layout manager
                frame.setLayout(new GridBagLayout());
                GridBagConstraints container = new GridBagConstraints();

                //create swing component
                displayedTextArea = new JTextArea();
                displayedTextArea.setEditable(false);
                displayedTextArea.setText(Main.user.balance);

                JButton withDrawButton = new JButton("Withdraw");
                withDrawButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        NumberPad numberPad = new NumberPad(ATM.this,"Number Pad");
                        numberPad.Run(1);
                    }
                });

                JButton depositButton = new JButton("Deposit");
                depositButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        NumberPad numberPad = new NumberPad(ATM.this,"Number Pad");
                        numberPad.Run(2);
                    }
                });

                JButton balanceInquireButton = new JButton("Balance Inquire");
                balanceInquireButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        displayedTextArea.setText(Main.updatedBalance);
                    }
                });

                JButton historyButton = new JButton("History");
                historyButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        History history = new History("History");
                        history.Run();
                    }
                });

                // FIRST ROW
                container.weightx = 0.1;
                container.weighty = 0.1;
                container.gridx = 0;
                container.gridy = 0;
                frame.add(displayedTextArea, container);

                // SECOND ROW

                container.weightx = 0.1;
                container.weighty = 0.1;
                container.gridx = 0;
                container.gridy = 1;
                container.fill = GridBagConstraints.BOTH;
                frame.add(withDrawButton, container);

                container.gridx = 1;
                container.gridy = 1;
                container.fill = GridBagConstraints.BOTH;
                frame.add(depositButton, container);

                // THIRD ROW
                container.weightx = 0.1;
                container.weighty = 0.1;
                container.gridx = 0;
                container.gridy = 2;
                container.fill = GridBagConstraints.BOTH;
                frame.add(balanceInquireButton, container);

                container.gridx = 1;
                container.gridy = 2;
                container.fill = GridBagConstraints.BOTH;
                frame.add(historyButton, container);


            }
        });
    }

    @Override
    public void updateMe(String value) {
        String transactionHistory;
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String timeString = time.format(new Date());
        Long diff = Long.parseLong(value) - Long.parseLong(Main.updatedBalance);
        if (diff <= 0){
            transactionHistory = "Withdraw: " + Math.abs(diff) + "\n" + timeString;
        }else {
            transactionHistory = "Deposit: " + diff + "\n" + timeString;
        }
        Main.user.transactionHistory.add(transactionHistory);
        displayedTextArea.setText (value);
        Main.updatedBalance = value;
    }
}
