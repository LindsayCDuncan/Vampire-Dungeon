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
public abstract class Character{
    private Location location;
    private final char boardRepresentation;
    
    public Character(Location location, char boardRepresentation){
        this.location = location;
        this.boardRepresentation = boardRepresentation;
    }
    
    public Location getLocation(){
        return this.location;
    }
    
    public void newLocation(Location location){
        this.location = location;
    }
   
    
    @Override
    public String toString(){
        return this.boardRepresentation + " " + this.location.toString();
    }
}
