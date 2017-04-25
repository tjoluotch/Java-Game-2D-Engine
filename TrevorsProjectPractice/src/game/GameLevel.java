/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

/**
 * abstract class creating contents that are in each level
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public abstract class GameLevel extends World {

    /**
     * main player within the game
     */
    private OptimusPrime player;

    /**
     * ufo that is throwing bombs at player in the game
     */
    public Ufo ufo;
    
    
    /**
     *bomb that ufo fires in game
     */
    private Bomb bomb;
    
    /**
     * health of player
     */
    private Health health;
    
    /**
     * emeralds that player has got
     */
    private Emerald emerald;
    
    /**
     *main enemy at the 4th level
     */
    private Boss boss;
    
    /**
     *enemy in level 2 and 3 and 4
     */
    Martian martian;
    
    Martian martian2;

    /**
     * get the main player
     * @return
     * main game player controlled by the user
     */
    public OptimusPrime getPlayer() {
        return player;
    }

    /**
     *get the boss used at level 4
     * @return
     * boss/ enemy trying to kill player
     */
    public Boss getBoss(){
        return boss;
    }
    
    /**
     *get ufo trying to kill player
     * @return
     * ufo trying to kill player
     */
    public Ufo getUfo() {
        return ufo;
    }
    
    /**
     *get enemy walker trying to kill player
     * @return
     * enemy trying to kill player
     */
    public Martian getMartian(){
        return martian;
    }
    
    /**
     *get player health
     * @return
     * player health
     */
    public Health getHealth(){
        return health;
    }
    
    /**
     *get player's emeralds
     * @return
     * player's emeralds
     */
    public Emerald getEmerald(){
        return emerald;
    }

    /**
     *populate game level with all the methods created
     * @param game
     */
    public void populate(Game game) {
        player = new OptimusPrime(this);
        player.setPosition(startPosition());
        ufo = new Ufo(this);
        ufo.setPosition(ufoStartPosition());
        ufo.setGravityScale(0);
        //set gravityScale to 0 so that UFO just floats
        ufo.addCollisionListener(new UfoHit(game,ufo));
        //collision Listener for anythhing tht hits the UFO
        Portal portal = new Portal(this);
        portal.setPosition(portalPosition());
        portal.addCollisionListener(new PortalListener(game,player));
        health = new Health(this);
        emerald = new Emerald(this);
    }

    /**
     *player start position at each level
     * @return
     * position
     */
    public abstract Vec2 startPosition();

    /**
     *ufo start position at each level
     * @return
     * position
     */
    public abstract Vec2 ufoStartPosition();
    
    /**
     *portal position at each level
     * @return
     * portal position
     */
    public abstract Vec2 portalPosition();
     
    /**
     *check if level is completed 
     * @return
     * level completed depending on each levels stipulations
     */
    public abstract boolean isCompleted();

}
