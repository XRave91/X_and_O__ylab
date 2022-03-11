package com.xrave;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int[] gameField = new int[9];
    static int activePlayer=1;
    static int winner=0;
    static int steps=0;
    static Scanner console = new Scanner(System.in);
    public static void main(String[] args)  {
        int selectedPlace;
        while (true) {
            printField(gameField);
            System.out.println("select number of place by numpad layout and press enter");
            try {
                selectedPlace = console.nextInt()-1;
            }
            catch (InputMismatchException e){
                selectedPlace=-1;
                console.nextLine();
            }
            if (selectedPlace>=10){
                System.out.println("select number of place(1-9) by numpad layout and press enter");
                continue;
            }
            if(!makeStep(selectedPlace)){
                continue;
            }
            if(checkGameOver()){
                break;
            }
            if (activePlayer==1){
                activePlayer=100;
            }else {
                activePlayer=1;
            }
        }
        printGameResults();
        writeResultsToFile();
    }

    private static void writeResultsToFile() {
        System.out.println("Type name of winner for eternal memory\n");
        console.nextLine();
    }

    private static void printGameResults() {
        printField(gameField);
        if (winner == 0){
            System.out.println("no winner, tie this time");
        }else {
            if(winner > 10){
                System.out.println("winner is - O");
            }else{
            System.out.println("winner is - X");}
        }
    }

    private static boolean checkGameOver() {
        for (int i = 0; i < 3; i++) {
            if(gameField[i*3]!=0&&(gameField[i*3]==gameField[1+i*3])&&(gameField[1+i*3]==gameField[2+i*3])){
                winner = gameField[i*3];
                return true;
            }
            if (gameField[i]!=0&&(gameField[i]==gameField[i+3])&&(gameField[i+3]==gameField[i+6])){
                winner = gameField[i];
                return true;
            }
        }
        if(gameField[4]!=0&&((gameField[0]==gameField[4]&&gameField[4]==gameField[8])||
                (gameField[6]==gameField[4]&&gameField[4]==gameField[2]))){
            winner = gameField[4];
            return true;
        }
        return steps == 9;
    }

    private static boolean makeStep( int selectedPlace) {
        if (gameField[selectedPlace]==0){
            gameField[selectedPlace]=activePlayer;
            steps++;
        }else {
            return false;
        }
        return true;
    }

    private static void clrscr(){
        System.out.print("\033[H\033[2J");//clear console
    }
    public static void printField(int[] field){
        StringBuilder line = new StringBuilder();
        clrscr();
        for (int i = 8; i >= 0; i--) {
            if((i+1)%3==0 && i!=8){
                System.out.println("|"+line);
                line = new StringBuilder();
                //line=line+"|\n";
            }
            line.insert(0, "|");
            if (field[i]==0){
                line.insert(0, " ");
            }
            if (field[i]==1){
                line.insert(0, "X");
            }
            if (field[i]==100){
                line.insert(0, "O");
            }

            // System.out.println("|"+field[3*i]+"|"+field[3*i+1]+"|"+field[3*i+1]+"|");
        }
        System.out.println("|"+line);
    }
}
