package domain.board;

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
    
    @After
    public void tearDown() {
    
    }
}
