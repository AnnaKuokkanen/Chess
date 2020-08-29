package datastructureproject.datastructure;

import domain.board.Tile;

/**
 * Data structure that replaces Java's HashMap.
 * This program uses HashMap in one way: it stores tiles as keys 
 * and lists of tiles as values. That way we can store possible moves 
 * as a pair: one pair contains the starter tile (key value) and list of
 * all possible finish tiles from that tile. 
 */
public class HashMap {
    private Object[][] array;
    private int[] pointer;
    
    public HashMap() {
        this.array = new Object[15][10];
        this.pointer = new int[15];
    }
    
    /**
     * This method allows searching HashMap by key value.
     * @param t is tile that serves as key value
     * @return ArrayList is the list that is stored with the tile
     */
    public ArrayList get(Tile t) {
        int hash = hashFunction(t);
        for (int i = 0; i < array[hash].length; i++) {
            Pair pair = (Pair) array[hash][i];
            if (pair != null && pair.getTile().equals(t)) {
                return pair.getList();
            }
        }
        return new ArrayList();
    }
    
    /**
     * This method stores pairs of tiles and lists. 
     * @param key is tile that we use as key value 
     * @param list is the list we want to 
     */
    public void put(Tile key, ArrayList list) {
        Pair pair = new Pair(key, list);
        int index = hashFunction(key);
        if (pointer[index] == array[index].length) {
            Object[] helperArray = array[index];
            array[index] = new Object[array[index].length * 2];
            for (int i = 0; i < helperArray.length; i++) {
                array[index][i] = helperArray[i];
            }
        }
        array[index][pointer[index]] = pair;
        pointer[index]++;
    }
    
    /**
     * This method replaces old list of possible moves with 
     * new list of possible moves.
     * @param key is tile under which new list is stored
     * @param newList is the new list
     */
    public void replace(Tile key, ArrayList newList) {
        int index = hashFunction(key);
        for (int i = 0; i < array[index].length; i++) {
            Pair pair = (Pair) array[index][i];
            if (pair != null && pair.getTile().equals(key)) {
                pair.setList(newList);
            }
        }
    }
    
    /**
     * Returns number of pairs under certain hash value.
     * @param o is object whose hash value is checked
     * @return count of pairs
     */
    public int size(Object o) {
        int hash = hashFunction(o);
        return pointer[hash];
    }
    
    /**
     * Simple hash function that assigns to a tile sum of 
     * its x and y coordinates. 
     * This way the most pairs are stored in idex 7 (8 pairs) 
     * and least in indexes 0 and 14. 
     * This is also why length of array is specifically 15. 
     * 
     * @param o is object to which we assign a value
     * @return hash value
     */
    public int hashFunction(Object o) {
        if (o instanceof Tile) {
            Tile tile = (Tile) o;
            return tile.getX() + tile.getY();
        }
        return 0;
    }
    
    /** 
     * @return list of all key values
     */
    public ArrayList keySet() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((Pair) array[i][j] != null) {
                    Pair pair = (Pair) array[i][j];
                    if (!pair.getList().isEmpty()) {
                        list.add(pair.getTile());
                    }
                }
            }
        }
        return list;
    }
}
