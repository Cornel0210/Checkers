package game;

import java.util.*;

public class Red implements Piece{
    private final Colour colour;
    private Position position;
    private Type type;

    public Red(Colour colour, Position position, Type type) {
        this.colour = colour;
        this.position = position;
        this.type = type;
    }

    @Override
    public Map<Integer, List<Position>> getOptions(Position toPos){
        if (isValid(toPos)) {
            Map<Integer, List<Position>> options = new HashMap<>();
            getOptions(this.position, toPos,  new LinkedList<>(), new LinkedList<>(), options);
            if (options.size() != 0){
                return options;
            }
        }
        return null;
    }

    private void getOptions(Position start, Position end, LinkedList<Position> visited, LinkedList<Position> route, Map<Integer, List<Position>> lists){
        route.add(start);
        visited.add(start);
        List<Position> neighbours;
        if (this.type == Type.MAN){
            neighbours = getMansNeighbours(start);
        } else {
            neighbours = getNeighbours(start);
        }
        for (Position  pos : neighbours){
            if (!visited.contains(pos) && !pos.equals(end)){
                getOptions(pos, end, visited, route, lists);
                route.removeLast();
                visited.removeLast();
            } else if (pos.equals(end)){
                route.add(end);
                lists.put(lists.size(), new LinkedList<>(route));
                route.removeLast();
            }
        }
    }

    private List<Position> getNeighbours(Position current){
        Piece[][] board = Game.getInstance().getCheckersBoard().getBoard();
        List<Position> list = new LinkedList<>();
        if (isValid(current)){
            Position temp = new Position(current.getX()-1,current.getY()-1);
            Position freeSpot = new Position(current.getX()-2,current.getY()-2);
            if (isValid(temp) && isValid(freeSpot) && board[temp.getX()][temp.getY()] instanceof Black && board[freeSpot.getX()][freeSpot.getY()] == null){
                list.add(freeSpot);
            }
            temp = new Position(current.getX()-1,current.getY()+1);
            freeSpot = new Position(current.getX()-2,current.getY()+2);
            if (isValid(temp) && isValid(freeSpot) && board[temp.getX()][temp.getY()] instanceof Black && board[freeSpot.getX()][freeSpot.getY()] == null){
                list.add(freeSpot);
            }
            temp = new Position(current.getX()+1,current.getY()-1);
            freeSpot = new Position(current.getX()+2,current.getY()-2);
            if (isValid(temp) && isValid(freeSpot) && board[temp.getX()][temp.getY()] instanceof Black && board[freeSpot.getX()][freeSpot.getY()] == null){
                list.add(freeSpot);
            }
            temp = new Position(current.getX()+1,current.getY()+1);
            freeSpot = new Position(current.getX()+2,current.getY()+2);
            if (isValid(temp) && isValid(freeSpot) && board[temp.getX()][temp.getY()] instanceof Black && board[freeSpot.getX()][freeSpot.getY()] == null){
                list.add(freeSpot);
            }
        }
        return list;
    }

    private List<Position> getMansNeighbours(Position current){
        Piece[][] board = Game.getInstance().getCheckersBoard().getBoard();
        List<Position> list = new LinkedList<>();
        if (isValid(current)){
            Position temp = new Position(current.getX()+1,current.getY()-1);
            Position freeSpot = new Position(current.getX()+2,current.getY()-2);
            if (isValid(temp) && isValid(freeSpot) && board[temp.getX()][temp.getY()] instanceof Black && board[freeSpot.getX()][freeSpot.getY()] == null){
                list.add(freeSpot);
            }
            temp = new Position(current.getX()+1,current.getY()+1);
            freeSpot = new Position(current.getX()+2,current.getY()+2);
            if (isValid(temp) && isValid(freeSpot) && board[temp.getX()][temp.getY()] instanceof Black && board[freeSpot.getX()][freeSpot.getY()] == null){
                list.add(freeSpot);
            }
        }
        return list;
    }

    @Override
    public void shapeShift() {
        Piece.super.shapeShift();
    }
    @Override
    public Colour getColour() {
        return this.colour;
    }
    @Override
    public Type getType() {
        return type;
    }
    @Override
    public Position getPosition() {
        return position;
    }
    @Override
    public void setPosition(Position position) {
        this.position = position;
    }
    @Override
    public void setType(Type type) {
        this.type = type;
    }
    @Override
    public boolean canMove(Position to) {
        return Piece.super.checkIfCanMove(to);
    }
    @Override
    public String toString() {
        if (this.type == Type.MAN){
            return "\033[0;31mo\033[0m";
        } else {
            return "\033[1;31mO\033[0m";
        }
    }
}
