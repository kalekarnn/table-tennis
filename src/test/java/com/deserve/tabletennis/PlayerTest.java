package com.deserve.tabletennis;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest extends TestCase {

    @Test
    public void testToString() {
        Player player = new Player("name");
        Assert.assertEquals(" 'name' ", player.toString());
    }

}
