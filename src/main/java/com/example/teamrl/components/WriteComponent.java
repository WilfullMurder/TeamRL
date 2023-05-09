package com.example.teamrl.components;
//lead auth:JacobFarrow(20007972)
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.teamrl.Activity;
import com.example.teamrl.Admin;
import com.example.teamrl.SuperUser;
import com.example.teamrl.User;

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

    public static void updateUser(UserInfoComponent uic, ArrayList<User> data){
        ArrayList<User> newData = data;
        for(int i =0; i < data.size(); i++){
            if(uic.getUobNumber().equals(data.get(i).getUobNumber())){
                newData.get(i).setMyInfo(uic);
            }
        }
        writeUserDataToJSONPretty(FileComponent.USER_FILENAME, FileComponent.MAIN_FOLDER, newData);
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

//Comment your name under this here if you familiarized yourself with the codebase the third time Jacob asked:
//Jacob
