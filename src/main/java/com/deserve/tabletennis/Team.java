package com.deserve.tabletennis;

import java.util.Arrays;

public class Team {

    private final com.deserve.tabletennis.Player[] players;
    private int points;
    private int serveCount;

    public com.deserve.tabletennis.Player[] getPlayers() {
        return players;
    }

    public Team(com.deserve.tabletennis.Player[] players) {
        this.players = players;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void incrementServeCount() {
        this.serveCount = this.serveCount + 1;
    }

    public int getServeCount() {
        return serveCount;
    }

    public void resetServeCount() {
        this.serveCount = 0;
    }

    public boolean isMaxServeReached() {
        return this.serveCount == 2;
    }

    public int serve() {
        return (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return serveCount != 0 ? "players=" + Arrays.toString(players) +
                ", points=" + points +
                ", serveCount=" + serveCount : "players=" + Arrays.toString(players) +
                ", points=" + points;
    }
}
