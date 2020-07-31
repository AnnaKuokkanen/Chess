package gui;

import domain.board.*;
import domain.pieces.*;

public class Pieces {
    private Piece[][] locations;
    private Queen queen = new Queen(true);
    private King king = new King(true);
    
    public Pieces() {
        this.locations = new Piece[8][8];
    }
    
    public Piece[][] getLocations() {
        return locations;
    }
    
    public void setLocations() {
        Tile queenLocation = queen.getLocation();
        Tile kingLocation = king.getLocation();
        locations[kingLocation.getX()][kingLocation.getY()] = king;
    }
}
