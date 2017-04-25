/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author User
 */
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * write text to a file
 * @author  Trevor, oluotch, Trevor.Oluotch@city.ac.uk
 * @version 3.0
 * @since version 1.0
 */
public class WriteFile {

    /**
     * file path text is being written to
     */
    private String path;

    /**
     * overwrite current text on file 
     * or insert text below previously written
     */
    private boolean append_to_file = false;
    
    /**
     * initialise file path to path
     * @param file_path
     * where text is being written to
     */
    public WriteFile(String file_path){
        path = file_path;
    }
    
    /**
     *creates write file class
     * @param file_path
     * initialised to path
     * @param append_value
     *  wipe previous data on te file or add to it
     */
    public WriteFile(String file_path, boolean append_value){
       path = file_path;
       append_to_file = append_value;
    }
    
    /**
     * write characters to file path 
     * @param textLine
     * line of text being written to
     * @throws IOException
     * runtime error occurred while trying to write to file
     */
    public void writeToFile(String textLine) throws IOException{
        FileWriter write = new FileWriter(path, append_to_file);
        PrintWriter print_line = new PrintWriter(write);   
        print_line.printf("%s"+ "%n", textLine);
        print_line.close();
    }
    
}
