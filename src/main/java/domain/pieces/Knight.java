package domain.pieces;

import chess.model.Side;
import domain.board.*;
import java.util.ArrayList;

public class Knight extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public Knight(Side side) {
        super(side, PieceName.KNIGHT);
        this.side = side;
        this.location = super.getLocation();
        this.onBoard = super.onBoard();
    } 
    
    /**
     * knight can move and capture two tiles up/down/right/left and one tile u/d/r/l
     * @param board for current game situation
     * @return list of tiles where knight can legally move
     */
    @Override
    public ArrayList<Tile> getPossibleMoves(Board board) {
        ArrayList<Tile> moves = new ArrayList<>();
        Tile[][] tiles = board.getBoard();
        
        int x = this.getLocation().getX();
        int y = this.getLocation().getY();
        
        if (x + 2 < 8 && y + 1 < 8 && (tiles[x + 2][y + 1].getPiece() == null || tiles[x + 2][y + 1].getPiece().getSide() != this.side)) {
            moves.add(tiles[x + 2][y + 1]);
        }
        if (x + 2 < 8 && y - 1 >= 0 && (tiles[x + 2][y - 1].getPiece() == null || tiles[x + 2][y - 1].getPiece().getSide() != this.side)) {
            moves.add(tiles[x + 2][y - 1]);
        }
        if (x - 2 >= 0 && y + 1 < 8 && (tiles[x - 2][y + 1].getPiece() == null || tiles[x - 2][y + 1].getPiece().getSide() != this.side)) {
            moves.add(tiles[x - 2][y + 1]);
        }
        if (x - 2 >= 0 && y -1 >= 0 && (tiles[x - 2][y - 1].getPiece() == null || tiles[x - 2][y - 1].getPiece().getSide() != this.side)) {
            moves.add(tiles[x - 2][y - 1]);
        }
        if (x + 1 < 8 && y + 2 < 8 && (tiles[x + 1][y + 2].getPiece() == null || tiles[x + 1][y + 2].getPiece().getSide() != this.side)) {
            moves.add(tiles[x + 1][y + 2]);
        }
        if (x + 1 < 8 && y - 2 >= 0 && (tiles[x + 1][y - 2].getPiece() == null || tiles[x + 1][y - 2].getPiece().getSide() != this.side)) {
            moves.add(tiles[x + 1][y - 2]);
        }
        if (x - 1 >= 0 && y + 2 < 8 && (tiles[x - 1][y + 2].getPiece() == null || tiles[x - 1][y + 2].getPiece().getSide() != this.side)) {
            moves.add(tiles[x - 1][y + 2]);
        }
        if (x - 1 >= 0 && y - 2 >= 0 && (tiles[x - 1][y - 2].getPiece() == null || tiles[x - 1][y - 2].getPiece().getSide() != this.side)) {
            moves.add(tiles[x - 1][y - 2]);
        }
        
        return moves;
    }
    
    public int getValue() {
        int value = 30;
        if (side == side.BLACK) {
            value = value * (-1);
        }
        return value;
    } 
}
