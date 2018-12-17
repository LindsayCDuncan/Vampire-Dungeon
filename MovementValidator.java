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
public class MovementValidator {
    private final String input;
    
    public MovementValidator(String input){
        this.input = input;
    }
    
    public Queue<String> createMovementQueue(){
        Queue<String> movement = new LinkedList<String>();

        for(int i = 0; i < input.length(); i++){
            if (input.charAt(i) == 'w' ||
                    input.charAt(i) == 'a' ||
                    input.charAt(i) == 's' ||
                    input.charAt(i) == 'd'){
                String addChar = String.valueOf(input.charAt(i));
                movement.add(addChar);
            }
        }       
        return movement;
    }   
}
