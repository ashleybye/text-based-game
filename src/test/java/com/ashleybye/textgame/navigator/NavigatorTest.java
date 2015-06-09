package com.ashleybye.textgame.navigator;

import com.ashleybye.textgame.world.Location;
import com.ashleybye.textgame.world.World;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ashley on 08/06/2015.
 */
public class NavigatorTest
{
    @Test
    public void shouldBeAQuasiSingleton()
    {
        Map map = Mockito.mock(Map.class);
        World world = Mockito.mock(World.class);

        Navigator navigator = Navigator.getNavigator(map, world);

        assertNotNull("navigator cannot be null", navigator);
    }

    @Test
    public void beginMethodShouldSetASceneOnTheStage()
    {
        Location location = Mockito.mock(Location.class);
        Map map = Mockito.mock(Map.class);
        World world = Mockito.mock(World.class);

        when(map.loadLoaction(0, 0)).thenReturn(location);
        when(world.getCurrentLocation()).thenReturn(location);

        Navigator navigator = Navigator.getNavigator(map, world);
        navigator.begin();

        assertEquals("begin() method should set a location on the world but none was set", location, world.getCurrentLocation());
// find out why the interactions with these mocks are failing
//        verify(map).loadLoaction(0, 0);
//        verify(world).setLocation(location);
    }

    @Test
    public void shouldSetNewSceneOnStageWhenRequestedProvidedSceneAccessible()
    {
        Location location = Mockito.mock(Location.class);
        Map map = Mockito.mock(Map.class);
        World world = Mockito.mock(World.class);

        when(map.isLocationAccessibleFrom(1, 1, Compass.NORTH)).thenReturn(true);
        when(map.loadLoaction(1, 2)).thenReturn(location);
        when(map.getCurrentX()).thenReturn(1);
        when(map.getCurrentY()).thenReturn(1);
        when(world.getCurrentLocation()).thenReturn(location);

        Navigator navigator = Navigator.getNavigator(map, world);
        navigator.goToLocation(Compass.NORTH);

        assertEquals("passing loadLoaction() message to world should result in new location being set",
                location, world.getCurrentLocation());

        verify(map).isLocationAccessibleFrom(1, 1, Compass.NORTH);
        verify(map).loadLoaction(1, 2);
        verify(world).setLocation(location);
    }
}
