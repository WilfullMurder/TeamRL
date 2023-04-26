package com.teamrl.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.teamrl.app.components.UserInfoComponent;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     *   {@link User#User()}
     *   {@link User#setMyActivities(ArrayList)}
     *   {@link User#setMyInfo(UserInfoComponent)}
     *   {@link User#toString()}
     *   {@link User#getMyActivities()}
     *   {@link User#getMyInfo()}
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        ArrayList<String> stringList = new ArrayList<>();
        actualUser.setMyActivities(stringList);
        UserInfoComponent userInfoComponent = new UserInfoComponent("Doe", "Forename", "42", "jane.doe@example.org",
                "iloveyou", "Dob", "Start Year", "End Year");

        actualUser.setMyInfo(userInfoComponent);
        String actualToStringResult = actualUser.toString();
        assertSame(stringList, actualUser.getMyActivities());
        assertSame(userInfoComponent, actualUser.getMyInfo());
        assertEquals(
                "{\"surname\":\"Doe\", \"forename\": \"Forename\", \"uobNumber\":\"42\", \"email\":\"jane.doe@example.org\","
                        + " \"password\":\"iloveyou\", \"DOB\":\"Dob\", \"startYear\":\"Start Year\", \"endYear\":\"End Year\", \"adminFlag\":\"false\","
                        + " \"superFlag\":\"false\"}",
                actualToStringResult);
    }

    /**
     * Method under test: {@link User#User(String, String)}
     */
    @Test
    void testConstructor2() {
        User actualUser = new User("foo", "foo");

        assertEquals("null,null,null,foo,null,null,null", actualUser.toCSV());
        UserInfoComponent myInfo = actualUser.getMyInfo();
        assertEquals("foo", myInfo.getPassword());
        assertEquals("foo", myInfo.getEmail());
    }

    /**
     * Method under test: {@link User#User(String, String, String, String, String, String, String, String)}
     */
    @Test
    void testConstructor3() {
        User actualUser = new User("Doe", "Forename", "42", "jane.doe@example.org", "iloveyou", "Dob", "Start Year",
                "End Year");

        assertEquals("Doe,Forename,42,jane.doe@example.org,Dob,Start Year,End Year", actualUser.toCSV());
        UserInfoComponent myInfo = actualUser.getMyInfo();
        assertEquals("Dob", myInfo.getDOB());
        assertEquals("42", myInfo.getUobNumber());
        assertEquals("Doe", myInfo.getSurname());
        assertEquals("Start Year", myInfo.getStartYear());
        assertEquals("iloveyou", myInfo.getPassword());
        assertEquals("Forename Doe", myInfo.getFullname());
        assertEquals("Forename", myInfo.getForename());
        assertEquals("End Year", myInfo.getEndYear());
        assertEquals("jane.doe@example.org", myInfo.getEmail());
    }

    /**
     * Method under test: {@link User#User(String, String, String, String, String, String, String, String, boolean, boolean)}
     */
    @Test
    void testConstructor4() {
        User actualUser = new User("Doe", "Forename", "42", "jane.doe@example.org", "iloveyou", "Dob", "Start Year",
                "End Year", true, true);

        assertEquals("Doe,Forename,42,jane.doe@example.org,Dob,Start Year,End Year", actualUser.toCSV());
        UserInfoComponent myInfo = actualUser.getMyInfo();
        assertEquals("Dob", myInfo.getDOB());
        assertTrue(myInfo.isSuperFlag());
        assertTrue(myInfo.isAdminFlag());
        assertEquals("42", myInfo.getUobNumber());
        assertEquals("Doe", myInfo.getSurname());
        assertEquals("Start Year", myInfo.getStartYear());
        assertEquals("iloveyou", myInfo.getPassword());
        assertEquals("Forename Doe", myInfo.getFullname());
        assertEquals("Forename", myInfo.getForename());
        assertEquals("End Year", myInfo.getEndYear());
        assertEquals("jane.doe@example.org", myInfo.getEmail());
    }

    /**
     * Method under test: {@link User#User(String, String, String, String, String, String, String, String, boolean, boolean)}
     */
    @Test
    void testConstructor5() {
        User actualUser = new User("foo", "foo", "foo", "foo", "foo", "foo", "foo", (String) "", false, false);

        assertEquals("foo,foo,foo,foo,foo,foo,", actualUser.toCSV());
        UserInfoComponent myInfo = actualUser.getMyInfo();
        assertEquals("foo", myInfo.getDOB());
        assertFalse(myInfo.isSuperFlag());
        assertFalse(myInfo.isAdminFlag());
        assertEquals("foo", myInfo.getUobNumber());
        assertEquals("foo", myInfo.getSurname());
        assertEquals("foo", myInfo.getStartYear());
        assertEquals("foo", myInfo.getPassword());
        assertEquals("foo foo", myInfo.getFullname());
        assertEquals("foo", myInfo.getForename());
        assertEquals("", myInfo.getEndYear());
        assertEquals("foo", myInfo.getEmail());
    }

    /**
     * Method under test: {@link User#toJSON()}
     */
    @Test
    void testToJSON() {
        assertEquals(
                "{\"surname\":\"null\", \"forename\": \"null\", \"uobNumber\":\"null\", \"email\":\"foo\", \"password\":\"foo\", \"DOB\":\"null\","
                        + " \"startYear\":\"null\", \"endYear\":\"null\", \"adminFlag\":\"false\", \"superFlag\":\"false\"}",
                (new User("foo", "foo")).toJSON());
    }


    /**
     * Method under test: {@link User#toCSV()}
     */
    @Test
    void testToCSV() {
        assertEquals("null,null,null,foo,null,null,null", (new User("foo", "foo")).toCSV());
    }

}

