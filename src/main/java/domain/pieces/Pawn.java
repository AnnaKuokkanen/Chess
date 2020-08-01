package domain.pieces;

import chess.model.Side;
import domain.board.Tile;
import java.util.ArrayList;

public class Pawn extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public Pawn(Side side) {
        super(side, "pawn");
    }
    
    public ArrayList<Tile> getPossibleMoves() {
        ArrayList<Tile> moves = new ArrayList<>();
        
        int x = getLocation().getX();
        int y = getLocation().getY();
        
        if(x<7) {
            moves.add(new Tile(x + 1, y));
        }
        
        return moves;
    }
    
    public int getValue() {
        int value = 10;
        if(side == side.BLACK) {
            value = value * (-1);
        }
        return value;
    }
}
