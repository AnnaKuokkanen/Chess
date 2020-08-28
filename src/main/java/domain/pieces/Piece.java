package domain.pieces;

import chess.model.*;
import datastructureproject.datastructure.ArrayList;
import domain.board.*;
import java.util.Objects;

/**
 * Abstract class that provides methods common to all piecetypes.
 */
public abstract class Piece {
    private boolean onBoard;
    private Tile location;
    private final Side side;
    private final PieceName type;
    
    public Piece(Side side, PieceName type) {
        this.onBoard = true;
        this.side = side;
        this.type = type;
    }

    public Tile getLocation() {
        return location;
    }
    
    public void setLocation(int x, int y) {
        this.location = new Tile(x, y);
    }
    
    public boolean onBoard() {
        return onBoard;
    }
    
    public void remove() {
        this.location.setPiece(null);
        onBoard = false;
    }
    
    public Side getSide() {
        return side;
    }
    
    public PieceName getType() {
        return this.type;
    }
    
    /**
     * Method that checks if piece on some
     * tile is the same side as this piece.
     * 
     * @param tile is the tile we are checking
     * @return boolean value of comparison 
     */
    public boolean differentSide(Tile tile) {
        return tile.getPiece().getSide() != this.side;
    }
    
    public abstract ArrayList getPossibleMoves(Board board);
    
    public abstract int getValue();
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Piece) {  
            Piece piece = (Piece) o;  
            if (piece.getSide() != this.side) {
                return false;
            }
            return (piece.getLocation().getX() == this.location.getX()) 
                    && (piece.getLocation().getY() == this.location.getY());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.onBoard ? 1 : 0);
        hash = 29 * hash + Objects.hashCode(this.location);
        hash = 29 * hash + Objects.hashCode(this.side);
        return hash;
    }
}
