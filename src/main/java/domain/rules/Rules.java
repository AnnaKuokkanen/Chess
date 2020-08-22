package domain.rules;

import datastructureproject.datastructure.ArrayList;
import domain.board.Tile;

public class Rules {
    private int x;
    private int y;
    private Tile[][] tiles;
    private ArrayList moves;
    
    public Rules(int x, int y, Tile[][] tiles) {
        this.x = x;
        this.y = y;
        this.tiles = tiles;
        this.moves = new ArrayList();
    }

    public void setMoves(ArrayList moves) {
        this.moves = moves;
    }

    public ArrayList moveHorizontallyAndVertically() {
        setMoves(new ArrayList());
        int i = 1;
        while (x + i < 8) {
            if (tiles[x + i][y].getPiece() != null) {
                if (tiles[x + i][y].getPiece().getSide() == tiles[x][y].getPiece().getSide()) {
                    break;
                } else if (tiles[x + i][y].getPiece().getSide() != tiles[x][y].getPiece().getSide()) {
                    moves.add(tiles[x + i][y]);
                    break;
                }
            } else {
                moves.add(tiles[x + i][y]);
            }
            i++;
        }
        
        i = 1;
        while (x - i >= 0) {
            if (tiles[x - i][y].getPiece() != null) {
                if (tiles[x - i][y].getPiece().getSide() == tiles[x][y].getPiece().getSide()) {
                    break;
                } else if (tiles[x - i][y].getPiece().getSide() != tiles[x][y].getPiece().getSide()) {
                    moves.add(tiles[x - i][y]);
                    break;
                }
            } else {
                moves.add(tiles[x - i][y]);
            }
            i++;
        }
        
        i = 1;
        while (y + i < 8) {
            if (tiles[x][y + i].getPiece() != null) {
                if (tiles[x][y + i].getPiece().getSide() == tiles[x][y].getPiece().getSide()) {
                    break;
                } else if (tiles[x][y + i].getPiece().getSide() != tiles[x][y].getPiece().getSide()) {
                    moves.add(tiles[x][y + i]);
                    break;
                } 
            } else {
                moves.add(tiles[x][y + i]);
            }
            i++;
        }
        
        i = 1;
        while (y - i >= 0) {
            if (tiles[x][y - i].getPiece() != null) {
                if (tiles[x][y - i].getPiece().getSide() == tiles[x][y].getPiece().getSide()) {
                    break;
                } else if (tiles[x][y - i].getPiece().getSide() != tiles[x][y].getPiece().getSide()) {
                    moves.add(tiles[x][y - i]);
                    break;
                }
            } else {
                moves.add(tiles[x][y - i]);
            }
            i++;
        }
        
        return moves;
    }
   
    public ArrayList moveDiagonally() {
        setMoves(new ArrayList());
        int i = 1;
        while (x + i < 8 && y + i < 8) {
            if (tiles[x + i][y + i].getPiece() != null) {
                if (tiles[x + i][y + i].getPiece().getSide() == tiles[x][y].getPiece().getSide()) {
                    break;
                } else if (tiles[x + i][y + i].getPiece().getSide() != tiles[x][y].getPiece().getSide()) {
                    moves.add(tiles[x + i][y + i]);
                    break;
                }
            } else {
                moves.add(tiles[x + i][y + i]);
            }
            i++;
        }
        
        i = 1;
        while (x - i >= 0 && y + i < 8) {
            if (tiles[x - i][y + i].getPiece() != null) {
                if (tiles[x - i][y + i].getPiece().getSide() == tiles[x][y].getPiece().getSide()) {
                    break;
                } else if (tiles[x - i][y + i].getPiece().getSide() != tiles[x][y].getPiece().getSide()) {
                    moves.add(tiles[x - i][y + i]);
                    break;
                }
            } else {
                moves.add(tiles[x - i][y + i]);
            }
            i++;
        }
        
        i = 1;
        while (x + i < 8 && y - i >= 0) {
            if (tiles[x + i][y - i].getPiece() != null) {
                if (tiles[x + i][y - i].getPiece().getSide() == tiles[x][y].getPiece().getSide()) {
                    break;
                } else if (tiles[x + i][y - i].getPiece().getSide() != tiles[x][y].getPiece().getSide()) {
                    moves.add(tiles[x + i][y - i]);
                    break;
                }
            } else {
                moves.add(tiles[x + i][y - i]);
            }
            i++;
        }
        
        i = 1;
        while (x - i >= 0 && y - i >= 0) {
            if (tiles[x - i][y - i].getPiece() != null) {
                if (tiles[x - i][y - i].getPiece().getSide() == tiles[x][y].getPiece().getSide()) {
                    break;
                } else if (tiles[x - i][y - i].getPiece().getSide() != tiles[x][y].getPiece().getSide()) {
                    moves.add(tiles[x - i][y - i]);
                    break;
                }
            } else {
                moves.add(tiles[x - i][y - i]);
            }
            i++;
        }
        
        return moves;
    }
}
