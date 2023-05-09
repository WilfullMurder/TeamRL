package com.example.teamrlnew.components;
//lead auth:JacobFarrow(20007972)

import com.example.teamrlnew.Activity;
import com.example.teamrlnew.Admin;
import com.example.teamrlnew.SuperUser;
import com.example.teamrlnew.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class ReadComponent {
    //auth:JacobFarrow(20007972)
    public static ArrayList<User> readUserDataFromJSON(String filename, String keyFolder)
    {
        ArrayList<UserInfoComponent> data = new ArrayList<>();

        String path = FileComponent.getFilePath(filename, keyFolder);

        ObjectMapper mapper = new ObjectMapper();
        try {
            data = mapper.readValue(new File(path), new TypeReference<ArrayList<UserInfoComponent>>(){});
        }catch(IOException e)
        {
            throw new RuntimeException(e);
        }

        //is this worth the separate info component?
        ArrayList<User> users = new ArrayList<>();
        for(int i =0; i < data.size(); i++)
        {
            User u = new User();
            u.setMyInfo(data.get(i));
            users.add(u);
        }
        return users;
    }

    /**
     * We can find a single user by email
     * @param email ~ the desired user attribute (surname, email, uob, etc.)
     * @param filename ~ the lookup filename
     * @param keyFolder ~ the key folder (test or main)
     * @return Found user or null
     */
    public static User findSingleUser(String email, String filename, String keyFolder) {
        ArrayList<User> users = readUserDataFromJSON(filename,keyFolder);

        for (int i = 0; i< users.size(); i++){

            if(email.equals(users.get(i).getEmail())){
                return users.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Admin> readAdminDataFromJSON(String filename, String keyFolder){
        ArrayList<Admin> data = new ArrayList<>();
        String path = FileComponent.getFilePath(filename, keyFolder);
        ObjectMapper mapper = new ObjectMapper();
        try{
            data = mapper.readValue(new File(path), new TypeReference<ArrayList<Admin>>(){});
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        return data;
    }
    public static ArrayList<SuperUser> readSuperDataFromJSON(String filename, String keyFolder){
        ArrayList<SuperUser> data = new ArrayList<>();
        String path = FileComponent.getFilePath(filename, keyFolder);
        ObjectMapper mapper = new ObjectMapper();
        try{
            data = mapper.readValue(new File(path), new TypeReference<ArrayList<SuperUser>>(){});
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        return data;
    }
    public static ArrayList<Activity> readActivityDataFromJSON(String filename, String keyFolder){
        ArrayList<Activity> data = new ArrayList<>();
        String path = FileComponent.getFilePath(filename, keyFolder);
        ObjectMapper mapper = new ObjectMapper();
        try{
            data = mapper.readValue(new File(path), new TypeReference<ArrayList<Activity>>(){});
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        return data;
    }

    /**
     * needs finishing
     * @param filename
     * @param keyFolder
     * @return
     */
    public static ArrayList<UserInfoComponent> readUserDataFromCSV(String filename, String keyFolder)
    {
        ArrayList<UserInfoComponent> data = new ArrayList<>();
        String path = FileComponent.getFilePath(filename, keyFolder);
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while(br.lines() != null)
            {
                //split csv string
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return data;
    }
}
//Comment your name under this here if you familiarized yourself with the codebase the fourth time Jacob asked:
//Jacob