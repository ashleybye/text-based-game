package com.ashleybye.textgame.script;

import com.ashleybye.textgame.script.Scene;
import com.ashleybye.textgame.stage.Actor;
import com.ashleybye.textgame.stage.Enemy;
import com.ashleybye.textgame.stage.Friend;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ashley on 08/06/2015.
 */
public class SceneTest
{
    private static final String SCENE_DESCRIPTION = "It's a dark, dark night...";

    @Test
    public void constructorCorrectlyInitialisesSceneWithDescription()
    {
        Scene scene = new Scene(SCENE_DESCRIPTION);

        assertEquals("constructor should set a description of what is going on in the scene",
                SCENE_DESCRIPTION, scene.getDescription());
    }

    @Test
    public void constructorCorrectlyInitialisesSceneWithEmptyListOfActors()
    {
        Scene scene = new Scene(SCENE_DESCRIPTION);

        assertEquals("constructor should set a the list of actors to an empty list, expected 0, got "
                + scene.getActors().size(), 0, scene.getActors().size());
    }

    @Test
    public void sceneCanHaveMoreThanOneActor()
    {
        List<Actor> actors = new ArrayList<>();
        actors.add(new Enemy());
        actors.add(new Friend());

        Scene scene = new Scene(SCENE_DESCRIPTION);
        scene.setActors(actors);

        assertEquals("does not return the correct number of actors: got " + scene.getActors().size()
                    + ", expected " + actors.size(), actors.size(), scene.getActors().size());
    }
}
