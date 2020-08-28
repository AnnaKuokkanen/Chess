package datastructureproject.datastructure;

import domain.board.Tile;

public class HashMap {
    private Object[][] array;
    private int[] pointer;
    
    public HashMap() {
        this.array = new Object[15][10];
        this.pointer = new int[15];
    }
    
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
    
    public void replace(Tile key, ArrayList newList) {
        int index = hashFunction(key);
        for (int i = 0; i < array[index].length; i++) {
            Pair pair = (Pair) array[index][i];
            if (pair != null && pair.getTile().equals(key)) {
                pair.setList(newList);
            }
        }
    }
    
    public int size(Object o) {
        int hash = hashFunction(o);
        return pointer[hash];
    }
    
    public int hashFunction(Object o) {
        if (o instanceof Tile) {
            Tile tile = (Tile) o;
            return tile.getX() + tile.getY();
        }
        return 0;
    }
    
    public ArrayList keySet() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if ((Pair) array[i][j] != null) {
                    Pair pair = (Pair) array[i][j];
                    list.add(pair.getTile());
                }
            }
        }
        return list;
    }
}
