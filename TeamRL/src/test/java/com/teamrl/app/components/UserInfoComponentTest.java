package com.teamrl.app.components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UserInfoComponentTest {
    /**
     * Methods under test:
     *   {@link UserInfoComponent#UserInfoComponent()}
     *   {@link UserInfoComponent#setAdminFlag(boolean)}
     *   {@link UserInfoComponent#setDOB(String)}
     *   {@link UserInfoComponent#setEmail(String)}
     *   {@link UserInfoComponent#setEndYear(String)}
     *   {@link UserInfoComponent#setForename(String)}
     *   {@link UserInfoComponent#setFullname(String)}
     *   {@link UserInfoComponent#setPassword(String)}
     *   {@link UserInfoComponent#setStartYear(String)}
     *   {@link UserInfoComponent#setSuperFlag(boolean)}
     *   {@link UserInfoComponent#setSurname(String)}
     *   {@link UserInfoComponent#setUobNumber(String)}
     *   {@link UserInfoComponent#toString()}
     *   {@link UserInfoComponent#getDOB()}
     *   {@link UserInfoComponent#getEmail()}
     *   {@link UserInfoComponent#getEndYear()}
     *   {@link UserInfoComponent#getForename()}
     *   {@link UserInfoComponent#getFullname()}
     *   {@link UserInfoComponent#getPassword()}
     *   {@link UserInfoComponent#getStartYear()}
     *   {@link UserInfoComponent#getSurname()}
     *   {@link UserInfoComponent#getUobNumber()}
     *   {@link UserInfoComponent#isAdminFlag()}
     *   {@link UserInfoComponent#isSuperFlag()}
     */
    @Test
    void testConstructor() {
        UserInfoComponent actualUserInfoComponent = new UserInfoComponent();
        actualUserInfoComponent.setAdminFlag(true);
        actualUserInfoComponent.setDOB("DOB");
        actualUserInfoComponent.setEmail("jane.doe@example.org");
        actualUserInfoComponent.setEndYear("End Year");
        actualUserInfoComponent.setForename("Forename");
        actualUserInfoComponent.setFullname("Dr Jane Doe");
        actualUserInfoComponent.setPassword("iloveyou");
        actualUserInfoComponent.setStartYear("Start Year");
        actualUserInfoComponent.setSuperFlag(true);
        actualUserInfoComponent.setSurname("Doe");
        actualUserInfoComponent.setUobNumber("42");
        String actualToStringResult = actualUserInfoComponent.toString();
        assertEquals("DOB", actualUserInfoComponent.getDOB());
        assertEquals("jane.doe@example.org", actualUserInfoComponent.getEmail());
        assertEquals("End Year", actualUserInfoComponent.getEndYear());
        assertEquals("Forename", actualUserInfoComponent.getForename());
        assertEquals("Dr Jane Doe", actualUserInfoComponent.getFullname());
        assertEquals("iloveyou", actualUserInfoComponent.getPassword());
        assertEquals("Start Year", actualUserInfoComponent.getStartYear());
        assertEquals("Doe", actualUserInfoComponent.getSurname());
        assertEquals("42", actualUserInfoComponent.getUobNumber());
        assertTrue(actualUserInfoComponent.isAdminFlag());
        assertTrue(actualUserInfoComponent.isSuperFlag());
        assertEquals(
                "{\"surname\":\"Doe\", \"forename\": \"Forename\", \"uobNumber\":\"42\", \"email\":\"jane.doe@example.org\","
                        + " \"password\":\"iloveyou\", \"DOB\":\"DOB\", \"startYear\":\"Start Year\", \"endYear\":\"End Year\", \"adminFlag\":\"true\","
                        + " \"superFlag\":\"true\"}",
                actualToStringResult);
    }

    /**
     * Method under test: {@link UserInfoComponent#UserInfoComponent(String, String, String, String, String, String, String, String)}
     */
    @Test
    void testConstructor2() {
        UserInfoComponent actualUserInfoComponent = new UserInfoComponent("Doe", "Forename", "42", "jane.doe@example.org",
                "iloveyou", "Dob", "Start Year", "End Year");

        assertEquals("Dob", actualUserInfoComponent.getDOB());
        assertEquals("42", actualUserInfoComponent.getUobNumber());
        assertEquals("Doe", actualUserInfoComponent.getSurname());
        assertEquals("Start Year", actualUserInfoComponent.getStartYear());
        assertEquals("iloveyou", actualUserInfoComponent.getPassword());
        assertEquals("Forename Doe", actualUserInfoComponent.getFullname());
        assertEquals("Forename", actualUserInfoComponent.getForename());
        assertEquals("End Year", actualUserInfoComponent.getEndYear());
        assertEquals("jane.doe@example.org", actualUserInfoComponent.getEmail());
    }

    /**
     * Method under test: {@link UserInfoComponent#UserInfoComponent(String, String, String, String, String, String, String, String, boolean, boolean)}
     */
    @Test
    void testConstructor3() {
        UserInfoComponent actualUserInfoComponent = new UserInfoComponent("Doe", "Forename", "42", "jane.doe@example.org",
                "iloveyou", "Dob", "Start Year", "End Year", true, true);

        assertEquals("Dob", actualUserInfoComponent.getDOB());
        assertTrue(actualUserInfoComponent.isSuperFlag());
        assertTrue(actualUserInfoComponent.isAdminFlag());
        assertEquals("42", actualUserInfoComponent.getUobNumber());
        assertEquals("Doe", actualUserInfoComponent.getSurname());
        assertEquals("Start Year", actualUserInfoComponent.getStartYear());
        assertEquals("iloveyou", actualUserInfoComponent.getPassword());
        assertEquals("Forename Doe", actualUserInfoComponent.getFullname());
        assertEquals("Forename", actualUserInfoComponent.getForename());
        assertEquals("End Year", actualUserInfoComponent.getEndYear());
        assertEquals("jane.doe@example.org", actualUserInfoComponent.getEmail());
    }

    /**
     * Method under test: {@link UserInfoComponent#toCSV()}
     */
    @Test
    void testToCSV() {
        assertEquals("Doe,Forename,42,jane.doe@example.org,Dob,Start Year,End Year", (new UserInfoComponent("Doe",
                "Forename", "42", "jane.doe@example.org", "iloveyou", "Dob", "Start Year", "End Year")).toCSV());
    }
}

