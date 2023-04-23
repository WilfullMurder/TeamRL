package com.example.teamRl;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class WriteComponent {


    /**
     * !DEPRECATED! Use writeUserDataToJSON or writeUserDataToJSONPretty
     * @param filename name of target file
     * @param keyFolder name of target folder
     * @param data ArrayList of User class
     */
    @Deprecated
    public static void writeUserDataToFile(String filename, String keyFolder, ArrayList<User> data)
    {
        File f = FileComponent.createFile(filename, keyFolder);
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

    /**
     *
     * @param filename name of target file
     * @param keyFolder name of target folder
     * @param data ArrayList of User class
     */
    public static void writeUserDataToJSON(String filename, String keyFolder, ArrayList<UserInfoComponent> data)
    {
        File target = FileComponent.createFile(filename, keyFolder);
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
    public static void writeUserDataToJSONPretty(String filename, String keyFolder, ArrayList<UserInfoComponent> data)
    {

        File target = FileComponent.createFile(filename, keyFolder);
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
    public static void writeUserDataToCSV(String filename, String keyFolder, ArrayList<User> data)
    {
        File f = FileComponent.createFile(filename, keyFolder);
        try{
            FileOutputStream fos = new FileOutputStream(f);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write("surname,forename,uob_number,email,DOB,startYear,endYear");
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

    //work on this
    public static void writeAdminDataToJSON(String filename, String keyFolder, ArrayList<User> data)
    {
        File f = FileComponent.createFile(filename, keyFolder);
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
    public static void writeAdminDataToJSONPretty(String filename, String keyFolder, ArrayList<User> data)
    {
        File target = FileComponent.createFile(filename, keyFolder);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(target, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
