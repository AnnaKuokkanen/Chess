package chess.bot;

import chess.engine.GameState;
import datastructureproject.RandomChoice;
import domain.board.Board;
import domain.board.Tile;
import domain.board.TileNameConverter;

public class MyBot implements ChessBot {
    
    private RandomChoice choice;
    TileNameConverter converter = new TileNameConverter();
    private final Board board = new Board();
    
    public MyBot() {
        this.board.setupBoard();
        this.board.setupPieces();
    }
    
    @Override
    public String nextMove(GameState gamestate) {       
        if (gamestate.getMoveCount() > 0) { 
            String opponentMove = gamestate.getLatestMove();
            
            Tile[] opponentTiles = converter.convertToTile(opponentMove);
            Tile start = opponentTiles[0];
            Tile finish = opponentTiles[1];

            if (board.getBoard()[finish.getX()][finish.getY()].getPiece() != null) {
                board.getBoard()[finish.getX()][finish.getY()].getPiece().remove();
            }
            
            board.getBoard()[finish.getX()][finish.getY()].setPiece(board.getBoard()[start.getX()][start.getY()].getPiece());
            board.getBoard()[start.getX()][start.getY()].setPiece(null);
        }
        
        this.choice = new RandomChoice(board);
        
        return choice.chooseMove();
    }
}