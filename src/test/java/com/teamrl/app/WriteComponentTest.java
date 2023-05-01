package com.teamrl.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class WriteComponentTest {
    /**
     * Method under test: {@link WriteComponent#writeUserDataToFile(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToFile() {
        WriteComponent.writeUserDataToFile("foo.txt", "test", new ArrayList<>());
    }

    /**
     * Method under test: {@link WriteComponent#writeUserDataToJSON(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToJSON() {
        WriteComponent.writeUserDataToJSON("JSON-foo.txt", "test", new ArrayList<>());
    }

    /**
     * Method under test: {@link WriteComponent#writeUserDataToJSON(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToJSON2() {
         ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        WriteComponent.writeUserDataToJSON("JSON-foo2.txt", "test", userList);
    }


    /**
     * Method under test: {@link WriteComponent#writeUserDataToJSONPretty(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToJSONPretty() {
        WriteComponent.writeUserDataToJSONPretty("pretty-foo.txt", "test", new ArrayList<>());
    }

    /**
     * Method under test: {@link WriteComponent#writeUserDataToJSONPretty(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToJSONPretty2() {
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        WriteComponent.writeUserDataToJSONPretty("pretty-foo2", "test", userList);
    }



    /**
     * Method under test: {@link WriteComponent#writeUserDataToCSV(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToCSV() {
        WriteComponent.writeUserDataToCSV("csv-foo.txt", "test", new ArrayList<>());
    }

    /**
     * Method under test: {@link WriteComponent#writeUserDataToCSV(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToCSV2() {
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        WriteComponent.writeUserDataToCSV("csv-foo2.txt", "test", userList);
    }

    /**
     * Method under test: {@link WriteComponent#convertUserData(ArrayList)}
     */
    @Test
    void testConvertUserData() {
        assertTrue(WriteComponent.convertUserData(new ArrayList<>()).isEmpty());
    }

    /**
     * Method under test: {@link WriteComponent#convertUserData(ArrayList)}
     */
    @Test
    void testConvertUserData2() {
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        userList.add(new User("foo", "foo"));
        assertEquals(18, WriteComponent.convertUserData(userList).size());
    }


    /**
     * Method under test: {@link WriteComponent#writeAdminDataToJSONPretty(String, String, ArrayList)}
     */
    @Test
    void testWriteAdminDataToJSONPretty() {
        WriteComponent.writeAdminDataToJSONPretty("admin-foo.txt", "test", new ArrayList<>());
    }

    /**
     * Method under test: {@link WriteComponent#writeSuperDataToJSONPretty(String, String, ArrayList)}
     */
    @Test
    void testWriteSuperDataToJSONPretty() {
        WriteComponent.writeSuperDataToJSONPretty("super-foo.txt", "test", new ArrayList<>());
    }

    /**
     * Method under test: {@link WriteComponent#writeActivityDataToJSONPretty(String, String, ArrayList)}
     */
    @Test
    void testWriteActivityDataToJSONPretty() {
        WriteComponent.writeActivityDataToJSONPretty("activity-foo.txt", "test", new ArrayList<>());
    }
}

