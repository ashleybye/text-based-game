package com.ashleybye.textgame.world;

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
public class LocationTest
{
    @Test
    public void constructorCorrectlyInitialisesSceneWithDefaultDescription()
    {
        Location location = new Location(0, 0);

        assertNotNull("constructor should set a description of what is going on in the location",
                location.getDescription());
    }

    @Test
    public void constructorCorrectlyInitialisesSceneWithEmptyListOfActors()
    {
        Location location = new Location(0, 0);

        assertEquals("constructor should set a the list of actors to an empty list, expected 0, got "
                + location.getActors().size(), 0, location.getActors().size());
    }

    @Test
    public void sceneCanHaveMoreThanOneActor()
    {
        List<Actor> actors = new ArrayList<>();
        actors.add(new Enemy());
        actors.add(new Friend());

        Location location = new Location(0 ,0);
        location.setActors(actors);

        assertEquals("does not return the correct number of actors: got " + location.getActors().size()
                    + ", expected " + actors.size(), actors.size(), location.getActors().size());
    }
}
