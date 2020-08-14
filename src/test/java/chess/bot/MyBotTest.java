package chess.bot;

import chess.engine.GameState;
import domain.board.Board;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MyBotTest {
    private Board board;
    
    @Before
    public void setupBoard() {
        this.board = new Board();
        this.board.setupBoard();
        this.board.setupPieces();
    }
    
    @Test
    public void doesBotReturnValidMoves() {
        MyBot bot = new MyBot();
        assertEquals("a7a6", bot.nextMove(new GameState()));
        assertEquals("a8a7", bot.nextMove(new GameState()));
        assertEquals("a7a8", bot.nextMove(new GameState()));
    }
    
    @After
    public void tearDown() {
    
    }

}
