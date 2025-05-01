import java.awt.*;
import javax.swing.*;

public class WhacAMole {
    int boardWidth = 600;
    int boardHeight = 650;

    JFrame frame = new JFrame("Mario: Whac A Mole");

    public WhacAMole() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }
    

    
}
