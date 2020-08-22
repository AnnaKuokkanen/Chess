package datastructureproject.algorithm;

import chess.model.Side;
import datastructureproject.datastructure.ArrayList;
import domain.board.Board;
import domain.board.Tile;
import domain.board.TileNameConverter;
import domain.pieces.Piece;
import java.util.HashMap;

public class AlphaBetaPruning {
    private final Board board;
    private HashMap<Tile, ArrayList> moves;
    private final TileNameConverter converter = new TileNameConverter();
    
    public AlphaBetaPruning(Board board) {
        this.board = board;
    }
    
    public String useAlphaBetaPruner() {
        this.moves = this.board.getPossibleMoves(Side.BLACK);
        
        String move = "";
        
        int greatestRisk = Integer.MAX_VALUE;
        Tile bestStartTile = null;
        Tile bestFinishTile = null;
        
        for (Tile start : this.moves.keySet()) { 
            for (int i = 0; i < this.moves.get(start).size(); i++) {
                Tile finish = (Tile)this.moves.get(start).get(i);
                int nextMove = search(start, finish, 4, Integer.MIN_VALUE, Integer.MAX_VALUE, Side.WHITE);
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
    public int search(Tile start, Tile finish, int depth, int alpha, int beta, Side side) {
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
            HashMap<Tile, ArrayList> allMoves = board.getPossibleMoves(side.BLACK);
            int currentValue = Integer.MAX_VALUE;
            
            for (Tile newStart : allMoves.keySet()) {
                for (int i = 0; i < allMoves.get(newStart).size(); i++) {
                    int newValue = search(newStart, (Tile)allMoves.get(newStart).get(i), depth - 1, alpha, beta, Side.WHITE);
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
            HashMap<Tile, ArrayList> allMoves = board.getPossibleMoves(side.WHITE);
            int currentValue = Integer.MIN_VALUE;
            
            for (Tile newStart : allMoves.keySet()) {
                for (int i = 0; i < allMoves.get(newStart).size(); i++) {
                    int newValue = search(newStart, (Tile)allMoves.get(newStart).get(i), depth - 1, alpha, beta, Side.BLACK);
                    currentValue = currentValue > newValue ? currentValue : newValue;
                    alpha = alpha > currentValue ? alpha : currentValue;
                    if (alpha >= beta ) {
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
