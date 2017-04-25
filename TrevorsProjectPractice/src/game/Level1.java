/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import java.awt.event.*;

import javax.swing.Timer;

import org.jbox2d.common.Vec2;

/**
 * class implements level1
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class Level1 extends GameLevel implements ActionListener {

    /**
     * number of emeralds available for the player to collect
     */
    private static final int NUM_EMERALDS = 8;

    /**
     * health available to collect
     */
    private static final int NUM_HEALTH = 7;

    /**
     *4 seconds to aid timer event
     */
    public final static int FOUR_SECONDS = 4000; 

    /**
     * timer to control bombs getting fired every 4 seconds
     */
    private Timer timer;

    /**
     *populates the level 1 class with game as a parameter
     * @param game
     * game that the user is playing
     */
    @Override
    public void populate (Game game){
        super.populate(game);
         
         // make the ground
         /**
          * creating a ground in the game
          */
        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
       
        
        // walls
        /**
         * creating walls in the game
         */
        Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-11.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        
        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(11.5f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
        

        // make platforms
        /**
         * create the platforms in the game
         */
        Shape boxShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, 5.5f));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(5, -2.5f));
    
    
     for (int i = 0; i < NUM_EMERALDS; i++) {
            Body emerald = new Emerald(this);
            emerald.setPosition(new Vec2(i*2-10, 10));
            emerald.addCollisionListener(new Pickup(getPlayer(), game));
        }
             for (int h = 0; h< NUM_HEALTH; h++) {
            Body health = new Health(this);
            health.setPosition(new Vec2(h*5-6,7)); 
            health.addCollisionListener(new Pickup(getPlayer(), game));
        }
             timer = new Timer(FOUR_SECONDS,this);
             timer.start();
             
    }
    
    /**
     *ufo start position in level 1
     * @return
     * vec2 of the ufo starting position in level 1 
     */
    @Override
    public Vec2 startPosition(){
        return new Vec2(8f, -10f);
    }
    
    /**
     *position of portal in level 1
     * @return
     * Vec2 of portal in level 1
     */
    @Override
    public Vec2 portalPosition(){
        return new Vec2(-3f,-3f);
    }
    
    /**
     *position of ufo in level 1
     * @return
     * Vec2 of ufo in level 1
     */
    @Override
    public Vec2 ufoStartPosition(){
        return new Vec2(0f,11f);
    }
    
    /**
     *check if level 1 is completed 
     * @return
     * true if player has 1 emerald and has entered the portal
     */
    @Override
    public boolean isCompleted(){
        return getPlayer().getEmeraldCount() == 1;
    }
    
    @Override
    /**
     * fires a bomb from ufo that spreads into 5 bombs <br>
     * every 4 seconds
     */
    public void actionPerformed(ActionEvent e){
        timer.start();
        System.out.println("timer life");
        
        for(int i = 0; i<1; i++){
            DynamicBody bomb = new Bomb(this);
            bomb.setPosition(new Vec2(ufo.getPosition().x,ufo.getPosition().y-3));
            bomb.setLinearVelocity(new Vec2(0,-20));
        }
        
        timer.isRepeats();
        System.out.println("timer repeats");
    }
        
    
}
