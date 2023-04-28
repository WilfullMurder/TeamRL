package com.teamrl.app;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ReadComponentTest {
    /**
     * Method under test: {@link ReadComponent#findSingleUser(String, String, String)}
     */
    @Test
    void testFindSingleUser() {
        assertThrows(RuntimeException.class,
                () -> ReadComponent.findSingleUser("jane.doe@example.org", "foo.txt", "Key Folder"));
        assertThrows(RuntimeException.class, () -> ReadComponent.findSingleUser("foo", "foo", "foo"));
    }

    /**
     * Method under test: {@link ReadComponent#readAdminDataFromJSON(String, String)}
     */
    @Test
    void testReadAdminDataFromJSON() {
        assertThrows(RuntimeException.class, () -> ReadComponent.readAdminDataFromJSON("foo.txt", "Key Folder"));
    }

    /**
     * Method under test: {@link ReadComponent#readSuperDataFromJSON(String, String)}
     */
    @Test
    void testReadSuperDataFromJSON() {
        assertThrows(RuntimeException.class, () -> ReadComponent.readSuperDataFromJSON("foo.txt", "Key Folder"));
    }

    /**
     * Method under test: {@link ReadComponent#readActivityDataFromJSON(String, String)}
     */
    @Test
    void testReadActivityDataFromJSON() {
        assertThrows(RuntimeException.class, () -> ReadComponent.readActivityDataFromJSON("foo.txt", "Key Folder"));
    }

    /**
     * Method under test: {@link ReadComponent#readUserDataFromCSV(String, String)}
     */
    @Test
    void testReadUserDataFromCSV() {
        assertThrows(RuntimeException.class, () -> ReadComponent.readUserDataFromCSV("foo.txt", "Key Folder"));
    }
}

