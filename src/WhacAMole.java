
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class WhacAMole {
    int boardWidth = 600;
    int boardHeight = 650;

    JFrame frame = new JFrame("Mario: Whac A Mole");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();
    JButton[] boards = new JButton[9];

    ImageIcon moleIcon;
    ImageIcon plantIcon;
    JButton currMoleTile;
    JButton currPlantTile;

    Random random = new Random();
    Timer setMoleTimer;
    Timer setPlantTimer;
    int score = 0;

    public WhacAMole() {
        
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

        //plantIcon = new ImageIcon(getClass().getResource("./piranha.png"));
        Image plantImg = new ImageIcon(getClass().getResource("./piranha.png")).getImage();
        plantIcon = new ImageIcon(plantImg.getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH));

        Image moleImg = new ImageIcon(getClass().getResource("./monty.png")).getImage();
        moleIcon = new ImageIcon(moleImg.getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH));


        for (int i = 0; i<9 ; i++){
            JButton tile = new JButton();;
            boards[i] = tile;
            boardPanel.add(tile);
            tile.setFocusable(false);
            //tile.setIcon(moleIcon);
            tile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    JButton tile = (JButton)e.getSource();
                    if(tile == currMoleTile){
                        score += 10;
                        textLabel.setText("Score: " + Integer.toString(score));
                    }
                    else if (tile == currPlantTile){
                        textLabel.setText("Game Over!! Score: " + Integer.toString(score));
                        setMoleTimer.stop();
                        setPlantTimer.stop();
                        for (int i = 0;  i< 9; i++){
                            boards[i].setEnabled(false);
                        }
                    }
                }
            });
        }

        setMoleTimer = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(currMoleTile != null){
                    currMoleTile.setIcon(null);
                    currMoleTile = null;
                }
                int num = random.nextInt(9);
                JButton tile = boards[num];

                //make sure that the plan tile is not in confirm with the new tile for the mole
                if(currPlantTile == tile) return;

                currMoleTile = tile;
                currMoleTile.setIcon(moleIcon);
            }
        });

        setPlantTimer = new Timer(1500, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(currPlantTile != null){
                    currPlantTile.setIcon(null);
                    currPlantTile = null;
                }
                int num = random.nextInt(9);
                JButton tile = boards[num];

                if(currMoleTile == tile) return;

                currPlantTile = tile;
                currPlantTile.setIcon(plantIcon);
            }
        });

        setMoleTimer.start();
        setPlantTimer.start();
        frame.setVisible(true);

    }
    

    
}
