package com.deserve.tabletennis;

import java.util.Arrays;
import java.util.Comparator;

public class TableTennis {

    public static final int POINTS_11 = 11;
    public static final int POINTS_21 = 21;

    protected Team[] teams;

    public void displayScore() {
        Arrays.stream(teams).forEach(System.out::println);
    }

    public TableTennis(Team team1, Team team2) {
        teams = new Team[]{team1, team2};
    }

    public Team play() {

        int team = 2;
        do {
            int serveResult = getServeResult();

            team = updatePoints(serveResult);

            System.out.println("serveResult : " + serveResult);
            displayScore();
        } while (!isFinished(team));

        return getWinner();
    }

    public boolean isFinished(int team) {

        if (isFirstToReachEleven()) {
            return true;
        } else if (isFirstToReachTwentyOne()) {
            return true;
        } else if (isFifteenWithTwoConsecutivePoints(team)) {
            return true;
        } else
            return isTwoPointsLead();
    }

    private boolean isFifteenWithTwoConsecutivePoints(int team) {
        return teams[0].getPoints() >= 15 && teams[1].getPoints() >= 15 && (team == 0 || team == 1);
    }

    public Team getWinner() {
        return Arrays.stream(teams)
                .max(Comparator.comparingInt(Team::getPoints))
                .get();

    }

    private boolean isTwoPointsLead() {
        return teams[0].getPoints() >= 10 && teams[1].getPoints() >= 10 && Math.abs(teams[0].getPoints() - teams[1].getPoints()) == 2;
    }

    private boolean isFirstToReachEleven() {
        return isFirstToReach(POINTS_11, 10);
    }

    private boolean isFirstToReachTwentyOne() {
        return isFirstToReach(POINTS_21, 21);
    }

    private boolean isFirstToReach(int points1, int points2) {
        return (teams[0].getPoints() == points1 && teams[1].getPoints() < points2) ||
                (teams[1].getPoints() == points1 && teams[0].getPoints() < points2);
    }

    private int getServeResult() {
        int serveResult = 0;
        if (!teams[0].isMaxServeReached() && teams[1].getServeCount() != 1) {
            serveResult = serveAndUpdate(1, 0);

        } else if (!teams[1].isMaxServeReached()) {
            serveResult = serveAndUpdate(0, 1);
        }
        return serveResult;
    }

    private int serveAndUpdate(int teamToReset, int teamToServe) {
        int serveResult;
        teams[teamToReset].resetServeCount();
        serveResult = teams[teamToServe].serve();
        teams[teamToServe].incrementServeCount();
        return serveResult;
    }

    private int updatePoints(int serveResult) {
        if (serveResult % 2 == 0) {
            int currentPoints = teams[0].getPoints();
            teams[0].setPoints(currentPoints + 1);

            if (teams[0].isLastPointWinner()) {
                return 0;
            }

            teams[0].setLastPointWinner(true);
            teams[1].setLastPointWinner(false);

        } else {
            int currentPoints = teams[1].getPoints();
            teams[1].setPoints(currentPoints + 1);

            if (teams[1].isLastPointWinner()) {
                return 1;
            }
            teams[1].setLastPointWinner(true);
            teams[0].setLastPointWinner(false);
        }

        return 2;
    }
}
