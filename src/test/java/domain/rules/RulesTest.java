package domain.rules;

import chess.model.Side;
import domain.board.*;
import domain.pieces.*;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class RulesTest {
    private Board board;
    private Rook rook;
    private Bishop bishop;
    
    @Before
    public void setUp() {
        this.board = new Board();
        this.board.setupBoard();
        
        this.rook = new Rook(Side.BLACK);
        //this.bishop = new Bishop(Side.BLACK);
        
        this.board.getBoard()[1][1].setPiece(this.rook);
        //this.board.getBoard()[6][6].setPiece(this.bishop);
    }
    
    @Test
    public void arePiecesSet() {
        assertTrue(board.getBoard()[1][1].getPiece().equals(rook));
        assertTrue(board.getBoard() != null);
        assertTrue(board.getBoard()[1][1].getPiece().getSide() == Side.BLACK);
        assertTrue(board.getBoard()[2][1].getPiece() == null); 
        assertFalse(board.getBoard()[2][1] == null); 
    }
    
    @Test
    public void doesPieceMoveHorizontallyWhenTilesAreFree() {
        ArrayList<Tile> list = this.rook.getPossibleMoves(board);
        assertFalse(list == null);
        assertTrue(list.contains(new Tile(0, 1)));
        assertTrue(list.contains(new Tile(2, 1)));
    }
    
    @Test
    public void doesPieceMoveHorizontallyWhenThereIsOpponentPiece() {
    
    }
    
    @Test
    public void doesPieceNotMoveHorizontallyWhenThereIsOwnPiece() {
    
    }
    
//    @Test
//    public void doesPieceMoveVertically() {
//    
//    }
//    
//    @Test
//    public void doesPieceMoveDiagonally() {
//    
//    }
}
