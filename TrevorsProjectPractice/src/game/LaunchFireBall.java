
package game;

import city.cs.engine.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.jbox2d.common.Vec2;

/**
 * A MouseListener that projects a fire ball on each mouse press.
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class LaunchFireBall extends MouseAdapter {

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private WorldView view;
    //initialise world view calss
   
    /**
     * the player character the user controls
     */
    private OptimusPrime prime;
    
    /**
     * the ufo enemy in the game that is trying to kill the player 
     */
    Ufo ufo;
    
    
    /**
     * Construct the LaunchFireBall class
     * @param view the view the mouse will be clicked on
     * @param prime the player tat fireball objects will be fired from
     */
    public LaunchFireBall (WorldView view,OptimusPrime prime ) {
        this.view = view;
        this.prime = prime;
       
      
        
      
    }

    /**
     * fireball is projected when mouse is clicked
     * @param e event object containing the mouse event
     
     */
    @Override
    public void mousePressed(MouseEvent e) {
       DynamicBody ball = new FireBall(view.getWorld());
        ball.setPosition(new Vec2 (prime.getPosition().x, prime.getPosition().y + 3));
        ball.setLinearVelocity(new Vec2 (0,20));
        ball.setAngularVelocity(0);
        
       
    }
 
}
