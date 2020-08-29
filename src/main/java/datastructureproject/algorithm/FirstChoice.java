package datastructureproject.algorithm;

import chess.model.Side;
import datastructureproject.datastructure.HashMap;
import domain.board.Board;
import domain.board.Tile;
import domain.board.TileNameConverter;

/**
 * Class that has method for choosing the first legal move that is found.
 * Search starts at upper left corner and progresses across board until legal 
 * move is found.
 * This class does not really play well but can be used for quick testing.
 */
public class FirstChoice {
    private final Board board;
    private HashMap moves;
    private final TileNameConverter converter = new TileNameConverter();
    
    public FirstChoice(Board board) {
        this.board = board;
    }
    
    /**
     * Method that searches for legal moves.
     * @param side is the side that is currently making moves
     * @return move in textual form, for example "e2e4".
     * This method also updates board when move is chosen.
     */
    public String chooseMove(Side side) {
        this.moves = this.board.getPossibleMoves(side);
        
        String move = "";
        
        for (int i = 0; i < this.moves.keySet().size(); i++) { 
            Tile tile = (Tile) this.moves.keySet().get(i);
            if (this.moves.get(tile).size() > 0) {
                Tile start = tile;
                Tile finish = (Tile) moves.get(start).get(0);

                move += converter.convertToString(start.getX(), start.getY());
                move += converter.convertToString(finish.getX(), finish.getY());

                if (board.getBoard()[finish.getX()][finish.getY()].getPiece() != null) {
                    board.getBoard()[finish.getX()][finish.getY()].getPiece().remove();
                }

                board.getBoard()[finish.getX()][finish.getY()].setPiece(start.getPiece());
                board.getBoard()[start.getX()][start.getY()].setPiece(null);
                
                break;
            }
        }
        return move;
    }
}
