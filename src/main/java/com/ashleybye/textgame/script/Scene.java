package com.ashleybye.textgame.script;

import com.ashleybye.textgame.actors.Actor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashley on 08/06/2015.
 */
public class Scene
{
    private final String DEFAULT_DESCRIPTION = "This is a boring, default scene";
    private String description;
    private List<Actor> actors;

    public Scene(int xPosition, int yPosition)
    {
        this.description = DEFAULT_DESCRIPTION;
        this.actors = new ArrayList<>();
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<Actor> getActors()
    {
        return actors;
    }

    public void setActors(List<Actor> actors)
    {
        this.actors = actors;
    }
}
