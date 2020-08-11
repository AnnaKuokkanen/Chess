package chess.bot;

import chess.engine.GameState;
import chess.model.Side;
import domain.board.Board;
import domain.board.Tile;
import domain.board.TileNameConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MyBot implements ChessBot {
    
    private final Board board;
    private HashMap<Tile, ArrayList<Tile>> moves;
    private Random random;
    private TileNameConverter converter;
    
    public MyBot() {
        this.board = new Board();
        this.board.setupBoard();
        this.board.setupPieces();
        this.moves = new HashMap<>();
        this.converter = new TileNameConverter();
    }
    
    @Override
    public String nextMove(GameState gamestate) {
        this.moves = this.board.getPossibleMoves(Side.BLACK);
        this.random = new Random(moves.keySet().size() - 1);
        
        //Tile start = (Tile) moves.keySet().toArray()[random.nextInt()];
        Tile start = (Tile) moves.keySet().toArray()[0];
        Tile finish = moves.get(start).get(0);
        
        String move = converter.convert(start.getX(), start.getY());
        move += converter.convert(finish.getX(), finish.getY());
        
        finish.setPiece(start.getPiece());
        start.setPiece(null);
        
        return move;
    }
}
