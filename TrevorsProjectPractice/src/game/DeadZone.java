/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 *This class controls the zone in which the player dies <br>
 * upon contact with it. Player comes across this in level <br>
 * 3
 * 
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class DeadZone extends StaticBody {
    
    /**
     * radius of the deadzone circle
     */
    private static final float radius = 1.0f;
    //initalised float to act as radius value
    
    /**
     * ballshape variable is a circle shape with radius <br>
     * in the parentheses
     */
    private static final Shape BallShape = new CircleShape(radius); 
    //new BallShape object being made with radius value parsed in
    
    /**
     * creates image of deadzone with png image and image size <br>
     * as parameters
     */
    private static final BodyImage BombImage =
            new BodyImage("data/deadzone.png", 2*radius);
    //image from data file to represent each fireball

    /**
     *constructor with world parsed through.<br>
     * Super has same world and ballShape parsed.
     * @param w
     * game world that the player is participating in 
     */
    public DeadZone(World w) {
        super(w, BallShape);
        
         addImage(BombImage);
        //metod for image use
        
    }
    
}
