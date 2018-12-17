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
public class Move {
    private final ValidateMovement validMoves;
    
    public Move(ValidateMovement validMoves){
        this.validMoves = validMoves;
    }
    
        public Location moveToNewLocation(String move, Location oldLocation){
        int newX = oldLocation.getX();
        int newY = oldLocation.getY();

        if(move.equals("w") && validMoves.goUp(oldLocation)){
           newX--;
        }
        else if(move.equals("a") && validMoves.goLeft(oldLocation)){
            newY--;
        }            
        else if(move.equals("s") && validMoves.goDown(oldLocation)){
            newX++;
        }
        else if(move.equals("d") && validMoves.goRight(oldLocation)){
            newY++;
        }
        
        Location newLocation = new Location(newX, newY);
        return newLocation;
    }
}
