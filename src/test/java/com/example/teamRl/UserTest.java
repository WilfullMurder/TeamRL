package com.example.teamRl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    /**
     * Methods under test:
     * <p>
     * {@link User#User()}
     * {@link User#setAdmin(Admin)}
     * {@link User#setAdminFlag(boolean)}
     * {@link User#setDOB(String)}
     * {@link User#setEmail(String)}
     * {@link User#setEndYear(String)}
     * {@link User#setForename(String)}
     * {@link User#setPassword(String)}
     * {@link User#setStartYear(String)}
     * {@link User#setSuperFlag(boolean)}
     * {@link User#setSuperUser(SuperUser)}
     * {@link User#setSurname(String)}
     * {@link User#setUobNumber(String)}
     * {@link User#requestAdminRights()}
     * {@link User#getAdmin()}
     * {@link User#getAdminFlag()}
     * {@link User#getDOB()}
     * {@link User#getEmail()}
     * {@link User#getEndYear()}
     * {@link User#getForename()}
     * {@link User#getPassword()}
     * {@link User#getStartYear()}
     * {@link User#getSuperFlag()}
     * {@link User#getSuperUser()}
     * {@link User#getSurname()}
     * {@link User#getUobNumber()}
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        Admin admin = new Admin();
        actualUser.setAdmin(admin);
        actualUser.setAdminFlag(true);
        actualUser.setDOB("DOB");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setEndYear("End Year");
        actualUser.setForename("Forename");
        actualUser.setPassword("iloveyou");
        actualUser.setStartYear("Start Year");
        actualUser.setSuperFlag(true);
        SuperUser superUser = new SuperUser();
        actualUser.setSuperUser(superUser);
        actualUser.setSurname("Doe");
        actualUser.setUobNumber("Ub");
        actualUser.requestAdminRights();
        assertSame(admin, actualUser.getAdmin());
        assertTrue(actualUser.getAdminFlag());
        assertEquals("DOB", actualUser.getDOB());
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("End Year", actualUser.getEndYear());
        assertEquals("Forename", actualUser.getForename());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("Start Year", actualUser.getStartYear());
        assertTrue(actualUser.getSuperFlag());
        assertSame(superUser, actualUser.getSuperUser());
        assertEquals("Doe", actualUser.getSurname());
        assertEquals("Ub", actualUser.getUobNumber());
    }

    /**
     * Methods under test:
     * <p>
     * {@link User#User(String, String)}
     * {@link User#setAdmin(Admin)}
     * {@link User#setAdminFlag(boolean)}
     * {@link User#setDOB(String)}
     * {@link User#setEmail(String)}
     * {@link User#setEndYear(String)}
     * {@link User#setForename(String)}
     * {@link User#setPassword(String)}
     * {@link User#setStartYear(String)}
     * {@link User#setSuperFlag(boolean)}
     * {@link User#setSuperUser(SuperUser)}
     * {@link User#setSurname(String)}
     * {@link User#setUobNumber(String)}
     * {@link User#requestAdminRights()}
     * {@link User#getAdmin()}
     * {@link User#getAdminFlag()}
     * {@link User#getDOB()}
     * {@link User#getEmail()}
     * {@link User#getEndYear()}
     * {@link User#getForename()}
     * {@link User#getPassword()}
     * {@link User#getStartYear()}
     * {@link User#getSuperFlag()}
     * {@link User#getSuperUser()}
     * {@link User#getSurname()}
     * {@link User#getUobNumber()}
     */
    @Test
    void testConstructor2() {
        User actualUser = new User("foo", "foo");
        Admin admin = new Admin();
        actualUser.setAdmin(admin);
        actualUser.setAdminFlag(true);
        actualUser.setDOB("DOB");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setEndYear("End Year");
        actualUser.setForename("Forename");
        actualUser.setPassword("iloveyou");
        actualUser.setStartYear("Start Year");
        actualUser.setSuperFlag(true);
        SuperUser superUser = new SuperUser();
        actualUser.setSuperUser(superUser);
        actualUser.setSurname("Doe");
        actualUser.setUobNumber("Ub");
        actualUser.requestAdminRights();
        assertSame(admin, actualUser.getAdmin());
        assertTrue(actualUser.getAdminFlag());
        assertEquals("DOB", actualUser.getDOB());
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("End Year", actualUser.getEndYear());
        assertEquals("Forename", actualUser.getForename());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("Start Year", actualUser.getStartYear());
        assertTrue(actualUser.getSuperFlag());
        assertSame(superUser, actualUser.getSuperUser());
        assertEquals("Doe", actualUser.getSurname());
        assertEquals("Ub", actualUser.getUobNumber());
    }

    /**
     * Method under test: {@link User#User(String, String, String, String, String, String, String)}
     */
    @Test
    void testConstructor3() {
        User actualUser = new User("Doe", "Forename", "42", "jane.doe@example.org", "DOB", "Start Year", "End Year");

        assertEquals("42", actualUser.getUobNumber());
        assertEquals("Doe", actualUser.getSurname());
        assertEquals("Start Year", actualUser.getStartYear());
        assertEquals("Forename", actualUser.getForename());
        assertEquals("End Year", actualUser.getEndYear());
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("DOB", actualUser.getDOB());
    }

    /**
     * Method under test: {@link User#User(String, String, String, String, String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor4() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.StringIndexOutOfBoundsException: begin 0, end 2, length 0
        //       at java.lang.String.checkBoundsBeginEnd(String.java:3319)
        //       at java.lang.String.substring(String.java:1874)
        //       at com.example.teamRl.User.checkForStaff(User.java:69)
        //       at com.example.teamRl.User.<init>(User.java:63)
        //   See https://diff.blue/R013 to resolve this issue.

        new User("Doe", "Forename", "", "jane.doe@example.org", "DOB", "Start Year", "End Year");

    }


    /**
     * Method under test: {@link User#toJSON()}
     */
    @Test
    void testToJSON() {
        assertEquals(
                "{\"surname\":\"null\", \"forename\": \"null\", \"uobNumber\":\"null\", \"email\":\"foo\", \"DOB\":\"null\", \"startYear\":\"null\","
                        + " \"endYear\":\"null\"}",
                (new User("foo", "foo")).toJSON());
    }

    /**
     * Method under test: {@link User#toCSV()}
     */
    @Test
    void testToCSV() {
        assertEquals("null,null,null", (new User("foo", "foo")).toCSV());
        assertEquals("null,null,null,foo,null,null,null", (new User("foo", "foo")).toCSV());
    }
}

