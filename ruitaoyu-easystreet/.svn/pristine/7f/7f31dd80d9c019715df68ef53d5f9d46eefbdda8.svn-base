/*
 * TCSS 305 Assignment 3 - Easy Street
 */
package tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import model.Direction;
import model.Light;
import model.Taxi;
import model.Terrain;
import model.Truck;
import org.junit.Before;
import org.junit.Test;


/**
 * This is the JUnite test for the Truck class.
 * 
 * @author Ruitao Yu
 * @version October 18 2017
 *
 */
public class TruckTest {
    
    /** The number of times to repeat a test for all possibilities. */
    public static final int TRIES_FOR_RANDOMNESS = 50;
    
    // The test fixture. The Objects I will use in this test.
    /**  a truck with x = 1, y = 1, direction = west. */
    private Truck myTruck;

    /**
     * This method is called before every test.
     */
    @Before
    public void setUp() {
        myTruck = new Truck(1, 1, Direction.WEST);
    }
    /**
     * Test method for {@link model.Truck#canPass(model.Terrain, model.Light)}.
     */
    @Test
    public void testCanPass() {
        
        // For each Terrain type and Light color combination
        // If terrain is street or light, return true
        // If terrain is corsswalk and the light is not red, return true
        // Otherwise, return false
        for (final Terrain terrain: Terrain.values()) {
            for (final Light light: Light.values()) {
                if (terrain == Terrain.STREET || terrain == Terrain.LIGHT) {
                    
                    // Trucks can pass on street and light in any condition
                    assertTrue("Truck should be able to pass" + terrain, 
                               myTruck.canPass(terrain, light));
                } else if (terrain == Terrain.CROSSWALK 
                                && light != Light.RED) {
                    
                    // Trucks can pass when the corsswalk is not red
                    assertTrue("Truck should be able to pass" + terrain + " with " 
                               + light, myTruck.canPass(terrain, light));
                } else {
                    assertFalse("Truck should NOT be able to pass" + terrain + " with " 
                                    + light, myTruck.canPass(terrain, light));
                }
            }
        }
        
        
    }

    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirection() {
        
        // Create a map that contain 4 direction with different terrains
        final Map<Direction, Terrain> neighbors = new HashMap<Direction, Terrain>();
        neighbors.put(Direction.EAST, Terrain.CROSSWALK);
        neighbors.put(Direction.NORTH, Terrain.LIGHT);
        neighbors.put(Direction.SOUTH, Terrain.GRASS);
        neighbors.put(Direction.WEST, Terrain.STREET);
        
        // Boolean that needed to check if the return direction is right
        boolean west = false;
        boolean east = false;
        boolean north = false;
        boolean south = false;
        
        // Run 50 times for to have a high probability that all
        // random possibilities have been explored.
        for (int i = 0; i < TRIES_FOR_RANDOMNESS; i++) {
            final Direction  d = myTruck.chooseDirection(neighbors);
            
            // Check each each return direction and make
            // the boolean true, if a direction is never occur,
            // that direction will always be false
            if (d == Direction.WEST) {
                west = true;
            } else if (d == Direction.EAST) {
                east = true;        
            } else if (d == Direction.NORTH) {
                north = true;
            } else if (d == Direction.SOUTH) {
                south = true;
            }
        }
        
        // The west and north is always true since we can go one a street
        // and light with any conditions
        assertTrue("Truck should be able to go east, north and west. ", 
                   west && north);
        
        // Trucks will not go reverse when other direction is available
        // Trucks will not go in a grass
        assertFalse("Truck should NOT be able to go south", south && east);
        
        // Clear the map
        // Make it only has one direction which is grass to force the
        // truck to go reverse
        neighbors.clear();
        neighbors.put(Direction.EAST, Terrain.GRASS);
        assertEquals(myTruck.getDirection().reverse(), myTruck.chooseDirection(neighbors));
        
        
        
    }

    /**
     * Test method for {@link model.Truck#Truck(int, int, model.Direction)}.
     */
    @Test
    public void testTruckConstructor() {
        // Test if the constructor is correctly set the truck to 
        // x = 1, y = 1, direction = west, death time = 0 and is alive.
        assertEquals("Truck x coordinate not initialized correctly!", 1, myTruck.getX());
        assertEquals("Truck y coordinate not initialized correctly!", 1, myTruck.getY());
        assertEquals("Truck direction not initialized correctly!", 
                     Direction.WEST, myTruck.getDirection());
        assertEquals("Truck death time not initialized correctly!", 0, myTruck.getDeathTime());
        assertEquals("Truck isAlive() falis initially", true, myTruck.isAlive());
        
    }
    
    /** Test method for Truck setters.*/
    @Test
    public void testTruckSetters() {
        
        // Test if the setters are correctly set the truck to 
        // x = 5, y = 10, direction = north.
        myTruck.setX(5);
        assertEquals("Truck setX failed!", 5, myTruck.getX());
        myTruck.setY(10);
        assertEquals("Truck setY failed!", 10, myTruck.getY());
        myTruck.setDirection(Direction.NORTH);
        assertEquals("Truck set direction failed!", 
                     Direction.NORTH, myTruck.getDirection());
        
    }
    
    /**
     * Test method for truck collide.
     */
    @Test
    public void testTruckColide() {
        // the truck will always alive from any collision.
        final Truck otherTruck = new Truck(1, 1, Direction.WEST);
        final Taxi otherTaxi = new Taxi(1, 1, Direction.WEST);
        myTruck.collide(otherTruck);
        assertTrue(myTruck.isAlive());
        myTruck.collide(otherTaxi);
        assertTrue(myTruck.isAlive());
    }
    
    /**
     * Test the getters of Truck.
     */
    @Test
    public void testTruckGetters() {
        
        // Test if the getters are correctly set the truck to 
        // x = 1, y = 1, direction = west.
        assertEquals("Truck getX failed!", 1, myTruck.getX());
        assertEquals("Truck getY failed!", 1, myTruck.getY());
        assertEquals("Truck get direction failed!", 
                     Direction.WEST, myTruck.getDirection());
    }
    
    /**
     *  Test method for Truck reset.
     */
    @Test
    public void testTruckReset() {
        myTruck = new Truck(10, 10, Direction.EAST);

        // Test if the reset are correctly set the truck to 
        // x = 1, y = 1, direction = west.
        myTruck.reset();
        assertEquals("Truck reset X failed!", 10, myTruck.getX());
        assertEquals("Truck reset Y failed!", 10, myTruck.getY());
        assertEquals("Truck reset direction failed!", 
                     Direction.EAST, myTruck.getDirection());
    }
    
    /**
     * Test method for Truck toString.
     */
    @Test
    public void testTruckToString() {
        // the toString in should return Truck (1, 1).
        assertEquals("Truck toString failed", "Truck (1, 1) ", myTruck.toString());
    }
    
    /**
     * Test method for Truck poke.
     */
    @Test
    public void testTruckPoke() {
        // poke should never be initialized since truck will never die.
        myTruck.poke();
        assertTrue("Truck poke should never change alive!", myTruck.isAlive());
    }
    
    /**
     * Test method for Truck getImageFileName.
     */
    @Test
    public void testTruckGetFileName() {
        // since the truck will never die
        // only the alive branch is test
        // in order to test the dead branch
        // we need to test other vehicles
        assertEquals("Truck get alive file name is not correct!",
                     "truck.gif", myTruck.getImageFileName());
    }
    
}
