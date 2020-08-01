package domain.pieces;

import chess.model.Side;
import domain.board.Tile;
import java.util.ArrayList;

public class Knight extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public Knight(Side side) {
        super(side, "knight");
    } 
    
    public ArrayList<Tile> getPossibleMoves() {
        ArrayList<Tile> tiles = new ArrayList<>();
        
        return tiles;
    }
    
    public int getValue() {
        int value = 30;
        if(side == side.BLACK) {
            value = value * (-1);
        }
        return value;
    } 
}
