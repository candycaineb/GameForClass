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
public class GameTree {

    public Difficulty difficulty;
    // private Board[][] gameBoards;
    private ArrayList<CheckersMove> gameBoards;
    private GameTreeNode original;
    private GameTreeNode child;
    private GameTreeNode parent;
    private GameTreeNode current;
    private byte[][] currentBoard;
    private static int numRun = 0;

    private ArrayList<GameTreeNode> solutions;

    public GameTree(Difficulty d) {
        difficulty = d;

        switch (difficulty) {
            case EASY:
                //gameBoards = new ArrayList<Board>[2];
                break;
            case MEDIUM:
                break;
            case HARD:
                break;
        }
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

//    public Board[][] getGameBoards() {
//        return gameBoards;
//    }
//      
//    public void setGameBoards(Board[][] gameBoards) {
//        this.gameBoards = gameBoards;
//    }
    public CheckersMove getBestMove(byte[][] currentBoard, Difficulty difficulty, boolean isRed) {
        original = new GameTreeNode(currentBoard);
        solutions = new ArrayList<>();

        System.out.println("Move in list: Original");
        for (int k = 0; k < 8; k++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(currentBoard[k][j] + "     ");

            }
            System.out.println("\n");
        }

        getBestMove(original, -1, difficulty, solutions, isRed);

//        getBottomNodes(GameTreeNode root, ArrayList<GameTreeNode> nodes) {
//    public Board findSolution(ArrayList<GameTreeNode> nodes, boolean isRed) {
        //return .getMyBoard();
        return findSolution(getBottomNodes(original, new ArrayList<GameTreeNode>()), isRed);
    }

    public void getBestMove(GameTreeNode node, int iteration,
            Difficulty difficulty, ArrayList<GameTreeNode> solutions, Boolean isRed) {
        // Board nextMove = new Board();
        CheckersMove[] list = getAllPossibleMoves(node.getBoardAfter(), isRed);

        ArrayList<GameTreeNode> nodes = new ArrayList<>();
        ArrayList<ArrayList<GameTreeNode>> siblings = new ArrayList<>();
        CheckersData nextPlace;

        numRun++;
        System.out.println(numRun);

        if (numRun == 5) {
            System.out.println("Debug Time");
        }

        // current = node;
        iteration++;
        switch (difficulty) {
            case EASY:

                if (iteration < 2) {

                    for (int i = 0; i < list.length; i++) {
                        nodes.add(new GameTreeNode(list[i], node));//create a list of nodes at the current level
                        //  siblings.add(new ArrayList<>());//create a list of siblings for each node
                        //   for (int j = 0; j < list.size(); j++) {
                        //       if (j != i) {
                        //           siblings.get(i).add(nodes.get(j));//populate list of siblings with every node at current level except for itself
                        //        }
                        //}
                        //nodes.get(i).setSiblings(siblings.get(i));
                        // node.addChild(nodes.get(i));
                        nextPlace = new CheckersData(node.getBoardAfter());
                        nextPlace.makeMove(list[i]);
                        nodes.get(i).setBoardAfter(nextPlace.getBoard());
                    }

                    for (int i = 0; i < nodes.size(); i++) {
                        System.out.println("Move in list: " + i);
                        for (int k = 0; k < 8; k++) {
                            for (int j = 0; j < 8; j++) {
                                System.out.print(nodes.get(i).getBoardAfter()[k][j] + "     ");

                            }
                            System.out.println("\n");
                        }
                        System.out.print(nodes.get(i).getMyBoard().fromRow + ", ");
                        System.out.println(nodes.get(i).getMyBoard().fromCol);
                        System.out.print(nodes.get(i).getMyBoard().toRow + ", ");
                        System.out.println(nodes.get(i).getMyBoard().toCol);

                    }

                    node.setChildList(nodes);

                    for (int j = 0; j < list.length; j++) {
                        if(iteration == 1){
                            getBestMove(nodes.get(j), iteration, difficulty, solutions, true);
                        }else{
                            getBestMove(nodes.get(j), iteration, difficulty, solutions, false);
                        }
                        
                    }
                } else {
//                    for (int j = 0; j < list.size(); j++) {
//                        solutions.add(getBestMove(nodes.get(j), iteration, difficulty, solutions));
//                    }
                }
//need to add a return case
                break;
            case MEDIUM:
                if (iteration < 3) {
                    if (iteration < 1) {
                        for (int j = 0; j < list.length; j++) {
                            getBestMove(nodes.get(j), iteration, difficulty, solutions, isRed);
                        }
                    } else {
//                    for (int j = 0; j < list.size(); j++) {
//                        solutions.add(getBestMove(nodes.get(j), iteration, difficulty, solutions));
//                    }
                    }
                }

                break;
            case HARD:
                if (iteration < 5) {
                    if (iteration < 1) {
                        for (int j = 0; j < list.length; j++) {
                            getBestMove(nodes.get(j), iteration, difficulty, solutions, isRed);
                        }
                    } else {
//                    for (int j = 0; j < list.size(); j++) {
//                        solutions.add(getBestMove(nodes.get(j), iteration, difficulty, solutions));
//                    }
                    }
                }

                break;
        }

        //return nextMove;
    }

