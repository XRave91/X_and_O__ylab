package com.xrave;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataProcessor {
    private static XMLOutputFactory xmlwriter=XMLOutputFactory.newInstance();
    static FileWriter fileWriter =  null;
    static XMLStreamWriter writer = null;//
    int[] gameField = new int[9];
    int activePlayer = 1;
    int winner = 0;
    int step = 0;
    String player1name;
    String player2name;
    public static void writeResultsToFile() {//todo move work with xml to class
        try {
            fileWriter = new FileWriter("myoutput.xml");
        }catch ( IOException e){
            System.out.println("cant open file\n");
            return;
        }
        try {
            writer = XMLOutputFactory.newInstance().createXMLStreamWriter(fileWriter);
            writer.writeStartDocument();

            writer.writeStartElement("Gameplay");

                writer.writeStartElement("Player");
                writer.writeAttribute("id","1");
                writer.writeAttribute("name","someName");
                writer.writeAttribute("symbol","X or O");
                writer.writeEndElement();//close player tag

                writer.writeStartElement("Game");
                    writer.writeStartElement("Step");
                    writer.writeAttribute("num","1");//num of step
                    writer.writeAttribute("playerId","1");
                    writer.writeCharacters("placeonfield");
                    writer.writeEndElement();//close Step tag

                writer.writeEndElement();//close Game tag

                writer.writeStartElement("GameResult");

                    writer.writeStartElement("Player");
                    writer.writeAttribute("id","1");
                    writer.writeAttribute("name","someName");
                    writer.writeAttribute("symbol","X or O");
                    writer.writeEndElement();//close player tag

                writer.writeEndElement();//close GameResult tag

           // writer.writeCharacters("myvalue"); //текст в теге
            writer.writeEndElement();//close gameplay tag

            writer.writeEndDocument();
            writer.flush();
            writer.close();
        } catch (XMLStreamException e) {
            System.out.println("XML generation failed\n");
            e.printStackTrace();
        }
        System.out.println("Type name of winner for eternal memory\n");
        //console.nextLine();
    }
}
