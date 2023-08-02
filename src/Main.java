import game.Game;
import game.Position;

public class Main {
    public static void main(String[] args) {
        Game.getInstance().getCheckersBoard().move(new Position(2,1), new Position(3,0));
        Game.getInstance().getCheckersBoard().move(new Position(5,0), new Position(4,1));
        Game.getInstance().getCheckersBoard().move(new Position(2,3), new Position(3,2));
        Game.getInstance().getCheckersBoard().move(new Position(5,2), new Position(4,3));
        Game.getInstance().getCheckersBoard().move(new Position(4,3), new Position(3,4));
        Game.getInstance().getCheckersBoard().move(new Position(5,6), new Position(4,7));
        Game.getInstance().getCheckersBoard().move(new Position(6,5), new Position(5,6));
        Game.getInstance().getCheckersBoard().move(new Position(6,1), new Position(5,2));
        Game.getInstance().getCheckersBoard().move(new Position(4,7), new Position(3,6));

        System.out.println(Game.getInstance().getCheckersBoard());
        System.out.println(Game.getInstance().getCheckersBoard().capture(new Position(2,5), new Position(6,1)));
        System.out.println(Game.getInstance().getCheckersBoard());
        Game.getInstance().getCheckersBoard().move(new Position(3,2), new Position(4,3));
        Game.getInstance().getCheckersBoard().move(new Position(1,2), new Position(2,3));
        System.out.println(Game.getInstance().getCheckersBoard());
        System.out.println(Game.getInstance().getCheckersBoard().capture(new Position(7,0), new Position(5,2)));
        System.out.println(Game.getInstance().getCheckersBoard().capture(new Position(4,3), new Position(6,1)));
        Game.getInstance().getCheckersBoard().move(new Position(6,1), new Position(7,0));
        Game.getInstance().getCheckersBoard().move(new Position(7,0), new Position(6,1));
        Game.getInstance().getCheckersBoard().move(new Position(6,3), new Position(5,2));
        Game.getInstance().getCheckersBoard().move(new Position(5,6), new Position(4,5));
        Game.getInstance().getCheckersBoard().move(new Position(4,5), new Position(3,4));
        Game.getInstance().getCheckersBoard().move(new Position(6,7), new Position(5,6));

        System.out.println(Game.getInstance().getCheckersBoard());
        System.out.println(Game.getInstance().getCheckersBoard().capture(new Position(6,1), new Position(2,5)));
        //select number 1 if you want the code below to be executed
        System.out.println(Game.getInstance().getCheckersBoard().move(new Position(1,4), new Position(3,2)));
        System.out.println(Game.getInstance().getCheckersBoard());
        Game.getInstance().getCheckersBoard().move(new Position(2,3), new Position(3,2));
        Game.getInstance().getCheckersBoard().move(new Position(0,1), new Position(1,2));
        Game.getInstance().getCheckersBoard().move(new Position(3,4), new Position(2,3));
        System.out.println(Game.getInstance().getCheckersBoard().capture(new Position(2,3), new Position(0,1)));
        Game.getInstance().getCheckersBoard().move(new Position(7,2), new Position(6,1));
        System.out.println(Game.getInstance().getCheckersBoard().capture(new Position(3,2), new Position(7,2)));



        System.out.println(Game.getInstance().getCheckersBoard());

    }
}
