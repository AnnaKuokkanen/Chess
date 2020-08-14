package chess.bot;

import chess.engine.GameState;
import chess.model.Side;
import domain.board.Board;
import domain.board.Tile;
import domain.board.TileNameConverter;
import java.util.ArrayList;
import java.util.HashMap;

public class MyBot implements ChessBot {
    
    private final Board board;
    private HashMap<Tile, ArrayList<Tile>> moves;
    private final TileNameConverter converter;
    
    public MyBot() {
        this.board = new Board();
        this.board.setupBoard();
        this.board.setupPieces();
        
        this.converter = new TileNameConverter();
    }
    
    @Override
    public String nextMove(GameState gamestate) {
        String opponentMove = gamestate.getLatestMove();
        
        
        this.moves = new HashMap<>();
        return search();
    }
    
    public String search() {
        this.moves = this.board.getPossibleMoves(Side.BLACK);
        String move = "";
        
        boolean found = false;
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!board.getBoard()[i][j].free() && board.getBoard()[i][j].getPiece().getSide() == Side.BLACK && !moves.get(board.getBoard()[i][j]).isEmpty()) {
                    Tile start = board.getBoard()[i][j];
                    Tile finish = moves.get(start).get(moves.get(start).size() - 1);

                    move += converter.convertToString(start.getX(), start.getY());
                    move += converter.convertToString(finish.getX(), finish.getY());
                    
                    if (finish.getPiece() != null) {
                        finish.getPiece().remove();
                    }
                    
                    finish.setPiece(start.getPiece());
                    start.setPiece(null);
                    found = true;
                    break;
                }
            }
            if (found) { 
                break;
            }
        }
        return move;
    }
}