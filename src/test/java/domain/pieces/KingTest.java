package domain.pieces;

import chess.model.Side;
import domain.board.*;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class KingTest {
    
    private King blackKing;
    private King whiteKing;
    private Board board;
    
    @Before
    public void setUp() {
        this.whiteKing = new King(Side.WHITE);
        this.blackKing = new King(Side.BLACK);
        this.board = new Board();
        this.board.setupBoard();
    }
    
    @Test
    public void doesKingHaveTheRightValue() {
        assertEquals(-900, this.blackKing.getValue());
        assertEquals(900, this.whiteKing.getValue());
    }
    
    @Test
    public void doesKingHaveRightMoves() {
        ArrayList<Tile> moves = new ArrayList<>();
        board.getBoard()[1][1].setPiece(whiteKing);
        board.getBoard()[0][0].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[0][1].setPiece(new Pawn(Side.WHITE));
        board.getBoard()[1][2].setPiece(new Pawn(Side.BLACK));
        board.getBoard()[1][0].setPiece(new Pawn(Side.BLACK));
        
        for (Tile tile : whiteKing.getPossibleMoves(board)) {
            moves.add(tile);
        }
        assertTrue(moves.size() == 6);
        assertTrue(moves.contains(new Tile(1, 0)));
        assertTrue(moves.contains(new Tile(1, 2)));
        assertTrue(moves.contains(new Tile(0, 2)));
        assertTrue(moves.contains(new Tile(2, 0)));
        assertTrue(moves.contains(new Tile(2, 1)));
        assertTrue(moves.contains(new Tile(2, 2)));
    }
}
