
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private ServerCommunicator _serverCommunication;
   // private static MainMenu _menu = new MainMenu();
    
    public static void main(String[] args) { 
       _checkersClient = new CheckersClient("Caine");
        SetupClient();
     ////CREATE GUI
        _checkersClient.AddActionListeners();
    }
    public static void SetupClient()
    {
      _checkersClient.connectionOK();
    }
    
}
