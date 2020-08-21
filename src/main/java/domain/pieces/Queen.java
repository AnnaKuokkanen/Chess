package domain.pieces;
import chess.model.Side;
import domain.board.*;
import domain.rules.Rules;
import java.util.*;
import datastructureproject.datastructure.ArrayList;

public class Queen extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public Queen(Side side) {
        super(side, PieceName.QUEEN);
        this.side = side;
        this.location = super.getLocation();
        this.onBoard = super.onBoard();
    }
    
    /**
     * queen can move and capture diagonally and horizontally but cannot jump over same side pieces
     * @param board for current game situation
     * @return list of tiles where queen can legally move
     */
    @Override
    public ArrayList getPossibleMoves(Board board) {
        ArrayList moves = new ArrayList();
        Tile[][] tiles = board.getBoard();
        
        int x = this.getLocation().getX();
        int y = this.getLocation().getY();
        
        Rules rules = new Rules(x, y, tiles);
        
//        for (Tile tile : rules.moveDiagonally()) {
//            moves.add(tile);
//        }
        for (int i = 0; i < rules.moveDiagonally().size(); i++) {
            moves.add((Tile) rules.moveDiagonally().get(i));
        }
        ArrayList list = new ArrayList();
        rules.setMoves(list);
        
//        for (Tile tile : rules.moveHorizontallyAndVertically()) {
//            moves.add(tile);
//        }
        for (int i = 0; i < rules.moveHorizontallyAndVertically().size(); i++) {
            moves.add((Tile) rules.moveHorizontallyAndVertically().get(i));
        }
        
        return moves;
    }
    
    @Override
    public int getValue() {
        int value = 90;
        if (side == side.BLACK) {
            value = value * (-1);
        }
        return value;
    }
}
