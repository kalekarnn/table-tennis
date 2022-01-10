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
    public void testPlayWithFirstToReach11_team2() {
        team1.setPoints(1);
        team2.setPoints(11);

        TableTennis tableTennis = new TableTennis(team1, team2);
        Team winner = tableTennis.play();

        Assert.assertEquals(team2.getPlayers()[0], winner.getPlayers()[0]);
    }

    @Test
    public void testPlayWithFirstToReach21() {
        team1.setPoints(21);
        team2.setPoints(11);

        TableTennis tableTennis = new TableTennis(team1, team2);
        Team winner = tableTennis.play();

        Assert.assertEquals(team1.getPlayers()[0], winner.getPlayers()[0]);
    }

    @Test
    public void testPlayWithFirstToReach21_team2() {
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
    public void testPlayWithTwoPointsLead_team2() {
        team1.setPoints(10);
        team2.setPoints(12);

        TableTennis tableTennis = new TableTennis(team1, team2);
        Team winner = tableTennis.play();

        Assert.assertEquals(team2.getPlayers()[0], winner.getPlayers()[0]);
    }

    @Test
    public void testPlayWithTwoPointsLead_equal() {
        team1.setPoints(10);
        team2.setPoints(10);

        TableTennis tableTennis = new TableTennis(team1, team2);
        Team winner = tableTennis.play();

        assertTrue(winner.getPoints() >= 11);
    }

    @Test
    public void testPlay() {

        TableTennis tableTennis = new TableTennis(team1, team2);
        Team winner = tableTennis.play();

        assertTrue(winner.getPoints() >= 11);
    }

    @Test
    public void testPlayWith15_15_two_consecutive_points() {
        team1.setPoints(16);
        team2.setPoints(15);

        team2.setLastPointWinner(true);
        team2.setPoints(16);

        TableTennis tableTennis = new TableTennis(team1, team2);
        Team winner = tableTennis.play();

        Assert.assertEquals(team2.getPlayers()[0], winner.getPlayers()[0]);
    }
}
