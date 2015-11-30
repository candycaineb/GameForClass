

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
    private static MainMenu _menu = new MainMenu();
    private static CheckersController CC = new CheckersController();
    
    public static void main(String[] args) { 
        _menu.CreateMainMenu();
       _checkersClient = new CheckersClient("Caine");

       CC.SetClient(_checkersClient);
        SetupClient();
     ////CREATE GUI
       // CheckerBoard board = new CheckerBoard();

    }
    public static void SetupClient()
    {
      _checkersClient.connectionOK();
    }
    
}
