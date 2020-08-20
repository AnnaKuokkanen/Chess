package datastructureproject.datastructure;

import domain.board.Tile;
import domain.pieces.Piece;

public class HashMap {
    private Object[][] array;
    private int[] pointer;
    
    public HashMap() {
        this.array = new Object[10][10];
        this.pointer = new int[10];
    }
    
    public Object[] get(Object o) {
        int hash = hashFunction(o);
        return array[hash];
    }
 
    public void put(Object key, Object object) {
        int index = hashFunction(key);
        if (pointer[index] == array[index].length) {
            Object[] helperArray = array[index];
            array[index] = new Object[array[index].length * 2];
            for (int i = 0; i < helperArray.length; i++) {
                array[index][i] = helperArray[i];
            }
        }
        array[index][pointer[index]] = object;
        pointer[index]++;
    }
    
    public int hashFunction(Object o) {
        if (o instanceof Piece) {
            Piece piece = (Piece) o;
            return piece.getValue() / 10;
        }
        if (o instanceof Tile) {
            Tile tile = (Tile) o;
            return tile.getX() + tile.getY();
        }
        return 0;
    }
}
