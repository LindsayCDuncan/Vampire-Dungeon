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
public class Turn {
    
    private final BoardTile[][] board;
    private final Move move;
    private int numberOfMoves;
    private final Iterator<Vampire> iterateVampList;
    
    public Turn(BoardTile[][] board, List<Vampire> vampList){
        this.board = board;
        this.move = new Move(new ValidateMovement(board.length, board[0].length));
        this.iterateVampList = vampList.iterator();
    }
    
    public void processHeroTurn(Hero hero, Queue<String> moveList){
        setNumberOfMoves(moveList.size());
        
        for(String movement : moveList){
            heroLeavesTile(hero.getLocation());
            heroEntersTile(movement, hero);
            
            killVampires(hero.getLocation().getX(), hero.getLocation().getY());           
        }
    }
    
    public void heroLeavesTile(Location location){
        int heroX = location.getX();
        int heroY = location.getY();
        board[heroX][heroY].heroLeavesTile();
    }
    
    public void heroEntersTile(String movement, Hero hero){
        hero.newLocation(move.moveToNewLocation(movement, hero.getLocation()));
        int heroNewX = hero.getLocation().getX();
        int heroNewY = hero.getLocation().getY();
        board[heroNewX][heroNewY].heroEntersTile(); 
    }
    
    public void setNumberOfMoves(int numberOfMoves){
        this.numberOfMoves = numberOfMoves;
    }
    
    //Kill vampires if present on hero tile
    public void killVampires(int heroX, int heroY){
        if(board[heroX][heroY].isVampPresent()){
            while(iterateVampList.hasNext()){
                Vampire vamp = iterateVampList.next();
                
                if(vamp.getLocation().getX() == heroX &&
                        vamp.getLocation().getY() == heroY){
                    iterateVampList.remove();
                    vampLeavesTile(vamp.getLocation());
                    break;
                }
            }
        }
    }
    
    public void processVampireTurn(){
        while (iterateVampList.hasNext()){
            Vampire vampire = iterateVampList.next();
            
            for(int i = 0; i < this.numberOfMoves; i++){
                Location oldLocation = vampire.getLocation();
                vampLeavesTile(oldLocation);
                
                Location newLocation = generateNewRandomLocation(oldLocation);
                vampEntersTile(oldLocation, newLocation, vampire);

                if(isHeroInNewTile(vampire.getLocation())){
                    iterateVampList.remove();
                    vampLeavesTile(vampire.getLocation());
                    break;
                }            
            }             
        }
    }
    
    public void vampLeavesTile(Location location){
        int vampX = location.getX();
        int vampY = location.getY();
        board[vampX][vampY].vampLeavesTile();
    }
    
    public Location generateNewRandomLocation(Location oldLocation){
        RandomMovement movement = new RandomMovement();
        movement.movementToken();
        String moveTo = movement.movementDirection();        
        return move.moveToNewLocation(moveTo, oldLocation);
    }
    
    public boolean isOtherVampInNewLocation(Location newLocation){
        int newX = newLocation.getX();
        int newY = newLocation.getY();
        return board[newX][newY].isVampPresent();
    }
    
    public void vampEntersTile(Location oldLocation, Location newLocation, Vampire vampire){
        if(isOtherVampInNewLocation(newLocation)){
            vampire.newLocation(oldLocation); //go back to old location - two vampires cannot be in same tile
        }
        else{
            vampire.newLocation(newLocation); //proceed to new tile
        }
        board[vampire.getLocation().getX()][vampire.getLocation().getY()].vampEntersTile(); //set tile status
    }
    
    public boolean isHeroInNewTile(Location location){
        return board[location.getX()][location.getY()].isHeroPresent();
    }    
}
