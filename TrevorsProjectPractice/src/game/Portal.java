/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 * gateway to the next level
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class Portal extends StaticBody {

    /**
     * constructor with world parsed in
     * @param world
     * game world of player
     */
    public Portal(World world) {
        super(world);
        /**
         * shape of portal
         */
        Shape PortalShape = new PolygonShape(
               -0.93f,0.86f, -0.56f,1.34f, 0.6f,1.33f,
                1.1f,0.62f, 1.06f,-1.4f, -0.9f,-1.4f
        );
        
        /**
         * fixture to make solid portal shape
         */
        Fixture PortalShapeFixture = new SolidFixture(this,PortalShape);
        
         addImage(new BodyImage("data/portal2.png",3)); 

    }
}
