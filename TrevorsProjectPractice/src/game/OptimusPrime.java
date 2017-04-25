/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import city.cs.engine.*;
/**
 *Walker class for game player controlled <br>
 * through left and right arrows and J button<br>
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class OptimusPrime extends Walker {
    
    /**
     * healthCount int variable
     * this represents the amount of Lives<br>
     * a player has
     */
    private int healthCount;
   
     
    /**
     * emeraldCount int variable being initialised <br>
     * this represents the amount of emeralds a player <br>
     * as collected
     */
    private int emeraldCount;

     
    /**
     *This represents a String variable that will be used <br>
     * to output health
     */
    private String outputHealth;

    /**
     * string used to output emerald count
     */
    private String outputEmerald;
     
    /**
     *constructor creating Optimus prime class
     * @param world
     * game world the user is playing in
     */
    public OptimusPrime(World world){
         // constructor with world parsed in
         
         super(world);
         
         /*
         * Creating player outline from multiple
         *convex shapes
         *Also adding image and setting size of it
         */
    Shape RocketBody = new PolygonShape(
 -0.36f,-1.02f, -0.58f,-0.35f, -0.59f,0.51f, -0.38f,1.09f, -0.01f,1.47f, 0.37f,1.07f, 0.62f,0.3f);    
    Fixture RocketBodyFixture = new SolidFixture(this,RocketBody);
                 
                 

          
        Shape RocketBody2 = new PolygonShape(
      -0.35f,-1.01f, 0.36f,-1.02f, 0.5f,-0.67f, 0.62f,0.07f, 0.59f,0.59f, 0.38f,1.04f, 0.07f,1.46f);
          Fixture RocketBody2Fixture = new SolidFixture(this,RocketBody2);
          
        Shape RocketBody3 = new PolygonShape(
   0.06f,-1.03f, -0.06f,-1.04f, -0.05f,-1.48f, 0.04f,-1.47f, 0.06f,-1.13f);
           Fixture RocketBody3Fixture = new SolidFixture(this,RocketBody3);
           
      addImage(new BodyImage("data/rocket.gif",3));
         
         healthCount = 0;
         //initialses healthcount to 0
         
         emeraldCount = 0 ;
         //initialises health count to 0
         
         outputHealth = "Lives:" + healthCount;
         outputEmerald = "Emeralds:" + emeraldCount;
     }

     

    /**
     * getter to return health
     * @return
     * health count of player
     */
    public int getHealthCount() {
        return healthCount;
    }

    //getter to return emerald count

    /**
     *getter to return emerald
     * @return
     * emerald count of player
     */
    public int getEmeraldCount() {
        return emeraldCount;
    }
    
  
    //setter to add health count value by 1
    //and print message with health count value
    //used in collision

    /**
     *setter to add health count value by 1 each time, <br>
     *and print message with health count value used in collision
     */
    public void incrementHealthCount() {
       healthCount++;
       outputHealth ="Lives:" + healthCount; 
        System.out.println("Great! more health to keep fighting = " 
                           + healthCount);
    }
    
    /**
     * setter to add emerald count value by 1 each time, <br>
     *and print message with emerald count value used in collision
     */
    public void incrementEmeraldCount() {
       emeraldCount++;
       outputEmerald ="Emerald:" + emeraldCount; 
        System.out.println("Great! more emeralds to keep fighting = " 
                           + emeraldCount);
    }

    /**
     * sets health count to a new health count integer
     * @param healthCount
     * player health
     */
    public void setHealthCount(int healthCount) {
        this.healthCount = healthCount;
    }

    /**
     *sets emerald count to a new health count integer
     * 
     * @param emeraldCount
     * player's emeralds
     */
    public void setEmeraldCount(int emeraldCount) {
        this.emeraldCount = emeraldCount;
    }

  

    /**
     *used to print to foreground as gui
     * @return
     * string name and health count
     */
    public String getOutputHealth(){
        return outputHealth;
    }

    /**
     *used to print emeralds to foreground as gui
     * @return
     * string emerald and emerald count printed to foreground
     */
    public String getOutputEmerald() {
        return outputEmerald;
    }  
}
