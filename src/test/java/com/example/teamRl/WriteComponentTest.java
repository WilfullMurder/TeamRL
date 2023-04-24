package com.example.teamRl;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class WriteComponentTest {
    /**
     * Method under test: {@link WriteComponent#writeUserDataToJSON(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToJSON() {

        WriteComponent writeComponent = new WriteComponent();
        writeComponent.writeUserDataToJSON("JSONtest.txt", "test", new ArrayList<>());
    }

    /**
     * Method under test: {@link WriteComponent#writeUserDataToJSON(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToJSON2() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("mail@mail", "3276482367945"));
        ArrayList<UserInfoComponent> data = new ArrayList<>();
        data.add(users.get(0).getMyInfo());
        WriteComponent writeComponent = new WriteComponent();
        writeComponent.writeUserDataToJSON("JSONtest2.txt", "test", data);
    }


    /**
     * Method under test: {@link WriteComponent#writeUserDataToJSONPretty(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToJSONPretty() {

        WriteComponent writeComponent = new WriteComponent();
        writeComponent.writeUserDataToJSONPretty("PrettyTest.txt", "test", new ArrayList<>());
    }
    /**
     * Method under test: {@link WriteComponent#writeUserDataToJSONPretty(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToJSONPretty2() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("mail@mail", "3276482367945"));
        WriteComponent writeComponent = new WriteComponent();
        writeComponent.writeUserDataToJSONPretty("PrettyTest2.txt", "test", users);
    }

    /**
     * Method under test: {@link WriteComponent#writeUserDataToCSV(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToCSV() {

        WriteComponent writeComponent = new WriteComponent();
        writeComponent.writeUserDataToCSV("csvtest.txt", "test", new ArrayList<>());
    }
    /**
     * Method under test: {@link WriteComponent#writeUserDataToCSV(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToCSV2() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("mail@mail", "3276482367945"));
        WriteComponent writeComponent = new WriteComponent();
        writeComponent.writeUserDataToCSV("csvtest2.txt", "test", users);
    }

    /**
     * Method under test: {@link WriteComponent#writeAdminDataToJSON(String, String, ArrayList)}
     */
    @Test
    void testWriteAdminDataToJSON() {

        WriteComponent writeComponent = new WriteComponent();
        writeComponent.writeAdminDataToJSON("admintest.txt", "test", new ArrayList<>());
    }
    /**
     * Method under test: {@link WriteComponent#writeAdminDataToJSON(String, String, ArrayList)}
     */
    @Test
    void testWriteAdminDataToJSON2() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("mail@mail", "3276482367945"));
        WriteComponent writeComponent = new WriteComponent();
        writeComponent.writeAdminDataToJSON("admintest2.txt", "test", users);
    }

    /**
     * Method under test: {@link WriteComponent#writeAdminDataToJSONPretty(String, String, ArrayList)}
     */
    @Test
    void testWriteAdminDataToJSONPretty() {

        WriteComponent writeComponent = new WriteComponent();
        writeComponent.writeAdminDataToJSONPretty("PrettyAdminTest.txt", "test", new ArrayList<>());
    }
    /**
     * Method under test: {@link WriteComponent#writeAdminDataToJSONPretty(String, String, ArrayList)}
     */
    @Test
    void testWriteAdminDataToJSONPretty2() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("mail@mail", "3276482367945"));
        WriteComponent writeComponent = new WriteComponent();
        writeComponent.writeAdminDataToJSONPretty("PrettyAdminTest.txt", "test", users);
    }
}