    public CheckersMove[] getAllPossibleMoves(byte[][] currentBoard, boolean isRed) {
        ArrayList<CheckersMove> list = new ArrayList<>();
        CheckersData newBoard = new CheckersData(currentBoard);
        System.out.println("Move in list: Original Passed");
        for (int k = 0; k < 8; k++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(newBoard.getBoard()[k][j] + "     ");

            }
            System.out.println("\n");
        }
        //newBoard.makeMove(board);
        if (isRed) {
            return newBoard.getLegalMoves(2);
        }

        return newBoard.getLegalMoves(1);
    }

    public ArrayList<GameTreeNode> getBottomNodes(GameTreeNode root, ArrayList<GameTreeNode> nodes) {
        //get a list of of the root node's children
        ArrayList<GameTreeNode> children = root.getChildList();

        //recuresively call for each child in the list
        for (int i = 0; i < children.size(); i++) {
            getBottomNodes(children.get(i), nodes);
        }

        //postorder traversal, if a node doesn't have a child add it to the list
        if (!root.hasChild()) {
            nodes.add(root);
        }

        return nodes;
    }

    public CheckersMove findSolution(ArrayList<GameTreeNode> nodes, boolean isRed) {
        GameTreeNode bestMove = nodes.get(0);
        ArrayList<CheckersData> newBoards = new ArrayList<>();
        int bestIndex = 0;

//        for (int i = 1; i < nodes.size(); i++) {
//            if (isRed) {
//                if (bestMove.getMyBoard().getBlackPieces() > nodes.get(i).getMyBoard().getBlackPieces()) {
//                    bestMove = nodes.get(i);
//                }
//
//            } else {
//                if (bestMove.getMyBoard().getRedPieces() > nodes.get(i).getMyBoard().getRedPieces()) {
//                    bestMove = nodes.get(i);
//                }
//            }
//        }
        for (int i = 0; i < nodes.size(); i++) {
            newBoards.add(new CheckersData(nodes.get(i).getBoardAfter()));
            //newBoards.get(i).makeMove(nodes.get(i).getMyBoard());
        }

        for (int i = 1; i < newBoards.size(); i++) {
            if (isRed) {
                if (newBoards.get(bestIndex).getBlackPieces() > newBoards.get(i).getBlackPieces()) {
                    bestIndex = i;
                }

            } else {
                if (newBoards.get(bestIndex).getRedPieces() > newBoards.get(i).getRedPieces()) {
                    bestIndex = i;
                }
            }
        }

        System.out.println(nodes.get(bestIndex).getMyBoard());

        System.out.print(nodes.get(bestIndex).getMyBoard().fromRow + ", ");
        System.out.println(nodes.get(bestIndex).getMyBoard().fromCol);
        System.out.print(nodes.get(bestIndex).getMyBoard().toRow + ", ");
        System.out.println(nodes.get(bestIndex).getMyBoard().toCol);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(nodes.get(bestIndex).getBoardAfter()[i][j]);

            }
            System.out.println("");
        }
        
        return nodes.get(bestIndex).getMyBoard();
    }

}
