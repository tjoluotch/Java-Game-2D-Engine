package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class Controller extends KeyAdapter {
    

    /**
     * jumping speed variable stores value 15 <br>
     * and will be used for player jump
     */
    private static final float JUMPING_SPEED = 15;
    //initialise walking speed

    /**
     * walking speed variable stores value 4 <br>
     * and will be used for player motion left to right
     */
    private static final float WALKING_SPEED = 4;
    
    /**
     * body variable represents the character <br>
     * that the player will be using 
     */
    private Walker body;
    
    /**
     * the controller constructor <br>
     * governs the way in which the character will be controlled in the game
     * @param body
     * game character body that will implement the controller
     */
    public Controller(Walker body) {
        this.body = body;
    }
    
    /**
     * Handle key press events for walking and jumping. <br>
     * q = quit game and will exit screen <br>
     * j = game character jumping <br>
     * left arrow = left movement <br>
     * right arrow = right movement <br>
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_J) { // J = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_LEFT) {
            body.startWalking(-WALKING_SPEED); // LEFT ARROW = walk left
        } else if (code == KeyEvent.VK_RIGHT) {
            body.startWalking(WALKING_SPEED); // RIGHT = walk right
        }
    }
    
    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            body.stopWalking();
        }
    }
    
    /**
     * Method allows controls specified above <br>
     * to be used with a different game character to <br>
     * the initial one
     * @param body
     * new walker variable body being initialised to body<br>
     * variable Walker in constructor
     */
    public void setBody(Walker body) {
        this.body = body;
    }
}
