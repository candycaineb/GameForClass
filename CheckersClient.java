
import Interfaces.CheckersClientInterface;
import Interfaces.ServerInterface;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Caine
 */
public class CheckersClient implements CheckersClientInterface{
    private ServerCommunicator _serverCommunication;
    CheckersClient(){
        
        _serverCommunication = new ServerCommunicator(this);
    }
    @Override
    public void connectionOK() {
        _serverCommunication.connectToServer("192.168.56.1", "Caine");
    }

    @Override
    public void youInLobby() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void youLeftLobby() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void newMsg(String user, String msg, boolean pm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void usersInLobby(String[] users) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void nowJoinedLobby(String user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void nowLeftLobby(String user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void newTable(int tid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void joinedTable(int tid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alertLeftTable() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void gameStart() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void colorBlack() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void colorRed() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void oppMove(int fr, int fc, int tr, int tc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void curBoardState(int tid, byte[][] boardState) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void youWin() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void youLose() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void onTable(int tid, String blackSeat, String redSeat) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void tableList(int[] tids) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void yourTurn() {
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
    public void illegalMove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void tableFull() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void tblNotExists() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void gameNotCreatedYet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void notYourTurn() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void notObserving() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void oppNotReady() {
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
    public void oppLeftTable() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void notInLobby() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
