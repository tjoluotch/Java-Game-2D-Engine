/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 * This class creates the Bomb that the Ufo will be firing <br>
 * controlled by a timer
 * 
 * @author Trevor, Oluotch, Trevor.Oluotch@city.ac.uk <br>
 * @version 3.0<br>
 * @since version 1.0<br>
 */
public class Bomb extends DynamicBody{
    
    /**
     * radius variable creates the radius of each<br>
     * bomb object
     */
    private static final float radius = 0.5f;
    //initalised float to act as radius value
    
    /**
     *ballShape variable creates the figure f the <br>
     * ball as a circle 
     */
    private static final Shape BallShape = new CircleShape(radius); 
    //new BallShape object being made with radius value parsed in
    
    /**
     * bombImage variable creates the actual bomb image along with display<br>
     * size 
     */
    private static final BodyImage BombImage =
            new BodyImage("data/bomb.png", 2*radius);
    //image from data file to represent each fireball

    /**
     *Bomb constructor parsing world instance <br>
     * and super constructor parsing in ballShhape variable
     * @param world
     * the world in which the bomb shall be used
     */
    public Bomb(World world) {
        
        super(world,BallShape);
        
        
          addImage(BombImage);
        //metod for image use
    }
    
    
}
