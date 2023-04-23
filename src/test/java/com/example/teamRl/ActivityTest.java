package com.example.teamRl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class ActivityTest {
    /**
     * Methods under test:
     *   {@link Activity#Activity()}
     *   {@link Activity#setCategory(String)}
     *   {@link Activity#setCostPerSemester(String)}
     *   {@link Activity#setCostPerYear(String)}
     *   {@link Activity#setDescription(String[])}
     *   {@link Activity#setEmail(String)}
     *   {@link Activity#setEndTime(String)}
     *   {@link Activity#setExternal_links(String[])}
     *   {@link Activity#setLastMeetingDate(String)}
     *   {@link Activity#setMeetingLocation(String)}
     *   {@link Activity#setName(String)}
     *   {@link Activity#setNextMeetingDate(String)}
     *   {@link Activity#setPresident(User)}
     *   {@link Activity#setStartTime(String)}
     *   {@link Activity#getCategory()}
     *   {@link Activity#getCostPerSemester()}
     *   {@link Activity#getCostPerYear()}
     *   {@link Activity#getEmail()}
     *   {@link Activity#getEndTime()}
     *   {@link Activity#getLastMeetingDate()}
     *   {@link Activity#getMeetingLocation()}
     *   {@link Activity#getName()}
     *   {@link Activity#getNextMeetingDate()}
     *   {@link Activity#getPresident()}
     *   {@link Activity#getStartTime()}
     */
    @Test
    void testConstructor() {
        Activity actualActivity = new Activity();
        actualActivity.setCategory("Category");
        actualActivity.setCostPerSemester("Cost Per Semester");
        actualActivity.setCostPerYear("Cost Per Year");
        actualActivity.setDescription(new String[]{"The characteristics of someone or something"});
        actualActivity.setEmail("jane.doe@example.org");
        actualActivity.setEndTime("End Time");
        actualActivity.setExternal_links(new String[]{"External links"});
        actualActivity.setLastMeetingDate("2020-03-01");
        actualActivity.setMeetingLocation("Meeting Location");
        actualActivity.setName("Name");
        actualActivity.setNextMeetingDate("2020-03-01");
        User user = new User("foo", "foo");

        actualActivity.setPresident(user);
        actualActivity.setStartTime("Start Time");

        assertEquals("Category", actualActivity.getCategory());
        assertEquals("Cost Per Semester", actualActivity.getCostPerSemester());
        assertEquals("Cost Per Year", actualActivity.getCostPerYear());
        assertEquals("jane.doe@example.org", actualActivity.getEmail());
        assertEquals("End Time", actualActivity.getEndTime());
        assertEquals("2020-03-01", actualActivity.getLastMeetingDate());
        assertEquals("Meeting Location", actualActivity.getMeetingLocation());
        assertEquals("Name", actualActivity.getName());
        assertEquals("2020-03-01", actualActivity.getNextMeetingDate());
        assertSame(user, actualActivity.getPresident());
        assertEquals("Start Time", actualActivity.getStartTime());
    }

    /**
     * Methods under test:
     *   {@link Activity#Activity(String, String, String[], String, String, String, String, String[], String, String)}
     *   {@link Activity#setCategory(String)}
     *   {@link Activity#setCostPerSemester(String)}
     *   {@link Activity#setCostPerYear(String)}
     *   {@link Activity#setDescription(String[])}
     *   {@link Activity#setEmail(String)}
     *   {@link Activity#setEndTime(String)}
     *   {@link Activity#setExternal_links(String[])}
     *   {@link Activity#setLastMeetingDate(String)}
     *   {@link Activity#setMeetingLocation(String)}
     *   {@link Activity#setName(String)}
     *   {@link Activity#setNextMeetingDate(String)}
     *   {@link Activity#setPresident(User)}
     *   {@link Activity#setStartTime(String)}
     *   {@link Activity#getCategory()}
     *   {@link Activity#getCostPerSemester()}
     *   {@link Activity#getCostPerYear()}
     *   {@link Activity#getEmail()}
     *   {@link Activity#getEndTime()}
     *   {@link Activity#getLastMeetingDate()}
     *   {@link Activity#getMeetingLocation()}
     *   {@link Activity#getName()}
     *   {@link Activity#getNextMeetingDate()}
     *   {@link Activity#getPresident()}
     *   {@link Activity#getStartTime()}
     */
    @Test
    void testConstructor2() {
        Activity actualActivity = new Activity("Name", "Cat", new String[]{"The characteristics of someone or something"},
                "Mail", "foo", "foo", "Lmd", new String[]{"Links"}, "Cps", "Cpy");
        actualActivity.setCategory("Category");
        actualActivity.setCostPerSemester("Cost Per Semester");
        actualActivity.setCostPerYear("Cost Per Year");
        actualActivity.setDescription(new String[]{"The characteristics of someone or something"});
        actualActivity.setEmail("jane.doe@example.org");
        actualActivity.setEndTime("End Time");
        actualActivity.setExternal_links(new String[]{"External links"});
        actualActivity.setLastMeetingDate("2020-03-01");
        actualActivity.setMeetingLocation("Meeting Location");
        actualActivity.setName("Name");
        actualActivity.setNextMeetingDate("2020-03-01");
        User user = new User("foo", "foo");

        actualActivity.setPresident(user);
        actualActivity.setStartTime("Start Time");
        assertEquals("Category", actualActivity.getCategory());
        assertEquals("Cost Per Semester", actualActivity.getCostPerSemester());
        assertEquals("Cost Per Year", actualActivity.getCostPerYear());
        assertEquals("jane.doe@example.org", actualActivity.getEmail());
        assertEquals("End Time", actualActivity.getEndTime());
        assertEquals("2020-03-01", actualActivity.getLastMeetingDate());
        assertEquals("Meeting Location", actualActivity.getMeetingLocation());
        assertEquals("Name", actualActivity.getName());
        assertEquals("2020-03-01", actualActivity.getNextMeetingDate());
        assertSame(user, actualActivity.getPresident());
        assertEquals("Start Time", actualActivity.getStartTime());
    }
}

