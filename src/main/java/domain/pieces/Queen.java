package domain.pieces;
import chess.model.Side;
import domain.board.*;
import domain.rules.Rules;
import java.util.*;

public class Queen extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public Queen(Side side) {
        super(side, PieceName.QUEEN);
    }
    
    /**
     * queen can move and capture diagonally and horizontally but cannot jump over same side pieces
     * @param board for current game situation
     * @return list of tiles where queen can legally move
     */
    public ArrayList<Tile> getPossibleMoves(Board board) {
        ArrayList<Tile> moves = new ArrayList<>();
        Tile[][] tiles = board.getBoard();
        
        int x = this.getLocation().getX();
        int y = this.getLocation().getY();
        
        Rules rules = new Rules(x, y, tiles);
        
        for (Tile tile : rules.moveDiagonally()) {
            moves.add(tile);
        }
        rules.setMoves(new ArrayList<>());
        
        for (Tile tile : rules.moveHorizontallyAndVertically()) {
            moves.add(tile);
        }
        
        return moves;
    }
    
    public int getValue() {
        int value = 90;
        if (side == side.BLACK) {
            value = value * (-1);
        }
        return value;
    }
}
