package board;

import game.*;

import java.util.List;
import java.util.Map;

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
    public boolean capture(Position from, Position to){
        if (isValid(from) && isValid(to)){
            Map<Integer, List<Position>> options = board[from.getX()][from.getY()].getOptions(to);
            if (options.size() == 0){
                return false;
            } else if (options.size() == 1){
                applyPath(options.get(0));
                return true;
            } else {
                System.out.println("Choose the path that you want to go through:");
                for (int i = 0; i < options.size(); i++) {
                    System.out.print(i + " -> ");
                    options.get(i).forEach(System.out::print);
                    System.out.println();
                }
                int input = Input.getInstance().getInt();
                while (input<0 || input > options.size()-1){
                    System.out.println("Insert a number between 0 and " + (options.size()-1) + ":");
                    input = Input.getInstance().getInt();
                }

                applyPath(options.get(input));
                return true;
            }
        }
        return false;
    }
    private void applyPath(List<Position> list){
        Position first = list.get(0);
        Piece piece = board[first.getX()][first.getY()];
        board[first.getX()][first.getY()] = null;
        Position second = first;
        for (int i = 1; i < list.size(); i++) {
            second = list.get(i);
            if (first.getX()<second.getX() &&
                    first.getY()<second.getY()){
                board[first.getX()+1][first.getY()+1] = null;
            } else if (first.getX()>second.getX() &&
                    first.getY()>second.getY()){
                board[first.getX()-1][first.getY()-1] = null;
            } else if (first.getX()<second.getX() &&
                    first.getY()>second.getY()){
                board[first.getX()+1][first.getY()-1] = null;
            } else if (first.getX()>second.getX() &&
                    first.getY()<second.getY()){
                board[first.getX()-1][first.getY()+1] = null;
            }
            first = second;
        }
        board[second.getX()][second.getY()] = piece;
        piece.setPosition(second);
    }

    private boolean isValid(Position pos) {
        return pos.getX() >= 0 && pos.getX() <= 7 &&
                pos.getY() >= 0 && pos.getY() <= 7;
    }

    public Piece[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if ((i+j)%2==0){
                    if (board[i][j] != null) {
                        stringBuilder.append("\u001b[47;1m").append(board[i][j]).append(" \u001b[0m| ");
                    } else {
                        stringBuilder.append("\u001b[47;1m ").append(" \u001b[0m| ");

                    }
                } else {
                    if (board[i][j] != null) {
                        stringBuilder.append(board[i][j]).append(" |\u001b[47;1m \u001b[0m");
                    } else {
                        stringBuilder.append(" ").append(" |\u001b[47;1m \u001b[0m");
                    }
                }
            }
            stringBuilder.replace(stringBuilder.length()-2, stringBuilder.length()-1, "");
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
