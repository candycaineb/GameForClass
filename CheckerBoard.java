/**
 * Created by benwinks on 11/18/15.
 */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class CheckerBoard extends JPanel {
    private JFrame gameFrame = new JFrame();
    private JPanel boardContainer = new JPanel();
    private JPanel messageBoxContainer = new JPanel();
    private JPanel observerContainer = new JPanel();
    private JPanel messageContainer = new JPanel();
    private JPanel overLordContainer = new JPanel();

    public JTextArea observerArea = new JTextArea("Observers Pane", 20, 10);
    private final int numberOfSquaresInRow = 8;
    private static JPanel[][] gameTiles;
    private int checkerBoardHeight, checkerBoardWidth;
    private static Color black = new Color(0, 0, 0);
    private static Color red = new Color(255, 0, 0);
    private ImageIcon redPiece; //= new ImageIcon("Images/redPiece.png");
    private ImageIcon blackPiece;// = new ImageIcon("Images/blackPiece.png");
    
    private ImageIcon redKing; //= new ImageIcon("Images/redKing.png");
    private ImageIcon blackKing;// = new ImageIcon("Images/blackKing.png");

    private JButton QuitBtn = new JButton("Quit");
    private static CheckersController CC = new CheckersController(); 
    private static JLabel vsLbl = new JLabel("VS.");
     private static JLabel moveLbl = new JLabel("Waiting to start Game..", JLabel.CENTER);

    public CheckerBoard() {
        
        checkerBoardHeight = 400;
        checkerBoardWidth = 400;
        boardContainer.setSize(new Dimension(checkerBoardWidth, checkerBoardHeight));
        overLordContainer.setSize(new Dimension(500, 500));
        gameFrame.setSize(new Dimension((600), (600)));
        gameTiles = new JPanel[numberOfSquaresInRow][numberOfSquaresInRow];
        this.setSize(checkerBoardHeight, checkerBoardWidth);
        GridLayout boardLayout = new GridLayout(numberOfSquaresInRow, numberOfSquaresInRow);
        FlowLayout messageBoxLayout = new FlowLayout();
        BorderLayout overLordLayout = new BorderLayout();
        overLordContainer.setLayout(overLordLayout);
        observerContainer.setLayout(new BorderLayout());
        boardContainer.setLayout(boardLayout);
        messageContainer.setLayout(messageBoxLayout);
        gameFrame.getContentPane().setLayout(new BoxLayout(gameFrame.getContentPane(), BoxLayout.PAGE_AXIS));
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Images/redPiece.png"));
        } catch (IOException e) {}
        Image dimg = img.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
        redPiece = new ImageIcon(dimg);
        
        try {
            img = ImageIO.read(new File("Images/blackPiece.png"));
        } catch (IOException e) {}
        dimg = img.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
        blackPiece = new ImageIcon(dimg);
        
        try {
            img = ImageIO.read(new File("Images/redKing.png"));
        } catch (IOException e) {}
        dimg = img.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
        redKing = new ImageIcon(dimg);
        
        try {
            img = ImageIO.read(new File("Images/blackKing.png"));
        } catch (IOException e) {}
        dimg = img.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
        blackKing = new ImageIcon(dimg);
        
        makeCheckerBoard();

        QuitBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    CC.LeaveTable();
                } });
    }
    public void SetVisible(boolean b){
        gameFrame.setVisible(b);
    }
    
    public void Update(){
        //TODO: Update observer panel
        int tid = CheckersController.atTable;
        ArrayList<String> players = CheckersController.PlayersOnTbl.get(tid);
        String p1 = "",p2 = "";
       if ( players.size()>= 1){
        p1 = players.get(0);
       }
       if (players.size() == 2){
           p2 = players.get(1);
       }
       String vsLblText = "Table ID: " + tid + " Black: " + p1 + " vs Red: " + p2;
        moveLbl.setText("Waiting to start Game");
        
        if (CheckersController.gameReady){
            if (CheckersController.yourTurn){
                vsLblText += " ... Your Turn!";
                moveLbl.setText("Select a checker to move it");
            }else{
                vsLblText += " ... Opponents Turn!";
                moveLbl.setText("");
            }
            vsLblText += " You are: "+CheckersController.checkerColor;
            boardContainer.removeAll();
            for (int t = 0; t<8; t++){
                for (int s = 0; s < 8; s++){
                    final int row = t;
                    final int column = s;
                    Color tileColor;
                    JPanel boardTile = new JPanel();
                    JLabel piece = null;
                    if ((t + s) % 2 == 1) {
                        tileColor = black;
                    }
                    else {
                        tileColor = red;
                    }
                    if (CheckersController.boardState[t][s] == 1){
                        piece = new JLabel("", blackPiece, JLabel.CENTER);
                        boardTile.add(piece);
                    }else if(CheckersController.boardState[t][s] == 2){
                        piece = new JLabel("", redPiece, JLabel.CENTER);
                        boardTile.add(piece);
                    }else if(CheckersController.boardState[t][s] == 3){
                        piece = new JLabel("", blackKing, JLabel.CENTER);
                        boardTile.add(piece);
                    }else if(CheckersController.boardState[t][s] == 4){
                        piece = new JLabel("", redKing, JLabel.CENTER);
                        boardTile.add(piece);
                    }
                    boardTile.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent mouseEvent) {
                        if (CheckersController.yourTurn){
                            CC.YourTurn(row, column);
                            if (CheckersController._fromCol == -1){
                                moveLbl.setText("Select a checker to move it");
                            }else{
                               moveLbl.setText(" Select an empty space to move your checker");
                            }
                        }
                    }

                        @Override
                    public void mousePressed(MouseEvent mouseEvent) {}
                    @Override
                    public void mouseReleased(MouseEvent mouseEvent) {}
                    @Override
                    public void mouseEntered(MouseEvent mouseEvent) {}
                    @Override
                    public void mouseExited(MouseEvent mouseEvent) {}
                    });
                    boardTile.setBackground(tileColor);
                    gameTiles[t][s] = boardTile;
                    boardContainer.add(boardTile);
                }
            }
                
        }
        vsLbl.setText(vsLblText);
    }
    
    public void makeCheckerBoard(){
        Color tileColor;

        for (int rowIndex = 0; rowIndex < numberOfSquaresInRow; rowIndex++) {
            for (int columnIndex = 0; columnIndex < numberOfSquaresInRow; columnIndex++) {
                final int row = rowIndex;
                final int column = columnIndex;
                JPanel boardTile = new JPanel();
                JLabel piece = null;
                if ((rowIndex + columnIndex) % 2 == 1) {

                    tileColor = black;
                }
                else {
                    tileColor = red;
                }

                if (rowIndex % 2 == 0 && columnIndex % 2 == 1 && rowIndex < 3) {
                   // System.out.println("HEYYYY");
                    
                    piece = new JLabel("", blackPiece, JLabel.CENTER);
                    piece.setSize(10, 10);
                    boardTile.add(piece);
                }

                else if (rowIndex % 2 == 1 && columnIndex % 2 == 0 && rowIndex < 3) {
                    piece = new JLabel("", blackPiece, JLabel.CENTER);
                    boardTile.add(piece);
                }

                else if (rowIndex % 2 == 0 && columnIndex % 2 == 1 && rowIndex > 4) {
                    piece = new JLabel("", redPiece, JLabel.CENTER);
                    boardTile.add(piece);
                }

                else if (rowIndex % 2 == 1 && columnIndex % 2 == 0 && rowIndex > 4) {
                    piece = new JLabel("", redPiece, JLabel.CENTER);
                    boardTile.add(piece);
                }

                boardTile.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent mouseEvent) {
                        System.out.println("Hey, you clicked row " + row + " column " + column);
                    }

                    @Override
                    public void mousePressed(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mouseExited(MouseEvent mouseEvent) {

                    }
                });
                boardTile.setSize(new Dimension((50), (50)));
                boardTile.setBackground(tileColor);
                gameTiles[rowIndex][columnIndex] = boardTile;
                boardContainer.add(boardTile);
            }
        }
        boardContainer.setMinimumSize(new Dimension(checkerBoardWidth, checkerBoardHeight));
        boardContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        observerArea.setEditable(false);
        overLordContainer.add(moveLbl, BorderLayout.NORTH);
        observerContainer.add(observerArea);
        
        messageBoxContainer.add(QuitBtn);
        messageContainer.add(vsLbl);
        
        overLordContainer.add(boardContainer, BorderLayout.CENTER);
        overLordContainer.add(messageContainer, BorderLayout.SOUTH);
        overLordContainer.add(messageBoxContainer, BorderLayout.EAST);
        overLordContainer.add(observerContainer, BorderLayout.WEST);
        gameFrame.add(overLordContainer);
        overLordContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //gameFrame.pack();
        
        gameFrame.setResizable(false);
        gameFrame.setVisible(true);

    }



}
