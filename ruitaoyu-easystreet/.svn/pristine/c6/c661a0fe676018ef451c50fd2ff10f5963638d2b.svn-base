/*
 * TCSS 305 Assignment 3 - Easy Street
 */
package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * This is the Human class that extended from the AbstractVehivle class.
 * 
 * @author Ruitao Yu
 * @version October 18 2017
 */
public class Human extends AbstractVehicle {
    
    /** Death time of the truck. */
    public static final int MY_TIME = 50;
    
    /**
     * This is the constructor of the Human class.
     * 
     * @param theX the x coordinate of the human's location.
     * @param theY the y coordinate of the human's location.
     * @param theDir the current direction of the human.
     */
    public Human(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, MY_TIME);
    }
    
    /**
     * {@inheritDoc}
     * 
     * A Human will only walk on grass or crosswalk with red and yellow light.
     * 
     * @param theTerrain The terrain the human is facing.
     * @param theLight The current light color.
     * @return whether or not this human is facing a certain terrains . 
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        final boolean pass;
        
        // If the terrain is cross walk with red and yellow light or grass,
        // human will pass
        if ((theTerrain == Terrain.CROSSWALK && theLight != Light.GREEN)
                        || theTerrain == Terrain.GRASS) {
            pass = true;
        } else {
            pass = false;
        }
        return pass;
    }
    
    /**
     * {@inheritDoc}
     * 
     * A human will randomly choose direction in grass, but prefer to 
     * get on a crosswalk if there is one near him/her.
     * 
     * @param theNeighbors The map of neighboring terrain.
     * @return the direction this human will move to.
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        // the result direction and the possible direction list
        Direction dir;
        final ArrayList<Direction> list = new ArrayList<Direction>();
        
        // for each terrain in the map
        for (final Direction direction : theNeighbors.keySet()) {
            
            // If the terrain is cross walk and it is not on the back side
            // return that direction
            if (theNeighbors.get(direction) == Terrain.CROSSWALK 
                            && direction != getDirection().reverse()) {
                dir = direction;
                return dir;
            } else if (theNeighbors.get(direction) == Terrain.GRASS 
                            && direction != getDirection().reverse()) {
                
                // If the terrain is grass, add to the list
                list.add(direction);
            }
        }
        
        // If the list is empty, reverse the direction
        // otherwise, randomly select a direction from the list.
        if (list.isEmpty()) {
            dir = getDirection().reverse();
        } else {
            final Random rand = new Random();
            final int num = rand.nextInt(list.size());
            dir = list.get(num);
        }
        return dir;
    }
}
