
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
        //client.newMsg(client._username, msg, false);
        client._serverCommunication.sendMsg_All(msg);
        
    }
    public void UpdatePublicForum(String user, String msg){
        PublicMsgs += user + " : "+ msg + "\n";
        MM.UpdateMessages();
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
