package domain.pieces;

import chess.model.Side;
import datastructureproject.datastructure.ArrayList;
import domain.board.*;
//import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class PawnTest {
    private Pawn blackPawn;
    private Pawn whitePawn;
    private Board board;
    private ArrayList blackMoves;
    private ArrayList whiteMoves;
    
    @Before
    public void setUp() {
        this.whitePawn = new Pawn(Side.WHITE);
        this.blackPawn = new Pawn(Side.BLACK);
        
        this.board = new Board();
        this.board.setupBoard();
        
        this.board.getBoard()[6][6].setPiece(whitePawn);
        this.board.getBoard()[1][1].setPiece(blackPawn);
        
        this.blackMoves = new ArrayList();
        this.whiteMoves = new ArrayList();
    }
    
    @Test
    public void doesPawnHaveTheRightValue() {
        assertEquals(-10, this.blackPawn.getValue());
        assertEquals(10, this.whitePawn.getValue());
    }
    
    @Test
    public void doesPawnMoveForwardWhenThereIsSpace() {        
        for (int i = 0; i < whitePawn.getPossibleMoves(board).size(); i++) {
            whiteMoves.add((Tile)whitePawn.getPossibleMoves(board).get(i));
        }
        assertTrue(whiteMoves.size() == 1);
        assertTrue(whiteMoves.contains(new Tile(6, 5)));
        
        for (int i = 0; i < blackPawn.getPossibleMoves(board).size(); i++) {
            blackMoves.add((Tile)blackPawn.getPossibleMoves(board).get(i));
        }
        assertTrue(blackMoves.size() == 1);
        assertTrue(blackMoves.contains(new Tile(1, 2)));
    }
    
    @Test
    public void doesPawnStayIfThereIsPieceInFront() {
        this.board.getBoard()[1][2].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[6][5].setPiece(new Pawn(Side.WHITE));
        
        for (int i = 0; i < whitePawn.getPossibleMoves(board).size(); i++) {
            whiteMoves.add((Tile)whitePawn.getPossibleMoves(board).get(i));
        }
        
        assertTrue(whiteMoves.isEmpty());
        
        for (int i = 0; i < blackPawn.getPossibleMoves(board).size(); i++) {
            blackMoves.add((Tile)blackPawn.getPossibleMoves(board).get(i));
        }
        
        assertTrue(blackMoves.isEmpty());
    }
    
    @Test
    public void doesPawnMoveDiagonallyWhenThereIsOppositePiece() {
        this.board.getBoard()[0][2].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[1][2].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[2][2].setPiece(new Pawn(Side.WHITE));
        
        this.board.getBoard()[5][5].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[6][5].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[7][5].setPiece(new Pawn(Side.BLACK));
        
        for (int i = 0; i < whitePawn.getPossibleMoves(board).size(); i++) {
            whiteMoves.add((Tile)whitePawn.getPossibleMoves(board).get(i));
        }
        
        assertTrue(whiteMoves.size() == 2);
        assertTrue(whiteMoves.contains(new Tile(5, 5)));
        assertTrue(whiteMoves.contains(new Tile(7, 5)));
        
        for (int i = 0; i < blackPawn.getPossibleMoves(board).size(); i++) {
            blackMoves.add((Tile)blackPawn.getPossibleMoves(board).get(i));
        }
        assertTrue(blackMoves.size() == 2);
        assertTrue(blackMoves.contains(new Tile(0, 2)));
        assertTrue(blackMoves.contains(new Tile(2, 2)));
    }
    
    @Test
    public void doesPawnStayIfThereIsSameSidePieceDiagonally() {
        this.board.getBoard()[0][2].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[1][2].setPiece(new Pawn(Side.BLACK));
        this.board.getBoard()[2][2].setPiece(new Pawn(Side.BLACK));
        
        this.board.getBoard()[5][5].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[6][5].setPiece(new Pawn(Side.WHITE));
        this.board.getBoard()[7][5].setPiece(new Pawn(Side.WHITE));
        
        for (int i = 0; i < whitePawn.getPossibleMoves(board).size(); i++) {
            whiteMoves.add((Tile)whitePawn.getPossibleMoves(board).get(i));
        }
        
        assertTrue(whiteMoves.isEmpty());
        
        for (int i = 0; i < blackPawn.getPossibleMoves(board).size(); i++) {
            blackMoves.add((Tile)blackPawn.getPossibleMoves(board).get(i));
        }
        
        assertTrue(blackMoves.isEmpty());
    }
}
