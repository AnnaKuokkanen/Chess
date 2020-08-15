package chess.bot;

import chess.engine.GameState;
import chess.model.Side;
import datastructureproject.RandomChoice;
import domain.board.Board;
import domain.board.Tile;
import domain.board.TileNameConverter;
import java.util.ArrayList;
import java.util.HashMap;

public class MyBot implements ChessBot {
    
    private RandomChoice choice;
    TileNameConverter converter = new TileNameConverter();
    
    public MyBot() {
        this.choice = new RandomChoice();
    }
    
    @Override
    public String nextMove(GameState gamestate) {
        if (gamestate.getMoveCount() > 0) { 
            String opponentMove = gamestate.getLatestMove();
            //this array symbolizes opponent move's start and finish tiles
            Tile[] opponentTiles = converter.convertToTile(opponentMove);

            if (opponentTiles[1].getPiece() != null) {
                opponentTiles[1].getPiece().remove();
            }
            
            opponentTiles[1].setPiece(opponentTiles[0].getPiece());
            opponentTiles[0].setPiece(null);
        }
        
        return choice.chooseMove();
    }
}