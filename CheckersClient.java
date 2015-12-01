
import Interfaces.CheckersClientInterface;
import Interfaces.ServerInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Caine
 */
public class CheckersClient implements CheckersClientInterface{
    public ServerCommunicator _serverCommunication;
    public String _username;

    private ArrayList<String> _users = new ArrayList<>();
    private static CheckersController CC = new CheckersController();

    
    CheckersClient(String uname){
        _username = uname;
        _serverCommunication = new ServerCommunicator(this);
    }
    
    
    @Override
    public void connectionOK() {
        
        _serverCommunication.connectToServer("192.168.56.1", _username);
    }

    @Override
    public void youInLobby() {///////////////////////////////////////////////
        System.out.println("Congratulations, you have just joined the lobby");
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void youLeftLobby() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void newMsg(String user, String msg, boolean pm) {
        if (!pm){
          //_serverCommunication.sendMsg_All(msg);//if pm = false
            CC.UpdatePublicForum(user, msg);
        }
        else{//Private Msg
            
        }
        
       // throw new UnsupportedOperationException("Not supported yet.");
        
    }

    @Override
    public void usersInLobby(String[] users) {
        System.out.println("The current users in the lobby: ");
        _users.removeAll(_users);
        for( int t = 0; t < users.length; t++){
           CC.AddClient(users[t]);
           
        }
    }

    @Override
    public void nowJoinedLobby(String user) {///////////////////////////////////////////////
        //throw new UnsupportedOperationException("Not supported yet.");
        CC.AddClient(user);
    }

    @Override
    public void nowLeftLobby(String user) {///////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void newTable(int tid) {///////////////////////////////////////////////
        //_serverCommunication.makeTable(_username);
       
        CC.AddTable(tid);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void joinedTable(int tid) {///////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alertLeftTable() {///////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void gameStart() {/////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void colorBlack() {/////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void colorRed() {/////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void oppMove(int fr, int fc, int tr, int tc) {/////////////////////////////////////////////
        //_serverCommunication.move(fr, fc, tr, tc);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void curBoardState(int tid, byte[][] boardState) {/////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void youWin() {/////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void youLose() {/////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onTable(int tid, String blackSeat, String redSeat) {/////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void tableList(int[] tids) {/////////////////////////////
        for( int t = 0; t < tids.length; t++){
           CC.AddTable(tids[t]);
        }
    }

    @Override
    public void yourTurn() {/////////////////////////////////////////////
        //int fr = 0, fc = 0, tr = 0, tc = 0;
        
        //_serverCommunication.move(_username, fr, fc, tr, tc);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void nowObserving(int tid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void stoppedObserving(int tid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void networkException(String msg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void nameInUseError() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void nameIllegal() {
        
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void illegalMove() {/////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void tableFull() {/////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void tblNotExists() {/////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void gameNotCreatedYet() {/////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void notYourTurn() {/////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void notObserving() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void oppNotReady() {/////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void errorInLobby() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void badMessage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void oppLeftTable() {/////////////////////////////////////////////
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void notInLobby() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void createTable(){
        _serverCommunication.makeTable(_username);
    }
}
