package com.ashleybye.textgame.navigator;

import com.ashleybye.textgame.world.Location;
import com.ashleybye.textgame.world.World;

/**
 * Created by ashley on 08/06/2015.
 */
public class Navigator
{
    // only one Navigator object should ever be returned during gameplay
    private static Navigator navigator;
    private Map map;
    private World world;

    private Navigator(Map map, World world)
    {
        this.map = map;
        this.world = world;
    }

    public static final Navigator getNavigator(Map map, World world)
    {
        if (navigator == null)
        {
            navigator = new Navigator(map, world);
        }
        return navigator;
    }

    public void begin()
    {
        Location location = map.loadLoaction(0, 0);
        world.setLocation(location);
    }

    public void goToLocation(Compass direction)
    {
        boolean accessible = map.isLocationAccessibleFrom(map.getCurrentX(), map.getCurrentY(), direction);
        if (accessible)
        {
            int x = map.getCurrentX();
            int y = map.getCurrentY();

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

            Location location = map.loadLoaction(x, y);
            world.setLocation(location);
        }
    }
}
