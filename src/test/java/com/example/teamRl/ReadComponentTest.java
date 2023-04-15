package com.example.teamRl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ReadComponentTest {
    /**
     * Method under test: {@link ReadComponent#readUserDataFromJSONFile(String, String)}
     */
    @Test
    void testReadUserDataFromJSONFile() {
        assertThrows(RuntimeException.class, () -> (new ReadComponent()).readUserDataFromJSONFile("foo.txt", "Key Folder"));
        assertThrows(RuntimeException.class, () -> (new ReadComponent()).readUserDataFromJSONFile("foo", "foo"));
    }
}

