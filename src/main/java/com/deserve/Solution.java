package com.deserve;

import com.deserve.tabletennis.Player;
import com.deserve.tabletennis.TableTennis;
import com.deserve.tabletennis.Team;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        try {
            Player player1 = new Player("Vikas");
            Player player2 = new Player("Tushar");

            Team team1 = new Team(new Player[]{player1});
            Team team2 = new Team(new Player[]{player2});

            TableTennis tableTennis = new TableTennis(team1, team2);
            Team winner = tableTennis.play();

            System.out.println("Winner is " + Arrays.toString(winner.getPlayers()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
