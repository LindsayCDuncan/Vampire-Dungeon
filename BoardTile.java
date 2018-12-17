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
public class BoardTile {
    private final Location location;
    private boolean empty;
    private boolean heroPresent;
    private boolean vampPresent;
    
    public BoardTile(Location location){
        this.location = location;
        this.empty = true;
        this.heroPresent = false;
        this.vampPresent = false;
    }
    
    public boolean isEmpty(){
        return this.empty;
    }
    
    public boolean isHeroPresent(){
        return this.heroPresent;
    }
    
    public boolean isVampPresent(){
        return this.vampPresent;
    }
    
    public void heroEntersTile(){
        this.heroPresent = true;
        this.empty = false;
    }
    
    public void vampEntersTile(){
        this.vampPresent = true;
        this.empty = false;
    }
    
    public void heroLeavesTile(){
        this.heroPresent = false;
        this.checkIfEmpty();
    }
    
    public void vampLeavesTile(){
        this.vampPresent = false;
        this.checkIfEmpty();
    }
    
    public void checkIfEmpty(){
        this.empty = (this.heroPresent == false) && (this.vampPresent == false);
    }
    
    public Location getLocation(){
        return this.location;
    }
    
}
