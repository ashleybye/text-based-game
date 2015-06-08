package com.ashleybye.textgame.stage;

/**
 * Created by ashley on 08/06/2015.
 */
public class AbstractEnemy implements Actor
{
    private String name;

    public AbstractEnemy(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
