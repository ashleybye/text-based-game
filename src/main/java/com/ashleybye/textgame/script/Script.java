package com.ashleybye.textgame.script;

/**
 * Created by ashley on 08/06/2015.
 */
public class Script
{
    public static final int DEFAULT_X_POSITION = 0;
    public static final int DEFAULT_Y_POSITION = 0;

    private int xAxisLength;
    private int yAxisLength;
    private Scene[][] scenes;
    
    public Script(int xLength, int yLength) throws IllegalArgumentException
    {
        if ((xLength <= 0) || yLength <= 0)
        {
            throw new IllegalArgumentException("scene grid must have minimum dimensions of 1x1");
        }
        this.scenes = new Scene[xLength][yLength];
        this.xAxisLength = xLength;
        this.yAxisLength = yLength;
    }

    public Scene[][] getAllScenes()
    {
        return scenes;
    }

    public void addScene(Scene scene, int xPosition, int yPosition) throws IndexOutOfBoundsException
    {
        if ((xPosition < 0) || (xPosition >= xAxisLength) || (yPosition < 0)
                || (yPosition >= yAxisLength))
        {
            throw new IndexOutOfBoundsException("a scene cannot be placed outside of the scene grid; grid is "
                        + xAxisLength + "x" + yAxisLength + ", attempted to place scene at position ("
                        + xPosition + ", " + yPosition + ")");
        }
        scenes[xPosition][yPosition] = scene;
    }

    public Scene getScene(int xPosition, int yPosition)
    {
        return scenes[xPosition][yPosition];
    }
}
