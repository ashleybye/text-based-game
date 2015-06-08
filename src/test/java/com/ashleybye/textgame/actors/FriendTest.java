package com.ashleybye.textgame.actors;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by ashley on 08/06/2015.
 */
public class FriendTest
{
    @Test
    public void shouldBeAnInstanceOfActor()
    {
        Friend friend = new Friend();

        assertTrue("must extend AbstractFriend", friend instanceof AbstractFriend);
    }

    @Test
    public void shouldHaveADefaultName()
    {
        Friend friend = new Friend();

        assertNotNull("should not have a null name", friend.getName());
        assertNotEquals("should have a default name", "", friend.getName());
    }
}
