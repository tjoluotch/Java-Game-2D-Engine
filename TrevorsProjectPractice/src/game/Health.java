/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 *Health class to represent health of the player
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class Health extends DynamicBody{

    /**
     *area of the health icon
     */
    private static final float area = 0.5f;
//declaring and initialising float
//to represent area of health

    /**
     *shape of the health icon made up of 2 <br>
     * area parameters.
     */
    private static final Shape BoxShape = new BoxShape(area, area);
//Box SHape tat will be health icon in game world

    /**
     *image to be displayed for health objects in the game
     */
    private static final BodyImage HealthImage =
            new BodyImage("data/health.png", 3*area);


    /**
     *constructor creating health class
     * @param world
     * world the health class will be used in. <br>
     * This is also used in super along with boxshape variable
     */
    public Health(World world) {
        //constructor with world parsed in 
        super(world,BoxShape);
        
        
        addImage(HealthImage);
        //image object parsed through addImage method
    }
    
    
}
