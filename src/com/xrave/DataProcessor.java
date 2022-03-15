package com.xrave;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataProcessor {
    
    int[] gameField = new int[9];
    int activePlayer = 1;
    int winner = 0;
    int step = 0;
    String player1name;
    String player2name;

    public static void writeResultsToFile() {
    }
}
