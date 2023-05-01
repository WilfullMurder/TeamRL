package com.teamrl.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ActivityTest {
    /**
     * Methods under test:
     *   {@link Activity#Activity()}
     *   {@link Activity#setCostPerSemester(String)}
     *   {@link Activity#setCostPerYear(String)}
     *   {@link Activity#setDescription(ArrayList)}
     *   {@link Activity#setExternalLinks(ArrayList)}
     *   {@link Activity#setLocation(String)}
     *   {@link Activity#setMainContact(String)}
     *   {@link Activity#setName(String)}
     *   {@link Activity#toString()}
     *   {@link Activity#getCostPerSemester()}
     *   {@link Activity#getCostPerYear()}
     *   {@link Activity#getDescription()}
     *   {@link Activity#getExternalLinks()}
     *   {@link Activity#getLocation()}
     *   {@link Activity#getMainContact()}
     *   {@link Activity#getName()}
     */
    @Test
    void testConstructor() {
        Activity actualActivity = new Activity();
        actualActivity.setCostPerSemester("Cost Per Semester");
        actualActivity.setCostPerYear("Cost Per Year");
        ArrayList<String> stringList = new ArrayList<>();
        actualActivity.setDescription(stringList);
        ArrayList<String> stringList1 = new ArrayList<>();
        actualActivity.setExternalLinks(stringList1);
        actualActivity.setLocation("Location");
        actualActivity.setMainContact("Main Contact");
        actualActivity.setName("Name");
        String actualToStringResult = actualActivity.toString();
        assertEquals("Cost Per Semester", actualActivity.getCostPerSemester());
        assertEquals("Cost Per Year", actualActivity.getCostPerYear());
        ArrayList<String> description = actualActivity.getDescription();
        assertSame(stringList, description);
        ArrayList<String> externalLinks = actualActivity.getExternalLinks();
        assertEquals(externalLinks, description);
        assertSame(stringList1, externalLinks);
        assertEquals(stringList, externalLinks);
        assertEquals("Location", actualActivity.getLocation());
        assertEquals("Main Contact", actualActivity.getMainContact());
        assertEquals("Name", actualActivity.getName());
        assertEquals(
                "{\"name\":\"Name\", \"description\": \"[]\", \"mainContact\":\"Main Contact\", \"location\":\"Location\", \"costPerSemester"
                        + "\":\"Cost Per Semester\", \"costPerYear\":\"Cost Per Year\", \"externalLinks\":\"[]\"}",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *   {@link Activity#Activity(String, ArrayList, String, String, String, String, ArrayList)}
     *   {@link Activity#setCostPerSemester(String)}
     *   {@link Activity#setCostPerYear(String)}
     *   {@link Activity#setDescription(ArrayList)}
     *   {@link Activity#setExternalLinks(ArrayList)}
     *   {@link Activity#setLocation(String)}
     *   {@link Activity#setMainContact(String)}
     *   {@link Activity#setName(String)}
     *   {@link Activity#toString()}
     *   {@link Activity#getCostPerSemester()}
     *   {@link Activity#getCostPerYear()}
     *   {@link Activity#getDescription()}
     *   {@link Activity#getExternalLinks()}
     *   {@link Activity#getLocation()}
     *   {@link Activity#getMainContact()}
     *   {@link Activity#getName()}
     */
    @Test
    void testConstructor2() {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<String> stringList1 = new ArrayList<>();
        Activity actualActivity = new Activity("Nom", stringList, "Contact", "Loc", "Cps", "Cpy", stringList1);
        actualActivity.setCostPerSemester("Cost Per Semester");
        actualActivity.setCostPerYear("Cost Per Year");
        ArrayList<String> stringList2 = new ArrayList<>();
        actualActivity.setDescription(stringList2);
        ArrayList<String> stringList3 = new ArrayList<>();
        actualActivity.setExternalLinks(stringList3);
        actualActivity.setLocation("Location");
        actualActivity.setMainContact("Main Contact");
        actualActivity.setName("Name");
        String actualToStringResult = actualActivity.toString();
        assertEquals("Cost Per Semester", actualActivity.getCostPerSemester());
        assertEquals("Cost Per Year", actualActivity.getCostPerYear());
        ArrayList<String> description = actualActivity.getDescription();
        assertSame(stringList2, description);
        assertEquals(stringList, description);
        assertEquals(stringList1, description);
        ArrayList<String> externalLinks = actualActivity.getExternalLinks();
        assertEquals(externalLinks, description);
        assertSame(stringList3, externalLinks);
        assertEquals(stringList, externalLinks);
        assertEquals(stringList1, externalLinks);
        assertEquals(stringList2, externalLinks);
        assertEquals("Location", actualActivity.getLocation());
        assertEquals("Main Contact", actualActivity.getMainContact());
        assertEquals("Name", actualActivity.getName());
        assertEquals(
                "{\"name\":\"Name\", \"description\": \"[]\", \"mainContact\":\"Main Contact\", \"location\":\"Location\", \"costPerSemester"
                        + "\":\"Cost Per Semester\", \"costPerYear\":\"Cost Per Year\", \"externalLinks\":\"[]\"}",
                actualToStringResult);
    }
}

