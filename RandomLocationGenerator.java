/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Random;

/**
 *
 * @author linzi
 */
public class RandomLocationGenerator {
    
    private final int maxHeight;
    private final int maxLength;
    private final Random rand;
    
    public RandomLocationGenerator(int maxHeight, int maxLength){
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
        this.rand = new Random();
    }
    
    public int generateXCoord(){
        int xCoord = rand.nextInt(this.maxLength);
        return xCoord;
    }
    
    public int generateYCoord(){
        int yCoord = rand.nextInt(this.maxHeight);
        return yCoord;
    }
    
}
