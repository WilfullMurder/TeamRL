package com.teamrl.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     * {@link User#User()}
     * {@link User#setAdmin(Admin)}
     * {@link User#setMyActivities(ArrayList)}
     * {@link User#setMyInfo(UserInfoComponent)}
     * {@link User#setSuperUser(SuperUser)}
     * {@link User#toString()}
     * {@link User#getAdmin()}
     * {@link User#getMyActivities()}
     * {@link User#getMyInfo()}
     * {@link User#getSuperUser()}
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        Admin admin = new Admin();
        actualUser.setAdmin(admin);
        ArrayList<String> stringList = new ArrayList<>();
        actualUser.setMyActivities(stringList);
        UserInfoComponent userInfoComponent = new UserInfoComponent("Doe", "Forename", "42", "jane.doe@example.org",
                "iloveyou", "Dob", "Start Year", "End Year");

        actualUser.setMyInfo(userInfoComponent);
        SuperUser superUser = new SuperUser();
        actualUser.setSuperUser(superUser);
        String actualToStringResult = actualUser.toString();
        assertSame(admin, actualUser.getAdmin());
        assertSame(stringList, actualUser.getMyActivities());
        assertSame(userInfoComponent, actualUser.getMyInfo());
        assertSame(superUser, actualUser.getSuperUser());
        assertEquals(
                "{\"surname\":\"Doe\", \"forename\": \"Forename\", \"uobNumber\":\"42\", \"email\":\"jane.doe@example.org\","
                        + " \"password\":\"iloveyou\", \"DOB\":\"Dob\", \"startYear\":\"Start Year\", \"endYear\":\"End Year\", \"adminFlag\":\"false\","
                        + " \"superFlag\":\"false\"}",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *   {@link User#User(UserInfoComponent)}
     *   {@link User#setAdmin(Admin)}
     *   {@link User#setMyActivities(ArrayList)}
     *   {@link User#setMyInfo(UserInfoComponent)}
     *   {@link User#setSuperUser(SuperUser)}
     *   {@link User#toString()}
     *   {@link User#getAdmin()}
     *   {@link User#getMyActivities()}
     *   {@link User#getMyInfo()}
     *   {@link User#getSuperUser()}
     */
    @Test
    void testConstructor2() {
        User actualUser = new User(new UserInfoComponent("Doe", "Forename", "42", "jane.doe@example.org", "iloveyou",
                "Dob", "Start Year", "End Year"));
        Admin admin = new Admin();
        actualUser.setAdmin(admin);
        ArrayList<String> stringList = new ArrayList<>();
        actualUser.setMyActivities(stringList);
        UserInfoComponent userInfoComponent = new UserInfoComponent("Doe", "Forename", "42", "jane.doe@example.org",
                "iloveyou", "Dob", "Start Year", "End Year");

        actualUser.setMyInfo(userInfoComponent);
        SuperUser superUser = new SuperUser();
        actualUser.setSuperUser(superUser);
        String actualToStringResult = actualUser.toString();
        assertSame(admin, actualUser.getAdmin());
        assertSame(stringList, actualUser.getMyActivities());
        assertSame(userInfoComponent, actualUser.getMyInfo());
        assertSame(superUser, actualUser.getSuperUser());
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
    void testConstructor3() {
        User actualUser = new User("foo", "foo");

        assertFalse(actualUser.isSuperFlag());
        UserInfoComponent myInfo = actualUser.getMyInfo();
        assertEquals("foo", myInfo.getPassword());
        assertEquals("foo", myInfo.getEmail());
    }

    /**
     * Method under test: {@link User#User(String, String, String, String, String, String, String, String)}
     */
    @Test
    void testConstructor4() {
        User actualUser = new User("Doe", "Forename", "42", "jane.doe@example.org", "iloveyou", "Dob", "Start Year",
                "End Year");

        assertFalse(actualUser.isSuperFlag());
        UserInfoComponent myInfo = actualUser.getMyInfo();
        assertEquals("iloveyou", myInfo.getPassword());
        assertEquals("Forename Doe", myInfo.getFullname());
        assertEquals("Forename", myInfo.getForename());
        assertEquals("End Year", myInfo.getEndYear());
        assertEquals("jane.doe@example.org", myInfo.getEmail());
        assertEquals("Dob", myInfo.getDOB());
        assertEquals("Doe", myInfo.getSurname());
        assertEquals("Start Year", myInfo.getStartYear());
        assertEquals("42", myInfo.getUobNumber());
    }

    /**
     * Method under test: {@link User#User(String, String, String, String, String, String, String, String, boolean, boolean)}
     */
    @Test
    void testConstructor5() {
        User actualUser = new User("Doe", "Forename", "42", "jane.doe@example.org", "iloveyou", "Dob", "Start Year",
                "End Year", true, true);

        assertTrue(actualUser.isSuperFlag());
        UserInfoComponent myInfo = actualUser.getMyInfo();
        assertEquals("iloveyou", myInfo.getPassword());
        assertEquals("Forename Doe", myInfo.getFullname());
        assertEquals("Forename", myInfo.getForename());
        assertEquals("End Year", myInfo.getEndYear());
        assertEquals("jane.doe@example.org", myInfo.getEmail());
        assertEquals("Dob", myInfo.getDOB());
        assertEquals("Doe", myInfo.getSurname());
        assertTrue(myInfo.isAdminFlag());
        assertTrue(myInfo.isSuperFlag());
        assertEquals("Start Year", myInfo.getStartYear());
        assertEquals("42", myInfo.getUobNumber());
    }

    /**
     * Method under test: {@link User#User(String, String, String, String, String, String, String, String, boolean, boolean)}
     */
    @Test
    void testConstructor6() {
        User actualUser = new User("foo", "foo", "foo", "foo", "foo", "foo", "foo", (String) "", false, false);

        assertFalse(actualUser.isSuperFlag());
        UserInfoComponent myInfo = actualUser.getMyInfo();
        assertEquals("foo", myInfo.getPassword());
        assertEquals("foo foo", myInfo.getFullname());
        assertEquals("foo", myInfo.getForename());
        assertEquals("", myInfo.getEndYear());
        assertEquals("foo", myInfo.getEmail());
        assertEquals("foo", myInfo.getDOB());
        assertEquals("foo", myInfo.getSurname());
        assertFalse(myInfo.isAdminFlag());
        assertFalse(myInfo.isSuperFlag());
        assertEquals("foo", myInfo.getStartYear());
        assertEquals("foo", myInfo.getUobNumber());
    }


    /**
     * Method under test: {@link User#getSurname()}
     */
    @Test
    void testGetSurname() {
        assertNull((new User("foo", "foo")).getSurname());
    }

    /**
     * Method under test: {@link User#setSurname(String)}
     */
    @Test
    void testSetSurname() {
        User user = new User("foo", "foo");
        user.setSurname("foo");
        assertEquals("foo", user.getMyInfo().getSurname());
    }



    /**
     * Method under test: {@link User#getForename()}
     */
    @Test
    void testGetForename() {
        assertNull((new User("foo", "foo")).getForename());
    }


    /**
     * Method under test: {@link User#setForename(String)}
     */
    @Test
    void testSetForename() {
        User user = new User("foo", "foo");
        user.setForename("foo");
        assertEquals("foo", user.getMyInfo().getForename());
    }

    /**
     * Method under test: {@link User#getFullname()}
     */
    @Test
    void testGetFullname() {
        assertNull((new User("foo", "foo")).getFullname());
    }

    /**
     * Method under test: {@link User#setFullname(String)}
     */
    @Test
    void testSetFullname() {
        User user = new User("foo", "foo");
        user.setFullname("foo");
        assertEquals("foo", user.getMyInfo().getFullname());
    }


    /**
     * Method under test: {@link User#getUobNumber()}
     */
    @Test
    void testGetUobNumber() {
        assertNull((new User("foo", "foo")).getUobNumber());
    }

    /**
     * Method under test: {@link User#setUobNumber(String)}
     */
    @Test
    void testSetUobNumber() {
        User user = new User("foo", "foo");
        user.setUobNumber("foo");
        assertEquals("foo", user.getMyInfo().getUobNumber());
    }


    /**
     * Method under test: {@link User#getEmail()}
     */
    @Test
    void testGetEmail() {
        assertEquals("foo", (new User("foo", "foo")).getEmail());
    }


    /**
     * Method under test: {@link User#setEmail(String)}
     */
    @Test
    void testSetEmail() {
        User user = new User("foo", "foo");
        user.setEmail("foo");
        assertEquals("foo", user.getMyInfo().getEmail());
    }


    /**
     * Method under test: {@link User#getPassword()}
     */
    @Test
    void testGetPassword() {
        assertEquals("foo", (new User("foo", "foo")).getPassword());
    }


    /**
     * Method under test: {@link User#setPassword(String)}
     */
    @Test
    void testSetPassword() {
        User user = new User("foo", "foo");
        user.setPassword("foo");
        assertEquals("foo", user.getMyInfo().getPassword());
    }


    /**
     * Method under test: {@link User#getDob()}
     */
    @Test
    void testGetDob() {
        assertNull((new User("foo", "foo")).getDob());
    }


    /**
     * Method under test: {@link User#setDob(String)}
     */
    @Test
    void testSetDob() {
        User user = new User("foo", "foo");
        user.setDob("foo");
        assertEquals("foo", user.getMyInfo().getDOB());
    }

    /**
     * Method under test: {@link User#getStartYear()}
     */
    @Test
    void testGetStartYear() {
        assertNull((new User("foo", "foo")).getStartYear());
    }

    /**
     * Method under test: {@link User#setStartYear(String)}
     */
    @Test
    void testSetStartYear() {
        User user = new User("foo", "foo");
        user.setStartYear("foo");
        assertEquals("foo", user.getMyInfo().getStartYear());
    }

    /**
     * Method under test: {@link User#getEndYear()}
     */
    @Test
    void testGetEndYear() {
        assertNull((new User("foo", "foo")).getEndYear());
    }

    /**
     * Method under test: {@link User#setEndYear(String)}
     */
    @Test
    void testSetEndYear() {
        User user = new User("foo", "foo");
        user.setEndYear("foo");
        assertEquals("foo", user.getMyInfo().getEndYear());
    }

    /**
     * Method under test: {@link User#isAdminFlag()}
     */
    @Test
    void testIsAdminFlag() {
        assertFalse((new User("foo", "foo")).isAdminFlag());
        assertTrue((new User("Doe", "Forename", "42", "jane.doe@example.org", "iloveyou", "Dob", "Start Year",
                "End Year", true, true)).isAdminFlag());
    }

    /**
     * Method under test: {@link User#setAdminFlag(boolean)}
     */
    @Test
    void testSetAdminFlag() {
        User user = new User("foo", "foo");
        user.setAdminFlag(true);
        assertTrue(user.getMyInfo().isAdminFlag());
    }

    /**
     * Method under test: {@link User#isSuperFlag()}
     */
    @Test
    void testIsSuperFlag() {
        assertFalse((new User("foo", "foo")).isSuperFlag());
        assertTrue((new User("Doe", "Forename", "42", "jane.doe@example.org", "iloveyou", "Dob", "Start Year",
                "End Year", true, true)).isSuperFlag());
    }

    /**
     * Method under test: {@link User#setSuperFlag(boolean)}
     */
    @Test
    void testSetSuperFlag() {
        User user = new User("foo", "foo");
        user.setSuperFlag(true);
        assertTrue(user.getMyInfo().isSuperFlag());
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

