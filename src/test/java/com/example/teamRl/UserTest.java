package com.example.teamRl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setAdmin(User.Admin)}
     *   <li>{@link User#setAdminFlag(boolean)}
     *   <li>{@link User#setDOB(String)}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setEndYear(String)}
     *   <li>{@link User#setForename(String)}
     *   <li>{@link User#setStartYear(String)}
     *   <li>{@link User#setSuperFlag(boolean)}
     *   <li>{@link User#setSurname(String)}
     *   <li>{@link User#requestAdminRights()}
     *   <li>{@link User#getAdminFlag()}
     *   <li>{@link User#getDOB()}
     *   <li>{@link User#getEmail()}
     *   <li>{@link User#getEndYear()}
     *   <li>{@link User#getForename()}
     *   <li>{@link User#getStartYear()}
     *   <li>{@link User#getSuperFlag()}
     *   <li>{@link User#getSurname()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setAdmin(null);
        actualUser.setAdminFlag(true);
        actualUser.setDOB("DOB");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setEndYear("End Year");
        actualUser.setForename("Forename");
        actualUser.setStartYear("Start Year");
        actualUser.setSuperFlag(true);
        actualUser.setSurname("Doe");
        actualUser.requestAdminRights();
        assertTrue(actualUser.getAdminFlag());
        assertEquals("DOB", actualUser.getDOB());
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("End Year", actualUser.getEndYear());
        assertEquals("Forename", actualUser.getForename());
        assertEquals("Start Year", actualUser.getStartYear());
        assertTrue(actualUser.getSuperFlag());
        assertEquals("Doe", actualUser.getSurname());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User(String, String, String, String, String)}
     *   <li>{@link User#setAdmin(User.Admin)}
     *   <li>{@link User#setAdminFlag(boolean)}
     *   <li>{@link User#setDOB(String)}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setEndYear(String)}
     *   <li>{@link User#setForename(String)}
     *   <li>{@link User#setStartYear(String)}
     *   <li>{@link User#setSuperFlag(boolean)}
     *   <li>{@link User#setSurname(String)}
     *   <li>{@link User#requestAdminRights()}
     *   <li>{@link User#getAdminFlag()}
     *   <li>{@link User#getDOB()}
     *   <li>{@link User#getEmail()}
     *   <li>{@link User#getEndYear()}
     *   <li>{@link User#getForename()}
     *   <li>{@link User#getStartYear()}
     *   <li>{@link User#getSuperFlag()}
     *   <li>{@link User#getSurname()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        User actualUser = new User("foo", "foo", "foo", "foo", "foo");
        actualUser.setAdmin(null);
        actualUser.setAdminFlag(true);
        actualUser.setDOB("DOB");
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setEndYear("End Year");
        actualUser.setForename("Forename");
        actualUser.setStartYear("Start Year");
        actualUser.setSuperFlag(true);
        actualUser.setSurname("Doe");
        actualUser.requestAdminRights();
        assertTrue(actualUser.getAdminFlag());
        assertEquals("DOB", actualUser.getDOB());
        assertEquals("jane.doe@example.org", actualUser.getEmail());
        assertEquals("End Year", actualUser.getEndYear());
        assertEquals("Forename", actualUser.getForename());
        assertEquals("Start Year", actualUser.getStartYear());
        assertTrue(actualUser.getSuperFlag());
        assertEquals("Doe", actualUser.getSurname());
    }

    /**
     * Method under test: {@link User#User(String, String, String, String, String, String, String)}
     */
    @Test
    void testConstructor3() {
        User actualUser = new User("Doe", "Forename", "42", "jane.doe@example.org", "DOB", "Start Year", "End Year");

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
    void testConstructor4() {
        new User("Doe", "Forename", "12345678", "jane.doe@example.org", "DOB", "Start Year", "End Year");

    }

    /**
     * Method under test: {@link User#toJSON()}
     */
    @Test
    void testToJSON() {
        assertEquals(
                "\"foo\" :{\"forename\": \"foo\", \"uobNumber\":\"foo\", \"email\":\"foo\", \"DOB\":\"foo\", \"startYear\":\"null\","
                        + " \"endYear\":\"null\"}",
                (new User("foo", "foo", "foo", "foo", "foo")).toJSON());
    }

    /**
     * Method under test: {@link User#toCSV()}
     */
    @Test
    void testToCSV() {
        assertEquals("foo,foo,foo", (new User("foo", "foo", "foo", "foo", "foo")).toCSV());
    }
}

