package game;

import board.CheckersBoard;

public class Game {
    private CheckersBoard board = GameBoard.getInstance().getCheckersBoard();
    private boolean isBlack = true;

    public void run(){
        System.out.println(board);
        while (!board.isEnd()) {
            Position from = new Position(Input.getInstance().getInt(), Input.getInstance().getInt());
            Position to = new Position(Input.getInstance().getInt(), Input.getInstance().getInt());
            while (!board.move(from, to, isBlack ? Colour.BLACK : Colour.RED) &&
                    !board.capture(from, to, isBlack ? Colour.BLACK : Colour.RED)) {
                System.out.println("Something went wrong");
                from = new Position(Input.getInstance().getInt(), Input.getInstance().getInt());
                to = new Position(Input.getInstance().getInt(), Input.getInstance().getInt());
            }
            isBlack = !isBlack;
            System.out.println(board);
        }
        if (isBlack) {
            System.out.println("RED won!");
        } else {
            System.out.println("BLACK won");
        }
    }

}
