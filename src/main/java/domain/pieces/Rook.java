package domain.pieces;

import chess.model.Side;
import domain.board.*;
import domain.rules.Rules;
import java.util.ArrayList;

public class Rook extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public Rook(Side side) {
        super(side, PieceName.ROOK);
        this.side = side;
        this.location = super.getLocation();
        this.onBoard = super.onBoard();
    }
    
    /**
     * rook can move and capture vertically and horizontally but cannot jump over same side pieces
     * @param board for current game situation
     * @return list of tiles where rook can legally move
     */
    @Override
    public ArrayList<Tile> getPossibleMoves(Board board) {
        ArrayList<Tile> moves = new ArrayList<>();
        Tile[][] tiles = board.getBoard();
        
        int x = this.getLocation().getX();
        int y = this.getLocation().getY();
        
        Rules rules = new Rules(x, y, tiles);
        
        for (Tile tile : rules.moveHorizontallyAndVertically()) {
            moves.add(tile);
        }
        return moves;
    }
    
    public int getValue() {
        int value = 50;
        if (side == side.BLACK) {
            value = value * (-1);
        }
        return value;
    }
}
