package datastructureproject.algorithm;

import chess.model.Side;
import datastructureproject.datastructure.ArrayList;
import datastructureproject.datastructure.HashMap;
import domain.board.Board;
import domain.board.Tile;
import domain.board.TileNameConverter;
import domain.pieces.Piece;
//import java.util.HashMap;

public class MiniMax { 
    private final Board board;
    private HashMap moves;
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
        
        for (int i = 0; i < this.moves.keySet().size(); i++) { 
            Tile start = (Tile) this.moves.keySet().get(i);
            for (int j = 0; j < this.moves.get(start).size(); j++) {
                Tile finish = (Tile)this.moves.get(start).get(j);
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
    
    /**
     * @return textual representation of move
     * that guarantees the smallest risk
     */
    public String useMiniMax() {
        this.moves = this.board.getPossibleMoves(Side.BLACK);
        
        String move = "";
        
        int greatestRisk = Integer.MAX_VALUE;
        Tile bestStartTile = null;
        Tile bestFinishTile = null;
        
        for (int i = 0; i < this.moves.keySet().size(); i++) { 
            Tile start = (Tile) this.moves.keySet().get(i);
            for (int j = 0; j < this.moves.get(start).size(); j++) {
                Tile finish = (Tile) this.moves.get(start).get(j);
                int nextMove = search(start, finish, 2, Side.WHITE);
                if (nextMove < greatestRisk) {
                    bestStartTile = start;
                    bestFinishTile = finish;
                    greatestRisk = nextMove;
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
    
    /**
     * recursive method that calculates move's biggest risk
     * 
     * @param start is Tile where move starts
     * @param finish is Tile where move ends
     * @param depth depicts the depth of the tree
     * @param side is the side for which moves are calculated
     * @return biggest risk for the move we were examining
     */
    public int search(Tile start, Tile finish, int depth, Side side) {      
        if (depth == 0) {
            return board.getBoardValue();
        }
        
        Piece startPiece = start.getPiece();
        Piece finishPiece = finish.getPiece();
        if (finishPiece != null) {
            finish.getPiece().remove();
        }
        finish.setPiece(startPiece);
        start.setPiece(null);
        
        if (side == Side.BLACK) {
            HashMap allMoves = board.getPossibleMoves(side.BLACK);
            int currentValue = Integer.MAX_VALUE;
            
            for (int i = 0; i < allMoves.keySet().size(); i++) {
                Tile newStart = (Tile) allMoves.keySet().get(i);
                for (int j = 0; j < allMoves.get(newStart).size(); j++) {
                    int newValue = search(newStart, (Tile)allMoves.get(newStart).get(j), depth - 1, Side.WHITE);
                    currentValue = currentValue < newValue ? currentValue : newValue;
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
                    int newValue = search(newStart, (Tile)allMoves.get(newStart).get(j), depth - 1, Side.BLACK);
                    currentValue = currentValue > newValue ? currentValue : newValue;
                }
            }
            start.setPiece(startPiece);
            finish.getPiece().remove();
            finish.setPiece(finishPiece);
            
            return currentValue;
        }
    } 
}
