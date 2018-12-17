/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;
import java.util.*;
/**
 *
 * @author linzi
 */
public class InputReader {
    private Scanner scanner;
    
    public InputReader(Scanner scanner){
        this.scanner = scanner;
    }
    
    public String readLine(){
        return scanner.nextLine();
    }
    
}
