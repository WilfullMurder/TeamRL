package com.example.teamRl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadComponent {

    public ArrayList<User> readUserDataFromJSONFile(String filename, String keyFolder)
    {
        ArrayList<User> data = new ArrayList<>();

        String path = getFilePath(filename, keyFolder);

        ObjectMapper mapper = new ObjectMapper();
        try {
            data = mapper.readValue(new File(path), new TypeReference<ArrayList<User>>(){});
        }catch(IOException e)
        {
            throw new RuntimeException(e);
        }
        return data;
    }




    private String getFilePath(String filename, String keyFolder)
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
}
