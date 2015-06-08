package com.ashleybye.textgame.stage;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ashley on 08/06/2015.
 */
public class EnemyTest
{
    @Test
    public void shouldBeAnInstanceOfAbstractEnemy()
    {
        Enemy enemy = new Enemy("Boo");

        assertTrue("must extend AbstractEnemy", enemy instanceof AbstractEnemy);
    }

    @Test
    public void shouldHaveAName()
    {
        Enemy enemy = new Enemy("Boo");

        assertEquals("enemy should have a name", "Boo", enemy.getName());
    }
}
