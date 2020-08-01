package domain.pieces;

import chess.model.Side;
import domain.board.*;
import java.util.ArrayList;

public class Bishop extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public Bishop(Side side) {
        super(side, "bishop");
    }
    
    /**
     * bishop can move and capture diagonally but cannot jump over same side pieces
     * @param board for current game situation
     * @return list of tiles where bishop can legally move
     */
    public ArrayList<Tile> getPossibleMoves(Board board) {
        ArrayList<Tile> moves = new ArrayList<>();
        Tile[][] tiles = board.getBoard();
        
        int x = this.getLocation().getX();
        int y = this.getLocation().getY();
        
        int i = 1;
        while (x + i < 8 && y + i < 8) {
            if (tiles[x + i][y + i] != null && tiles[x + i][y + i].getPiece().getSide() == this.side) {
                break;
            } else if (tiles[x + i][y + i] != null && tiles[x + i][y + i].getPiece().getSide() != this.side) {
                moves.add(tiles[x + i][y + i]);
                break;
            } else {
                moves.add(tiles[x + i][y + i]);
            }
            i++;
        }
        
        i = 1;
        while (x - i >= 0 && y + i < 8) {
            if (tiles[x - i][y + i] != null && tiles[x - i][y + i].getPiece().getSide() == this.side) {
                break;
            } else if (tiles[x - i][y + i] != null && tiles[x - i][y + i].getPiece().getSide() != this.side) {
                moves.add(tiles[x - i][y + i]);
                break;
            } else {
                moves.add(tiles[x - i][y + i]);
            }
            i++;
        }
        
        i = 1;
        while (x + i < 8 && y - i >= 0) {
            if (tiles[x + i][y - i] != null && tiles[x + i][y - i].getPiece().getSide() == this.side) {
                break;
            } else if (tiles[x + i][y - i] != null && tiles[x + i][y - i].getPiece().getSide() != this.side) {
                moves.add(tiles[x + i][y - i]);
                break;
            } else {
                moves.add(tiles[x + i][y - i]);
            }
            i++;
        }
        
        i = 1;
        while (x - i >= 0 && y - i >= 0) {
            if (tiles[x - i][y - i] != null && tiles[x - i][y - i].getPiece().getSide() == this.side) {
                break;
            } else if (tiles[x - i][y - i] != null && tiles[x - i][y - i].getPiece().getSide() != this.side) {
                moves.add(tiles[x - i][y - i]);
                break;
            } else {
                moves.add(tiles[x - i][y - i]);
            }
            i++;
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
