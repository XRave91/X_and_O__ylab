package com.xrave;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int[] gameField = new int[9];
    static int activePlayer=1;
    static int winner=0;
    static int steps=0;
    public static void main(String[] args)  {
        int selectedPlace=-1;
        Scanner console = new Scanner(System.in);
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
            if(gameField[0+i*3]!=0&&(gameField[0+i*3]==gameField[1+i*3])&&(gameField[1+i*3]==gameField[2+i*3])){
                winner = gameField[0+i*3];
                return true;
            }
            if (gameField[i]!=0&&(gameField[i]==gameField[i+3])&&(gameField[i+3]==gameField[i+6])){
                winner = gameField[i];
                return true;
            }
        }
        if(gameField[5]!=0&&((gameField[1]==gameField[5]&&gameField[5]==gameField[9])||
                (gameField[7]==gameField[5]&&gameField[5]==gameField[3]))){
            return true;
        }
        if(steps==9){
            return true;
        }
        return false;
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
        String line = "";
        clrscr();
        for (int i = 8; i >= 0; i--) {
            if((i+1)%3==0 && i!=8){
                System.out.println("|"+line);
                line="";
                //line=line+"|\n";
            }
            line="|"+line;
            if (field[i]==0){
                line=" "+line;
            }
            if (field[i]==1){
                line="X"+line;
            }
            if (field[i]==100){
                line="O"+line;
            }

            // System.out.println("|"+field[3*i]+"|"+field[3*i+1]+"|"+field[3*i+1]+"|");
        }
        System.out.println("|"+line);
    }
}
