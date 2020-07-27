package domain;

public abstract class Piece {
    
    abstract void move(int x, int y);
    
    abstract Tile[] getPossibleMoves();
    
    abstract Tile getLocation();
    
    abstract boolean onBoard();
    
    abstract void getRemoved();
}
