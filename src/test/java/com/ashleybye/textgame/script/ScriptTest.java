package com.ashleybye.textgame.script;

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
public class ScriptTest
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
        Script script = new Script(x, y);

        int xLength = script.getAllScenes().length;
        int yLength = script.getAllScenes()[0].length;

        assertNotNull("list of scenes should not be null", script.getAllScenes());
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
        Script script = new Script(x, y);
    }

    @Test
    public void scenesAreAbleToBeAddedToValidGridPlacements()
    {
        Scene scene = Mockito.mock(Scene.class);
        Script script = new Script(1, 1);

        script.addScene(scene, 0, 0);

        assertTrue("scene should be added to the specified grid location",
                script.getAllScenes()[0][0] instanceof Scene);
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
        Scene scene = Mockito.mock(Scene.class);
        Script script = new Script(size, size);

        script.addScene(scene, x, y);
    }

    @Test
    public void shouldBeAbleToGetSceneAtSpecifiedGrid()
    {
        Scene scene = Mockito.mock(Scene.class);
        Script script = new Script(1, 1);
        script.addScene(scene, 0, 0);

        Scene returnedScene = script.getScene(0, 0);

        assertEquals("getScene should return a scene", scene, returnedScene);
    }
}
