/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * reads file. This is then used to display high scores
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class ReadFile {

    /**
     * specific file that should be read
     */
    private String path;
 
    /**
     * initialises file that should be read to the path
     * @param file_path
     * file that should be read
     */
    public ReadFile(String file_path){
     path = file_path;
 }
 
    /**
     *opens the file and reads the strings as array
     * @return
     * all strings in the file read
     * @throws IOException
     * if run time error occurs, throws exception 
     */
    public String[] OpenFile() throws IOException{
   FileReader fr = new FileReader(path);
   BufferedReader textReader = new BufferedReader(fr);
   
   int numberOfLines = readLines();
   String[ ] textData = new String[numberOfLines];
   
   int i;

for (i=0; i < numberOfLines; i++) {
textData[ i ] = textReader.readLine();

}
textReader.close( );
return textData;
 }
 
    /**
     *reads each line in the file
     * @return
     * number of lines in text file
     * @throws IOException
     * if run time error occurs, throws exception 
     */
    int readLines() throws IOException{
     
     FileReader file_to_read = new FileReader(path);
     BufferedReader bf = new BufferedReader(file_to_read);
     
     String aLine;
     int numberOfLines = 0;
     
     while((aLine = bf.readLine()) != null){
         numberOfLines++;
     }
     bf.close();
     return numberOfLines;
 }
}
