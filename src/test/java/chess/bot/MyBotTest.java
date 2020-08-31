package chess.bot;

import chess.engine.GameState;
import domain.board.Tile;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class MyBotTest {
    private ChessBot bot;
    
    @Before
    public void setupBot() {
        this.bot = new MyBot(2);
    }
    
//    @Test
//    public void doesBotReturnValidMoves() {        
//        assertEquals("a7a6", bot.nextMove(new GameState()));
//        assertEquals("a8a7", bot.nextMove(new GameState()));
//        assertEquals("a7a8", bot.nextMove(new GameState()));
//    }
//    
//    @Test
//    public void doesBotRespondCorrectly() {
//        GameState gs = new GameState();
//        Tile start = new Tile(0, 1);
//        Tile finish = new Tile(0, 2);
//        assertTrue(start.getPiece() == null);
//        bot.nextMove(gs);
//        //assertEquals("a7a6", bot.nextMove(new GameState()));
//        assertTrue(finish.getPiece() != null);
//        gs.setMoves("");
//    }
    
    @After
    public void tearDown() {
    
    }

}
