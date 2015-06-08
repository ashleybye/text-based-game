package com.ashleybye.textgame.director;

import com.ashleybye.textgame.script.Scene;
import com.ashleybye.textgame.script.Script;
import com.ashleybye.textgame.stage.Stage;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ashley on 08/06/2015.
 */
public class DirectorTest
{
    @Test
    public void shouldBeAQuasiSingleton()
    {
        Script script = Mockito.mock(Script.class);
        Stage stage = Mockito.mock(Stage.class);

        Director director = Director.getDirector(script, stage);

        assertNotNull("director cannot be null", director);
    }

    @Test
    public void beginMethodShouldSetASceneOnTheStage()
    {
        Script script = Mockito.mock(Script.class);
        Stage stage = Mockito.mock(Stage.class);
        Scene scene = Mockito.mock(Scene.class);

        when(script.getScene(0, 0)).thenReturn(scene);
        when(stage.getScene()).thenReturn(scene);

        Director director = Director.getDirector(script, stage);
        director.begin();

        assertEquals("begin() method should set a scene on the stage but none was set", scene, stage.getScene());

        verify(script).getScene(0, 0);
        verify(stage).setScene(scene);
    }
}
