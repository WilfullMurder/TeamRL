package com.teamrl.app;
//lead auth:JacobFarrow(20007972)
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamrl.app.Activity;
import com.teamrl.app.Admin;
import com.teamrl.app.SuperUser;
import com.teamrl.app.User;

import java.io.*;
import java.util.ArrayList;

public class WriteComponent {
    //auth:JacobFarrow(20007972)

     /** !DEPRECATED! Use writeUserDataToJSON or writeUserDataToJSONPretty
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
    public static void writeUserDataToJSON(String filename, String keyFolder, ArrayList<User> data)
    {
        ArrayList<UserInfoComponent> ui =convertUserData(data);
        File target = FileComponent.createFile(filename, keyFolder);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(target, ui);
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
    public static void writeUserDataToJSONPretty(String filename, String keyFolder, ArrayList<User> data)
    {
        ArrayList<UserInfoComponent> ui = convertUserData(data);
        File target = FileComponent.createFile(filename, keyFolder);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(target, ui);
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
        ArrayList<UserInfoComponent> ui = convertUserData(data);
        File f = FileComponent.createFile(filename, keyFolder);
        try{
            FileOutputStream fos = new FileOutputStream(f);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write("surname,forename,uob_number,email,DOB,startYear,endYear");
            bw.newLine();
            for(int i =0; i< ui.size(); i++)
            {
                bw.write(ui.get(i).toCSV());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<UserInfoComponent> convertUserData(ArrayList<User> data){
        ArrayList<UserInfoComponent> ui = new ArrayList<>();
        for(int i = 0; i< data.size(); i++)
        {
            ui.add(data.get(i).getMyInfo());
        }
        return ui;
    }

    /**
     *
     * @param filename name of target file
     * @param keyFolder name of target folder
     * @param data ArrayList of User class
     */
    public static void writeAdminDataToJSONPretty(String filename, String keyFolder, ArrayList<Admin> data)
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
    public static void writeSuperDataToJSONPretty(String filename, String keyFolder, ArrayList<SuperUser> data)
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
    public static void writeActivityDataToJSONPretty(String filename, String keyFolder, ArrayList<Activity> data)
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
