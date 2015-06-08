package com.ashleybye.textgame.stage;

import com.ashleybye.textgame.script.Scene;

/**
 * Created by ashley on 08/06/2015.
 */
public class Stage
{
    // not final, it needs to be set back to null once no longer required
    private static Stage stage;
    private Scene currentScene;

    private Stage()
    {
    }

    public static final Stage getStage()
    {
        if (stage == null)
        {
            stage = new Stage();
        }
        return stage;
    }

    public Scene getScene()
    {
        return currentScene;
    }

    public void setScene(Scene scene)
    {
        this.currentScene = scene;
    }
}
