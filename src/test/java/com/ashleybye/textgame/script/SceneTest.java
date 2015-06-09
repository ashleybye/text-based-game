package com.ashleybye.textgame.script;

import com.ashleybye.textgame.actors.Actor;
import com.ashleybye.textgame.actors.Enemy;
import com.ashleybye.textgame.actors.Friend;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ashley on 08/06/2015.
 */
public class SceneTest
{
    @Test
    public void constructorCorrectlyInitialisesSceneWithDefaultDescription()
    {
        Scene scene = new Scene(0, 0);

        assertNotNull("constructor should set a description of what is going on in the scene",
                scene.getDescription());
    }

    @Test
    public void constructorCorrectlyInitialisesSceneWithEmptyListOfActors()
    {
        Scene scene = new Scene(0, 0);

        assertEquals("constructor should set a the list of actors to an empty list, expected 0, got "
                + scene.getActors().size(), 0, scene.getActors().size());
    }

    @Test
    public void sceneCanHaveMoreThanOneActor()
    {
        List<Actor> actors = new ArrayList<>();
        actors.add(new Enemy());
        actors.add(new Friend());

        Scene scene = new Scene(0 ,0);
        scene.setActors(actors);

        assertEquals("does not return the correct number of actors: got " + scene.getActors().size()
                    + ", expected " + actors.size(), actors.size(), scene.getActors().size());
    }
}
