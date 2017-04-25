/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 * listens for collisions with the portal
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class PortalListener implements CollisionListener {
    
    /**
     *computer game
     */
    private Game game;
   
    /**
     *player user controls
     */
    private OptimusPrime player;

    /**
     *constructor creating portal listener class
     * @param game
     * computer game being played
     * @param player
     * player in collision with the listener
     */
    public PortalListener(Game game, OptimusPrime player){
        this.game = game;
        this.player = player;
    }    
    
    /**
     *go to next level when portal and player collide
     * @param e
     * calls instances of portal and player to check if collision has occurred
     */
    @Override
        public void collide(CollisionEvent e) {
        //OptimusPrime player = game.getPlayer();
        if (e.getReportingBody() instanceof Portal && e.getOtherBody() instanceof OptimusPrime) {
            System.out.println("Going to next level...");
            game.goNextLevel();
        }
    }
    
}
