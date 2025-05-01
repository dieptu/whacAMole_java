import java.awt.*;
import javax.swing.*;

public class WhacAMole {
    int boardWidth = 600;
    int boardHeight = 650;

    JFrame frame = new JFrame("Mario: Whac A Mole");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JButton[] boards = new JButton[9];


    public WhacAMole() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Score: 0");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3,3));
        //boardPanel.setBackground(Color.black);
        frame.add(boardPanel);

        for (int i = 0; i<9 ; i++){
            JButton tile = new JButton();;
            boards[i] = tile;
            boardPanel.add(tile);
        }

    }
    

    
}
