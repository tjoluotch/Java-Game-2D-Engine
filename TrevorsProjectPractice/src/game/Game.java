package game;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;

/**
 * The computer game.
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;

    /**
     * A graphical display of the world (a specialised JPanel).
     */
    private UserView view;
    
    /**
     * a integer representation of the current level
     */
    public int level;

    /**
     *the controller that the user uses to move the rocket
     */
    private Controller controller;
    
    /**
     *string that will print players name to the user view
     */
    public static String pName = "";
    
    /**
     * start menu that comes up and allows the user to navigate to a new <br>
     * game, leaderboard, rules page
     */
    public static JFrame jf = new JFrame();

    /**
     * displays contents of text file that contains scores and player names <br>
     * 
     */
    public static JFrame scoreSheet = new JFrame();
   

    /**
     * Initialise a new Game.
     * @throws java.io.IOException
     */
    public Game() throws IOException {
        
        

        level = 4;
        world = new Level4();
        

        world.populate(this);
        // make the world

        view = new MyView(this,world, world.getPlayer(), 500, 500);

      

        

        //mouse motion listener added to track mouse 
        //and fire shots in tat direction

        //view.addMouseListener(new MouseTest());
        // make a view
        // uncomment this to draw a 1-metre grid over the view
        //view.setGridResolution(1);

        /**
         * Jframe that displays a graphical view of the world
         */
        final JFrame frame = new JFrame("Event handling");
        
        /**
         * display the buttons used for GUI: pause , resume, quit.
         */
       Container buttons = new ControlPanel(getWorld());
         frame.add(buttons, BorderLayout.SOUTH);
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized      
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);

        view.addMouseListener(new GiveFocus(frame));

       
        
        

        view.addMouseListener(new LaunchFireBall(view,getPlayer()));

 
        /**
         * make a debugging view for the world
         */
        JFrame debugView = new DebugViewer(world, 500, 500);
        
        // start!
        world.start();
    }

    /**
     *method that gets the game world
     * @return
     * game world the user is in
     */
    public World getWorld(){
        return world;
    }
    
    /**
     *method that gets the current level
     * @return
     * current level user is in
     */
    public int getLevel(){
        return level;
    }

    /**
     *method that gets the main player
     * @return
     * main player
     */
    public OptimusPrime getPlayer() {
        return world.getPlayer();
    }
    
    /**
     * method that gets the health of the player
     * @return
     * health of the player from method in world <br>
     * as health variable isn't made in game class
     */
    public Health getHealth(){
        return world.getHealth();
    }
    
    /**
     *method that gets the emeralds of the player
     * @return
     * emeralds of the player from method in world <br>
     * as emerald variable isn't made in game class
     * 
     */
    public Emerald getEmerald(){
        return world.getEmerald();
    }

    /**
     *checks if level is completed, if true advance to next level
     * @return
     * level is completed
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /**
     *enter next level with new worlds. <br>
     * 
     */
    public void goNextLevel() {
        world.stop();
        int lives = world.getPlayer().getHealthCount();
        int emerald = world.getPlayer().getEmeraldCount();
        if (level == 4) {
            
            try {
                
                /**
                 * at the last level the emeralds collected and the health
                 * are written to a text file
                 */
                WriteFile data = new WriteFile("sample.txt",true);
                data.writeToFile(" Emeralds collected " + emerald);
                data.writeToFile(" Health " + lives + System.lineSeparator());
                System.out.println("Text written");
                System.exit(0);
            } catch (IOException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (level == 3){
            level++;
            // get a new world
            world = new Level4();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            
            // show the new world in the view
            view.setWorld(world);
            
            view.addMouseListener(new LaunchFireBall(view,getPlayer()));
            
            world.getPlayer().setEmeraldCount(emerald);
            world.getPlayer().setHealthCount(lives);
            ((MyView)view).setPrime(world.getPlayer()); 

            world.start();
        } 
        else if (level == 2){
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            
            view.addMouseListener(new LaunchFireBall(view,getPlayer()));
            
            world.getPlayer().setEmeraldCount(emerald);
            world.getPlayer().setHealthCount(lives);
            ((MyView)view).setPrime(world.getPlayer()); 

            world.start();
        }
        else  {
        level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
           
            
            view.addMouseListener(new LaunchFireBall(view,getPlayer()));
            
            world.getPlayer().setEmeraldCount(emerald);
            world.getPlayer().setHealthCount(lives);
            ((MyView)view).setPrime(world.getPlayer()); 
            world.start();
          
            view.setWorld(world);
            
           
    }
    }

    /**
     * Run the game.
     * @param args
     */
    public static void main(String[] args) {
        
        /**
         * creates start menu
         */
        StartMenu sm = new StartMenu();
        sm.setVisible(true);
        jf.setSize(500, 400);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.add(sm); 
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
