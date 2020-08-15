package datastructureproject;

import chess.model.Side;
import domain.board.Board;
import domain.board.Tile;
import domain.board.TileNameConverter;
import java.util.ArrayList;
import java.util.HashMap;

public class RandomChoice {
    private final Board board = new Board();
    private HashMap<Tile, ArrayList<Tile>> moves;
    private final TileNameConverter converter = new TileNameConverter();
    
    public RandomChoice() {
        this.board.setupBoard();
        this.board.setupPieces();
    }
    
    public String chooseMove() {
        this.moves = this.board.getPossibleMoves(Side.BLACK);
        String move = "";
        
        for (Tile tile : this.moves.keySet()) { 
            if (this.moves.get(tile).size() > 0) {
                Tile start = tile;
                Tile finish = moves.get(start).get(moves.get(start).size() - 1);

                move += converter.convertToString(start.getX(), start.getY());
                move += converter.convertToString(finish.getX(), finish.getY());

                if (finish.getPiece() != null) {
                    finish.getPiece().remove();
                }

                finish.setPiece(start.getPiece());
                start.setPiece(null);
                
                break;
            }
        }
        return move;
    }
}
