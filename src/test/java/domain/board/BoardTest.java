package domain.board;

import chess.model.Side;
import domain.pieces.*;
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
                assertEquals(board.getBoard()[i][j], t);
            }
        }
    }
    
    @Test
    public void piecesAreSet() {
        for (int i = 0; i < 8; i++) {
            PieceName name = PieceName.PAWN;
            assertTrue(this.board.getBoard()[i][1].getPiece().getType() == name);
            assertTrue(this.board.getBoard()[i][6].getPiece().getType() == name);
        }
    }
    
    @After
    public void tearDown() {
    
    }
}
