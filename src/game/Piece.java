package game;

import java.util.List;
import java.util.Map;

public interface Piece {

    Colour getColour();
    boolean canMove(Position to);
    Type getType();
    void setType(Type type);
    Position getPosition();
    void setPosition (Position position);
    Map<Integer, List<Position>> getOptions(Position pos);

    default void shapeShift(){
        if (this.getPosition().getX()==0 || this.getPosition().getX()==7) {
            if (this.getType() == Type.MAN) {
                this.setType(Type.KING);
            }
        }
    }
    default boolean isValid(Position pos){
        return pos.getX() >= 0 && pos.getX() <= 7 &&
                pos.getY() >= 0 && pos.getY() <= 7;
    }

    default boolean checkIfCanMove(Position to){
        if (Math.abs(getPosition().getX() - to.getX()) == 1 &&
                Math.abs(getPosition().getY() - to.getY()) == 1) {
            if (getType() == Type.MAN) {
                if (getColour() == Colour.RED) {
                    return getPosition().getX() < to.getX();
                } else {
                    return getPosition().getX() > to.getX();
                }
            } else {
                return true;
            }
        }
        return false;
    }

}