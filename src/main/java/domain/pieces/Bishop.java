package domain.pieces;

import chess.model.Side;
import domain.board.*;
import domain.rules.Rules;
import datastructureproject.datastructure.ArrayList;

public class Bishop extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public Bishop(Side side) {
        super(side, PieceName.BISHOP);
        this.side = side;
        this.location = super.getLocation();
        this.onBoard = super.onBoard();
    }
    
    /**
     * Bishop can move and capture diagonally but cannot jump over same side pieces.
     * @param board for current game situation
     * @return list of tiles where bishop can legally move
     */
    @Override
    public ArrayList getPossibleMoves(Board board) {
        ArrayList moves = new ArrayList();
        Tile[][] tiles = board.getBoard();
        
        int x = this.getLocation().getX();
        int y = this.getLocation().getY();
        
        Rules rules = new Rules(x, y, tiles);
        
        for (int i = 0; i < rules.moveDiagonally().size(); i++) {
            Tile tile = (Tile) rules.moveDiagonally().get(i);
            Piece piece = tile.getPiece();
            moves.add(tile);
        }
        return moves;
    }
    
    @Override
    public int getValue() {
        int value = 30;
        if (side == Side.BLACK) {
            value = value * (-1);
        }
        return value;
    }
}
