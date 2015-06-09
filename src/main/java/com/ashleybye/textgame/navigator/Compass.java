package com.ashleybye.textgame.navigator;

/**
 * Created by ashley on 09/06/2015.
 */
public enum Compass
{
    NORTH("N"),
    EAST("E"),
    SOUTH("S"),
    WEST("W");

    private final String abbreviation;

    private Compass(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation()
    {
        return abbreviation;
    }
}
