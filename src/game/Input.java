package game;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Input {

    private static Input INSTANCE;
    private final Scanner scanner;

    private Input() {
        this.scanner = new Scanner(System.in);
    }

    public int getInt(){
        int i = Integer.MIN_VALUE;
        while (scanner.hasNext()){
            try {
                i = scanner.nextInt();
                break;
            } catch (NoSuchElementException ne){
                System.out.println("Wrong input.");
            } catch (IllegalStateException e){
                System.out.println("Scanner was closed.");
            } finally {
                scanner.nextLine();
            }
        }
        return i;
    }

    public static Input getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Input();
        }
        return INSTANCE;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        scanner.close();
    }
}
