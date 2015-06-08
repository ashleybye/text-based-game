package com.ashleybye.textgame.stage;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ashley on 08/06/2015.
 */
public class EnemyTest
{
    private Enemy enemy = new Enemy();

    @Test
    public void shouldBeAnInstanceOfAbstractEnemy()
    {
        assertTrue("must extend AbstractEnemy", enemy instanceof AbstractEnemy);
    }

    @Test
    public void shouldHaveDefaultName()
    {
        assertNotNull("enemy should not have a null name", enemy.getName());
        assertNotEquals("enemy should have a default name", "", enemy.getName());
    }
}
