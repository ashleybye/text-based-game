package com.ashleybye.textgame.navigator;

import com.ashleybye.textgame.world.Location;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by ashley on 08/06/2015.
 */
@RunWith(JUnitParamsRunner.class)
public class MapTest
{
    private final Object[] validSceneGrids()
    {
        return new Object[] {
                new Object[] { 1, 1 },
                new Object[] { 6, 3 },
                new Object[] { 1, 20 },
                new Object[] { 20, 1 },
                new Object[] { 20, 20 }
        };
    }

    @Test
    @Parameters(method = "validSceneGrids")
    public void shouldStoreScenesInGridWithDimensionsSpecifiedAtConstruction(int x, int y)
    {
        Map map = new Map(x, y);

        int xLength = map.getAllLocations().length;
        int yLength = map.getAllLocations()[0].length;

        assertNotNull("list of scenes should not be null", map.getAllLocations());
        assertEquals("list of scenes should be in a grid " + x + "x" + y + " but got  "
                + xLength + "x" + yLength,
                (x + y), (xLength + yLength));
    }

    private final Object[] invalidSceneGrids()
    {
        return new Object[] {
                new Object[] { 0, 0 },
                new Object[] { 1, 0 },
                new Object[] { 0, 1 },
                new Object[] { -1, 0 },
                new Object[] { 0, -1 },
                new Object[] { -1, -1 }
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "invalidSceneGrids")
    public void shouldThrowIllegalArgumentExceptionWithInvalidSceneGridDimensions(int x, int y)
    {
        Map map = new Map(x, y);
    }

    @Test
    public void scenesAreAbleToBeAddedToValidGridPlacements()
    {
        Location location = Mockito.mock(Location.class);
        Map map = new Map(1, 1);

        map.addLocation(location, 0, 0);

        assertTrue("location should be added to the specified grid location",
                map.getAllLocations()[0][0] instanceof Location);
    }

    private final Object[] outOfBoundsPositions()
    {
        return new Object[] {
                new Object[] { 1, -1, 0 },
                new Object[] { 1, 0, -1 },
                new Object[] { 1, -1, -1 },
                new Object[] { 1, 0, 1 },
                new Object[] { 1, 1, 0 },
                new Object[] { 1, 1, 1 }
        };
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @Parameters(method = "outOfBoundsPositions")
    public void addingSceneOustideOfSceneGridShouldThrowIndexOutOfBoundsException(int size, int x, int y)
    {
        Location location = Mockito.mock(Location.class);
        Map map = new Map(size, size);

        map.addLocation(location, x, y);
    }

    @Test
    public void shouldBeAbleToGetSceneAtSpecifiedGrid()
    {
        Location location = Mockito.mock(Location.class);
        Map map = new Map(1, 1);
        map.addLocation(location, 0, 0);

        Location returnedLocation = map.loadLoaction(0, 0);

        assertEquals("getCurrentLocation should return a location", location, returnedLocation);
    }

    private final Object[] accessScenes()
    {
        return new Object[] {
                new Object[] { Compass.NORTH },
                new Object[] { Compass.EAST },
                new Object[] { Compass.SOUTH },
                new Object[] { Compass.WEST }
        };
    }

    @Test
    @Parameters(method = "accessScenes")
    public void isSceneAccessibleFromShouldReturnTrueWhenSceneAdjacent(Compass direction)
    {
        Map map = new Map(3, 3);

        boolean accessible = map.isLocationAccessibleFrom(1, 1, direction);

        assertTrue("from centre of 3x3 scene grid to " + direction.name() + " should be accessible but isn't",
                accessible);
    }

    @Test
    @Parameters(method = "accessScenes")
    public void isSceneAccessibleFromShouldReturnFalseWhenNoScenesAdjacent(Compass direction)
    {
        Map map = new Map(1, 1);

        boolean accessible = map.isLocationAccessibleFrom(0, 0, direction);

        assertFalse("from center of a 1x1 scene grid to " + direction.name() + " should not be accessible but is",
                accessible);
    }

    @Test
    public void scenesWithBarrierInBetweenShouldNotBeAccessible()
    {
        Map map = new Map(3, 3);
        map.addBarrier(1.0F, 1.5F);

        boolean accessible = map.isLocationAccessibleFrom(1, 1, Compass.NORTH);

        assertFalse("should not be able to access a scene if there is a barrier in the way", accessible);
    }
}
