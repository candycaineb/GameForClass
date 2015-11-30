
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MainMenu {

    static MessagesMenu MessageMenu;
    static MainScreen mainMenu;
	MainMenu(){
     
        }
        public void CreateMainMenu(){
            mainMenu = new MainScreen();//JFrame("Checkers Main Menu")
            mainMenu.setResizable(false);
            mainMenu.setVisible(true);  
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
        public void UpdateMessages(){
            if (MessageMenu != null){
                MessageMenu.Update();
            }
        }
        public void UpdateMainMenu(){
           mainMenu.Update();   
        }
        
}