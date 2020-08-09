package domain.pieces;

import domain.board.*;
import chess.model.*;
import java.util.*;

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
        onBoard = false;
    }
    
    public Side getSide() {
        return side;
    }
    
    public PieceName getType() {
        return this.type;
    }
    
    public void move(int x, int y) {
        location.setX(x);
        location.setY(y);
    }
    
    public abstract ArrayList<Tile> getPossibleMoves(Board board);
    
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
