package chess.bot;

import chess.engine.GameState;
import chess.model.Side;
import datastructureproject.algorithm.AlphaBetaPruning;
import domain.board.Board;
import domain.board.Tile;
import domain.board.TileNameConverter;
import domain.pieces.Piece;
import domain.pieces.PieceName;
import domain.pieces.Queen;

/**
 * This class implements ChessBot-interface and 
 * contains method for passing next move to the Bot.
 */
public class MyBot implements ChessBot {

    private AlphaBetaPruning alphabeta;
    private final TileNameConverter converter = new TileNameConverter();
    private final Board board = new Board();
    private final int depth;
    
    public MyBot(int depth) {
        this.board.setupBoard();
        this.board.setupPieces();
        this.depth = depth;
    }
    
    /**
     * @param gamestate is pointing to class GameState.
     * GameState is a premade class and it contains data from the game.
     * This method also checks if opponent has castled or promoted its pawn
     * and updates board accordingly.
     * @return move in textual form, for example "e2e4"
     */
    @Override
    public String nextMove(GameState gamestate) {       
        if (gamestate.getMoveCount() > 0) { 
            String opponentMove = gamestate.getLatestMove();
            
            Tile[] opponentTiles = converter.convertToTile(opponentMove);
            Tile start = opponentTiles[0];
            Tile finish = opponentTiles[1];
            Piece startPiece = board.getBoard()[start.getX()][start.getY()].getPiece();
            
            board.movePiece(start, finish);
            
            if (gamestate.getMoveCount() == 0) {
                // black played
                if (opponentMove.equals("e8g8") && startPiece.getType() == PieceName.KING) {
                    board.movePiece(new Tile(7, 0), new Tile(5, 0));
                }
                if (opponentMove.equals("e8c8") && startPiece.getType() == PieceName.KING) {
                    board.movePiece(new Tile(0, 0), new Tile(3, 0));
                }
                
                String[] characters = opponentMove.split("");
                
                if (characters.length == 5) {
                    // pawn has become a queen 
                    board.getBoard()[finish.getX()][finish.getY()].getPiece().remove();
                    board.getBoard()[finish.getX()][finish.getY()].setPiece(new Queen(Side.BLACK));
                }
            } else {
                // white played
                if (opponentMove.equals("e1g1") && startPiece.getType() == PieceName.KING) {
                    board.movePiece(new Tile(7, 7), new Tile(5, 7));
                }
                if (opponentMove.equals("e1c1") && startPiece.getType() == PieceName.KING) {
                    board.movePiece(new Tile(0, 7), new Tile(3, 7));
                }
                
                String[] characters = opponentMove.split("");
                
                if (characters.length == 5) {
                    // pawn has become a queen
                    board.getBoard()[finish.getX()][finish.getY()].getPiece().remove();
                    board.getBoard()[finish.getX()][finish.getY()].setPiece(new Queen(Side.WHITE));
                }
            }
        }

        this.alphabeta = new AlphaBetaPruning(board, depth);
        Side side = Side.WHITE;
        if (gamestate.getMoveCount() % 2 == 1) {
            side = Side.BLACK;
        }
        return alphabeta.useAlphaBetaPruner(side);
    }
}