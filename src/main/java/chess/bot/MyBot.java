package chess.bot;

import chess.engine.GameState;

public class MyBot implements ChessBot {
    
    @Override
    public String nextMove(GameState gamestate) {
        return "e2e4";
    }
}
