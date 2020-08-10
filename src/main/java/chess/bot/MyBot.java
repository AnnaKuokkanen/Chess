package chess.bot;

import chess.engine.GameState;
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
    }
    
    @Override
    public String nextMove(GameState gamestate) {
        //return this.board.getPossibleMoves().get(0);
        return "e7e5";
    }
}
