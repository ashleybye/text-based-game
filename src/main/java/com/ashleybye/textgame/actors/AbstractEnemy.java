package com.ashleybye.textgame.actors;

/**
 * Created by ashley on 08/06/2015.
 */
public class AbstractEnemy implements Actor
{
    private static final String DEFAULT_NAME = "Groucher";

    private String name;

    public AbstractEnemy()
    {
        this.name = DEFAULT_NAME;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
