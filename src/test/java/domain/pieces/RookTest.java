package domain.pieces;

import chess.model.Side;
import domain.board.*;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class RookTest {
    private Rook blackRook;
    private Rook whiteRook;
    private Board board;
    
    @Before
    public void setUp() {
        this.whiteRook = new Rook(Side.WHITE);
        this.blackRook = new Rook(Side.BLACK);
    }
    
    @Test
    public void doesRookHaveTheRightValue() {
        assertEquals(-50, this.blackRook.getValue());
        assertEquals(50, this.whiteRook.getValue());
    }
    
    @Test
    public void doesRookMoveWhenTilesAreFree() {
        this.board = new Board();
        this.board.setupBoard();
        ArrayList<Tile> moves = new ArrayList<>();
        
        this.board.getBoard()[1][1].setPiece(blackRook);
        
        for (Tile tile : blackRook.getPossibleMoves(board)) {
            moves.add(tile);
        } 
        assertTrue(moves.size() == 14);
        assertTrue(moves.contains(new Tile(0, 1)));
        assertTrue(moves.contains(new Tile(2, 1)));
        assertTrue(moves.contains(new Tile(3, 1)));
        assertTrue(moves.contains(new Tile(4, 1)));
        assertTrue(moves.contains(new Tile(5, 1)));
        assertTrue(moves.contains(new Tile(6, 1)));
        assertTrue(moves.contains(new Tile(7, 1)));
        
        assertTrue(moves.contains(new Tile(1, 0)));
        assertTrue(moves.contains(new Tile(1, 2)));
        assertTrue(moves.contains(new Tile(1, 3)));
        assertTrue(moves.contains(new Tile(1, 4)));
        assertTrue(moves.contains(new Tile(1, 5)));
        assertTrue(moves.contains(new Tile(1, 6)));
        assertTrue(moves.contains(new Tile(1, 7)));
    }
    
    @Test
    public void doesRookMoveWhenTilesOccupiedByOpponents() {
        this.board = new Board();
        this.board.setupBoard();
        ArrayList<Tile> moves = new ArrayList<>();
        
        this.board.getBoard()[1][1].setPiece(blackRook);
        this.board.getBoard()[0][1].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[1][0].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[2][1].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[1][2].setPiece(new Pawn(Side.WHITE));
        
        for (Tile tile : blackRook.getPossibleMoves(board)) {
            moves.add(tile);
        }
        
        assertTrue(moves.size() == 4);
        assertTrue(moves.contains(new Tile(0, 1)));
        assertTrue(moves.contains(new Tile(1, 0)));
        assertTrue(moves.contains(new Tile(2, 1)));
        assertTrue(moves.contains(new Tile(1, 2)));     
    }
    
    @Test
    public void doesRookStayIfTilesAreOccupiedBySameSidePieces() {
        this.board = new Board();
        this.board.setupBoard();
        ArrayList<Tile> moves = new ArrayList<>();
        
        this.board.getBoard()[1][1].setPiece(blackRook);
        this.board.getBoard()[0][1].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[1][0].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[2][1].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[1][2].setPiece(new Pawn(Side.BLACK));
        
        for (Tile tile : blackRook.getPossibleMoves(board)) {
            moves.add(tile);
        } 
        assertTrue(moves.isEmpty());
    }
}
