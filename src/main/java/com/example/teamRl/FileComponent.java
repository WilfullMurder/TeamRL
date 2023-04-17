package com.example.teamRl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileComponent {

    /**
     * @param filename name of target file
     * @param keyFolder name of target folder
     * @return the path of the target file
     */
    public static String getFilePath(String filename, String keyFolder)
    {
        //this probs needs moving out if read and write both use it
        Path p = Paths.get("");
        String s = p.toAbsolutePath().toString();
        s+= "\\src\\";
        s+= keyFolder;
        s+= "\\java\\com\\example\\teamRL\\";
        s+=filename;
        return s;
    }

    /**
     * create a new file if the file in question does not exist
     * @param fileName target file
     * @param keyFolder target folder
     * @return the file in question
     */
    public static File createFile(String fileName, String keyFolder)
    {
        String path = getFilePath(fileName, keyFolder);
        File f = new File(path);

        try{
            if(!f.exists())
            {
                f.createNewFile();
                System.out.println("File " + f.getName() + " created"); //change to log
            }
            else{
                System.out.println("File " + f.getName() + " already exists. File will be overwritten"); //change to log
            }
        }catch(IOException e)
        {
            e.printStackTrace(); //change to log
        }
        return f;
    }
}