package datastructureproject.algorithm;

import chess.model.Side;
import datastructureproject.datastructure.HashMap;
import domain.board.Board;
import domain.board.Tile;
import domain.board.TileNameConverter;
import domain.pieces.Piece;

/**
 * Class that implements Alpha-Beta Pruning.
 * It delivers same results as Minimax but is quicker.
 * Some possible moves are not examined because they cannot 
 * improve current situation. Whether a move should be examined 
 * is determined by comparing it to values of one of the two integers, alpha and beta.
 */
public class AlphaBetaPruning {
    private final Board board;
    private HashMap moves;
    private final TileNameConverter converter = new TileNameConverter();
    
    public AlphaBetaPruning(Board board) {
        this.board = board;
    }
    
    /**
     * @param side is the side making the move
     * @return textual representation of a move 
     * (for example "e2e4") that is least risky.
     * This method also updates board after move is determined.
     */
    public String useAlphaBetaPruner(Side side) {
        this.moves = this.board.getPossibleMoves(side);
        
        String move = "";
        
        int greatestRisk = Integer.MAX_VALUE;
        Side other = Side.WHITE;
        
        if (side == Side.WHITE) { 
            greatestRisk = Integer.MIN_VALUE;
            other = Side.BLACK;
        } 
        Tile bestStartTile = null;
        Tile bestFinishTile = null;
        
        for (int i = 0; i < this.moves.keySet().size(); i++) { 
            Tile start = (Tile) this.moves.keySet().get(i);
            for (int j = 0; j < this.moves.get(start).size(); j++) {
                Tile finish = (Tile) this.moves.get(start).get(j);
                
                int nextMove = search(start, finish, 4, Integer.MIN_VALUE, Integer.MAX_VALUE, other);
                
                if (side == Side.BLACK) {
                    if (nextMove <= greatestRisk) {
                        bestStartTile = start;
                        bestFinishTile = finish;
                        greatestRisk = nextMove;
                    }
                } else {
                    if (nextMove >= greatestRisk) {
                        bestStartTile = start;
                        bestFinishTile = finish;
                        greatestRisk = nextMove;
                    }
                }
            }
        }
        
        move += converter.convertToString(bestStartTile.getX(), bestStartTile.getY());
        move += converter.convertToString(bestFinishTile.getX(), bestFinishTile.getY());
        
        board.movePiece(bestStartTile, bestFinishTile);
        
        return move;
    }
    
    /**
     * recursive method that calculates move's biggest risk
     * 
     * @param start is Tile where move starts
     * @param finish is Tile where move ends
     * @param depth depicts the depth of the tree
     * @param side is the side for which moves are calculated
     * @param alpha measures the smallest value that should be pruned by black
     * @param beta measures the biggest value that should be pruned by white
     * @return biggest risk for the move we were examining
     */
    public int search(Tile start, Tile finish, int depth, int alpha, int beta, Side side) {
        if (depth == 0 || start == null || finish == null) {
            return board.getBoardValue();
        }
        
        Piece startPiece = start.getPiece();
        Piece finishPiece = finish.getPiece();
//        if (finishPiece != null) {
//            finish.getPiece().remove();
//        }
//        finish.setPiece(startPiece);
//        start.setPiece(null);
        board.movePiece(start, finish);
        
        if (side == Side.BLACK) {
            HashMap allMoves = board.getPossibleMoves(side.BLACK);
            int currentValue = Integer.MAX_VALUE;
            
            for (int i = 0; i < allMoves.keySet().size(); i++) {
                Tile newStart = (Tile) allMoves.keySet().get(i);
                for (int j = 0; j < allMoves.get(newStart).size(); j++) {
                    int newValue = search(newStart, (Tile) allMoves.get(newStart).get(j), depth - 1, alpha, beta, Side.WHITE);
                    currentValue = currentValue < newValue ? currentValue : newValue;
                    beta = beta < currentValue ? beta : currentValue;
                    if (beta <= alpha) {
                        break;
                    }
                }
            }
            start.setPiece(startPiece);
            finish.getPiece().remove();
            finish.setPiece(finishPiece);
            
            return currentValue;
        } else {
            HashMap allMoves = board.getPossibleMoves(side.WHITE);
            int currentValue = Integer.MIN_VALUE;
            
            for (int i = 0; i < allMoves.keySet().size(); i++) {
                Tile newStart = (Tile) allMoves.keySet().get(i);
                for (int j = 0; j < allMoves.get(newStart).size(); j++) {
                    int newValue = search(newStart, (Tile) allMoves.get(newStart).get(j), depth - 1, alpha, beta, Side.BLACK);
                    currentValue = currentValue > newValue ? currentValue : newValue;
                    alpha = alpha > currentValue ? alpha : currentValue;
                    if (alpha >= beta) {
                        break;
                    } 
                }
            }
            start.setPiece(startPiece);
            finish.getPiece().remove();
            finish.setPiece(finishPiece);
            
            return currentValue;
        }
    } 
}
