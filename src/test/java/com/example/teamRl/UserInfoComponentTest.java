package com.example.teamRl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserInfoComponentTest {
    /**
     * Methods under test:
     *   {@link UserInfoComponent#UserInfoComponent()}
     *   {@link UserInfoComponent#setDOB(String)}
     *   {@link UserInfoComponent#setEmail(String)}
     *   {@link UserInfoComponent#setEndYear(String)}
     *   {@link UserInfoComponent#setForename(String)}
     *   {@link UserInfoComponent#setFullname(String)}
     *   {@link UserInfoComponent#setPassword(String)}
     *   {@link UserInfoComponent#setStartYear(String)}
     *   {@link UserInfoComponent#setSurname(String)}
     *   {@link UserInfoComponent#setUobNumber(String)}
     *   {@link UserInfoComponent#getDOB()}
     *   {@link UserInfoComponent#getEmail()}
     *   {@link UserInfoComponent#getEndYear()}
     *   {@link UserInfoComponent#getForename()}
     *   {@link UserInfoComponent#getFullname()}
     *   {@link UserInfoComponent#getPassword()}
     *   {@link UserInfoComponent#getStartYear()}
     *   {@link UserInfoComponent#getSurname()}
     *   {@link UserInfoComponent#getUobNumber()}
     */
    @Test
    void testConstructor() {
        UserInfoComponent actualUserInfoComponent = new UserInfoComponent();
        actualUserInfoComponent.setSurname("Doe");
        actualUserInfoComponent.setForename("Jane");
        actualUserInfoComponent.setFullname("Jane Doe");
        actualUserInfoComponent.setUobNumber("42");
        actualUserInfoComponent.setDOB("DOB");
        actualUserInfoComponent.setEmail("jane.doe@example.org");
        actualUserInfoComponent.setPassword("iloveyou");
        actualUserInfoComponent.setEndYear("End Year");
        actualUserInfoComponent.setStartYear("Start Year");

        assertEquals("Doe", actualUserInfoComponent.getSurname());
        assertEquals("Jane", actualUserInfoComponent.getForename());
        assertEquals("Jane Doe", actualUserInfoComponent.getFullname());
        assertEquals("42", actualUserInfoComponent.getUobNumber());
        assertEquals("DOB", actualUserInfoComponent.getDOB());
        assertEquals("jane.doe@example.org", actualUserInfoComponent.getEmail());
        assertEquals("iloveyou", actualUserInfoComponent.getPassword());
        assertEquals("Start Year", actualUserInfoComponent.getStartYear());
        assertEquals("End Year", actualUserInfoComponent.getEndYear());
    }

    /**
     * Method under test: {@link UserInfoComponent#UserInfoComponent(String, String, String, String, String, String, String, String)}
     */
    @Test
    void testConstructor2() {
        UserInfoComponent actualUserInfoComponent = new UserInfoComponent("Doe", "Jane", "42", "jane.doe@example.org",
                "iloveyou", "Dob", "Start Year", "End Year");

        assertEquals("Doe", actualUserInfoComponent.getSurname());
        assertEquals("Jane", actualUserInfoComponent.getForename());
        assertEquals("Jane Doe", actualUserInfoComponent.getFullname());
        assertEquals("Dob", actualUserInfoComponent.getDOB());
        assertEquals("42", actualUserInfoComponent.getUobNumber());
        assertEquals("jane.doe@example.org", actualUserInfoComponent.getEmail());
        assertEquals("iloveyou", actualUserInfoComponent.getPassword());
        assertEquals("Start Year", actualUserInfoComponent.getStartYear());
        assertEquals("End Year", actualUserInfoComponent.getEndYear());

    }

    /**
     * Method under test: {@link UserInfoComponent#toJSON()}
     */
    @Test
    void testToJSON() {
        assertEquals(
                "{\"surname\":\"Doe\", \"forename\": \"Forename\", \"uobNumber\":\"42\", \"email\":\"jane.doe@example.org\","
                        + " \"password\":\"iloveyou\", \"DOB\":\"Dob\", \"startYear\":\"Start Year\", \"endYear\":\"End Year\"}",
                (new UserInfoComponent("Doe", "Forename", "42", "jane.doe@example.org", "iloveyou", "Dob", "Start Year",
                        "End Year")).toJSON());
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

