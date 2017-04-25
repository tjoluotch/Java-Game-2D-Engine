/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import java.util.logging.Logger;


/**
 *Class represents FireBall dynamic body which <br>
 * the player can use to inflict damage on the ufo.
 * 
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 * 
 */
public class FireBall extends DynamicBody  {
    
    /**
     * radius of the fireball circle object
     */
    private static final float radius = 0.5f;
    //initalised float to act as radius value
    
    /**
     * shape of the fireball with radius value <br>
     * parsed as parameter
     */
    private static final Shape BallShape = new CircleShape(radius); 
    //new BallShape object being made with radius value parsed in
    
    /**
     *image of the fireball along with the size of the image
     */
    private static final BodyImage FireImage =
            new BodyImage("data/fire.png", 2*radius);
    //image from data file to represent each fireball
    
 
    
    /**
     *constructor taking world as a parameter.<br>
     * Super takes the instance of world and ballshape parameters. 
     * @param world
     * world gets the world that the fireball <br>
     * object is being fired in
     */
    public FireBall(World world) {
        //parsing world through FireBall constructor as
        //its a requirement for DynamicBody from CS engine
      
        super(world, BallShape);
        //parsing world and Ball shape object into super
     
        addImage(FireImage);
        //metod for image use
             
    }

}
