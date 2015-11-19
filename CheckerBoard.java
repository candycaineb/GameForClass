/**
 * Created by benwinks on 11/18/15.
 */
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CheckerBoard extends JPanel {
    private JFrame gameFrame = new JFrame();
    private JPanel boardContainer = new JPanel();
    private JPanel messageContainer = new JPanel();
    private JPanel observerContainer = new JPanel();
    private JPanel overLordContainer = new JPanel();
    private JTextField messageBox = new JTextField();
    private JButton sendChatButton = new JButton("Send");
    private JLabel messageLabel = new JLabel("Message:");
    private JTextArea observerArea = new JTextArea("Observers Pane");
    private final int numberOfSquaresInRow = 8;
    private JPanel[][] gameTiles;
    private int checkerBoardHeight, checkerBoardWidth;
    private static Color black = new Color(0, 0, 0);
    private static Color red = new Color(255, 0, 0);


    public CheckerBoard() {
        checkerBoardHeight = 800;
        checkerBoardWidth = 800;
        boardContainer.setSize(new Dimension(checkerBoardWidth, checkerBoardHeight));
        overLordContainer.setSize(new Dimension(1000, 1000));
        gameFrame.setSize(new Dimension((1000), (1000)));
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
                if ((rowIndex + columnIndex) % 2 == 1) {
                    tileColor = black;
                }
                else {
                    tileColor = red;
                }

                JPanel boardTile = new JPanel();
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
        observerContainer.add(observerArea);
        overLordContainer.add(boardContainer, BorderLayout.CENTER);
        overLordContainer.add(messageContainer, BorderLayout.SOUTH);
        overLordContainer.add(observerArea, BorderLayout.EAST);
        gameFrame.add(overLordContainer);
        gameFrame.setVisible(true);




    }

}
