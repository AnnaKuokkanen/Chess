package chess.bot;

import chess.engine.GameState;
import domain.board.Board;

public class MyBot implements ChessBot {
    
    private final Board board;
    
    public MyBot() {
        this.board = new Board();
    }
    
    @Override
    public String nextMove(GameState gamestate) {
        return "e7e5";
    }
}
