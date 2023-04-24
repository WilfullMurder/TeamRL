package com.teamrl.app.components;

import com.teamrl.app.User;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WriteComponentTest {
    /**
     * Method under test: {@link WriteComponent#writeUserDataToFile(String, String, ArrayList)}
     */
    @Test
    @Disabled("DEPRECATED")
    void testWriteUserDataToFile() {
        WriteComponent.writeUserDataToFile("foo.txt", "Key Folder", new ArrayList<>());
    }

    /**
     * Method under test: {@link WriteComponent#writeUserDataToJSON(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToJSON() {
        WriteComponent.writeUserDataToJSON("json-foo.txt", "test", new ArrayList<>());
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
        WriteComponent.writeUserDataToJSON("json-foo-2.txt", "test", userList);
    }

    /**
     * Method under test: {@link WriteComponent#writeUserDataToJSON(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToJSON3() {
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        WriteComponent.writeUserDataToJSON("json-foobar.txt", "test", userList);
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
        WriteComponent.writeUserDataToJSONPretty("pretty-foo-2.txt", "test", userList);
    }

    /**
     * Method under test: {@link WriteComponent#writeUserDataToJSONPretty(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToJSONPretty3() {
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        WriteComponent.writeUserDataToJSONPretty("pretty-foobar.txt", "test", userList);
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
        WriteComponent.writeUserDataToCSV("csv-foo-2.txt", "test", userList);
    }

    /**
     * Method under test: {@link WriteComponent#writeUserDataToCSV(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToCSV3() {
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        userList.add(new User("foo", "bar", "foo", "bar", "foo", "bar", "foo", "bar"));
        WriteComponent.writeUserDataToCSV("csv-foobar.txt", "test", userList);
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
     * Method under test: {@link WriteComponent#convertUserData(ArrayList)}
     */
    @Test
    void testConvertUserData3() {

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
        WriteComponent.convertUserData(userList);
        assertEquals("foo", userList.get(0).getMyInfo().getPassword());

    }

    /**
     * Method under test: {@link WriteComponent#writeAdminDataToJSONPretty(String, String, ArrayList)}
     */
    @Test
    void testWriteAdminDataToJSONPretty() {

        WriteComponent.writeAdminDataToJSONPretty("admin-foo.txt", "test", new ArrayList<>());
    }
}

