package com.example.teamRl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setAdmin(Admin)}
     *   <li>{@link User#setAdminFlag(boolean)}
     *   <li>{@link User#setDOB(String)}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setEndYear(String)}
     *   <li>{@link User#setForename(String)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setStartYear(String)}
     *   <li>{@link User#setSuperFlag(boolean)}
     *   <li>{@link User#setSuperUser(SuperUser)}
     *   <li>{@link User#setSurname(String)}
     *   <li>{@link User#setUobNumber(String)}
     *   <li>{@link User#requestAdminRights()}
     *   <li>{@link User#getAdmin()}
     *   <li>{@link User#getAdminFlag()}
     *   <li>{@link User#getDOB()}
     *   <li>{@link User#getEmail()}
     *   <li>{@link User#getEndYear()}
     *   <li>{@link User#getForename()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getStartYear()}
     *   <li>{@link User#getSuperFlag()}
     *   <li>{@link User#getSuperUser()}
     *   <li>{@link User#getSurname()}
     *   <li>{@link User#getUobNumber()}
     * </ul>
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
     *
     * <ul>
     *   <li>{@link User#User(String, String)}
     *   <li>{@link User#setAdmin(Admin)}
     *   <li>{@link User#setAdminFlag(boolean)}
     *   <li>{@link User#setDOB(String)}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setEndYear(String)}
     *   <li>{@link User#setForename(String)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setStartYear(String)}
     *   <li>{@link User#setSuperFlag(boolean)}
     *   <li>{@link User#setSuperUser(SuperUser)}
     *   <li>{@link User#setSurname(String)}
     *   <li>{@link User#setUobNumber(String)}
     *   <li>{@link User#requestAdminRights()}
     *   <li>{@link User#getAdmin()}
     *   <li>{@link User#getAdminFlag()}
     *   <li>{@link User#getDOB()}
     *   <li>{@link User#getEmail()}
     *   <li>{@link User#getEndYear()}
     *   <li>{@link User#getForename()}
     *   <li>{@link User#getPassword()}
     *   <li>{@link User#getStartYear()}
     *   <li>{@link User#getSuperFlag()}
     *   <li>{@link User#getSuperUser()}
     *   <li>{@link User#getSurname()}
     *   <li>{@link User#getUobNumber()}
     * </ul>
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
    }
}

