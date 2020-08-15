package datastructureproject;

import chess.model.Side;
import domain.board.Board;
import domain.board.Tile;
import domain.board.TileNameConverter;
import java.util.ArrayList;
import java.util.HashMap;

public class RandomChoice {
    private final Board board;
    private HashMap<Tile, ArrayList<Tile>> moves;
    private final TileNameConverter converter = new TileNameConverter();
    
    public RandomChoice(Board board) {
        this.board = board;
    }
    
    public String chooseMove() {
        this.moves = this.board.getPossibleMoves(Side.BLACK);
        
        String move = "";
        
        for (Tile tile : this.moves.keySet()) { 
            if (this.moves.get(tile).size() > 0) {
                Tile start = tile;
                Tile finish = moves.get(start).get(0);

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
