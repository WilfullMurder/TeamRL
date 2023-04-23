package com.teamrl.app.components;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ReadComponentTest {
    /**
     * Method under test: {@link ReadComponent#readUserDataFromJSON(String, String)}
     */
    @Test
    void testReadUserDataFromJSON() {
        assertThrows(RuntimeException.class, () -> ReadComponent.readUserDataFromJSON("foo.txt", "Key Folder"));
        assertThrows(RuntimeException.class, () -> ReadComponent.readUserDataFromJSON("foo", "foo"));
    }

    /**
     * Method under test: {@link ReadComponent#readUserDataFromCSV(String, String)}
     */
    @Test
    void testReadUserDataFromCSV() {
        assertThrows(RuntimeException.class, () -> ReadComponent.readUserDataFromCSV("foo.txt", "Key Folder"));
    }
}

