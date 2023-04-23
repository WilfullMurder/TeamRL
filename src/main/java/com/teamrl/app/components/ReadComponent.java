package com.teamrl.app.components;
//lead auth:JacobFarrow(20007972)
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamrl.app.User;

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

        ArrayList<User> users = new ArrayList<>();
        for(int i =0; i < data.size(); i++)
        {
            User u = new User();
            u.setMyInfo(data.get(i));
            users.add(u);
        }
        return users;
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
