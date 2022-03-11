package com.xrave;

import java.util.InputMismatchException;
import java.util.Scanner;



public class GameXO {
    DataProcessor gameData;
    ConsoleUI gui;
    {
        gameData=new DataProcessor();
        gui = new ConsoleUI(gameData);
    }

    public  void main()  {
        int selectedPlace;
        while (true) {
            gui.printField();
            selectedPlace= gui.getUserInput();
            if(!makeStep(selectedPlace)){
                continue;
            }
            if(checkGameOver()){
                break;
            }
            if (gameData.activePlayer==1){
                gameData.activePlayer=100;
            }else {
                gameData.activePlayer=1;
            }
        }
        gui.printGameResults();
        DataProcessor.writeResultsToFile();
    }
    private  boolean checkGameOver() {
        for (int i = 0; i < 3; i++) {
            if(gameData.gameField[i*3]!=0&&(gameData.gameField[i*3]==gameData.gameField[1+i*3])&&(gameData.gameField[1+i*3]==gameData.gameField[2+i*3])){
                gameData.winner = gameData.gameField[i*3];
                return true;
            }
            if (gameData.gameField[i]!=0&&(gameData.gameField[i]==gameData.gameField[i+3])&&(gameData.gameField[i+3]==gameData.gameField[i+6])){
                gameData.winner = gameData.gameField[i];
                return true;
            }
        }
        if(gameData.gameField[4]!=0&&((gameData.gameField[0]==gameData.gameField[4]&&gameData.gameField[4]==gameData.gameField[8])||
                (gameData.gameField[6]==gameData.gameField[4]&&gameData.gameField[4]==gameData.gameField[2]))){
            gameData.winner = gameData.gameField[4];
            return true;
        }
        return gameData.steps == 9;
    }

    private  boolean makeStep( int selectedPlace) {
        if (gameData.gameField[selectedPlace]==0){
            gameData.gameField[selectedPlace]=gameData.activePlayer;
            gameData.steps++;
        }else {
            return false;
        }
        return true;
    }
}
