package domain.pieces;

import chess.model.Side;
import domain.board.*;
import java.util.ArrayList;

public class Rook extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public Rook(Side side) {
        super(side, "rook");
    }
    
    /**
     * rook can move and capture vertically and horizontally but cannot jump over same side pieces
     * @param board for current game situation
     * @return list of tiles where rook can legally move
     */
    public ArrayList<Tile> getPossibleMoves(Board board) {
        ArrayList<Tile> moves = new ArrayList<>();
        Tile[][] tiles = board.getBoard();
        
        int x = this.getLocation().getX();
        int y = this.getLocation().getY();
        
        int i = 1;
        while (x + i < 8) {
            if (tiles[x + i][y] != null && tiles[x + i][y].getPiece().getSide() == this.side) {
                break;
            } else if (tiles[x + i][y] != null && tiles[x + i][y].getPiece().getSide() != this.side) {
                moves.add(tiles[x + i][y]);
                break;
            } else {
                moves.add(tiles[x + i][y]);
            }
            i++;
        }
        
        i = 1;
        while (x - i >= 0) {
            if (tiles[x - i][y] != null && tiles[x - i][y].getPiece().getSide() == this.side) {
                break;
            } else if (tiles[x - i][y] != null && tiles[x - i][y].getPiece().getSide() != this.side) {
                moves.add(tiles[x - i][y]);
                break;
            } else {
                moves.add(tiles[x - i][y]);
            }
            i++;
        }
        
        i = 1;
        while (y + i < 8) {
            if (tiles[x][y + i] != null && tiles[x][y + i].getPiece().getSide() == this.side) {
                break;
            } else if (tiles[x][y + i] != null && tiles[x][y + i].getPiece().getSide() != this.side) {
                moves.add(tiles[x][y + i]);
                break;
            } else {
                moves.add(tiles[x][y + i]);
            }
            i++;
        }
        
        i = 1;
        while (y - i >= 0) {
            if (tiles[x][y - i] != null && tiles[x][y - i].getPiece().getSide() == this.side) {
                break;
            } else if (tiles[x][y - i] != null && tiles[x][y - i].getPiece().getSide() != this.side) {
                moves.add(tiles[x][y - i]);
                break;
            } else {
                moves.add(tiles[x][y - i]);
            }
            i++;
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
