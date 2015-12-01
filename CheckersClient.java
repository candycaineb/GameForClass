
import Interfaces.CheckersClientInterface;
import Interfaces.ServerInterface;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
public class CheckersClient implements CheckersClientInterface{
    public ServerCommunicator _serverCommunication;
    public String _username;
    private static MainMenu MM = new MainMenu();
    
    private ArrayList<String> _users = new ArrayList<>();
    private static CheckersController CC = new CheckersController();

    
    CheckersClient(String uname){
        _username = uname;
        _serverCommunication = new ServerCommunicator(this);
    }
    
    
    @Override
    public void connectionOK() {
        
        _serverCommunication.connectToServer("130.108.238.136", _username);
    }

    @Override
    public void youInLobby() {
        System.out.println("Congratulations, you have just joined the lobby");
        MM.SetMainMenuVisible(true);
        MM.SetCheckersBoardVisible(false);
    }

    @Override
    public void youLeftLobby() {///////////////////////////////////////////////
        System.out.println("You left the lobby");
        MM.SetMainMenuVisible(false);
        MM.CreateCheckersBoard();
    }

    @Override
    public void newMsg(String user, String msg, boolean pm) {
        if (!pm){
          //_serverCommunication.sendMsg_All(msg);//if pm = false
            CC.UpdatePublicForum(user, msg);
        }
        else{//Private Msg
            CC.UpdatePrivateForum(user, msg);
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
        System.out.println(user + " has joined the lobby");
        CC.AddClient(user);
    }

    @Override
    public void nowLeftLobby(String user) {///////////////////////////////////////////////
        //throw new UnsupportedOperationException("Not supported yet.");
        System.out.println(user + " has left the lobby");
        CC.RemoveClient(user);
    }

    @Override
    public void newTable(int tid) {///////////////////////////////////////////////
        //_serverCommunication.makeTable(_username);
        System.out.println("New table has been created id: " + tid);
        CC.AddTable(tid);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void joinedTable(int tid) {///////////////////////////////////////////////
        System.out.println("joinedTable " + tid);
        CheckersController.atTable = tid;
        
    }

    @Override
    public void alertLeftTable() {///////////////////////////////////////////////
        System.out.println("alertLeftTable");
        CC.Reset();
    }

    @Override
    public void gameStart() {/////////////////////////////////////////////
        System.out.println("gameStart");
        CheckersController.gameReady = true;
        MM.UpdateCheckersBoard();
    }

    @Override
    public void colorBlack() {/////////////////////////////////////////////
        System.out.println("colorBlack");
        CheckersController.checkerColor = "Black";
    }

    @Override
    public void colorRed() {/////////////////////////////////////////////
        System.out.println("colorRed");
        CheckersController.checkerColor = "Red";
    }

    @Override
    public void oppMove(int fr, int fc, int tr, int tc) {/////////////////////////////////////////////
        //_serverCommunication.move(fr, fc, tr, tc);
        System.out.println("oppMove");
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void curBoardState(int tid, byte[][] boardState) {/////////////////////////////////////////////
        System.out.println("curBoardState");
        if (CheckersController.yourTurn){
            CheckersController.yourTurn = false;
        }
        CC.UpdateBoardState(boardState);
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void youWin() {/////////////////////////////////////////////
        System.out.println("you Win!");
        CheckersController.gameReady = false;
        JFrame f = new JFrame("End Results");
        JLabel l = new JLabel(_username + ", YOU WIN!!!");
        l.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 28));
        f.add(l);
        f.pack();
        f.setVisible(true);
    }

    @Override
    public void youLose() {/////////////////////////////////////////////
        System.out.println(_username + ", you Lose!");
        CheckersController.gameReady = false;
        JFrame f = new JFrame("End Results");
        JLabel l = new JLabel(_username + ", YOU LOSE!!!");
        l.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 28));
        f.add(l);
        f.pack();
        f.setVisible(true);
    }

    @Override
    public void onTable(int tid, String blackSeat, String redSeat) {/////////////////////////////////////////////
        System.out.println("onTable "+tid+ " "+blackSeat+" "+redSeat);
        CC.UpdateTable(tid, blackSeat, redSeat);
    }

    @Override
    public void tableList(int[] tids) {/////////////////////////////
        for( int t = 0; t < tids.length; t++){
            System.out.println("Table added: "+tids[t]);
           CC.AddTable(tids[t]);
        }
    }

    @Override
    public void yourTurn() {/////////////////////////////////////////////
        //int fr = 0, fc = 0, tr = 0, tc = 0;
        CheckersController.yourTurn = true;
        MM.UpdateCheckersBoard();
        System.out.println("Your Turn");
       
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
        //throw new UnsupportedOperationException("Not supported yet.");
        System.out.println("ILLEGAL MOVE!");
        JFrame f = new JFrame("Checkers");
        JLabel l = new JLabel("Illegal move.");
        l.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 28));
        f.add(l);
        f.pack();
        f.setVisible(true);
    }

    @Override
    public void tableFull() {/////////////////////////////////////////////
        System.out.println("tableFull");
        JFrame f = new JFrame("Checkers");
        JLabel l = new JLabel("Table Full.");
        l.setFont(new Font("Serif",  Font.BOLD, 28));
        f.add(l);
        f.pack();
        f.setVisible(true);
    }

    @Override
    public void tblNotExists() {/////////////////////////////////////////////
        System.out.println("tblNotExists");
    }

    @Override
    public void gameNotCreatedYet() {/////////////////////////////////////////////
        System.out.println("gameNotCreatedYet");
    }

    @Override
    public void notYourTurn() {/////////////////////////////////////////////
        System.out.println("notYourTurn");
        CheckersController.yourTurn = false;
    }

    @Override
    public void notObserving() {
        System.out.println("notObserving");
    }

    @Override
    public void oppNotReady() {/////////////////////////////////////////////
        System.out.println("oppNotReady");
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
        System.out.println("oppLeftTable");
        CC.Reset();
    }

    @Override
    public void notInLobby() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
