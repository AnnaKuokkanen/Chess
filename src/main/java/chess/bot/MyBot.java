package chess.bot;

import chess.engine.GameState;
import datastructureproject.algorithm.AlphaBetaPruning;
import datastructureproject.algorithm.FirstChoice;
import domain.board.Board;
import domain.board.Tile;
import domain.board.TileNameConverter;

/**
 * This class implements ChessBot-interface and 
 * contains method for passing next move to the Bot.
 */
public class MyBot implements ChessBot {

    private AlphaBetaPruning alphabeta;
    private FirstChoice first;
    TileNameConverter converter = new TileNameConverter();
    private final Board board = new Board();
    
    public MyBot() {
        this.board.setupBoard();
        this.board.setupPieces();
    }
    
    /**
     * @param gamestate is pointing to class GameState.
     * GameState is a premade class and it contains data from the game.
     * @return move in textual form, for example "e2e4"
     */
    @Override
    public String nextMove(GameState gamestate) {       
        if (gamestate.getMoveCount() > 0) { 
            String opponentMove = gamestate.getLatestMove();
            
            Tile[] opponentTiles = converter.convertToTile(opponentMove);
            Tile start = opponentTiles[0];
            Tile finish = opponentTiles[1];
            
            int startX = start.getX();
            int startY = start.getY();
            int finishX = finish.getX();
            int finishY = finish.getY();

            if (board.getBoard()[finishX][finishY].getPiece() != null) {
                board.getBoard()[finishX][finishY].getPiece().remove();
            }
            
            board.getBoard()[finishX][finishY].setPiece(board.getBoard()[startX][startY].getPiece());
            board.getBoard()[startX][startY].setPiece(null);
        }
        
//        this.alphabeta = new AlphaBetaPruning(board);
//
//        return alphabeta.useAlphaBetaPruner();
        this.first = new FirstChoice(board);
        return first.chooseMove();
    }
}