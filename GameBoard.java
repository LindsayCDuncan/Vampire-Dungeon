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
public class GameBoard {
    private final int length;
    private final int height;
    private final int numOfVamps;
    private BoardTile[][] boardTiles;
    private Hero hero;
    private List<Vampire> vampList;
    
    
    public GameBoard(int length, int height, int numOfVamps){
        this.length = length;
        this.height = height;
        this.numOfVamps = numOfVamps;
    }
    
    public void initializeBoard(){
        this.createBoard();
        this.fillInitialBoard(); 
        this.createHero();
        this.createVamps();           
    }
    
    private void createBoard(){
        this.boardTiles = new BoardTile[this.length][this.height];
    }
    
    private void createHero(){
        this.hero = new Hero();
        boardTiles[hero.getLocation().getX()][hero.getLocation().getY()].heroEntersTile();
    }
    
    private void createVamps(){
        this.vampList = new ArrayList<Vampire>();
        Vampire vampire;
        Location location;
        
        for(int i = 0; i < this.numOfVamps; i++){           
            while(true){ //vampires cannot occupy a spot already taken by another vampire
                location = initialVampLocation();
                vampire = new Vampire(location);
                if(!boardTiles[location.getX()][location.getY()].isVampPresent()){
                    break;
                }
            }            
            vampList.add(vampire);
            boardTiles[vampire.getLocation().getX()][vampire.getLocation().getY()].vampEntersTile();
        }
    }
    
    private Location initialVampLocation(){
        RandomLocationGenerator randomLocation = new RandomLocationGenerator(this.height, this.length);
        Location location;
        int x;
        int y;
        
        while (true){ //vampire cannot start at 0,0
            x = randomLocation.generateXCoord();
            y = randomLocation.generateYCoord();
            if (x != 0 && y != 0){
                break;
            }
        }
        location = new Location(x,y);
        return location;        
    }
    
    public List<Vampire> getVampList(){
        return this.vampList;
    }
    
    public BoardTile[][] getBoardTiles(){
        return this.boardTiles;
    }
    
    private void fillInitialBoard(){
        for(int i = 0; i < boardTiles.length; i ++){
            for (int j = 0; j < boardTiles[i].length; j++){
                boardTiles[i][j] = new BoardTile(new Location(i, j));
            }
        }
    }
    
    public boolean isVampListEmpty(){
        return vampList.isEmpty();
    }           
    
    public Hero getHero(){
        return this.hero;
    }
       
    public void printBoard(OutputWriter writer){
        for (BoardTile[] row : boardTiles) {
            for (BoardTile tile : row) {
                if(tile.isEmpty()){
                    writer.writeLine(".");
                }
                else if (tile.isHeroPresent()){
                    writer.writeLine("@");
                }
                else if (tile.isVampPresent()){
                    writer.writeLine("v");
                }
            }
            writer.writeLine("\n");
        }
    }
}
