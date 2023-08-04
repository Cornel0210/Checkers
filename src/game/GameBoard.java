package game;

import board.CheckersBoard;

public final class GameBoard {

    private static GameBoard INSTANCE;
    private final CheckersBoard board;
    private GameBoard(){
        board = new CheckersBoard();
    }

    public CheckersBoard getCheckersBoard() {
        return board;
    }

    public static GameBoard getInstance(){
        if (INSTANCE == null){
            INSTANCE = new GameBoard();
        }
        return INSTANCE;
    }
}
