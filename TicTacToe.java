import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class TicTacToe {
    private static JFrame frame;
    private static JPanel panel;
    private static JButton[] buttons = new JButton[9];
    private static boolean KohTurn = true;

    

    public static void main(String[] args) {
        frame = new JFrame("CSCAMP - KOHKAE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 80));
            buttons[i].setBackground(Color.BLACK);
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    if (KohTurn) {
                        button.setText("KOH");
                        button.setBackground(Color.WHITE);
                    } else {
                        button.setText("KAE");
                        button.setBackground(Color.RED);
                    }
                    button.setEnabled(false);
                    KohTurn = !KohTurn;
                    checkForWinner();
                }
            });
            panel.add(buttons[i]);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(1920, 1080);

        Scanner sc = new Scanner(System.in);
        System.out.println(": Are you ready to play? (Y)");
        String play = sc.nextLine();
        sc.close();
        switch (play) {
            case "Y":
                System.out.println("Good, I'll sent you to play KOHKAE GAME!!!");
                break;
            case"y":
                System.out.println("Good, I'll sent you to play KOHKAE GAME!!!");
                break;
            case "Yes":
                System.out.println("Good, I'll sent you to play KOHKAE GAME!!!");
                break;
            case "yes":
                System.out.println("Good, I'll sent you to play KOHKAE GAME!!!");
                break;
            default:
                System.out.println("Okay then, Bye");
                System.exit(0) ;
                break;
        }

        frame.setVisible(true);
    }

    public static void checkForWinner() {
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (buttons[i].getText().equals(buttons[i + 1].getText()) && buttons[i].getText().equals(buttons[i + 2].getText()) && !buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, buttons[i].getText() + " Wins !");
                resetGame();
                return;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(buttons[i + 3].getText()) && buttons[i].getText().equals(buttons[i + 6].getText()) && !buttons[i].isEnabled()) {
                JOptionPane.showMessageDialog(frame, buttons[i].getText() + " Wins !");
                resetGame();
                return;
            }
        }

        // Check diagonals
        if (buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[0].isEnabled()) {
            JOptionPane.showMessageDialog(frame, buttons[0].getText() + " Wins !");
            resetGame();
            return;
        }
        if (buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].isEnabled()) {


            JOptionPane.showMessageDialog(frame, buttons[2].getText() + " Wins !");
            resetGame();
            return;
        }

        // Check for tie
        boolean tie = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].isEnabled()) {
                tie = false;
                break;
            }
        }
        if (tie) {
            JOptionPane.showMessageDialog(frame, "Tie Game !");
            resetGame();
        }
    }

    public static void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
            buttons[i].setBackground(Color.BLACK);
        }
        KohTurn = true;
    }
}
