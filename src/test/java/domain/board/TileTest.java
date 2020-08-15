package domain.board;

import chess.model.Side;
import domain.pieces.Queen;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class TileTest {
    private Tile tile;
    private TileNameConverter converter;
    
    @Before
    public void TileTest() {
        this.tile = new Tile(0, 0);
        this.converter = new TileNameConverter();
    }
    
    @Test
    public void areTilesEqual() {
        Tile tile2 = new Tile(0, 0);
        assertTrue(tile.equals(tile2));
    }
    
    @Test
    public void areNamesConvertedToStringCorrectly() {        
        assertEquals("a8", converter.convertToString(0, 0));
    }
    
    @Test
    public void areMovesConvertedToTilesCorrectly() {
        String move1 = "b4b7";
        String move2 = "g1h8";
        
        Tile[] tiles1 = converter.convertToTile(move1);
        Tile[] tiles2 = converter.convertToTile(move2);
        
        assertEquals(1, tiles1[0].getX());
        assertEquals(4, tiles1[0].getY());
        assertEquals(new Tile(1, 4), tiles1[0]);
        assertEquals(1, tiles1[1].getX());
        assertEquals(1, tiles1[1].getY());
        assertEquals(new Tile(1, 1), tiles1[1]);
        
        assertEquals(6, tiles2[0].getX());
        assertEquals(7, tiles2[0].getY());
        assertEquals(new Tile(6, 7), tiles2[0]);
        assertEquals(7, tiles2[1].getX());
        assertEquals(0, tiles2[1].getY());
        assertEquals(new Tile(7, 0), tiles2[1]);
    }
    
    @Test
    public void isNullPieceReturnedCorrectly() {
        assertTrue(this.tile.getPiece() == null);
        assertTrue(this.tile.free());
        this.tile.setPiece(new Queen(Side.WHITE));
        assertTrue(!this.tile.free());
    }
    
    @Test
    public void isPieceSetCorrectly() {
        Queen q = new Queen(Side.BLACK);
        tile.setPiece(q);
        assertEquals(tile.getPiece(), q);
        assertTrue(q.getLocation().equals(tile));
    }
    
    @Test
    public void isPieceMovedCorrectly() {
        Tile start = new Tile(1, 1);
        Tile finish = new Tile(1, 2);
        
        Queen blackQueen = new Queen(Side.BLACK);
        Queen whiteQueen = new Queen(Side.WHITE);
        
        start.setPiece(blackQueen);
        finish.setPiece(whiteQueen);
        
        if (finish.getPiece() != null) {
            finish.getPiece().remove();
        }

        finish.setPiece(start.getPiece());
        start.setPiece(null);
        
        assertTrue(start.getPiece() == null);
        assertTrue(finish.getPiece().equals(blackQueen));
        assertTrue(!whiteQueen.onBoard());
        assertTrue(blackQueen.getLocation().equals(finish));
    }
    
    @After
    public void tearDown() {
    
    }
}
