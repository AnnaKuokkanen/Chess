package domain.board;

import chess.model.Side;
import domain.pieces.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Board {
    
    private Tile[][] tiles;
    private Side black = Side.BLACK;
    private Side white = Side.WHITE;
    private HashMap<Tile, ArrayList<Tile>> moves;
    
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
    public HashMap<Tile, ArrayList<Tile>> getPossibleMoves(Side side) {
        this.moves = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.moves.put(tiles[i][j], new ArrayList<>());
                if (!this.tiles[i][j].free()) {
                    if (tiles[i][j].getPiece().onBoard() && tiles[i][j].getPiece().getSide() == side) { 
                        ArrayList<Tile> list = this.moves.get(tiles[i][j]);
                        for (Tile tile : tiles[i][j].getPiece().getPossibleMoves(this)) {
                            list.add(tile);
                        }
                        moves.replace(tiles[i][j], list);
                    }
                }
            }
        }
        return moves;
    }
}