package com.dsalgo.scaler.primer;

/**
 * Little Ponny and Little Donny are playing a game. The game consists of a box containing A stones in the beginning.
 *
 * A move consists of removing some stones from the box. Now, if the box contains K stones at the moment, then a player
 * can pick up anywhere between 1 to K − 1 number of stones except if there is only one left in which case the player has
 * no other choice but to pick it. The player who isn't able to make any move loses.
 *
 * Guess the winner if Little Ponny moves first.
 *
 * Note: Both the players make their moves optimally.
 */
public class LittlePonnyDonnyMain {

    public static void main(String[] args) {
        System.out.println("whoIsTheWinner(9) = " + whoIsTheWinner(9));
    }

    private static String whoIsTheWinner(int i) {
        if(i == 1) {
            return "Ponny";
        }
        if(i == 2) {
            return "Donny";
        }
        return "Ponny";
    }

}
