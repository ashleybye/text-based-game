package com.ashleybye.textgame.stage;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by ashley on 08/06/2015.
 */
public class StageTest
{
    @Test
    public void staticMethodGetStageShouldReturnStageObject()
    {
        Stage stage = Stage.getStage();

        assertNotNull("getStage() method should always return the single instace of stage", stage);
    }
}
