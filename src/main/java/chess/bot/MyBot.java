package chess.bot;

import chess.engine.GameState;
import chess.model.Side;
import domain.board.Board;
import domain.board.Tile;
import java.util.ArrayList;
import java.util.Random;

public class MyBot implements ChessBot {
    
    private final Board board;
    private ArrayList<Tile> moves;
    private Random random;
    
    public MyBot() {
        this.board = new Board();
        this.board.setupBoard();
        this.board.setupPieces();
    }
    
    @Override
    public String nextMove(GameState gamestate) {
        return this.board.getPossibleMoves(Side.BLACK).get(0);
        //return "a7a5";
    }
}
