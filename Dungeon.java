/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author linzi
 */
public class Dungeon {
    private int turns;
    private final GameBoard board;
    private final InputReader reader;
    private final OutputWriter writer;
    
    
    public Dungeon(int length, int height, int vampires, int turns, InputReader reader, OutputWriter writer){
        this.turns = turns;      
        board = new GameBoard(length, height, vampires);
        this.reader = reader;
        this.writer = writer;
    }
    
    public void run(){
        board.initializeBoard();
        message();
        playGame();
        board.printBoard(writer);
        displayTurns();
    }
    
    public void playGame(){
        while(!board.isVampListEmpty()){
            board.printBoard(writer);
            this.displayTurns();
            
            if(this.turns <= 0){
                writer.writeLine("You lose.\n");
                break;
            }
                       
            MovementValidator input = new MovementValidator(userInputString());
            
            Turn turn = new Turn(board.getBoardTiles(), board.getVampList());
            turn.processHeroTurn(board.getHero(), input.createMovementQueue());
            turn.processVampireTurn();
            
            this.reduceTurns();

        }
        if (board.isVampListEmpty()){
            writer.writeLine("You win\n");
        }
    }
    
    public String userInputString(){
        String input = reader.readLine();
        return input;
    }

    public void message(){
        writer.writeLine("\nUse WASD keys to move. Multiple moves can be performed in one turn.\n");
        writer.writeLine("However, the vampires will move as many times as you!\n");
        writer.writeLine("Land on vampires to kill them. Kill all the vampires to win.\n");
        writer.writeLine("Run out of turns and you lose.\n");
    }
    
    public void reduceTurns(){
        this.turns--;
    }
    
    public void displayTurns(){
        writer.writeLine("Turns left: " + this.turns + "\n");
    }

}
