package com.example.teamRl;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WriteComponent {

    /**
     * create a new file if the file in question does not exist
     * @param fileName target file
     * @param keyFolder target folder
     * @return the file in question
     */
    private File createFile(String fileName, String keyFolder)
    {
        String path = getFilePath(fileName, keyFolder);
        File f = new File(path);

        try{
            if(!f.exists())
            {
                f.createNewFile();
                System.out.println("File " + f.getName() + "created"); //change to log
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


    /**
     *
     * @param filename name of target file
     * @param keyFolder name of target folder
     * @param data ArrayList of User class
     */
    public void writeUserDataToJSON(String filename, String keyFolder, ArrayList<User> data)
    {
        File f = createFile(filename, keyFolder);
        try{
            FileOutputStream fos = new FileOutputStream(f);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write("[" );
            for(int i =0; i< data.size(); i++)
            {
                bw.write(data.get(i).toJSON());
                if(i<data.size()-1){bw.write(",");}
                bw.newLine();
            }
            bw.write("]");
            bw.close();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void writeUserDataToJSONPretty(String filename, String keyFolder, ArrayList<User> data)
    {
        File target = createFile(filename, keyFolder);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(target, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //work on this
    public void writeAdminDataToJSON(String filename, String keyFolder, ArrayList<User> data)
    {
        File f = createFile(filename, keyFolder);
        try{
            FileOutputStream fos = new FileOutputStream(f);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write("[" );
            for(int i =0; i< data.size(); i++)
            {
                bw.write(data.get(i).toJSON());
                if(i<data.size()-1){bw.write(",");}
                bw.newLine();
            }
            bw.write("]");
            bw.close();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void writeAdminDataToJSONPretty(String filename, String keyFolder, ArrayList<User> data)
    {
        File target = createFile(filename, keyFolder);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(target, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param filename name of target file
     * @param keyFolder name of target folder
     * @param data ArrayList of User class
     */
    public void writeUserDataToCSV(String filename, String keyFolder, ArrayList<User> data)
    {
        File f = createFile(filename, keyFolder);
        try{
            FileOutputStream fos = new FileOutputStream(f);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write("surname,forename,uob_number");
            bw.newLine();
            for(int i =0; i< data.size(); i++)
            {
                bw.write(data.get(i).toCSV());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param filename name of target file
     * @param keyFolder name of target folder
     * @return the path of the target file
     */
    private String getFilePath(String filename, String keyFolder)
    {
        Path p = Paths.get("");
        String s = p.toAbsolutePath().toString();
        s+= "\\src\\";
        s+= keyFolder;
        s+= "\\java\\com\\example\\teamRL\\";
        s+=filename;
        return s;
    }
}
