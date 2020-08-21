package domain.pieces;

import chess.model.Side;
import datastructureproject.datastructure.ArrayList;
import domain.board.*;
//import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class QueenTest {
    private Queen blackQueen;
    private Queen whiteQueen;
    private Board board;
    
    @Before
    public void setUp() {
        this.whiteQueen = new Queen(Side.WHITE);
        this.blackQueen = new Queen(Side.BLACK);
    }
    
    @Test
    public void doesQueenHaveTheRightValue() {
        assertEquals(-90, this.blackQueen.getValue());
        assertEquals(90, this.whiteQueen.getValue());
    }
    
    @Test
    public void doesQueenMoveWhenTilesAreFree() {
         this.board = new Board();
        this.board.setupBoard();
        ArrayList moves = new ArrayList();
        
        this.board.getBoard()[4][2].setPiece(whiteQueen);
        
        for (int i = 0; i < whiteQueen.getPossibleMoves(board).size(); i++) {
            moves.add((Tile)whiteQueen.getPossibleMoves(board).get(i));
        }
        assertTrue(moves.size() == 25);
    }
    
    @Test
    public void doesQueenMoveWhenTilesOccupiedByOpponents() {
         this.board = new Board();
        this.board.setupBoard();
        ArrayList moves = new ArrayList();
        
        this.board.getBoard()[4][2].setPiece(whiteQueen);
        
        this.board.getBoard()[3][1].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[4][1].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[5][1].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[3][2].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[5][2].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[3][3].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[4][3].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[5][3].setPiece(new Pawn(Side.BLACK));
        
        for (int i = 0; i < whiteQueen.getPossibleMoves(board).size(); i++) {
            moves.add((Tile)whiteQueen.getPossibleMoves(board).get(i));
        }
        assertTrue(moves.size() == 8);
        assertTrue(moves.contains(new Tile(3, 1)));
        assertTrue(moves.contains(new Tile(4, 1)));
        assertTrue(moves.contains(new Tile(5, 1)));
        assertTrue(moves.contains(new Tile(3, 2)));
        assertTrue(moves.contains(new Tile(5, 2)));
        assertTrue(moves.contains(new Tile(3, 3)));
        assertTrue(moves.contains(new Tile(4, 3)));
        assertTrue(moves.contains(new Tile(5, 3)));
    }
    
    @Test
    public void doesQueenStayIfTilesAreOccupiedBySameSidePieces() {
         this.board = new Board();
        this.board.setupBoard();
        ArrayList moves = new ArrayList();
        
        this.board.getBoard()[4][2].setPiece(whiteQueen);
        
        this.board.getBoard()[3][1].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[4][1].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[5][1].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[3][2].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[5][2].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[3][3].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[4][3].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[5][3].setPiece(new Pawn(Side.WHITE));
        
        for (int i = 0; i < whiteQueen.getPossibleMoves(board).size(); i++) {
            moves.add((Tile)whiteQueen.getPossibleMoves(board).get(i));
        }
        assertTrue(moves.isEmpty());
    }
}
