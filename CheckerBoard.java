/**
 * Created by benwinks on 11/18/15.
 */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class CheckerBoard extends JPanel {
    private JFrame gameFrame = new JFrame();
    private JPanel boardContainer = new JPanel();
    private JPanel messageBoxContainer = new JPanel();
    private JPanel observerContainer = new JPanel();
    private JPanel messageContainer = new JPanel();
    private JPanel overLordContainer = new JPanel();
    private JTextField messageBox = new JTextField();
    private JButton sendChatButton = new JButton("Send");
    private JLabel messageLabel = new JLabel("Message:");
    private JTextArea observerArea = new JTextArea("Observers Pane", 5, 10);
    private JTextArea messageArea = new JTextArea("Messages", 10, 20);
    private final int numberOfSquaresInRow = 8;
    private JPanel[][] gameTiles;
    private int checkerBoardHeight, checkerBoardWidth;
    private static Color black = new Color(0, 0, 0);
    private static Color red = new Color(255, 0, 0);
    private ImageIcon redPiece = new ImageIcon("Images/redPiece.png");
    private ImageIcon blackPiece = new ImageIcon("Images/blackPiece.png");
    private ImageIcon redKing = new ImageIcon("Images/redKing.png");
    private ImageIcon blackKing = new ImageIcon("Images/blackKing.png");




    public CheckerBoard() {
        checkerBoardHeight = 800;
        checkerBoardWidth = 800;
        boardContainer.setSize(new Dimension(checkerBoardWidth, checkerBoardHeight));
        overLordContainer.setSize(new Dimension(1000, 1000));
        gameFrame.setSize(new Dimension((1200), (1200)));
        gameTiles = new JPanel[numberOfSquaresInRow][numberOfSquaresInRow];
        this.setSize(checkerBoardHeight, checkerBoardWidth);
        GridLayout boardLayout = new GridLayout(numberOfSquaresInRow, numberOfSquaresInRow);
        FlowLayout messageBoxLayout = new FlowLayout();
        BorderLayout overLordLayout = new BorderLayout();
        overLordContainer.setLayout(overLordLayout);
        boardContainer.setLayout(boardLayout);
        messageContainer.setLayout(messageBoxLayout);
        messageBox.setColumns(30);
        gameFrame.getContentPane().setLayout(new BoxLayout(gameFrame.getContentPane(), BoxLayout.PAGE_AXIS));
        makeCheckerBoard();


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

                    piece = new JLabel("", blackPiece, JLabel.CENTER);
                    piece.setSize(boardTile.getWidth(), boardTile.getHeight());
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
                boardTile.setSize(new Dimension((100), (100)));
                boardTile.setBackground(tileColor);
                gameTiles[rowIndex][columnIndex] = boardTile;
                boardContainer.add(boardTile);
            }
        }
        boardContainer.setMinimumSize(new Dimension(checkerBoardWidth, checkerBoardHeight));
        boardContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        messageContainer.add(messageLabel);
        messageContainer.add(messageBox);
        messageContainer.add(sendChatButton);
        messageBoxContainer.add(messageArea);
        observerContainer.add(observerArea);
        overLordContainer.add(boardContainer, BorderLayout.CENTER);
        overLordContainer.add(messageContainer, BorderLayout.SOUTH);
        overLordContainer.add(messageBoxContainer, BorderLayout.EAST);
        overLordContainer.add(observerArea, BorderLayout.WEST);
        gameFrame.add(overLordContainer);
        overLordContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //gameFrame.pack();
        gameFrame.setVisible(true);

    }



}
