package domain.board;

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
    public void areNamesConvertedCorrectly() {        
        assertEquals(converter.convert(0, 0), "a1");
    }
}
