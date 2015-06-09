package com.ashleybye.textgame.world;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by ashley on 08/06/2015.
 */
public class WorldTest
{
    @Test
    public void staticMethodGetStageShouldReturnStageObject()
    {
        World world = World.getWorld();

        assertNotNull("getWorld() method should always return the single instace of world", world);
    }
}
