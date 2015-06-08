package com.ashleybye.textgame.director;

import com.ashleybye.textgame.script.Scene;
import com.ashleybye.textgame.script.Script;
import com.ashleybye.textgame.stage.Stage;

/**
 * Created by ashley on 08/06/2015.
 */
public class Director
{
    // only one Director object should ever be returned during gameplay
    private static Director director;
    private Script script;
    private Stage stage;

    private Director(Script script, Stage stage)
    {
        this.script = script;
        this.stage = stage;
    }

    public static final Director getDirector(Script script, Stage stage)
    {
        if (director == null)
        {
            director = new Director(script, stage);
        }
        return director;
    }

    public void begin()
    {
        Scene scene = script.getScene(Script.DEFAULT_X_POSITION, Script.DEFAULT_Y_POSITION);
        stage.setScene(scene);
    }
}
