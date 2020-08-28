package datastructureproject.algorithm;

import chess.model.Side;
import datastructureproject.datastructure.ArrayList;
import datastructureproject.datastructure.HashMap;
import domain.board.Board;
import domain.board.Tile;
import domain.board.TileNameConverter;
//import java.util.HashMap;

public class FirstChoice {
    private final Board board;
    private HashMap moves;
    private final TileNameConverter converter = new TileNameConverter();
    
    public FirstChoice(Board board) {
        this.board = board;
    }
    
    public String chooseMove() {
        this.moves = this.board.getPossibleMoves(Side.BLACK);
        
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
