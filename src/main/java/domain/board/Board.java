package domain.board;

import chess.model.Side;
import datastructureproject.datastructure.ArrayList;
import domain.pieces.*;
//import java.util.ArrayList;
import java.util.HashMap;

public class Board {
    
    private final Tile[][] tiles;
    private final Side black = Side.BLACK;
    private final Side white = Side.WHITE;
    private HashMap<Tile, ArrayList> moves;
    
    public Board() {
        this.tiles = new Tile[8][8];
    }
    
    /**
     * method that sets up board consisting of tiles
     */
    public void setupBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.tiles[i][j] = new Tile(i, j);
            }
        }
    }
    /**
     * method that assigns pieces to their starting positions
     */
    public void setupPieces() {
        tiles[0][0].setPiece(new Rook(black));
        tiles[1][0].setPiece(new Knight(black));
        tiles[2][0].setPiece(new Bishop(black));
        tiles[3][0].setPiece(new Queen(black));
        tiles[4][0].setPiece(new King(black));
        tiles[5][0].setPiece(new Bishop(black));
        tiles[6][0].setPiece(new Knight(black));
        tiles[7][0].setPiece(new Rook(black));
        for (int i = 0; i < 8; i++) {
            tiles[i][1].setPiece(new Pawn(black));
        }
        
        tiles[0][7].setPiece(new Rook(white));
        tiles[1][7].setPiece(new Knight(white));
        tiles[2][7].setPiece(new Bishop(white));
        tiles[3][7].setPiece(new Queen(white));
        tiles[4][7].setPiece(new King(white));
        tiles[5][7].setPiece(new Bishop(white));
        tiles[6][7].setPiece(new Knight(white));
        tiles[7][7].setPiece(new Rook(white));
        for (int i = 0; i < 8; i++) {
            tiles[i][6].setPiece(new Pawn(white));
        }
    }
    
    /**
     * @return current board situation
     */
    public Tile[][] getBoard() {
        return this.tiles;
    }
    
    /**
     * @return all possible moves in current game situation parsed to String
     */
    public HashMap<Tile, ArrayList> getPossibleMoves(Side side) {
        this.moves = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.moves.put(tiles[i][j], new ArrayList());
                if (!this.tiles[i][j].free()) {
                    if (tiles[i][j].getPiece().getSide() == side) { 
                        ArrayList list = this.moves.get(tiles[i][j]);
                        for (int k = 0; k < tiles[i][j].getPiece().getPossibleMoves(this).size(); k++) {
                            list.add((Tile)tiles[i][j].getPiece().getPossibleMoves(this).get(k));
                        }
                        moves.replace(tiles[i][j], list);
                    }
                }
            }
        }
        return moves;
    }
    
    /**
     * this method counts the sum of
     * values of all pieces on board
     * @return int sum
     */
    public int getBoardValue() {
        int sum = 0;
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tiles[i][j].getPiece() != null) {
                    sum += tiles[i][j].getPiece().getValue();
                } 
            }
        }
        return sum; 
    }
}