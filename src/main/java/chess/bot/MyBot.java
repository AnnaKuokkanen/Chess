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
        this.moves = this.board.getPossibleMoves(Side.BLACK);
        String move = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!moves.get(board.getBoard()[i][j]).isEmpty()) {
                    Tile start = board.getBoard()[i][j];
                    Tile finish = moves.get(start).get(0);

                    move += converter.convert(start.getX(), start.getY());
                    move += converter.convert(finish.getX(), finish.getY());

                    finish.setPiece(start.getPiece());
                    start.setPiece(null);
                    break;
                }
            }
            break;
        }
        return move;
    }
}