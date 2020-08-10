package domain.board;

import chess.model.Side;
import domain.pieces.*;
import java.util.ArrayList;

public class Board {
    
    private Tile[][] tiles;
    private TileNameConverter converter;
    private Side black = Side.BLACK;
    private Side white = Side.WHITE;
    
    public Board() {
        this.tiles = new Tile[8][8];
        this.converter = new TileNameConverter();
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
    public ArrayList<String> getPossibleMoves(Side side) {
        ArrayList<String> moves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.tiles[i][j].getPiece() != null && tiles[i][j].getPiece().onBoard() && tiles[i][j].getPiece().getSide() == side) {
                    String name = converter.convert(i, j);
                    for (Tile tile : tiles[i][j].getPiece().getPossibleMoves(this)) {
                        name += converter.convert(tile.getX(), tile.getY());
                        moves.add(name);
                        name = converter.convert(i, j);
                    }
                }
            }
        }
        return moves;
    }
    
    public void addParsedMoves(Tile tile, ArrayList<String> moves) {
        
    }
}