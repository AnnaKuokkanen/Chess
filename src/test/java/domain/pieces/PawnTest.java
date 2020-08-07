package domain.pieces;

import chess.model.Side;
import domain.board.*;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class PawnTest {
    private Pawn blackPawn;
    private Pawn whitePawn;
    private Board board;
    
    @Before
    public void setUp() {
        this.whitePawn = new Pawn(Side.WHITE);
        this.blackPawn = new Pawn(Side.BLACK);
    }
    
    @Test
    public void doesPawnHaveTheRightValue() {
        assertEquals(-10, this.blackPawn.getValue());
        assertEquals(10, this.whitePawn.getValue());
    }
    
    @Test
    public void doesPawnMoveForwardWhenThereIsSpace() {
        this.board = new Board();
        this.board.setupBoard();
        ArrayList<Tile> moves = new ArrayList<>();
        
        this.board.getBoard()[1][1].setPiece(whitePawn);
        
        for (Tile tile : whitePawn.getPossibleMoves(board)) {
            moves.add(tile);
        }
        assertTrue(moves.size() == 1);
        assertTrue(moves.contains(new Tile(1, 2)));
    }
    
    @Test
    public void doesPawnStayIfThereIsPieceInFront() {
        this.board = new Board();
        this.board.setupBoard();
        ArrayList<Tile> moves = new ArrayList<>();
        
        this.board.getBoard()[1][1].setPiece(whitePawn);
        this.board.getBoard()[1][2].setPiece(new Knight(Side.WHITE));
        
        for (Tile tile : whitePawn.getPossibleMoves(board)) {
            moves.add(tile);
        }
        assertTrue(moves.isEmpty());
    }
    
    @Test
    public void doesPawnMoveDiagonallyWhenThereIsOppositePiece() {
        this.board = new Board();
        this.board.setupBoard();
        ArrayList<Tile> moves = new ArrayList<>();
        
        this.board.getBoard()[1][1].setPiece(whitePawn);
        this.board.getBoard()[0][2].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[1][2].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[2][2].setPiece(new Pawn(Side.BLACK));
        
        for (Tile tile : whitePawn.getPossibleMoves(board)) {
            moves.add(tile);
        }
        assertTrue(moves.size() == 2);
        assertTrue(moves.contains(new Tile(0, 2)));
        assertTrue(moves.contains(new Tile(2, 2)));
    }
    
    @Test
    public void doesPawnStayIfThereIsSameSidePieceDiagonally() {
        this.board = new Board();
        this.board.setupBoard();
        ArrayList<Tile> moves = new ArrayList<>();
        
        this.board.getBoard()[1][1].setPiece(whitePawn);
        this.board.getBoard()[0][2].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[1][2].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[2][2].setPiece(new Pawn(Side.WHITE));
        
        for (Tile tile : whitePawn.getPossibleMoves(board)) {
            moves.add(tile);
        }
        assertTrue(moves.isEmpty());
    }
}
