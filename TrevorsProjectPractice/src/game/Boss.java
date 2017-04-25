/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * This class creates a boss character who is the final <br>
 * enemy the game player shall face once level 4 is reached.
 * 
 * @author Trevor, Oluotch, Trevor.Oluotch@city.ac.uk <br>
 * @version 3.0<br>
 * @since version 1.0<br>
 */
public class Boss extends Walker implements StepListener{
       private int lives;
    
    private int xLeft = -10;
    
    private int xRight = 10;
    
    private int direction = 1;
    
    /**
     *constructor takes world parameter
     * @param w
     * game world user is playing in
     */
    public Boss(World w) {
        super(w);
        
        /**
         * creates shape for martian
         */
         Shape bossShape = new PolygonShape(-0.028f,0.956f, 1.189f,0.761f, 
                 1.133f,-0.861f, -0.883f,-0.878f, -1.244f,0.628f, -0.622f,0.878f);   
    
         /**
          * creates fixture with martian class and shape parsed into the fixture
          */
    Fixture martianFixture = new SolidFixture(this, bossShape);
    addImage(new BodyImage("data/boss.png",3)); 
    
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
    

