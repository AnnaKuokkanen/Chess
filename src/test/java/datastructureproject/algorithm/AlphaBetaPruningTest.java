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
        board.getBoard()[0][0].setPiece(new Rook(Side.BLACK));
        board.getBoard()[0][1].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[0][2].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[0][4].setPiece(new Queen(Side.BLACK));
        board.getBoard()[1][4].setPiece(new Bishop(Side.BLACK));
        board.getBoard()[1][5].setPiece(new Knight(Side.BLACK));
        board.getBoard()[2][1].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[3][3].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[4][3].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[5][0].setPiece(new Rook(Side.BLACK));
        board.getBoard()[5][1].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[6][0].setPiece(new King(Side.BLACK));
        board.getBoard()[6][1].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[7][3].setPiece(new Pawn(Side.BLACK));
        
        board.getBoard()[1][6].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[2][7].setPiece(new Bishop(Side.WHITE));
        board.getBoard()[3][5].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[4][6].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[4][7].setPiece(new King(Side.WHITE));
        board.getBoard()[5][6].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[5][7].setPiece(new Bishop(Side.WHITE));
        board.getBoard()[6][5].setPiece(new Knight(Side.WHITE));
        board.getBoard()[6][6].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[6][7].setPiece(new Knight(Side.WHITE));
        board.getBoard()[7][6].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[7][7].setPiece(new Rook(Side.WHITE));
        
        AlphaBetaPruning ab = new AlphaBetaPruning(board, 3);
        
        assertEquals("e1d1", ab.useAlphaBetaPruner(Side.WHITE));
    }
    
    @Test
    public void testSecondGameSituation() {
        
        board.getBoard()[0][7].setPiece(new Rook(Side.BLACK));
        board.getBoard()[1][1].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[1][3].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[1][5].setPiece(new Knight(Side.BLACK));
        board.getBoard()[2][4].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[3][2].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[4][1].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[5][1].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[6][0].setPiece(new King(Side.BLACK));
        board.getBoard()[6][1].setPiece(new Bishop(Side.BLACK));
        board.getBoard()[7][2].setPiece(new Pawn(Side.BLACK));
        
        board.getBoard()[1][7].setPiece(new King(Side.WHITE));
        board.getBoard()[1][6].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[3][6].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[4][5].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[5][5].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[6][5].setPiece(new Rook(Side.WHITE));    
        board.getBoard()[7][3].setPiece(new Pawn(Side.WHITE));
        
        AlphaBetaPruning ab = new AlphaBetaPruning(board, 3);
        
        assertEquals("b1c2", ab.useAlphaBetaPruner(Side.WHITE));
    }
}
