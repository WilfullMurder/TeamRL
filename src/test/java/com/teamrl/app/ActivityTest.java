package com.teamrl.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ActivityTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Activity#Activity()}
     *   <li>{@link Activity#setCostPerSemester(double)}
     *   <li>{@link Activity#setCostPerYear(double)}
     *   <li>{@link Activity#setDescription(ArrayList)}
     *   <li>{@link Activity#setExternalLinks(ArrayList)}
     *   <li>{@link Activity#setLocation(String)}
     *   <li>{@link Activity#setMainContact(String)}
     *   <li>{@link Activity#setName(String)}
     *   <li>{@link Activity#getCostPerSemester()}
     *   <li>{@link Activity#getCostPerYear()}
     *   <li>{@link Activity#getDescription()}
     *   <li>{@link Activity#getExternalLinks()}
     *   <li>{@link Activity#getLocation()}
     *   <li>{@link Activity#getMainContact()}
     *   <li>{@link Activity#getName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Activity actualActivity = new Activity();
        actualActivity.setCostPerSemester(10.0d);
        actualActivity.setCostPerYear(10.0d);
        ArrayList<String> stringList = new ArrayList<>();
        actualActivity.setDescription(stringList);
        ArrayList<String> stringList1 = new ArrayList<>();
        actualActivity.setExternalLinks(stringList1);
        actualActivity.setLocation("Location");
        actualActivity.setMainContact("Main Contact");
        actualActivity.setName("Name");
        assertEquals(10.0d, actualActivity.getCostPerSemester());
        assertEquals(10.0d, actualActivity.getCostPerYear());
        ArrayList<String> description = actualActivity.getDescription();
        assertSame(stringList, description);
        ArrayList<String> externalLinks = actualActivity.getExternalLinks();
        assertEquals(externalLinks, description);
        assertSame(stringList1, externalLinks);
        assertEquals(stringList, externalLinks);
        assertEquals("Location", actualActivity.getLocation());
        assertEquals("Main Contact", actualActivity.getMainContact());
        assertEquals("Name", actualActivity.getName());
    }

    /**
     * Method under test: {@link Activity#Activity(String, ArrayList, String, String, double, double, ArrayList)}
     */
    @Test
    void testConstructor2() {
        ArrayList<String> stringList = new ArrayList<>();
        Activity actualActivity = new Activity("Nom", stringList, "Contact", "Loc", 10.0d, 10.0d, new ArrayList<>());

        assertEquals(10.0d, actualActivity.getCostPerSemester());
        assertEquals("Nom", actualActivity.getName());
        assertEquals("Contact", actualActivity.getMainContact());
        assertEquals("Loc", actualActivity.getLocation());
        ArrayList<String> externalLinks = actualActivity.getExternalLinks();
        assertEquals(stringList, externalLinks);
        assertEquals(externalLinks, actualActivity.getDescription());
        assertEquals(10.0d, actualActivity.getCostPerYear());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Activity#Activity()}
     *   <li>{@link Activity#setCostPerSemester(double)}
     *   <li>{@link Activity#setCostPerYear(double)}
     *   <li>{@link Activity#setDescription(ArrayList)}
     *   <li>{@link Activity#setExternalLinks(ArrayList)}
     *   <li>{@link Activity#setLocation(String)}
     *   <li>{@link Activity#setMainContact(String)}
     *   <li>{@link Activity#setName(String)}
     *   <li>{@link Activity#toString()}
     *   <li>{@link Activity#getCostPerSemester()}
     *   <li>{@link Activity#getCostPerYear()}
     *   <li>{@link Activity#getDescription()}
     *   <li>{@link Activity#getExternalLinks()}
     *   <li>{@link Activity#getLocation()}
     *   <li>{@link Activity#getMainContact()}
     *   <li>{@link Activity#getName()}
     * </ul>
     */
    @Test
    void testConstructor3() {
        Activity actualActivity = new Activity();
        actualActivity.setCostPerSemester(10.0d);
        actualActivity.setCostPerYear(10.0d);
        ArrayList<String> stringList = new ArrayList<>();
        actualActivity.setDescription(stringList);
        ArrayList<String> stringList1 = new ArrayList<>();
        actualActivity.setExternalLinks(stringList1);
        actualActivity.setLocation("Location");
        actualActivity.setMainContact("Main Contact");
        actualActivity.setName("Name");
        String actualToStringResult = actualActivity.toString();
        assertEquals(10.0d, actualActivity.getCostPerSemester());
        assertEquals(10.0d, actualActivity.getCostPerYear());
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
                        + "\":\"10.0\", \"costPerYear\":\"10.0\", \"extrenalLinks\":\"[]\"}",
                actualToStringResult);
    }
}

