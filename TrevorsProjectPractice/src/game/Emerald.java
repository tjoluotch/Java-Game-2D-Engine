/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import city.cs.engine.*;
/**
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk <br>
 * @version 3.0 <br>
 * @since version 1.0 <br>
 * Emerald class to represent emerald the walker <br>
 * is aiming to pick up in game and save the galaxy
 */
public class Emerald extends DynamicBody {
    
    /**
     *
     * @param world
     * is an object of type World and is getting parsed in super constructor <br>
     * This will construct the actual emerald object 
     */
    public Emerald(World world) {
        //parse world through constructor
        super(world);
        
        /**
         * Shape object emerald shape1 makes new polygonShape with <br>
         * values gotten from polygon editor. this object is then <br>
         * parsed through the Fixture object 
         */
         Shape EmeraldShape1 = new PolygonShape(
            -1.08f,0.88f, -0.78f,1.17f, 0.72f,1.16f, 1.0f,0.89f, 1.01f,-0.6f);
         //initialiises EmeraldShape1
         
Fixture EmeraldShape1Fixture = new SolidFixture(this,EmeraldShape1);
         //initialiises EmeraldShape1Fixture
         
    
  
     
     Shape EmeraldShape2 = new PolygonShape(
     1.0f,-0.64f, 0.71f,-0.92f, -0.78f,-0.93f, -1.08f,-0.63f, -1.08f,0.85f);
     //initialiises EmeraldShape2
     
     Fixture EmeraldShape2Fixture = new SolidFixture(this,EmeraldShape2);
      //initialiises EmeraldShape2Fixture
     
      /**
       * add Image creates the image that the emerald will <br>
       * use along with the size
       */
        addImage(new BodyImage("data/emerald.gif",1)); 
             //creates the image of emerald
    }
    
    

}
