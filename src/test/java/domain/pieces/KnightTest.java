package domain.pieces;

import chess.model.Side;
import datastructureproject.datastructure.ArrayList;
import domain.board.*;
//import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class KnightTest {
    private Knight blackKnight;
    private Knight whiteKnight;
    private Board board;
    
    @Before
    public void setUp() {
        this.whiteKnight = new Knight(Side.WHITE);
        this.blackKnight = new Knight(Side.BLACK);
    }
    
    @Test
    public void doesKnightHaveTheRightValue() {
        assertEquals(-30, this.blackKnight.getValue());
        assertEquals(30, this.whiteKnight.getValue());
    }
    
    @Test
    public void doesKnightMoveWhenTilesAreFree() {
        this.board = new Board();
        this.board.setupBoard();
        ArrayList moves = new ArrayList();
        
        this.board.getBoard()[4][2].setPiece(whiteKnight);
        
        for (int i = 0; i < whiteKnight.getPossibleMoves(board).size(); i++) {
            moves.add((Tile)whiteKnight.getPossibleMoves(board).get(i));
        }
        assertTrue(moves.size() == 8);
        assertTrue(moves.contains(new Tile(3, 0)));
        assertTrue(moves.contains(new Tile(5, 0)));
        assertTrue(moves.contains(new Tile(2, 1)));
        assertTrue(moves.contains(new Tile(6, 1)));
        assertTrue(moves.contains(new Tile(2, 3)));
        assertTrue(moves.contains(new Tile(6, 3)));
        assertTrue(moves.contains(new Tile(3, 4)));
        assertTrue(moves.contains(new Tile(5, 4)));
    }
    
    @Test
    public void doesKnightMoveWhenTilesOccupiedByOpponents() {
        this.board = new Board();
        this.board.setupBoard();
        ArrayList moves = new ArrayList();
        
        this.board.getBoard()[4][2].setPiece(whiteKnight);
        this.board.getBoard()[3][0].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[5][0].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[2][1].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[6][1].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[2][3].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[6][3].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[3][4].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[5][4].setPiece(new Pawn(Side.BLACK));
        
        for (int i = 0; i < whiteKnight.getPossibleMoves(board).size(); i++) {
            moves.add((Tile)whiteKnight.getPossibleMoves(board).get(i));
        }
        assertTrue(moves.size() == 8);
        assertTrue(moves.contains(new Tile(3, 0)));
        assertTrue(moves.contains(new Tile(5, 0)));
        assertTrue(moves.contains(new Tile(2, 1)));
        assertTrue(moves.contains(new Tile(6, 1)));
        assertTrue(moves.contains(new Tile(2, 3)));
        assertTrue(moves.contains(new Tile(6, 3)));
        assertTrue(moves.contains(new Tile(3, 4)));
        assertTrue(moves.contains(new Tile(5, 4)));
    }
    
    @Test
    public void doesKnightStayIfTilesAreOccupiedBySameSidePieces() {
        this.board = new Board();
        this.board.setupBoard();
        ArrayList moves = new ArrayList();
        
        this.board.getBoard()[4][2].setPiece(whiteKnight);
        this.board.getBoard()[3][0].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[5][0].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[2][1].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[6][1].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[2][3].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[6][3].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[3][4].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[5][4].setPiece(new Pawn(Side.WHITE));
        
        for (int i = 0; i < whiteKnight.getPossibleMoves(board).size(); i++) {
            moves.add((Tile)whiteKnight.getPossibleMoves(board).get(i));
        }
        assertTrue(moves.isEmpty());
    }
}
