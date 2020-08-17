package datastructureproject.algorithm;

import chess.model.Side;
import domain.board.Board;
import domain.board.Tile;
import domain.board.TileNameConverter;
import java.util.ArrayList;
import java.util.HashMap;

public class MiniMax { 
    private final Board board;
    private HashMap<Tile, ArrayList<Tile>> moves;
    private final TileNameConverter converter = new TileNameConverter();
    
    public MiniMax(Board board) {
        this.board = board;
    }
    
    /**
     * This is the first version of AI
     * Algorithm knows the sum of all pieces on board 
     * and checks if it can remove some piece to minimize this value
     * This algorithm will take an opponent piece whenever possible
     * 
     * @return next move in textual form
     */
    public String chooseMove() {
        this.moves = this.board.getPossibleMoves(Side.BLACK);
        
        String move = "";
        
        int currentSum = board.getBoardValue();
        int bestMove = Integer.MAX_VALUE;
        Tile bestStartTile = null;
        Tile bestFinishTile = null;
        
        for (Tile start : this.moves.keySet()) { 
            for (Tile finish : this.moves.get(start)) {
                if (finish.getPiece() != null) {
                    currentSum -= finish.getPiece().getValue();
                }
                if (currentSum < bestMove) {
                    bestMove = currentSum;
                    bestStartTile = start;
                    bestFinishTile = finish;
                }
            } 
        }
        
        move += converter.convertToString(bestStartTile.getX(), bestStartTile.getY());
        move += converter.convertToString(bestFinishTile.getX(), bestFinishTile.getY());
        
        if (board.getBoard()[bestFinishTile.getX()][bestFinishTile.getY()].getPiece() != null) {
            board.getBoard()[bestFinishTile.getX()][bestFinishTile.getY()].getPiece().remove();
        }

        board.getBoard()[bestFinishTile.getX()][bestFinishTile.getY()].setPiece(bestStartTile.getPiece());
        board.getBoard()[bestStartTile.getX()][bestStartTile.getY()].setPiece(null);
        
        return move;
    }
}
