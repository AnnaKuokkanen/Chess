package domain.pieces;

import chess.model.Side;
import domain.board.*;
import java.util.*;

public class King extends Piece {
    private boolean onBoard;
    private Tile location;
    private Side side;
    
    public King(Side side) {
        super(side, PieceName.KING);
        this.side = side;
        this.location = super.getLocation();
        this.onBoard = super.onBoard();
    }
    
    /**
     * king can move and capture on tile up, down, right or left
     * @param board for current game situation
     * @return list of tiles where king can legally move
     */
    @Override
    public ArrayList<Tile> getPossibleMoves(Board board) {
        ArrayList<Tile> moves = new ArrayList<>();
        Tile[][] tiles = board.getBoard();
        
        int x = this.getLocation().getX();
        int y = this.getLocation().getY();
        
        if (x + 1 < 8 && (tiles[x + 1][y].free() || differentSide(tiles[x + 1][y]))) {
            moves.add(tiles[x + 1][y]);
        }
        if (y + 1 < 8 && (tiles[x][y + 1].free() || differentSide(tiles[x][y + 1]))) {
            moves.add(tiles[x][y + 1]);
        }
        if (y - 1 >= 0 && (tiles[x][y - 1].free() || differentSide(tiles[x][y - 1]))) {
            moves.add(tiles[x][y - 1]);
        }
        if (x - 1 >= 0 && (tiles[x - 1][y].free() || differentSide(tiles[x - 1][y]))) {
            moves.add(tiles[x - 1][y]);
        }
        if (x + 1 < 8 && y + 1 < 8 && (tiles[x + 1][y + 1].free() || differentSide(tiles[x + 1][y + 1]))) {
            moves.add(tiles[x + 1][y + 1]);
        }
        if (x + 1 < 8 && y - 1 >= 0 && (tiles[x + 1][y - 1].free() || differentSide(tiles[x + 1][y - 1]))) {
            moves.add(tiles[x + 1][y - 1]);
        }
        if (x - 1 >= 0 && y + 1 < 8 && (tiles[x - 1][y + 1].free() || differentSide(tiles[x - 1][y + 1]))) {
            moves.add(tiles[x - 1][y + 1]);
        }
        if (x - 1 >= 0 && y - 1 >= 0 && (tiles[x - 1][y - 1].free() || differentSide(tiles[x - 1][y - 1]))) {
            moves.add(tiles[x - 1][y - 1]);
        }
        
        return moves;
    }
    
    @Override
    public int getValue() {
        int value = 900;
        if (side == Side.BLACK) {
            value = value * (-1);
        }
        return value;
    }
}
