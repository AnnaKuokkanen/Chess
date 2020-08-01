package domain.board;

import domain.pieces.Piece;

public class Tile {
    
    private int x;
    private int y;
    private Piece piece;
    private String id;
    
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        
    }
    
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public Piece getPiece() {
        //this should be programmed to inform of type of piece
        return piece;
    }
}
