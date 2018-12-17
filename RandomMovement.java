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
public class RandomMovement {
    private final Random rand;
    private int randNum;
    
    public RandomMovement(){
        rand = new Random();
        
    }
    
    public void movementToken(){
        this.randNum = rand.nextInt(4) + 1;
    }
    
    public String movementDirection(){
        String move = "";
        switch(randNum){
            case 1: move = "w"; break;
            case 2: move = "a"; break;
            case 3: move = "s"; break;
            case 4: move = "d";
        }
        return move;
    }
}
