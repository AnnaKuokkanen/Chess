package domain.pieces;

import domain.board.Tile;
import java.util.*;

public class Piece {
    private boolean onBoard;
    private Tile location;
    private boolean black;
    
    public Piece(Tile location, boolean black) {
        this.onBoard = true;
        this.location = location;
        this.black = black;
    }

    public Tile getLocation() {
        return location;
    }
    
    public boolean onBoard() {
        return onBoard;
    }
    
    public void getRemoved() {
        onBoard = false;
    }
    
    public boolean isBlack() {
        return black;
    }
    
    public void move(int x, int y) {
        location.setX(x);
        location.setY(y);
    }
    
    public void chooseMove(ArrayList<Tile> tiles) {
        //this should choose the best move using minimax
    }
}
