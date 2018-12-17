package dungeon;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
         final Scanner scanner = new Scanner(System.in);
         final InputReader reader = new InputReader(scanner);
         final OutputWriter writer = new OutputWriter();

        new Dungeon(10,10,5,14, reader, writer).run();
        
    }
}
