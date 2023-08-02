package board;

import game.*;

public class CheckersBoard {
    private final Piece[][] board;

    public CheckersBoard() {
        this.board = new Piece[8][8];
        loadDefaultBoard();
    }
    private void loadDefaultBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < board.length; j++) {
                if ((i + j) % 2 != 0){
                    board[i][j] = new Red(Colour.RED, new Position(i,j), Type.MAN);
                    board[board.length-i-1][board.length-j-1] = new Black(Colour.BLACK, new Position(board.length-i-1,board.length-j-1), Type.MAN);
                } else {
                    board[i][j] = null;
                    board[board.length-i-1][board.length-j-1] = null;
                }
                board[3][j] = null;
                board[4][j] = null;

            }
        }
    }

    public boolean move(Position from, Position to){
        if (isValid(from) && isValid(to)){
            Piece piece = board[from.getX()][from.getY()];
            if(piece!=null && piece.canMove(to)){
                board[to.getX()][to.getY()] = piece;
                piece.setPosition(new Position(to.getX(), to.getY()));
                board[from.getX()][from.getY()] = null;

                if (piece.getColour() == Colour.BLACK && to.getX() == 0){
                    piece.shapeShift();
                    System.out.println("shifted");
                } else if (piece.getColour() == Colour.RED && to.getX() == 7){
                    piece.shapeShift();
                    System.out.println("shifted");
                }
                return true;
            }
        }
        return false;
    }

    private boolean isValid(Position pos) {
        return pos.getX() >= 0 && pos.getX() <= 7 &&
                pos.getY() >= 0 && pos.getY() <= 7;
    }
}
