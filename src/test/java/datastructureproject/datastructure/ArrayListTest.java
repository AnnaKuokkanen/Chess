package datastructureproject.datastructure;

import chess.model.Side;
import domain.board.Tile;
import domain.pieces.Pawn;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {
    
    ArrayList list;
    
    @Before 
    public void setup() {
        this.list = new ArrayList();
    }
    
    @Test
    public void itemIsAddedCorrectlyWhenThereIsSpace() {
        assertEquals(0, list.size());
        list.add(new Pawn(Side.BLACK));
        assertEquals(1, list.size());
    }
    
    @Test
    public void itemIsAddedCorrectlyWhenListIsFull() {
        for (int i = 0; i < 102; i++) {
            list.add(i);
        }
        assertEquals(102, list.size());
        assertEquals(101, list.get(list.size() -1));
    }
    
    @Test
    public void itemIsReturnedCorrectly() {
        list.add(new Tile(1, 1));
        list.add(new Tile(2, 1));
        assertEquals(new Tile(1, 1), list.get(0));
        assertEquals(new Tile(2, 1), list.get(1));
    }
    
    @Test
    public void sizeIsCorrect() {
        assertEquals(0, list.size());
        list.add(new Pawn(Side.WHITE));
        assertEquals(1, list.size());
    }
}
