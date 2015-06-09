package com.ashleybye.textgame.director;

import com.ashleybye.textgame.script.Compass;
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
        Scene scene = script.goToScene(0, 0);
        stage.setScene(scene);
    }

    public void loadScene(Compass direction)
    {
        boolean accessible = script.isSceneAccessibleFrom(script.getCurrentX(), script.getCurrentY(), direction);
        if (accessible)
        {
            int x = script.getCurrentX();
            int y = script.getCurrentY();

            switch (direction)
            {
                case NORTH:
                    y += 1;
                    break;
                case EAST:
                    x += 1;
                case SOUTH:
                    y -= 1;
                    break;
                case WEST:
                    x -= 1;
                    break;
            }

            Scene scene = script.goToScene(x, y);
            stage.setScene(scene);
        }
    }
}
