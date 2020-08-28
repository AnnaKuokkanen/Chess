package datastructureproject.datastructure;

import domain.board.Tile;

/**
 * This is a helper method for HashMap.
 * It simply contains two values: a tile and a list.
 */
public class Pair {
    private Tile tile;
    private ArrayList list;
    
    public Pair(Tile tile, ArrayList list) {
        this.tile = tile;
        this.list = list;
    }
    
    public Tile getTile() {
        return this.tile;
    }
    
    public ArrayList getList() {
        return this.list;
    }
    
    public void setList(ArrayList list) {
        this.list = list;
    }
}
