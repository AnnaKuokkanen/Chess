package domain.pieces;

import chess.model.Side;
import domain.board.*;
import java.util.ArrayList;

public class Knight extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public Knight(Side side) {
        super(side, "knight");
    } 
    
    /**
     * knight can move and capture two tiles but cannot jump over same side pieces
     * @param board for current game situation
     * @return list of tiles where bishop can legally move
     */
    public ArrayList<Tile> getPossibleMoves(Board board) {
        ArrayList<Tile> moves = new ArrayList<>();
        Tile[][] tiles = board.getBoard();
        
        int x = this.getLocation().getX();
        int y = this.getLocation().getY();
        
        if (tiles[x + 2][y + 1].getPiece() == null || tiles[x + 2][y + 1].getPiece().getSide() != this.side) {
            moves.add(tiles[x + 2][y + 1]);
        }
        if (tiles[x + 2][y - 1].getPiece() == null || tiles[x + 2][y - 1].getPiece().getSide() != this.side) {
            moves.add(tiles[x + 2][y - 1]);
        }
        if (tiles[x - 2][y + 1].getPiece() == null || tiles[x - 2][y + 1].getPiece().getSide() != this.side) {
            moves.add(tiles[x - 2][y + 1]);
        }
        if (tiles[x - 2][y - 1].getPiece() == null || tiles[x - 2][y - 1].getPiece().getSide() != this.side) {
            moves.add(tiles[x - 2][y - 1]);
        }
        if (tiles[x + 1][y + 2].getPiece() == null || tiles[x + 1][y + 2].getPiece().getSide() != this.side) {
            moves.add(tiles[x + 1][y + 2]);
        }
        if (tiles[x + 1][y - 2].getPiece() == null || tiles[x + 1][y - 2].getPiece().getSide() != this.side) {
            moves.add(tiles[x + 1][y - 2]);
        }
        if (tiles[x - 1][y + 2].getPiece() == null || tiles[x - 1][y + 2].getPiece().getSide() != this.side) {
            moves.add(tiles[x - 1][y + 2]);
        }
        if (tiles[x - 1][y - 2].getPiece() == null || tiles[x - 1][y - 2].getPiece().getSide() != this.side) {
            moves.add(tiles[x - 1][y - 2]);
        }
        
        return moves;
    }
    
    public int getValue() {
        int value = 30;
        if(side == side.BLACK) {
            value = value * (-1);
        }
        return value;
    } 
}
