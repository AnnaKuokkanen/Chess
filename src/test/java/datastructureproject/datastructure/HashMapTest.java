package datastructureproject.datastructure;

import domain.board.Tile;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class HashMapTest {
    HashMap map;
    
    @Before 
    public void setup() {
        this.map = new HashMap();
    }
    
    @Test
    public void itemIsAddedCorrectly() {
        ArrayList list = new ArrayList();
        list.add(new Tile(1, 1));
        map.put(new Tile(0, 0), list);
        
        assertEquals(1, map.size(new Tile(0, 0)));
        assertEquals(0, map.size(new Tile(1, 1)));
        
        assertTrue(map.get(new Tile(0, 0)).contains(new Tile(1, 1)));
    }
    
    @Test
    public void itemIsAddedCorrectlyWhenListIsFull() {
        for (int i = 0; i < 102; i++) {
            map.put(new Tile(0, 0), new ArrayList());
        }
        assertEquals(102, map.size(new Tile(0, 0)));
    }
    
    @Test
    public void itemIsReturnedCorrectly() {
        ArrayList firstList = new ArrayList();
        ArrayList secondList = new ArrayList();
        firstList.add(new Tile(1, 1));
        secondList.add(new Tile(2, 2));
        
        map.put(new Tile(0, 0), firstList);
        map.put(new Tile(1, 1), secondList);
        assertEquals(firstList, map.get(new Tile(0, 0)));
        assertEquals(secondList, map.get(new Tile(1, 1)));
    }
    
    @Test
    public void itemsReplacedCorrectly() {
        ArrayList firstList = new ArrayList();
        ArrayList secondList = new ArrayList();
        firstList.add(new Tile(1, 1));
        secondList.add(new Tile(2, 2));
        
        map.put(new Tile(0, 0), firstList);
        assertEquals(firstList, map.get(new Tile(0, 0)));
        map.replace(new Tile(0, 0), secondList);
        assertEquals(secondList, map.get(new Tile(0, 0)));
    }
    
//    @Test
//    public void keySetIsReturnedCorrectly() {
//        map.put(new Tile(0, 0), new ArrayList());
//        map.put(new Tile(1, 1), new ArrayList());
//        map.put(new Tile(1, 2), new ArrayList());
//        
//        assertEquals(3, map.keySet().size());
//        assertTrue(map.keySet().contains(new Tile(0, 0)));
//        assertTrue(map.keySet().contains(new Tile(1, 1)));
//        assertTrue(map.keySet().contains(new Tile(1, 2)));
//    }
}
