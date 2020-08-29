package domain.board;

import chess.model.Side;
import datastructureproject.datastructure.ArrayList;
import datastructureproject.datastructure.HashMap;
import domain.pieces.*;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private Board board;
    
    @Before
    public void setupBoard() {
        this.board = new Board();
        this.board.setupBoard();
        this.board.setupPieces();
    }
    
    @Test
    public void boardIsSet() {
        assertTrue(this.board.getBoard() != null);
    }
    
    @Test
    public void tilesAreSet() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tile t = new Tile(i, j);
                assertEquals(t, board.getBoard()[i][j]);
            }
        }
    }
    
    @Test
    public void piecesAreSet() {
        for (int i = 0; i < 8; i++) {
            PieceName pawn = PieceName.PAWN;
            assertTrue(this.board.getBoard()[i][1].getPiece().getType() == pawn);
            assertTrue(this.board.getBoard()[i][6].getPiece().getType() == pawn);
        }
        PieceName rook = PieceName.ROOK;
        assertTrue(this.board.getBoard()[0][0].getPiece().getType() == rook);
        assertTrue(this.board.getBoard()[0][7].getPiece().getType() == rook);
        assertTrue(this.board.getBoard()[7][0].getPiece().getType() == rook);
        assertTrue(this.board.getBoard()[7][7].getPiece().getType() == rook);
        
        PieceName knight = PieceName.KNIGHT;
        assertTrue(this.board.getBoard()[1][0].getPiece().getType() == knight);
        assertTrue(this.board.getBoard()[6][0].getPiece().getType() == knight);
        assertTrue(this.board.getBoard()[1][7].getPiece().getType() == knight);
        assertTrue(this.board.getBoard()[6][7].getPiece().getType() == knight);
        
        PieceName bishop = PieceName.BISHOP;      
        assertTrue(this.board.getBoard()[2][0].getPiece().getType() == bishop);
        assertTrue(this.board.getBoard()[5][0].getPiece().getType() == bishop);
        assertTrue(this.board.getBoard()[2][7].getPiece().getType() == bishop);
        assertTrue(this.board.getBoard()[5][7].getPiece().getType() == bishop);
        
        PieceName queen = PieceName.QUEEN;  
        assertTrue(this.board.getBoard()[3][0].getPiece().getType() == queen);
        assertTrue(this.board.getBoard()[3][7].getPiece().getType() == queen);
        
        PieceName king = PieceName.KING;
        assertTrue(this.board.getBoard()[4][0].getPiece().getType() == king);
        assertTrue(this.board.getBoard()[4][7].getPiece().getType() == king);
    }
    
    @Test
    public void areRightMovesReturnedForAllPiecesOnBoard() {
        HashMap blackMoves = this.board.getPossibleMoves(Side.BLACK);
        HashMap whiteMoves = this.board.getPossibleMoves(Side.WHITE);
        for(int i = 0; i < 8; i++) {
            assertTrue(blackMoves.get(new Tile(i, 1)).size() == 1);
            assertTrue(whiteMoves.get(new Tile(i, 6)).size() == 1);
        }
        assertTrue(blackMoves.get(new Tile(1, 0)).size() == 2);
        assertTrue(blackMoves.get(new Tile(6, 0)).size() == 2);
        assertTrue(whiteMoves.get(new Tile(1, 7)).size() == 2);
        assertTrue(whiteMoves.get(new Tile(6, 7)).size() == 2);
    }
    
    @Test
    public void areValidMovesReturned() {
        HashMap blackMoves = this.board.getPossibleMoves(Side.BLACK);
        
        TileNameConverter converter = new TileNameConverter();
        Tile start = this.board.getBoard()[0][1];
        Tile finish = (Tile) blackMoves.get(start).get(0);
        
        String move = converter.convertToString(start.getX(), start.getY());
        move += converter.convertToString(finish.getX(), finish.getY());
        
        assertEquals("a7a6", move);
    }
    
    @Test 
    public void isRightValueReturned() {
        assertEquals(0, board.getBoardValue());
    }
    
    @Test
    public void areLegalMovesReturnedWhenKingIsCheckedByQueen() {
        Board testBoard = new Board();
        testBoard.setupBoard();
        
        testBoard.getBoard()[0][0].setPiece(new King(Side.BLACK));
        testBoard.getBoard()[2][2].setPiece(new Queen(Side.WHITE));
        
        HashMap blackMoves = testBoard.getPossibleMoves(Side.BLACK);
        
        assertEquals(2, blackMoves.get(new Tile(0, 0)).size());
        
        assertTrue(blackMoves.get(new Tile(0, 0)).contains(new Tile(1, 0)));
        assertTrue(blackMoves.get(new Tile(0, 0)).contains(new Tile(0, 1)));
    }
    
    @Test
    public void areLegalMovesReturnedWhenKingIsCheckedByRook() {
        Board testBoard = new Board();
        testBoard.setupBoard();
        
        testBoard.getBoard()[6][4].setPiece(new Rook(Side.BLACK));
        testBoard.getBoard()[4][0].setPiece(new Rook(Side.BLACK));
        testBoard.getBoard()[7][0].setPiece(new King(Side.WHITE));
        
        HashMap whiteMoves = testBoard.getPossibleMoves(Side.WHITE);
        assertEquals(1, whiteMoves.get(new Tile(7, 0)).size());
        assertEquals(new Tile(7, 1), whiteMoves.get(new Tile(7, 0)).get(0));
    }
    
    @Test
    public void areLegalMovesReturnedWhenKingIsCheckedByKnight() {
        Board testBoard = new Board();
        testBoard.setupBoard();
        
        testBoard.getBoard()[0][0].setPiece(new King(Side.BLACK));
        testBoard.getBoard()[2][2].setPiece(new Knight(Side.WHITE));

        HashMap blackMoves = testBoard.getPossibleMoves(Side.BLACK);
        
        assertEquals(1, blackMoves.get(new Tile(0, 0)).size());
        
        assertTrue(blackMoves.get(new Tile(0, 0)).contains(new Tile(1, 1)));
    }
    
    @Test
    public void areLegalMovesReturnedWhenKingIsCheckedByPawn() {
        Board testBoard = new Board();
        testBoard.setupBoard();
        
        testBoard.getBoard()[0][0].setPiece(new King(Side.BLACK));
        testBoard.getBoard()[2][2].setPiece(new Pawn(Side.WHITE));
        
        HashMap blackMoves = testBoard.getPossibleMoves(Side.BLACK);
        
        assertEquals(2, blackMoves.get(new Tile(0, 0)).size());
        
        assertTrue(blackMoves.get(new Tile(0, 0)).contains(new Tile(1, 0)));
        assertTrue(blackMoves.get(new Tile(0, 0)).contains(new Tile(0, 1)));
    }
    
    @Test
    public void canPiecesShieldKingWhenNoOtherOption() {
        Board testBoard = new Board();
        testBoard.setupBoard();
        
        testBoard.getBoard()[4][7].setPiece(new King(Side.WHITE));
        testBoard.getBoard()[5][7].setPiece(new Bishop(Side.WHITE));
        testBoard.getBoard()[4][6].setPiece(new Pawn(Side.WHITE));
        testBoard.getBoard()[3][6].setPiece(new Pawn(Side.WHITE));
        testBoard.getBoard()[3][7].setPiece(new Queen(Side.WHITE));
        testBoard.getBoard()[6][3].setPiece(new Rook(Side.WHITE));
        
        testBoard.getBoard()[7][4].setPiece(new Queen(Side.BLACK));
        
        HashMap whiteMoves = testBoard.getPossibleMoves(Side.WHITE);
        
        assertEquals(1, whiteMoves.get(new Tile(6, 3)).size());
        assertEquals(new Tile(6, 5), whiteMoves.get(new Tile(6, 3)).get(0));
        assertEquals(1, whiteMoves.keySet().size());
    }
    
    @Test
    public void doesKingRemoveOpponentWhenThereIsNoOtherOption() {
        Board testBoard = new Board();
        testBoard.setupBoard();
        
        testBoard.getBoard()[4][7].setPiece(new King(Side.WHITE));
        testBoard.getBoard()[5][7].setPiece(new Bishop(Side.WHITE));
        testBoard.getBoard()[4][6].setPiece(new Pawn(Side.WHITE));
        testBoard.getBoard()[5][6].setPiece(new Pawn(Side.WHITE));
        testBoard.getBoard()[3][6].setPiece(new Bishop(Side.WHITE));
        
        testBoard.getBoard()[4][2].setPiece(new Queen(Side.BLACK));
        testBoard.getBoard()[3][5].setPiece(new Knight(Side.BLACK));
        testBoard.getBoard()[3][7].setPiece(new Bishop(Side.BLACK));
        
        
        HashMap whiteMoves = testBoard.getPossibleMoves(Side.WHITE);
        
        assertEquals(1, whiteMoves.get(new Tile(4, 7)).size());
        assertEquals(new Tile(3, 7), whiteMoves.get(new Tile(4, 7)).get(0));
        assertEquals(1, whiteMoves.keySet().size());
    }
    
    @Test
    public void testGameSituation() {
        Board testboard = new Board();
        testboard.setupBoard();
        
        testboard.getBoard()[0][0].setPiece(new Rook(Side.BLACK));
        testboard.getBoard()[0][1].setPiece(new Pawn(Side.BLACK));
        testboard.getBoard()[0][2].setPiece(new Pawn(Side.BLACK));
        testboard.getBoard()[0][4].setPiece(new Queen(Side.BLACK));
        testboard.getBoard()[1][4].setPiece(new Bishop(Side.BLACK));
        testboard.getBoard()[1][5].setPiece(new Knight(Side.BLACK));
        testboard.getBoard()[2][1].setPiece(new Pawn(Side.BLACK));
        testboard.getBoard()[3][3].setPiece(new Pawn(Side.BLACK));
        testboard.getBoard()[4][3].setPiece(new Pawn(Side.BLACK));
        testboard.getBoard()[5][0].setPiece(new Rook(Side.BLACK));
        testboard.getBoard()[5][1].setPiece(new Pawn(Side.BLACK));
        testboard.getBoard()[6][0].setPiece(new King(Side.BLACK));
        testboard.getBoard()[6][1].setPiece(new Pawn(Side.BLACK));
        testboard.getBoard()[7][3].setPiece(new Pawn(Side.BLACK));
        
        testboard.getBoard()[1][6].setPiece(new Pawn(Side.WHITE));
        testboard.getBoard()[2][7].setPiece(new Bishop(Side.WHITE));
        testboard.getBoard()[3][5].setPiece(new Pawn(Side.WHITE));
        testboard.getBoard()[4][6].setPiece(new Pawn(Side.WHITE));
        testboard.getBoard()[4][7].setPiece(new King(Side.WHITE));
        testboard.getBoard()[5][6].setPiece(new Pawn(Side.WHITE));
        testboard.getBoard()[5][7].setPiece(new Bishop(Side.WHITE));
        testboard.getBoard()[6][5].setPiece(new Knight(Side.WHITE));
        testboard.getBoard()[6][6].setPiece(new Pawn(Side.WHITE));
        testboard.getBoard()[6][7].setPiece(new Knight(Side.WHITE));
        testboard.getBoard()[7][6].setPiece(new Pawn(Side.WHITE));
        testboard.getBoard()[7][7].setPiece(new Rook(Side.WHITE));
           
        HashMap white = testboard.getPossibleMoves(Side.WHITE);
       
        assertEquals(new Tile(2, 7), white.keySet().get(0));
        assertEquals(new Tile(3, 6), white.get(new Tile(2, 7)).get(0));
        assertEquals(2, white.keySet().size());
    }
    
    @Test
    public void testGameSituation2() {
        Board test = new Board();
        test.setupBoard();
        
        test.getBoard()[3][6].setPiece(new Rook(Side.BLACK));
        test.getBoard()[2][7].setPiece(new Queen(Side.BLACK));
        test.getBoard()[4][6].setPiece(new King(Side.WHITE));
        test.getBoard()[4][5].setPiece(new Pawn(Side.WHITE));
        
        HashMap white = test.getPossibleMoves(Side.WHITE);
        
        assertEquals(1, white.keySet().size());
        Tile t = (Tile) white.get(new Tile(4, 6)).get(0);
        assertEquals(1, white.get(new Tile(4, 6)).size());
        assertEquals(new Tile(5, 5), t);
    }
    
    @After
    public void tearDown() {
    
    }
}
