package com.github.curriculeon.jfoot;

import com.github.git_leon.RandomUtils;

import static com.github.curriculeon.jfoot.Direction.*;

/**
 * Wombat. A Wombat moves forward until it hits the edge of the world, at
 * which point it turns left. If a wombat finds a leaf, it eats it.
 *
 * @author Michael Kölling
 * @version 2.0
 */
public class Wombat extends Herbivore {
    public Wombat() {
        setImage("wombat.png");
    }

    public void act() {
        if (this.foundLeaf()) {
            this.eatLeaf();
        } else if (this.canMove()) {
            this.move();
        } else {
           if(getDirection() == EAST){
               move();
               turnLeft();
               move();
               turnLeft();
           } else if(getDirection() == WEST){
               move();
               turnRight();
               move();
               turnRight();
           } else{
               if(!this.foundLeaf()){
                   move(0);
                   getLeavesEaten();
               }
           }
        }
    }

    public void turnLeft() {
        if (this.getDirection() == EAST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(WEST);
        } else {
            this.setDirection(EAST);
        }
    }
    public void turnRight() {
        if (this.getDirection() == EAST) {
            this.setDirection(SOUTH);
        } else if (this.getDirection() == WEST) {
            this.setDirection(NORTH);
        } else if (this.getDirection() == NORTH) {
            this.setDirection(EAST);
        } else {
            this.setDirection(WEST);
        }
    }
}
