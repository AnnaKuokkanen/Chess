package domain.pieces;

import chess.model.Side;
import domain.board.Tile;
import java.util.*;

public class King extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public King(Side side) {
        super(side, "king");
    }
    
    public ArrayList<Tile> getPossibleMoves() {
        ArrayList<Tile> moves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == location.getX() ^ j == location.getY()) {
                    moves.add(new Tile(i, j));
                } 
            }
        }
        return moves;
    }
    
    public int getValue() {
        int value = 900;
        if(side == side.BLACK) {
            value = value * (-1);
        }
        return value;
    }
}
