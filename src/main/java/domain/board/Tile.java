package domain.board;

import domain.pieces.Piece;

public class Tile {
    
    private int x;
    private int y;
    private Piece piece;
    private String id;
    private TileNameConverter converter = new TileNameConverter();
    
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.id = converter.convert(x, y);
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
        return piece;
    }
    
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
