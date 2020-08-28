package domain.rules;

import chess.model.Side;
import domain.board.*;
import domain.pieces.PieceName;

/**
 * Class that allows checking if king is checked.
 * Checking done by other king is not yet added
 */
public class KingCheckSituation {
    
    private final int x; 
    private final int y;
    private final Tile[][] tiles;
    private final Side side;
    
    public KingCheckSituation(Board board, int x, int y, Side side) {
        this.tiles = board.getBoard();
        this.x = x;
        this.y = y;
        this.side = side;
    }   
    
    /**
     * @return true immediately if some piece is found checking the king
     */
    public boolean isChecked() {   
        if (checkHorizontalAndVertical()) {
            return true;
        }
        if (checkPawn()) {
            return true;
        }  
        if (checkKnight()) {
            return true;
        }
        if (checkDiagonal()) {
            return true;
        }
        return false;
    }
    
    /**
     * Checking all tiles diagonally from the king for opposite side queen or bishop.
     * @return true if one is found
     */
    public boolean checkDiagonal() {
        PieceName name1 = PieceName.QUEEN;
        PieceName name2 = PieceName.BISHOP;
        
        int i = 1;
        while (x + i < 8 && y + i < 8) {
            if (!tiles[x + i][y + i].free()) {
                if (differentSideAndCorrectPiece(x + i, y + i, name1) || differentSideAndCorrectPiece(x + i, y + i, name2)) {
                    return true;
                }
                if (tiles[x + i][y + i].getPiece().getSide() == side) {
                    break;
                }
            }
            i++;
        }
        i = 1;
        while (x - i >= 0 && y + i < 8) {
            if (!tiles[x - i][y + i].free()) {
                if (differentSideAndCorrectPiece(x - i, y + i, name1) || differentSideAndCorrectPiece(x - i, y + i, name2)) {
                    return true;
                }
                if (tiles[x - i][y + i].getPiece().getSide() == side) {
                    break;
                }
            }
            i++;
        }
        i = 1;
        while (x + i < 8 && y - i >= 0) {
            if (!tiles[x + i][y - i].free()) {
                if (differentSideAndCorrectPiece(x + i, y - i, name1) || differentSideAndCorrectPiece(x + i, y - i, name2)) {
                    return true;
                }
                if (tiles[x + i][y - i].getPiece().getSide() == side) {
                    break;
                }
            }
            i++;
        }
        i = 1;
        while (x - i >= 0 && y - i >= 0) {
            if (!tiles[x - i][y - i].free()) {
                if (differentSideAndCorrectPiece(x - i, y - i, name1) || differentSideAndCorrectPiece(x - i, y - i, name2)) {
                    return true;
                }
                if (tiles[x - i][y - i].getPiece().getSide() == side) {
                    break;
                }
            }
            i++;
        }
        
        return false;
    }
    
    /**
     * Check all tiles horizontally and vertically from the king for opposite side queen or rook.
     * 
     * @return true if one is found
     */
    public boolean checkHorizontalAndVertical() {
        PieceName name1 = PieceName.QUEEN;
        PieceName name2 = PieceName.ROOK;
        
        int i = 1;
        while (x + i < 8) {
            if (!tiles[x + i][y].free()) {
                if (differentSideAndCorrectPiece(x + i, y, name1) || differentSideAndCorrectPiece(x + i, y, name2)) {
                    return true;
                }
                if (tiles[x + i][y].getPiece().getSide() == side) {
                    break;
                }
            }
            i++;
        }
        i = 1;
        while (x - i >= 0) {
            if (!tiles[x - i][y].free()) {
                if (differentSideAndCorrectPiece(x - i, y, name1) || differentSideAndCorrectPiece(x - i, y, name2)) {
                    return true;
                }
                if (tiles[x - i][y].getPiece().getSide() == side) {
                    break;
                }
            }
            i++;
        }
        i = 1;
        while (y + i < 8) {
            if (!tiles[x][y + i].free()) {
                if (differentSideAndCorrectPiece(x, y + i, name1) || differentSideAndCorrectPiece(x, y + i, name2)) {
                    return true;
                }
                if (tiles[x][y + i].getPiece().getSide() == side) {
                    break;
                }
            }
            i++;
        }
        i = 1;
        while (y - i >= 0) {
            if (!tiles[x][y - i].free()) {
                if (differentSideAndCorrectPiece(x, y - i, name1) || differentSideAndCorrectPiece(x, y - i, name2)) {
                    return true;
                }
                if (tiles[x][y - i].getPiece().getSide() == side) {
                    break;
                }
            }
            i++;
        }       
        return false;
    }
    
    /**
     * Check if opposite side pawns are checking.
     * 
     * @return true if they are 
     */
    public boolean checkPawn() {     
        PieceName name = PieceName.PAWN;
        
        if (x - 1 >= 0 && y + 1 < 8 && !tiles[x - 1][y + 1].free()) {
            if (differentSideAndCorrectPiece(x - 1, y + 1, name)) {
                return true;
            }
        }
        if (x + 1 < 8 && y + 1 < 8 && !tiles[x + 1][y + 1].free()) {
            if (differentSideAndCorrectPiece(x + 1, y + 1, name)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check eight positions where opposite side knights can be checking.
     * 
     * @return true if at least one is found
     */
    public boolean checkKnight() {
        PieceName name = PieceName.KNIGHT;
        
        if (x + 2 < 8 && y + 1 < 8 && !tiles[x + 2][y + 1].free()) {
            if (differentSideAndCorrectPiece(x + 2, y + 1, name)) {
                return true;
            }
        }
        if (x + 2 < 8 && y - 1 >= 0 && !tiles[x + 2][y - 1].free()) {
            if (differentSideAndCorrectPiece(x + 2, y - 1, name)) {
                return true;
            }
        }
        if (x - 2 >= 0 && y + 1 < 8 && !tiles[x - 2][y + 1].free()) {
            if (differentSideAndCorrectPiece(x - 2, y + 1, name)) {
                return true;
            }
        }
        if (x - 2 >= 0 && y - 1 >= 0 && !tiles[x - 2][y - 1].free()) {
            if (differentSideAndCorrectPiece(x - 2, y - 1, name)) {
                return true;
            }
        }
        if (x + 1 < 8 && y + 2 < 8 && !tiles[x + 1][y + 2].free()) {
            if (differentSideAndCorrectPiece(x + 1, y + 2, name)) {
                return true;
            }
        }
        if (x + 1 < 8 && y - 2 >= 0 && !tiles[x + 1][y - 2].free()) {
            if (differentSideAndCorrectPiece(x + 1, y - 2, name)) {
                return true;
            }
        }
        if (x - 1 >= 0 && y + 2 < 8 && !tiles[x - 1][y + 2].free()) {
            if (differentSideAndCorrectPiece(x - 1, y + 2, name)) {
                return true;
            }
        }
        if (x - 1 >= 0 && y - 2 >= 0 && !tiles[x - 1][y - 2].free()) {
            if (differentSideAndCorrectPiece(x - 1, y - 2, name)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method that checks if some tile contains particular piece type and 
     * the piece is of opposite side.
     * 
     * @param x depicts x coordinate of tile
     * @param y depicts y coordinate of tile
     * @param name depicts the name of piece we are looking for
     * 
     * @return true if such piece is found
     */
    public boolean differentSideAndCorrectPiece(int x, int y, PieceName name) {
        boolean differentSide = tiles[x][y].getPiece().getSide() != this.side;
        boolean isPiece = tiles[x][y].getPiece().getType() == name;
        return (differentSide && isPiece);
    }
}
