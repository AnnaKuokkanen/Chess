package datastructureproject.datastructure;

import domain.board.Tile;

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
}