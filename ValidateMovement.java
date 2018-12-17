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
//Checks if new moves are within the bounds of the gameboard
public class ValidateMovement {
    
    private final int maxHeight;
    private final int maxLength;
    
    public ValidateMovement(int maxHeight, int maxLength){
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
    }
    
    //go up is x-coord - 1
    public boolean goUp(Location currentLocation){
        return (currentLocation.getX() - 1) >= 0;
    }
    
    //go down is x-coord + 1
    public boolean goDown(Location currentLocation){
        return (currentLocation.getX() + 1) < this.maxHeight;
    }
    
    //go left is y-coord - 1
    public boolean goLeft(Location currentLocation){
        return (currentLocation.getY() - 1) >= 0;
    }
    
    //go right is y-coord + 1
    public boolean goRight(Location currentLocation){
        return (currentLocation.getY() + 1) < this.maxLength;
    }
    
}
