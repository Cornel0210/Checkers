package game;

import board.CheckersBoard;

public final class Game {

    private static Game INSTANCE;
    private final CheckersBoard board;
    private Game(){
        board = new CheckersBoard();
    }

    public CheckersBoard getCheckersBoard() {
        return board;
    }

    public static Game getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Game();
        }
        return INSTANCE;
    }


}
