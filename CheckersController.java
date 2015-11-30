
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Caine
 */
public class CheckersController {
    private static MainMenu MM = new MainMenu();
    private static CheckersClient client;
    public static String PublicMsgs = "";
    public static Map<String, String> PrivateMsgs = new HashMap<>();
    public static ArrayList tableList = new ArrayList();
    
    CheckersController(){
        
    }
    public void SetClient(CheckersClient c){
        client = c;
    }
    public void AddMessageFrame(){
        MM.CreateMessageFrame();
    }
    public void SendPublicMsg(String msg){
        client.newMsg(client._username, msg, false);
        PublicMsgs += client._username + " : "+ msg + "\n";
    }
    public void AddClient(String uname){
        PrivateMsgs.put(uname, "");
        MM.UpdateMessages();
    }
    public void CreateTable(){
        client.createTable();
    }
    public void AddTable(int tid){
        tableList.add(tid);
        MM.UpdateMainMenu();
    }
}
