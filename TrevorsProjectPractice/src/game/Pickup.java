package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Collision listener that allows the rocket to collect things.
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class Pickup implements CollisionListener {
  
    /**
     * character that the user controls
     */
    private OptimusPrime prime;
    //declaring class

    /**
     * emeralds the player collects 
     */
    private Emerald emerald;

    /**
     * emerald collection sound
     */
    private static SoundClip emeraldSound;
    
    /**
     * health the user collects 
     */
    private Health health;

    /**
     * health collection sound
     */
    private static SoundClip healthSound;
 
    /**
     * computer game
     */
    private Game game;
    
    /**
     * constructor creating pickup class
     * @param prime
     * player the user controls
     * @param game
     * computer game the user is playing
     */
    public Pickup(OptimusPrime prime, Game game) {
        this.prime = prime;
        this.game = game;
        
    }
    
    static{
        try{
            /**
             * health sound played on every health pickup
             */
            healthSound = new SoundClip("data/healthSound.wav");
        }catch(UnsupportedAudioFileException|IOException|LineUnavailableException e){
            System.out.println(e);
    }
    }
    
    static{
        try{
            /**
             * emerald sound played on every emerald pickup
             */
            emeraldSound = new SoundClip("data/emeraldSound.wav");
        }catch(UnsupportedAudioFileException|IOException|LineUnavailableException e){
            System.out.println(e);
        }
    }
    
    


    /**
     * collision of every object optimus prime contacts
     * @param e
     * collision event to differentiate bodies
     */

   @Override
    public void collide(CollisionEvent e) {
     
        if (e.getOtherBody() instanceof OptimusPrime && e.getReportingBody() instanceof Health) {
            prime.incrementHealthCount();
            healthSound.play();
            e.getReportingBody().destroy();
            
           
        }
        
        else if (e.getOtherBody() instanceof OptimusPrime && e.getReportingBody() instanceof Emerald) {
            prime.incrementEmeraldCount();
            emeraldSound.play();
            e.getReportingBody().destroy();
        }
        
          else if (e.getOtherBody() instanceof OptimusPrime && e.getReportingBody() instanceof DeadZone) {
            e.getReportingBody().destroy();
            System.exit(0);
        } 
        
          else if (e.getReportingBody() instanceof Boss && e.getOtherBody() instanceof FireBall){
            e.getOtherBody().destroy();
            System.out.println("boss hit");
        }
        
            else if (e.getReportingBody() instanceof StaticBody && e.getOtherBody() instanceof FireBall){
            e.getOtherBody().destroy();
            System.out.println("boss hit");
        }   
  
    }
    

    
}
