package datastructureproject.algorithm;

import chess.bot.MyBot;
import chess.engine.GameState;
import chess.model.Side;
import domain.board.Board;
import domain.pieces.*;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class AlphaBetaPruningTest {
    
    private Board board;
    
    @Before
    public void setup() {
        this.board = new Board();
        board.setupBoard();
    }
    
    @Test
    public void testFirstGameSituation() {
        board.getBoard()[7][0].setPiece(new Queen(Side.WHITE));
        board.getBoard()[3][5].setPiece(new King(Side.WHITE));
        
        board.getBoard()[4][0].setPiece(new Rook(Side.BLACK));
        board.getBoard()[6][4].setPiece(new King(Side.BLACK));
        
        AlphaBetaPruning ab = new AlphaBetaPruning(board, 2);
        
        assertEquals("h8h5", ab.useAlphaBetaPruner(Side.WHITE));
    }
    
    @Test
    public void testSecondGameSituation() {
        
    }
}
