package chess.bot;

import chess.engine.GameState;
import chess.model.Side;
import datastructureproject.algorithm.AlphaBetaPruning;
import datastructureproject.algorithm.FirstChoice;
import domain.board.Board;
import domain.board.Tile;
import domain.board.TileNameConverter;
import domain.pieces.PieceName;
import domain.pieces.Queen;

/**
 * This class implements ChessBot-interface and 
 * contains method for passing next move to the Bot.
 */
public class MyBot implements ChessBot {

    private AlphaBetaPruning alphabeta;
    private FirstChoice first;
    private final TileNameConverter converter = new TileNameConverter();
    private final Board board = new Board();
    private int depth;
    
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
            
//            if (gamestate.getMoveCount() % 2 == 0) {
//                // black played
//                if (opponentMove.equals("e8g8") && start.getPiece().getType() == PieceName.KING) {
//                    // black castled
//                    board.movePiece(board.getBoard()[7][7], board.getBoard()[5][7]);
//                }
//                if (opponentMove.equals("e8c8") && start.getPiece().getType() == PieceName.KING) {
//                    // black castled
//                    board.movePiece(board.getBoard()[0][7], board.getBoard()[3][7]);
//                }
//                
//                String[] characters = opponentMove.split("");
//                
//                if (characters.length == 5) {
//                    // pawn has become a queen 
//                    start.getPiece().remove();
//                    start.setPiece(new Queen(Side.BLACK));
//                }
//            } else {
//                // white played
//                if (opponentMove.equals("e1g1") && start.getPiece().getType() == PieceName.KING) {
//                    //white castled
//                    int startX = start.getX();
//                    int startY = start.getY();
//                    int finishX = finish.getX();
//                    int finishY = finish.getY();
//
//                    if (board.getBoard()[finishX][finishY].getPiece() != null) {
//                        board.getBoard()[finishX][finishY].getPiece().remove();
//                    }
//
//                    board.getBoard()[finishX][finishY].setPiece(board.getBoard()[startX][startY].getPiece());
//                    board.getBoard()[startX][startY].setPiece(null);
//                }
//                if (opponentMove.equals("e1c1") && start.getPiece().getType() == PieceName.KING) {
//                    //white castled
//                    int startX = start.getX();
//                    int startY = start.getY();
//                    int finishX = finish.getX();
//                    int finishY = finish.getY();
//
//                    if (board.getBoard()[finishX][finishY].getPiece() != null) {
//                        board.getBoard()[finishX][finishY].getPiece().remove();
//                    }
//
//                    board.getBoard()[finishX][finishY].setPiece(board.getBoard()[startX][startY].getPiece());
//                    board.getBoard()[startX][startY].setPiece(null);
//                }
//                
//                String[] characters = opponentMove.split("");
//                
//                if (characters.length == 5) {
//                    // pawn has become a queen
//                    start.getPiece().remove();
//                    start.setPiece(new Queen(Side.WHITE));
//                }
//            }
            
            //board.movePiece(start, finish);
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

        this.alphabeta = new AlphaBetaPruning(board, depth);
        Side side = Side.WHITE;
        if (gamestate.getMoveCount() % 2 == 1) {
            side = Side.BLACK;
        }
        return alphabeta.useAlphaBetaPruner(side);
    }
}