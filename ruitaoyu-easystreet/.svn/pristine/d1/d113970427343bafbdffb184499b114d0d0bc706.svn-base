/*
 * TCSS 305 - Easy Street
 */
package model;

import java.util.Map;

/**
 * This is the parent class of the the vehicles including the human class.
 * 
 * @author Ruitao Yu
 * @version October 18 1027
 */
public abstract class AbstractVehicle implements Vehicle {
    
    /** The current x coordinate of the vehicle. */
    private int myX;
    
    /** The current y coordinate of the vehicle.*/
    private int myY;
    
    /** The poke number of the vehicle.*/
    private int myPoke;
    
    /** The default x coordinate of the vehicle.*/
    private final int myDefaultX;
    
    /** The default y coordinate of the vehicle.*/
    private final int myDefaultY;
    
    /** The default direction of the vehicle.*/
    private final Direction myDefaultDir;
    
    /** The current direction of the vehicle.*/
    private Direction myDir;
    
    /** The death time of the vehicle. */
    private final int myDeathTime;
    
    /** show if the vehicle or human is dead or not.*/
    private boolean myAlive;
    
    /**
     * 
     * @param theX the x coordinate of the human's location.
     * @param theY the y coordinate of the human's location.
     * @param theDir the current direction of the human.
     * @param theDeathTime the death time when collide with other vehicles.
     */
    protected AbstractVehicle(final int theX, final int theY, final Direction theDir,
            final int theDeathTime) {
        // set the x, y and, direction and make a copy of them as default
        // set the death time and make this vehicle alive
        myX = theX;
        myY = theY;
        myDefaultX = theX;
        myDefaultY = theY;
        myDefaultDir = theDir;
        myDir = theDir;
        myDeathTime = theDeathTime;
        myAlive = true;
    }
    
    /**
    * {@inheritDoc}
    * 
    * This is the canPass method that inherit from the Vehicle Interface that
    * check whether the terrain of the vehicle facing is movable or not.
    * 
    * @param theTerrain The terrain the vehicle is facing.
    * @param theLight The current light color.
    * @return whether or not this vehicle is facing a certain terrains and lights. 
    */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return true;
    }

    /**
     * {@inheritDoc}
     * 
     * This is the chooseDrection method that inherit from the Vehicle Interface,
     * it decide what direction the vehicle will go next.
     * 
     * @param theNeighbors The map of neighboring terrain.
     * @return the direction this vehicle will move to.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        return Direction.random();
    }
    
    /**
     * {@inheritDoc}
     * 
     * This is the collide method that inherit from the Vehicle Interface,
     * it decide If this vehicle can  or not in this accident.
     * 
     * @param theOther the other vehicle in this accident.
     */
    @Override
    public void collide(final Vehicle theOther) {
        // when the other vehicle's death time is less than this vehicle's death time
        // give the death time value to poke and change the alive status to false
        if (isAlive() && theOther.isAlive() 
                        && myDeathTime > theOther.getDeathTime()) {
            myPoke = myDeathTime;
            myAlive = false;
        }
    }

    /**
     * {@inheritDoc}
     * 
     * This is the getDeathTime method that inherit from the Vehicle Interface,
     * it returns the death time of this vehicle.
     * 
     */
    @Override
    public final int getDeathTime() {
        return myDeathTime;
    }

    /**
     * {@inheritDoc}
     * 
     * This is the getImageFileName method that inherit from the Vehicle Interface,
     * it returns the alive and death file name of this vehicle.
     */
    @Override
    public final String getImageFileName() {
        final String name;
        if (isAlive()) {
            
            // If alive, return the alive file name
            name = getClass().getSimpleName().toLowerCase()  + ".gif";
        } else {
            
         // If NOT alive, return the dead file name
            name = getClass().getSimpleName().toLowerCase()  + "_dead.gif";
        }
        return name;
    }

    /**
     * {@inheritDoc}
     * 
     * This is the getDirection method that inherit from the Vehicle Interface,
     * it returns the current direction of this vehicle.
     */
    @Override
    public final Direction getDirection() {
        return myDir;
    }

    /**
     * {@inheritDoc}
     * 
     * This is the getX method that inherit from the Vehicle Interface,
     * it returns the current x coordinate of this vehicle.
     */
    @Override
    public final int getX() {
        return myX;
    }

    /**
     * {@inheritDoc}
     * 
     * This is the getY method that inherit from the Vehicle Interface,
     * it returns the current y coordinate of this vehicle.
     */
    @Override
    public final int getY() {
        return myY;
    }

    /**
     * {@inheritDoc}
     * 
     * This is the isAlive method that inherit from the Vehicle Interface,
     * it returns a boolean shows whether or not the vehicle is alive.
     */
    @Override
    public final boolean isAlive() {
        return myAlive;
    }

    /**
     * {@inheritDoc}
     * 
     * This is the poke method that inherit from the Vehicle Interface,
     * it returns the current poke number of the vehicle.
     */
    @Override
    public final void poke() {
        // very time poke is call, subtract 1 from poke
        // when poke is 0, revive the vehicle and make it go random direction
        myPoke--;
        if (myPoke == 0) {
            myAlive = true;
            myDir = Direction.random();
        }
    }

    /**
     * {@inheritDoc}
     * 
     * This is the reset method that inherit from the Vehicle Interface,
     * it resets the x, y and direction for this vehicle.
     */
    @Override
    public final void reset() {
        myX = myDefaultX;
        myY = myDefaultY;
        myDir = myDefaultDir;
    }

    /**
     * {@inheritDoc}
     * 
     * This is the setDirection method that inherit from the Vehicle Interface,
     * it set the direction to the given value.
     * 
     * @param theDir the new direction.
     */
    @Override
    public final void setDirection(final Direction theDir) {
        myDir = theDir;
    }

    /**
     * {@inheritDoc}
     * 
     * This is the setX method that inherit from the Vehicle Interface,
     * it set the x coordinate to the given value.
     * 
     * @param theX the new x.
     */
    @Override
    public final void setX(final int theX) {
        myX = theX;
    }

    /**
     * {@inheritDoc}
     * 
     * This is the setY method that inherit from the Vehicle Interface,
     * it set the x coordinate to the given value.
     * 
     * @param theY the new y.
     */
    @Override
    public final void setY(final int theY) {
        myY = theY;
    }
    
    /**
     * {@inheritDoc}
     * 
     * This is the toString method that inherit from the Object class,
     * it returns a string the represent this vehicle.
     * in this format "Truck (10, 10)".
     */
    @Override
    public String toString() {
        // Create a String builder as return String.
        final StringBuilder builder = new StringBuilder(128);
        builder.append(getClass().getSimpleName());
        builder.append(" (");
        builder.append(myX);
        builder.append(", ");
        builder.append(myY);
        builder.append(") ");
        
        return builder.toString();
    }

}
