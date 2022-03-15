package com.xrave;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class XMLProcessorWriter {
    // private static XMLOutputFactory xmlwriter=XMLOutputFactory.newInstance();
    private FileWriter fileWriter =  null;
    private XMLStreamWriter writer = null;
    XMLProcessorWriter(){
        try {
            fileWriter = new FileWriter("myoutput.xml");//todo add timestamp to name
        }catch ( IOException e){
            System.out.println("cant open file\n");
            return;
        }
        try {
            writer = XMLOutputFactory.newInstance().createXMLStreamWriter(fileWriter);
        } catch (XMLStreamException e) {
            System.out.println("XML generation failed\n");
            e.printStackTrace();
        }
    }
    public  void writeResultsToFile() {

        System.out.println("Type name of winner for eternal memory\n");
        //console.nextLine();
    }
    void startWriteGame() throws XMLStreamException {
        writer.writeStartDocument();

        writer.writeStartElement("Gameplay");

        writer.writeStartElement("Player");
        writer.writeAttribute("id","1");
        writer.writeAttribute("name","someName");
        writer.writeAttribute("symbol","X or O");
        writer.writeEndElement();//close player tag

        writer.writeStartElement("Game");
    }
    void stopWriteGame() throws XMLStreamException {
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
    }
    void writeStep(){
        try {
            writer.writeStartElement("Step");
            writer.writeAttribute("num","1");//num of step
            writer.writeAttribute("playerId","1");
            writer.writeCharacters("placeonfield");
            writer.writeEndElement();//close Step tag
        } catch (XMLStreamException e) {
            System.out.println("XML generation failed\n");
            e.printStackTrace();
        }
    }

}
