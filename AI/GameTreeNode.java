/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public class GameTreeNode {

    private ArrayList<GameTreeNode> child;
    private ArrayList<GameTreeNode> siblings;
    private GameTreeNode parent;
    private CheckersMove myBoard;
    private boolean hasParent = false;
    private boolean hasChild = false;
    private byte[][] boardAfter;

    public GameTreeNode(byte[][] boardAfter) {
        this.boardAfter = boardAfter;
    }

    public GameTreeNode(CheckersMove myBoard, GameTreeNode parent) {
        this.myBoard = myBoard;
        hasParent = true;
        this.parent = parent;
        child = new ArrayList<>();
    }

    public byte[][] getBoardAfter() {
        return boardAfter;
    }

    public void setBoardAfter(byte[][] boardAfter) {
        this.boardAfter = boardAfter;
    }
    
    

    public GameTreeNode getChild(int i) {
        return child.get(i);
    }

    public void addChild(GameTreeNode child) {
        this.child.add(child);
        hasChild = true;
    }

    public ArrayList<GameTreeNode> getChildList() {
        return child;
    }

    public void setChildList(ArrayList<GameTreeNode> child) {
        this.child = child;
        hasChild = true;
    }

    public GameTreeNode getParent() {
        return parent;
    }

    public void setParent(GameTreeNode parent) {
        this.parent = parent;
    }

    public CheckersMove getMyBoard() {
        return myBoard;
    }

    public void setMyBoard(CheckersMove myBoard) {
        this.myBoard = myBoard;
    }

    public boolean hasParent() {
        return hasParent;
    }

    public void setHasParent(boolean hasParent) {
        this.hasParent = hasParent;
    }

    public boolean hasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    public ArrayList<GameTreeNode> getSiblings() {
        return siblings;
    }

    public void setSiblings(ArrayList<GameTreeNode> siblings) {
        this.siblings = siblings;
    }

}
