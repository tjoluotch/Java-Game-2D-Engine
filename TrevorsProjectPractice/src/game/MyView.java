/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/** contains everything that is printed or shown in the game outside of the <br>
 * physical objects
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class MyView extends UserView {
    
    /**
     * player tat user controls 
     */
    private OptimusPrime prime;
    //declaring OptimusPrime class
      
    /**
     * the computer game
     */
    private Game game;
      
    /**
     * the background
     */
    private Image background;
      
    /**
     * the string with the current players name
     */
    public static String name = "";
    
    /**
     * constructor creating the my view class
     * @param game
     * computer game
     * @param world
     * the current world the player is in 
     * @param prime
     * the user character 
     * @param width
     * width of view
     * @param height
     * height of the view
     */
    public MyView(Game game,World world, OptimusPrime prime, int width, int height) {
        super(world, width, height);
        this.game = game;
        this.prime = prime;
        this.background = new ImageIcon("data/game-background.jpg").getImage();
        
        
    }
     
    /**
     *create background
     * @param g
     * graphics2D method that calls draw image
     */
    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this);
    }
    
    /**
     *prints emeralds collected, health, level, and name to view
     * @param g
     * calls drawString, set colour and set font
     */
    @Override
    protected void paintForeground(Graphics2D g){
      Font font = new Font("SansSerif",Font.BOLD,18); 
      g.setFont(font);
      g.setColor(Color.GREEN);
      g.drawString(prime.getOutputHealth(),10,20);
      g.drawString(prime.getOutputEmerald(),350,20);
      g.drawString(" level "  + game.getLevel(),50,100);
      g.drawString(name, 200,200);
    }
    
    /**
     *sets a new character different to the one the user was previously <br>
     * using
     * @param prime
     * player that user controls
     */
    public void setPrime(OptimusPrime prime){
     this.prime = prime;
 }   
}