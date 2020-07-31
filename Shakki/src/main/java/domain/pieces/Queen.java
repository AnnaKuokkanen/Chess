package domain.pieces;
import domain.board.Tile;
import java.util.*;

public class Queen extends Piece {
    private boolean onBoard;
    private Tile location;
    private boolean black;
    
    public Queen(boolean black) {
        super(new Tile(0, 3), black);
    }
    
    public ArrayList<Tile> getPossibleMoves() {
        ArrayList<Tile> moves = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(i == location.getX() ^ j == location.getY()) {
                    moves.add(new Tile(i, j));
                } 
            }
        }
        return moves;
    }
}
