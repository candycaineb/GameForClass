
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class MainMenu {
///Caines testaroo!
    public static MessagesMenu MessageMenu;
    public static MainScreen mainMenu;
    static  CheckerBoard board;
	MainMenu(){
     
        }
        public void CreateMainMenu(){
            mainMenu = new MainScreen();//JFrame("Checkers Main Menu")
            mainMenu.setResizable(false);
           // mainMenu.setVisible(true);  
        }
        public void SetMainMenuVisible(boolean b){
            mainMenu.setVisible(b); 
        }
        public void CreateMessageFrame(){
            if (MessageMenu != null && MessageMenu.isVisible() == true)
                return;
            JFrame f = new JFrame("Messages");
            MessageMenu = new MessagesMenu();
            f.add(new MessagesMenu());
            f.pack();
            f.setResizable(false);
            f.setVisible(true);
            
        }
        public void CreateCheckersBoard(){
            board = new CheckerBoard();
            board.setVisible(true);
        }
        public void UpdateCheckersBoard(){
            board.Update();
        }
        public void SetCheckersBoardVisible(boolean b){
           // board.getTopLevelAncestor().setVisible(b);
            board.SetVisible(b);
        }
        public void UpdateMessages(){
            if (MessageMenu != null){
                MessageMenu.Update();
            }
        }
        public void UpdateMainMenu(){
           mainMenu.Update();   
        }
        public void observation(int tid, boolean b, String user){
            if(b==true){
                CreateCheckersBoard();
                SetCheckersBoardVisible(b);
                //board.observerArea.setText(user+"\n");
            } else {
                SetCheckersBoardVisible(b);
                CheckersController.tid = -1;
               // board.observerArea.setText(user + " has stopped\nwatching table " + tid + "\n");
            }
        }  
}