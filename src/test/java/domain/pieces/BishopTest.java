package domain.pieces;

import chess.model.Side;
import datastructureproject.datastructure.ArrayList;
import domain.board.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class BishopTest {
    private Bishop blackBishop;
    private Bishop whiteBishop;
    private Board board;
    
    @Before
    public void setUp() {
        this.whiteBishop = new Bishop(Side.WHITE);
        this.blackBishop = new Bishop(Side.BLACK);
    }
    
    @Test
    public void doesBishopHaveTheRightValue() {
        assertEquals(-30, this.blackBishop.getValue());
        assertEquals(30, this.whiteBishop.getValue());
    }
    
    @Test
    public void doesBishopMoveWhenTilesAreFree() {
        this.board = new Board();
        this.board.setupBoard();
        ArrayList moves = new ArrayList();
        
        this.board.getBoard()[4][2].setPiece(whiteBishop);
        
        for (int i = 0; i < whiteBishop.getPossibleMoves(board).size(); i++) {
            moves.add((Tile)whiteBishop.getPossibleMoves(board).get(i));
        }
        assertTrue(moves.size() == 11);
        assertTrue(moves.contains(new Tile(2, 0)));
        assertTrue(moves.contains(new Tile(6, 0)));
        assertTrue(moves.contains(new Tile(3, 1)));
        assertTrue(moves.contains(new Tile(5, 1)));
        assertTrue(moves.contains(new Tile(3, 3)));
        assertTrue(moves.contains(new Tile(5, 3)));
        assertTrue(moves.contains(new Tile(2, 4)));
        assertTrue(moves.contains(new Tile(6, 4)));
        assertTrue(moves.contains(new Tile(1, 5)));
        assertTrue(moves.contains(new Tile(7, 5)));
        assertTrue(moves.contains(new Tile(0, 6)));     
    }
    
    @Test
    public void doesBishopMoveWhenTilesOccupiedByOpponents() {
        this.board = new Board();
        this.board.setupBoard();
        ArrayList moves = new ArrayList();
        
        this.board.getBoard()[4][2].setPiece(whiteBishop);
        this.board.getBoard()[3][1].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[5][1].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[3][3].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[5][3].setPiece(new Pawn(Side.BLACK));
        
        for (int i = 0; i < whiteBishop.getPossibleMoves(board).size(); i++) {
            moves.add((Tile)whiteBishop.getPossibleMoves(board).get(i));
        }
        assertTrue(moves.size() == 4);
        assertTrue(moves.contains(new Tile(3, 1)));
        assertTrue(moves.contains(new Tile(5, 1)));
        assertTrue(moves.contains(new Tile(3, 3)));
        assertTrue(moves.contains(new Tile(5, 3)));
    }
    
    @Test
    public void doesBishopStayIfTilesAreOccupiedBySameSidePieces() {
        this.board = new Board();
        this.board.setupBoard();
        ArrayList moves = new ArrayList();
        
        this.board.getBoard()[4][2].setPiece(whiteBishop);
        this.board.getBoard()[3][1].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[5][1].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[3][3].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[5][3].setPiece(new Pawn(Side.WHITE));
        
        for (int i = 0; i < whiteBishop.getPossibleMoves(board).size(); i++) {
            moves.add((Tile)whiteBishop.getPossibleMoves(board).get(i));
        }
        assertTrue(moves.isEmpty());
    }
}
