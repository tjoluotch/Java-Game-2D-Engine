/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 * class implements collision listener to see if ufo has been hit
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class UfoHit implements CollisionListener {

    /**
     * enemy trying to kill player
     */
    private Ufo ufo;
    //declaring ufo class
 
    /**
     * computer game
     */
    private Game game;

    /**
     *creates ufo Hit class
     * @param game
     * computer game ufo is in 
     * @param ufo
     * ufo tat is taking the collision
     */
    public UfoHit(Game game,Ufo ufo) {
        this.ufo = ufo;
        this.game = game;
    }

    //anything that comes in contact with the ufo
    //e.g fireball from spaceship is destroyed

    /**
     *if ufo has been hit set ufo damage <br>
     * and destroy other body
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() == ufo && e.getOtherBody() instanceof FireBall) {
            ufo.setUfoDamage();
            e.getOtherBody().destroy();   
        } 
        if (e.getReportingBody() instanceof Boss && e.getOtherBody() instanceof FireBall){
            e.getOtherBody().destroy();
            System.out.println("boss hit");
        }
    }

}
