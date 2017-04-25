/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Fixture;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

/**
 *implements level 3 in the game
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class Level3 extends GameLevel {
    
    /**
     * emeralds that can be collected
     */
    private static final int NUM_EMERALDS = 8;
    
    /**
     *constructor that populates with the game the user is playing
     * @param game
     * game that is played
     */
    @Override 
    public void populate(Game game){
        super.populate(game);
    
             // make the ground
        /**
         * create ground
         */     
        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        // walls
        /**
         * create walls
         */
        Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-11.5f, 10f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(11.5f, 10f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);
        

        // make platforms
        /**
         * create platforms
         */
        Shape boxShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-7, 5.5f));
        Body platform2 = new StaticBody(this, boxShape);
        platform2.setPosition(new Vec2(5, -2.5f));
        
        /**
         * creates  3 dead zones in level 3 with collision listeners for each
         */
        DeadZone deadZone = new DeadZone(this);
        deadZone.setPosition(new Vec2(5f,5f));
        DeadZone deadZone1 = new DeadZone(this);
        deadZone1.setPosition(new Vec2(-2f,-6f));
        DeadZone deadZone2 = new DeadZone(this);
        deadZone2.setPosition(new Vec2(0f,2f));
         deadZone.addCollisionListener(new Pickup(getPlayer(), game));
          deadZone1.addCollisionListener(new Pickup(getPlayer(), game));
           deadZone2.addCollisionListener(new Pickup(getPlayer(), game));
        
    
    
     for (int i = 0; i < NUM_EMERALDS; i++) {
            Body emerald = new Emerald(this);
            emerald.setPosition(new Vec2(i*2-10, 10));
            emerald.addCollisionListener(new Pickup(getPlayer(), game));
        }
             for (int h = 0; h<7; h++) {
            Body health = new Health(this);
            health.setPosition(new Vec2(h*5-6,7)); 
            health.addCollisionListener(new Pickup(getPlayer(), game));
        }
             
        martian = new Martian(this);
        martian.setPosition(new Vec2(2f,5f));
        martian.addCollisionListener(new Pickup(getPlayer(),game));
        addStepListener(martian);
        
        martian2 = new Martian(this);
        martian2.setPosition(new Vec2(2f,5f));
        martian2.addCollisionListener(new Pickup(getPlayer(),game));
        addStepListener(martian2);
    }
    
    /**
     *position of player in level 3
     * @return
     * Vec2 of player in level 3
     */
    @Override
    public Vec2 startPosition(){
        return new Vec2(8f, -10f);
    }
    
    /**
     *position of portal in level 3
     * @return
     * Vec2 of portal in level 3
     */
    @Override
    public Vec2 portalPosition(){
        return new Vec2(-3f,-3f);
    }
    
    /**
     *position of ufo in level 3
     * @return
     * Vec2 of ufo in level 3
     */
    @Override
    public Vec2 ufoStartPosition(){
        return new Vec2(3f,11f);
    }
    
    /**
     *check if level 3 is completed 
     * @return
     * true if player has 8 emerald and has entered the portal
     */
    @Override
    public boolean isCompleted(){
        return getPlayer().getEmeraldCount() == NUM_EMERALDS;
    }
}
