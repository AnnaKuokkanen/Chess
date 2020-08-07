package domain.pieces;

import chess.model.Side;
import domain.board.*;
import java.util.ArrayList;

public class Pawn extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public Pawn(Side side) {
        super(side, PieceName.PAWN);
        this.side = side;
        this.location = super.getLocation();
        this.onBoard = super.onBoard();
    }
    /**
     * pawn can move straight forward or capture diagonally
     * on first move pawn can move two tiles forward
     * @param board for current game situation
     * @return list of tiles where pawn can legally move
     */
    public ArrayList<Tile> getPossibleMoves(Board board) {
        ArrayList<Tile> moves = new ArrayList<>();
        Tile[][] tiles = board.getBoard();
        
        int x = this.getLocation().getX();
        int y = this.getLocation().getY();
        
        if (y < 8 && tiles[x][y + 1].getPiece() == null) {
            moves.add(tiles[x][y + 1]);
        }
        if (tiles[x - 1][y + 1].getPiece() != null && tiles[x - 1][y + 1].getPiece().getSide() != this.side) {
            moves.add(tiles[x - 1][y + 1]);
        }
        if (tiles[x + 1][y + 1].getPiece() != null && tiles[x + 1][y + 1].getPiece().getSide() != this.side) {
            moves.add(tiles[x + 1][y + 1]);
        }
        
        return moves;
    }
    
    public int getValue() {
        int value = 10;
        if (side == side.BLACK) {
            value = value * (-1);
        }
        return value;
    }
}
