package datastructureproject;

import chess.bot.ChessBot;
import chess.bot.MyBot;
import chess.engine.GameState;

/**
 * Performance tests for MyBot.
 * 
 */
public class PerformanceTest {

    private static MyBot bot;
    
    public static void main(String[] args) {
        int[] depths = new int[] {1, 2, 3, 4};
        
        for (int i = 0; i < depths.length; i++) {
            this.bot = new MyBot(depths[i]);
        }
    }
}
