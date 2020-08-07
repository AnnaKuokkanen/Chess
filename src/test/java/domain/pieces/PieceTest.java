package domain.pieces;

import chess.model.Side;
import domain.board.Tile;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class PieceTest {  
    private Piece piece;
    
    @Before
    public void setUp() {
        this.piece = new Piece(Side.WHITE, PieceName.KING); 
        this.piece.setLocation(1, 1);
    }
    
    @Test
    public void doesPieceReturnRightSide() {
        Piece black = new Piece(Side.BLACK, PieceName.PAWN);
        Piece white = new Piece(Side.WHITE, PieceName.PAWN);
        assertTrue(black.getSide() == Side.BLACK);
        assertTrue(white.getSide() == Side.WHITE);
    }
    
    @Test
    public void doesPieceReturnRightType() {
        assertTrue(this.piece.getType().equals(PieceName.KING));
    }
    
    @Test
    public void isLocationCorrect() {
        Tile tile = new Tile(1, 1);
        assertTrue(this.piece.getLocation().equals(tile));
    }
    
    @Test
    public void arePiecesEquals() {
        King king = new King(Side.WHITE);
        king.setLocation(1, 1);
        assertTrue(king.equals(piece));
        
        King king2 = new King(Side.BLACK);
        king2.setLocation(1, 1);
        assertFalse(king2.equals(king));
        
        Pawn pawn = new Pawn(Side.BLACK);
        pawn.setLocation(0, 0);
        Pawn pawn2  = new Pawn(Side.BLACK);
        pawn2.setLocation(2, 2);
        assertFalse(pawn.equals(pawn2));
    }
    
    @Test
    public void doesPieceMoveCorrectly() {
        piece.move(2, 1);
        assertTrue(piece.getLocation().equals(new Tile(2, 1)));
    }
    
    @Test
    public void isPieceRemoved() {
        assertTrue(this.piece.onBoard());
        this.piece.remove();
        assertFalse(this.piece.onBoard());
    }
}
