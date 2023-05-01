package com.teamrl.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Paths;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class FileComponentTest {
    /**
     * Method under test: {@link FileComponent#getFilePath(String, String)}
     */
    @Test
    void testGetFilePath() {
        String actualFilePath = FileComponent.getFilePath("foo.txt", "Key Folder");
        assertEquals(
                String.join("", Paths.get(System.getProperty("user.dir"), "src", "Key").toString(), " Folder\\files\\foo.txt"),
                actualFilePath);
    }

    /**
     * Method under test: {@link FileComponent#createFile(String, String)}
     */
    @Test
    void testCreateFile() {
        FileComponent.createFile("filecreationtest.txt", "test");
    }
}

