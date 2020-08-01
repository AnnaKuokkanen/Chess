package domain.pieces;

import domain.board.Tile;
import chess.model.*;
import java.util.*;

public class Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    private String type;
    
    public Piece(Side side, String type) {
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
    
    public String getType() {
        return this.type;
    }
    
    public void move(int x, int y) {
        location.setX(x);
        location.setY(y);
    }
}
