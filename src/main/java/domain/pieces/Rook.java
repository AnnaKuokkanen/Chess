package domain.pieces;

import chess.model.Side;
import domain.board.*;
import domain.rules.Rules;
//import java.util.ArrayList;
import datastructureproject.datastructure.ArrayList;

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
    public ArrayList getPossibleMoves(Board board) {
        ArrayList moves = new ArrayList();
        Tile[][] tiles = board.getBoard();
        
        int x = this.getLocation().getX();
        int y = this.getLocation().getY();
        
        Rules rules = new Rules(x, y, tiles);
        
        for (int i = 0; i < rules.moveHorizontallyAndVertically().size(); i++) {
            Tile tile = (Tile) rules.moveHorizontallyAndVertically().get(i);
            Piece piece = tile.getPiece();
            moves.add(tile);
            if (piece != null && piece.getType() == PieceName.KING && differentSide(tile)) {
                King king = (King) piece;
                king.setCheck(true);
            }
        }
        return moves;
    }
    
    @Override
    public int getValue() {
        int value = 50;
        if (side == Side.BLACK) {
            value = value * (-1);
        }
        return value;
    }
}
