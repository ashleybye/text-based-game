package com.ashleybye.textgame.stage;

/**
 * Created by ashley on 08/06/2015.
 */
public class Scene
{
    private String description;
    private Actor actor;

    public Scene(String description)
    {
        this(description, null);
    }

    public Scene(String description, Actor actor)
    {
        this.description = description;
        this.actor = actor;
    }

    public String getDescription()
    {
        return description;
    }

    public Actor getActor()
    {
        return actor;
    }

    public void setActor(Actor actor)
    {
        this.actor = actor;
    }
}
