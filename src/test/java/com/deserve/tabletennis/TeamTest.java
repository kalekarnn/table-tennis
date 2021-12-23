package com.deserve.tabletennis;

import junit.framework.TestCase;

public class TeamTest extends TestCase {

    Team team;

    @Override
    public void setUp() {
        Player player = new Player("Vikas");
        team = new Team(new Player[]{player});
    }

    public void testPlayers() {
        assertEquals(1, team.getPlayers().length);
        assertEquals(" 'Vikas' ", team.getPlayers()[0].toString());
    }

    public void testToString() {
        assertEquals("players=[ 'Vikas' ], points=0, serveCount=0", team.toString());
    }

    public void testPoints() {
        team.setPoints(10);
        assertEquals(10, team.getPoints());
    }

    public void testServeCount() {
        team.resetServeCount();
        assertEquals(0, team.getServeCount());
        team.incrementServeCount();
        assertEquals(1, team.getServeCount());
        team.incrementServeCount();
        assertEquals(2, team.getServeCount());

        assertTrue(team.isMaxServeReached());
    }

    public void testServe() {
        assertTrue(0 <= team.serve() && team.serve() <= 100);
    }
}
