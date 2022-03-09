package com.xrave;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int[] gameField = new int[9];
    static int activePlayer=1;
    static int winner=0;
    public static void main(String[] args)  {
        int selectedPlace=-1;
        Scanner console = new Scanner(System.in);
        while (true) {
            printField(gameField);
            System.out.println("select number of place by numpad layout");
            try {
                selectedPlace = console.nextInt()-1;
            }
            catch (InputMismatchException e){
                selectedPlace=-1;
                console.nextLine();
            }
            makeStep(selectedPlace);
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
        System.out.println("winner is - "+ winner);
    }

    private static boolean checkGameOver() {
        int x;
        int y;
        int full;
        for (int i = 0; i < 9; i++) {

        }
        return false;
    }

    private static int makeStep( int selectedPlace) {
        if (gameField[selectedPlace]==0){
            gameField[selectedPlace]=activePlayer;
        }else {
            return -1;
        }
        return 1;
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
