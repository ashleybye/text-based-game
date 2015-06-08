package com.ashleybye.textgame.stage;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ashley on 08/06/2015.
 */
public class SceneTest
{
    @Test
    public void constructorCorrectlyInitialisesSceneWithDescription()
    {
        String description = "Bright lights!";
        Scene scene = new Scene(description);

        assertEquals("constructor should set a description of what is going on in the scene",
                description, scene.getDescription());
        assertNull("constructor should set actor to null if none is supplied", scene.getActor());
    }

    @Test
    public void constructorCorrectlyInitialisesSceneWithDescriptionAndActor()
    {
        Actor actor = Mockito.mock(Enemy.class);
        when(actor.getName()).thenReturn("Biggles");
        String description = "In a dark, dreary forrest";

        Scene scene = new Scene(description, actor);

        assertEquals("constructor should set a description of what is going on in the scene",
                description, scene.getDescription());
        assertEquals("constructor should set an actor if one is specified",
                "Biggles", scene.getActor().getName());
        verify(actor).getName();
    }
}
