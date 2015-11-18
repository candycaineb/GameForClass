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
    public static void main(String[] args) { 
       _checkersClient = new CheckersClient();
        SetupClient();
     
    }
    public static void SetupClient()
    {
      _checkersClient.connectionOK();
    }
    
}
