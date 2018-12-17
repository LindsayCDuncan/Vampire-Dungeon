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
public class Vampire extends Character{
    private boolean alive;
    
    public Vampire(Location location){
        super(location, 'v');
        this.alive = true;
    }
    
    public void killVampire(){
        this.alive = false;
    }
    
    public boolean isAlive(){
        return this.alive;
    }
    
}
