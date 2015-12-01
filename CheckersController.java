
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
    public static CheckersClient client;
    public static String PublicMsgs = "";
    public static Map<String, String> PrivateMsgs = new HashMap<>();
    public static ArrayList tableList = new ArrayList();
    public static Map<Integer, ArrayList<String>> PlayersOnTbl = new HashMap<>();
    public static int atTable = 0;
    public static byte[][] boardState;
    public static boolean gameReady = false;
    public static boolean yourTurn = false;
    public static String checkerColor = "";
    public static int _fromRow = -1;
    public static int _fromCol = -1;
    
    CheckersController(){
        Reset();
    }
    public void SetClient(CheckersClient c){
        client = c;
    }
    public void AddMessageFrame(){
        MM.CreateMessageFrame();
    }
     public void SendPublicMsg(String msg) {
        client._serverCommunication.sendMsg_All(msg);
    }

    public void UpdatePublicForum(String user, String msg) {
        PublicMsgs += user + " : " + msg + "\n";
        MM.UpdateMessages();
    }

    public void SendPrivateMsg(String user, String msg) {
        client._serverCommunication.sendMsg(user, msg);
    }

    public void UpdatePrivateForum(String user, String msg) {
        if (!user.equals(client._username)) {
            String tempMsg = PrivateMsgs.get(user);
            tempMsg += user + " : " + msg + "\n";
            PrivateMsgs.put(user, tempMsg);
            MM.UpdateMessages();
        }
    }
    public void AddClient(String uname){
        PrivateMsgs.put(uname, "");
        MM.UpdateMessages();
    }
    public void RemoveClient(String uname){
        PrivateMsgs.remove(uname);
        MM.UpdateMessages();
    }
    
    public void CreateTable(){
        client._serverCommunication.makeTable(client._username);
    }
    public void AddTable(int tid){
        tableList.add(tid);
        client._serverCommunication.getTblStatus(client._username, tid);
        //MM.UpdateMainMenu();
    }
    public void UpdateTable(int tid, String blk, String red){
        ArrayList<String> nms = new ArrayList<>();
        if (!"-1".equals(blk)){
            nms.add(blk);   
        }
        if (!"-1".equals(red)){
            nms.add(red);
        } 
        if (nms.size() == 2){
            client._serverCommunication.playerReady(client._username);}
            
        PlayersOnTbl.put(tid, nms);
        MM.UpdateMainMenu();
        MM.UpdateCheckersBoard();
    }
    
    public void LeaveTable(){
        client._serverCommunication.leaveTable(client._username);
    }
    public void JoinTable(int tid){
        client._serverCommunication.joinTable(client._username, tid);
       // client._serverCommunication.getTblStatus(client._username, tid);
    }
    public void UpdateBoardState(byte[][] board){
        for (int t=0; t < board.length; t++){
            System.arraycopy(board[t], 0, boardState[t], 0, board[t].length);
        }
        MM.UpdateCheckersBoard();
    }
    public void Reset(){
        atTable = 0;
        _fromRow = -1;
        _fromCol = -1;
        boardState = new byte[][]{
        {0,1,0,1,0,1,0,1},
        {1,0,1,0,1,0,1,0},
        {0,1,0,1,0,1,0,1},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {2,0,2,0,2,0,2,0},
        {0,2,0,2,0,2,0,2},
        {2,0,2,0,2,0,2,0},
        };
        gameReady = false;
        yourTurn = false;
        checkerColor = "";
    }
    
    public void YourTurn(int row, int col){
        if (_fromRow == -1 || _fromCol == -1){
            _fromRow = row;
            _fromCol = col;
        }else{
            client._serverCommunication.move(client._username, _fromRow, _fromCol, row, col);
            _fromRow = -1;
            _fromCol = -1;
        }
    }
}
