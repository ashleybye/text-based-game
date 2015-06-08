package com.ashleybye.textgame.script;

import com.ashleybye.textgame.stage.Actor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashley on 08/06/2015.
 */
public class Scene
{
    private String description;
    private List<Actor> actors;

    public Scene(String description)
    {
        this.description = description;
        this.actors = new ArrayList<>();
    }

    public String getDescription()
    {
        return description;
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
