package domain.board;

import domain.pieces.PieceName;
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
    
    @After
    public void tearDown() {
    
    }
}
