/*
 * TCSS 305 Assignment 3 - Easy Street
 */
package model;

import java.util.Map;

/**
 * This is the car class that extended from the AbstractVehivle class.
 * 
 * @author Ruitao Yu
 * @version October 18 2017
 */
public class Car extends AbstractVehicle {
    
    /** Death time of the vehicle. */
    public static final int MY_TIME = 10;
    
    /**
     * This is the constructor of the car class.
     * 
     * @param theX the x coordinate of the vehicle's location.
     * @param theY the y coordinate of the vehicle's location.
     * @param theDir the current direction of the vehicle.
     */
    public Car(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, MY_TIME);

    }
    
    /**
     * {@inheritDoc}
     * 
     * A car can pass crosswalk with green light,
     * streets and traffic light without red light.
     * 
     * @param theTerrain The terrain the vehicle is facing.
     * @param theLight The current light color.
     * @return whether or not this vehicle is facing a certain terrains and lights. 
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        
        // The car can only pass a green light crosswalk, street or 
        // a green/yellow traffic light
        final boolean pass;
        if ((theTerrain == Terrain.CROSSWALK && theLight == Light.GREEN)
            || theTerrain == Terrain.STREET 
            || (theTerrain == Terrain.LIGHT && theLight != Light.RED)) {
            pass = true;
        } else {
            pass = false;
        }
        return pass;
    }
    
    /**
     * {@inheritDoc}
     * 
     * A Car will randomly choose directions, it will choose go 
     * straight, left then right in order. If none of them is available, it reverses.
     * 
     * @param theNeighbors The map of neighboring terrain.
     * @return the direction this vehicle will move to.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        // If no direction is available,  car turn around
        Direction dir = getDirection().reverse();
        
        // Read every direction is the map
        // choose only crosswalk, light and street
        // prefer straight, then left, then right, otherwise, reverse
        for (final Direction direction : theNeighbors.keySet()) {
            if (theNeighbors.get(direction) == Terrain.CROSSWALK 
                            ||  theNeighbors.get(direction) == Terrain.LIGHT
                            || theNeighbors.get(direction) == Terrain.STREET) {
                if (direction == getDirection()) {
                    dir = getDirection();
                    break;
                } else if (direction == getDirection().left()) {
                    dir = getDirection().left();
                } else if (direction == getDirection().right() 
                                && dir != getDirection().left()) {
                    dir = getDirection().right();
                }
            }
        }
        return dir;
    }
}


