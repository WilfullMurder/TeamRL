package com.example.teamRl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
public class ReadComponent {

    public static ArrayList<UserInfoComponent> readUserDataFromJSON(String filename, String keyFolder)
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
        return data;
    }

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
