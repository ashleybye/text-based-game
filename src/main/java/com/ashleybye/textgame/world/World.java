package com.ashleybye.textgame.world;

/**
 * Created by ashley on 08/06/2015.
 */
public class World
{
    // not final, it needs to be set back to null once no longer required
    private static World world;
    private Location currentLocation;

    private World()
    {
    }

    public static final World getWorld()
    {
        if (world == null)
        {
            world = new World();
        }
        return world;
    }

    public Location getCurrentLocation()
    {
        return currentLocation;
    }

    public void setLocation(Location location)
    {
        this.currentLocation = location;
    }
}
