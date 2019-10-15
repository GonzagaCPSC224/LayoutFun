import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DiceView extends JFrame {
    // task: create a JFrame with a Y_AXIS boxlayout
    // that has two X_AXIS boxlayouts
    // inside have 3 labels and one button
    // click the "roll!" button, and update the first two
    // labels to show random die rolls in [1, 6]
    // update the third label to show the sum
    // ______________
    //|  5       3   |
    //
    //| Roll!   Sum:8|
    // _______________

    public DiceView() {
        super("Dice Thrower");

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 500));
        setupUI();
        pack();

    }

    private void setupUI() {
        // getContentPane() returns a Container reference
        // we can cast this Container to a JPanel
        JPanel panel = (JPanel) getContentPane();
        // by default, the contentPane has a BorderLayout()
        // 1. BoxLayout
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
//        JPanel topPanel = new JPanel();
//        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
//        JLabel die1Label = new JLabel(new ImageIcon("images/Die1.png"));
//        topPanel.add(die1Label);
//        JLabel die2Label = new JLabel(new ImageIcon("images/Die2.png"));
//        topPanel.add(die2Label);
//        panel.add(topPanel);
//
//        JPanel bottomPanel = new JPanel();
//        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
//        JButton rollButton = new JButton("Roll!");
//        bottomPanel.add(rollButton);
//        JLabel sumLabel = new JLabel("Sum: 3");
//        bottomPanel.add(sumLabel);
//        panel.add(bottomPanel);
        // 2. BorderLayout - 5 regions
        //JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        JLabel die1Label = new JLabel(new ImageIcon("images/Die1.png"));
        topPanel.add(die1Label);
        JLabel die2Label = new JLabel(new ImageIcon("images/Die2.png"));
        topPanel.add(die2Label);
        panel.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        JButton rollButton = new JButton("Roll!");
        bottomPanel.add(rollButton);
        JLabel sumLabel = new JLabel("Sum: 3");
        bottomPanel.add(sumLabel);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        //getContentPane().add(panel);

        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int die1 = rand.nextInt(6) + 1;
                int die2 = rand.nextInt(6) + 1;
                die1Label.setText(die1 + "");
                die2Label.setText(die2 + "");
                sumLabel.setText("Sum: " + (die1 + die2));
            }
        });
    }
}
