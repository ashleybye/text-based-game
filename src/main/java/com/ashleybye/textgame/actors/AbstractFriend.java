package com.ashleybye.textgame.actors;

/**
 * Created by ashley on 08/06/2015.
 */
public class AbstractFriend implements Actor
{
    private static final String DEFAULT_NAME = "Biggles";

    private String name;

    public AbstractFriend()
    {
        this.name = DEFAULT_NAME;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
