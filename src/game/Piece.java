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

    /**
     'shapeShift' method checks if current piece can be shifted from 'MAN' to 'KING'.
     (this can be done when reaching the last lane in the opposite direction from the game's starting position).
     */
    default void shapeShift(){
        if (this.getPosition().getX()==0 || this.getPosition().getX()==7) {
            if (this.getType() == Type.MAN) {
                this.setType(Type.KING);
            }
        }
    }

    /**
     'isValid' method checks if the inserted position is valid (between the limits of the board).
     A position is considered valid if its both 'x' and 'y' are included in the [0, 7] interval.
     Returns: true if the inserted position is on the board, false otherwise.
     */
    default boolean isValid(Position pos){
        return pos.getX() >= 0 && pos.getX() <= 7 &&
                pos.getY() >= 0 && pos.getY() <= 7;
    }

    /**
     'checkIfCanMove' method checks if destination position is on the diagonal of current position,
     and next to current position. In case of 'MAN' pieces, there will be allowed only forward moves, until the piece is
     shape-shifted to 'KING' piece.
     Same conditions are applied to 'KING' pieces, except that this type of pieces can move backwards.
     Returns: true if piece can be moved to the inserted position and false otherwise.
     */
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