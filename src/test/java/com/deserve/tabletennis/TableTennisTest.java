package com.deserve.tabletennis;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class TableTennisTest extends TestCase {

    Team team1, team2;

    @Override
    public void setUp() {
        Player player1 = new Player("Vikas");
        Player player2 = new Player("Tushar");
        team1 = new Team(new Player[]{player1});
        team2 = new Team(new Player[]{player2});
    }

    @Test
    public void testPlayWithFirstToReach11() {
        team1.setPoints(11);
        team2.setPoints(9);

        TableTennis tableTennis = new TableTennis(team1, team2);
        Team winner = tableTennis.play();

        Assert.assertEquals(team1.getPlayers()[0], winner.getPlayers()[0]);
    }

    @Test
    public void testPlayWithFirstToReach21() {
        team1.setPoints(11);
        team2.setPoints(21);

        TableTennis tableTennis = new TableTennis(team1, team2);
        Team winner = tableTennis.play();

        Assert.assertEquals(team2.getPlayers()[0], winner.getPlayers()[0]);
    }

    @Test
    public void testPlayWithTwoPointsLead() {
        team1.setPoints(12);
        team2.setPoints(10);

        TableTennis tableTennis = new TableTennis(team1, team2);
        Team winner = tableTennis.play();

        Assert.assertEquals(team1.getPlayers()[0], winner.getPlayers()[0]);
    }

    @Test
    public void testPlay() {

        TableTennis tableTennis = new TableTennis(team1, team2);
        Team winner = tableTennis.play();

        assertTrue(winner.getPoints() >= 11);
    }
}
