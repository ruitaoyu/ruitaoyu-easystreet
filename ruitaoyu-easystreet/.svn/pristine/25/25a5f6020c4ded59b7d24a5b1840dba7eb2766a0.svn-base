/*
 * TCSS 305 Assignment 3 - Easy Street
 */
package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * This is the Atv class that extended from the AbstractVehivle class.
 * 
 * @author Ruitao Yu
 * @version October 18 2017
 */
public class Atv extends AbstractVehicle {
    
    /** Death time of the vehicle. */
    public static final int MY_TIME = 20;

    /**
     * This is the constructor of the Taxi class.
     * 
     * @param theX the x coordinate of the vehicle's location.
     * @param theY the y coordinate of the vehicle's location.
     * @param theDir the current direction of the vehicle.
     */
    public Atv(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, MY_TIME);
    }

    /**
     * {@inheritDoc}
     * 
     * A Atv can pass anything but walls, it will randomly 
     * choose any direction but it never reverse.
     * 
     * @param theTerrain The terrain the vehicle is facing.
     * @param theLight The current light color.
     * @return whether or not this vehicle is facing a certain terrains and lights. 
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        final boolean pass;
        // Check if it is a wall, if not, pass
        if (theTerrain != Terrain.WALL) {
            pass = true;
        } else {
            pass = false;
        }
        return pass;
    }
    
    /**
     * {@inheritDoc}
     * 
     * A Atv will randomly choose directions.
     * 
     * @param theNeighbors The map of neighboring terrain.
     * @return the direction this vehicle will move to.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        // the direction of next moving
        final Direction dir;
        
        // The possible directions
        final ArrayList<Direction> list = new ArrayList<Direction>();
        
        // Check every terrain in the map.
        // If it is NOT a WALL and not reverse direction, add to the list
        for (final Direction direction : theNeighbors.keySet()) {
            if (theNeighbors.get(direction) != Terrain.WALL
                            && direction != getDirection().reverse()) {
                list.add(direction);
            }
        }
        
        // Randomly get a direction from the list
        final Random rand = new Random();
        final int num = rand.nextInt(list.size());
        dir = list.get(num);
        
        return dir;
    }
}
