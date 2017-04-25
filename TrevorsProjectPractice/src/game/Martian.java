/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * enemy that is trying to kill the player
 *@author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class Martian extends Walker implements StepListener{

    private int lives;
    
    private int xLeft = -10;
    
    private int xRight = 10;
    
    private int direction = 1;
    
    /**
     *constructor takes world parameter
     * @param w
     * game world user is playing in
     */
    public Martian(World w) {
        super(w);
        
        /**
         * creates shape for martian
         */
         Shape martian = new PolygonShape(0.736f,-0.986f, -0.722f,-0.954f, 
                 -0.717f,0.03f, -0.405f,0.954f, 0.497f,0.954f, 0.726f,0.016f);   
    
         /**
          * creates fixture with martian class and shape parsed into the fixture
          */
    Fixture martianFixture = new SolidFixture(this, martian);
    addImage(new BodyImage("data/martian.gif",3)); 
    
    }
    
    @Override
    public void preStep(StepEvent e){
        if(this.getPosition().x > xRight){
            direction = -8;
        }
        else if(this.getPosition().x < xLeft){
            direction = 6;
        }
        this.setLinearVelocity(new Vec2(direction,0));
    }
    
     @Override
    public void postStep(StepEvent e){
        
    }
  
}
