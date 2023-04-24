package com.teamrl.app.components;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
     * Method under test: {@link ReadComponent#readUserDataFromJSON(String, String)}
     * this one is dodgy! relies on files being in the test>files directory
     */
    @Test
    void testReadUserDataFromJSON2() {
        assertNotNull(ReadComponent.readUserDataFromJSON("pretty-foobar.txt", "test"));
    }

    /**
     * Method under test: {@link ReadComponent#readAdminDataFromJSON(String, String)}
     */
    @Test
    void testReadAdminDataFromJSON() {
        assertThrows(RuntimeException.class, () -> ReadComponent.readAdminDataFromJSON("foo.txt", "Key Folder"));
        assertThrows(RuntimeException.class, () -> ReadComponent.readAdminDataFromJSON("foo", "foo"));
    }

    /**
     * Method under test: {@link ReadComponent#readUserDataFromCSV(String, String)}
     */
    @Test
    void testReadUserDataFromCSV() {
        assertThrows(RuntimeException.class, () -> ReadComponent.readUserDataFromCSV("foo.txt", "Key Folder"));
    }


}

