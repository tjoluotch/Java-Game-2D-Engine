/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import city.cs.engine.*;
/**
 * Ufo class that is against the player
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class Ufo extends Walker {
    
    /**
     * gravity of the ufo
     */
    private static final float gravity = 0;
   //declaring and initialising gravity variable to 0
   
    /**
     * damage to the ufo
     */
    private int ufoDamage;
 //declaring variable tat will be used to inidicste ufo damage 
  // from collisions
   
    /**
     * creates ufo class 
     * @param w
     * game world the ufo is in
     */
    public Ufo(World w) {
        //constructor parsing world through its parameters
        
        super(w);
        
        this.setGravityScale(gravity);
        //setting gravity scale to 0
        //so ufo just floats in set position
        
       
        
       
        Shape ufoHead = new PolygonShape(-0.468f,0.826f, -0.673f,0.489f, 
                           -0.649f,0.273f, -0.102f,
                           0.075f, 0.589f,0.297f, 0.607f,0.616f, 
                             0.252f,0.946f, -0.252f,0.97f);
        
        Fixture ufoHeadFixture = new SolidFixture(this, ufoHead);
        addImage(new BodyImage("data/ufo.png",2));
        
        Shape ufoBody1 = new PolygonShape(
        -0.673f,0.508f, -1.297f,0.303f, -1.886f,-0.117f, -1.658f,-0.369f, 
           -0.691f,-0.688f, 0.775f,-0.676f, 1.568f,-0.435f, 1.886f,-0.201f);
        Fixture ufoBody1Fixture = new SolidFixture(this, ufoBody1);
        
        Shape ufoBody2 = new PolygonShape(
        1.868f,-0.231f, 1.862f,-0.117f, 1.562f,0.177f, 1.231f,0.345f,
                0.901f,0.441f, 0.643f,0.483f, 0.607f,0.477f);
        Fixture ufoBody2Fixture = new SolidFixture(this, ufoBody2);
        
        Shape ufoBottom = new PolygonShape(
        0.541f,-0.706f, 0.42f,-0.844f, 0.228f,-0.946f, 0.036f,-0.982f, 
                -0.192f,-0.982f, -0.414f,-0.904f, 
                -0.571f,-0.808f, -0.661f,-0.688f);
        Fixture ufoBottomFixture = new SolidFixture(this, ufoBottom);
    }  

 //getter to return ufo damage

    /**
     * get damage to ufo
     * @return
     */
    public int getUfoDamage() {
        return ufoDamage;
    }

    //setter thats incremented by 1
    //alos prints message wen collison is registered

    /**
     * increment damage by 1 each time
     * and print message to console
     */
    public void setUfoDamage() {
        ufoDamage++;
        System.out.println("Great hit on the UFO Optimus! = "
                           + ufoDamage);
    }
        
}
