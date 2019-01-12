/*
 * TCSS 305 Assignment 3 - Easy Street
 */
package model;

import java.util.Map;

/**
 * This is the Taxi class that extended from the AbstractVehivle class.
 * 
 * @author Ruitao Yu
 * @version October 18 2017
 */
public class Taxi extends AbstractVehicle {
    
    /** Death time of the vehicle. */
    public static final int MY_TIME = 10;
    
    /** The wait time in front of a crosswalk. */
    public static final int MY_CROSSWALK_COUNT = 3;
    
    /** Count the time stay in front of a crosswalk.*/
    private int myCrosswalkCount;

    /**
     * This is the constructor of the Taxi class.
     * 
     * @param theX the x coordinate of the vehicle's location.
     * @param theY the y coordinate of the vehicle's location.
     * @param theDir the current direction of the vehicle.
     */
    public Taxi(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, MY_TIME);
        myCrosswalkCount = 0;
    }
    
    /**
     * {@inheritDoc}
     * 
     * A taxi can pass crosswalk without red light,
     * streets and traffic light without green light.
     * If it stay in front of a crosswalk light for 3 cycles, it passes.
     * 
     * @param theTerrain The terrain the vehicle is facing.
     * @param theLight The current light color.
     * @return whether or not this vehicle is facing a certain terrains and lights. 
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        final boolean pass;
        
        if (myCrosswalkCount == MY_CROSSWALK_COUNT) {
            // If the car stay in front of a crosswalk for 3 cycle times
            // let it pass
            pass = true;
            myCrosswalkCount = 0;
        } else if ((theTerrain == Terrain.CROSSWALK && theLight != Light.RED)
            || theTerrain == Terrain.STREET 
            || (theTerrain == Terrain.LIGHT && theLight != Light.RED)) {
            
            // Let the Taxi pass if the terrain is crosswalk and light is not red
            // or the street
            // or the LIGHT with green or yellow
            pass = true;
        } else if (theTerrain == Terrain.CROSSWALK && theLight == Light.RED) {
            
            // If the Taxi stay in front of a crosswalk for 1 cycle
            // add 1 to myCOunt and not let it pass
            pass = false;
            myCrosswalkCount++;
        } else {
            
            // can not pass on other terrains
            pass = false;
        }
        return pass;
    }
    
    /**
     * {@inheritDoc}
     * 
     * A Taxi will randomly choose directions, it will choose go 
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
