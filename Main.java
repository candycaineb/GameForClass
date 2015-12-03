
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Caine
 */
public class Main {
    private static CheckersClient _checkersClient;
    //private ServerCommunicator _serverCommunication;
    private static MainMenu _menu = new MainMenu();
    private static CheckersController CC = new CheckersController();
    
    public static void main(String[] args) { 
        final LoginMenu m = new LoginMenu();
        
        m.setVisible(true);
        m.loginBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    if(!"".equals(m.usernameTxt.getText())){
                        _checkersClient = new CheckersClient(m.usernameTxt.getText());
                        SetupClient();
                        try {
                            Thread.sleep(2000);
                            if (!CheckersClient.loginFail){
                              CC.SetClient(_checkersClient);
                              m.dispatchEvent(new WindowEvent(m, WindowEvent.WINDOW_CLOSING));
                            }else{
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                } });
        //_menu.CreateMainMenu();
       _menu.CreateMainMenu();
     ////CREATE GUI
        //CheckerBoard board = new CheckerBoard();

    }
    
    public static void SetupClient()
    {
      _checkersClient.connectionOK();
    }
    
}
