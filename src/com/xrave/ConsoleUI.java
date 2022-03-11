package com.xrave;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    DataProcessor gameData;
    ConsoleUI(DataProcessor data){
        gameData=data;
    }
    private final Scanner console = new Scanner(System.in);
    public void printField(){
        StringBuilder line = new StringBuilder();
        clrscr();
        for (int i = 8; i >= 0; i--) {
            if((i+1)%3==0 && i!=8){
                System.out.println("|"+line);
                line = new StringBuilder();
                //line=line+"|\n";
            }
            line.insert(0, "|");
            if (gameData.gameField[i]==0){
                line.insert(0, " ");
            }
            if (gameData.gameField[i]==1){
                line.insert(0, "X");
            }
            if (gameData.gameField[i]==100){
                line.insert(0, "O");
            }
        }
        System.out.println("|"+line);
    }
    public int getUserInput(){

        System.out.println("select number of place by numpad layout and press enter");
        try {
            return console.nextInt()-1;
        }
        catch (InputMismatchException e){
            console.nextLine();
            System.out.println("select number of place(1-9) by numpad layout and press enter");
            return -1;
        }

    }
    public  void printGameResults() {
        printField();
        if (gameData.winner == 0){
            System.out.println("no winner, tie this time");
        }else {
            if(gameData.winner > 10){
                System.out.println("winner is - O");
            }else{
                System.out.println("winner is - X");}
        }
    }
    private static void clrscr(){
        System.out.print("\033[H\033[2J");//clear console
    }
}
