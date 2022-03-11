package com.xrave;

public class DataProcessor {
     int[] gameField = new int[9];
     int activePlayer=1;
     int winner=0;
     int steps=0;
     String player1name;
     String player2name;
    public static void writeResultsToFile() {
        System.out.println("Type name of winner for eternal memory\n");
        //console.nextLine();
    }
}
