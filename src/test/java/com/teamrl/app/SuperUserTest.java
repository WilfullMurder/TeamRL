package com.teamrl.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SuperUserTest {
    /**
     * Methods under test:
     *   {@link SuperUser#SuperUser()}
     *   {@link SuperUser#setActivitiesList(ArrayList)}
     *   {@link SuperUser#setAdminList(ArrayList)}
     *   {@link SuperUser#toString()}
     *   {@link SuperUser#getActivitiesList()}
     *   {@link SuperUser#getAdminList()}
     */
    @Test
    void testConstructor() {
        SuperUser actualSuperUser = new SuperUser();
        ArrayList<String> stringList = new ArrayList<>();
        actualSuperUser.setActivitiesList(stringList);
        ArrayList<String> stringList1 = new ArrayList<>();
        actualSuperUser.setAdminList(stringList1);
        String actualToStringResult = actualSuperUser.toString();
        ArrayList<String> activitiesList = actualSuperUser.getActivitiesList();
        assertSame(stringList, activitiesList);
        assertEquals(stringList1, activitiesList);
        ArrayList<String> adminList = actualSuperUser.getAdminList();
        assertSame(stringList1, adminList);
        assertEquals(activitiesList, adminList);
        assertEquals("\"adminList\":\"[]\", \"activitiesList\":\"[]\"", actualToStringResult);
    }

    /**
     * Methods under test:
     *   {@link SuperUser#SuperUser(ArrayList, ArrayList)}
     *   {@link SuperUser#setActivitiesList(ArrayList)}
     *   {@link SuperUser#setAdminList(ArrayList)}
     *   {@link SuperUser#toString()}
     *   {@link SuperUser#getActivitiesList()}
     *   {@link SuperUser#getAdminList()}
     */
    @Test
    void testConstructor2() {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<String> stringList1 = new ArrayList<>();
        SuperUser actualSuperUser = new SuperUser(stringList, stringList1);
        ArrayList<String> stringList2 = new ArrayList<>();
        actualSuperUser.setActivitiesList(stringList2);
        ArrayList<String> stringList3 = new ArrayList<>();
        actualSuperUser.setAdminList(stringList3);
        String actualToStringResult = actualSuperUser.toString();
        ArrayList<String> activitiesList = actualSuperUser.getActivitiesList();
        assertSame(stringList2, activitiesList);
        assertEquals(stringList, activitiesList);
        assertEquals(stringList1, activitiesList);
        assertEquals(stringList3, activitiesList);
        ArrayList<String> adminList = actualSuperUser.getAdminList();
        assertSame(stringList3, adminList);
        assertEquals(stringList, adminList);
        assertEquals(stringList1, adminList);
        assertEquals(activitiesList, adminList);
        assertEquals("\"adminList\":\"[]\", \"activitiesList\":\"[]\"", actualToStringResult);
    }
}

