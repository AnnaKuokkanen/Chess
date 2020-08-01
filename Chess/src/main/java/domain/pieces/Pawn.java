package domain.pieces;

import chess.model.Side;
import domain.board.Tile;
import java.util.ArrayList;

public class Pawn extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public Pawn(Side side) {
        super(side);
    }
    
    public ArrayList<Tile> getPossibleMoves() {
        ArrayList<Tile> moves = new ArrayList<>();
        
        int x = getLocation().getX();
        int y = getLocation().getY();
        
        moves.add(new Tile(x+1, y));
        
        return moves;
    }
}
