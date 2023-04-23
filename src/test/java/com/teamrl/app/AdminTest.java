package com.teamrl.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AdminTest {
    /**
     * Methods under test:
     *   {@link Admin#Admin()}
     *   {@link Admin#setBannedList(ArrayList)}
     *   {@link Admin#setMyActivity(String)}
     *   {@link Admin#setMyActivityMembers(ArrayList)}
     *   {@link Admin#toString()}
     *   {@link Admin#getBannedList()}
     *   {@link Admin#getMyActivity()}
     *   {@link Admin#getMyActivityMembers()}
     */
    @Test
    void testConstructor() {
        Admin actualAdmin = new Admin();
        ArrayList<String> stringList = new ArrayList<>();
        actualAdmin.setBannedList(stringList);
        actualAdmin.setMyActivity("My Activity");
        ArrayList<String> stringList1 = new ArrayList<>();
        actualAdmin.setMyActivityMembers(stringList1);
        String actualToStringResult = actualAdmin.toString();
        ArrayList<String> bannedList = actualAdmin.getBannedList();
        assertSame(stringList, bannedList);
        assertEquals(stringList1, bannedList);
        assertEquals("My Activity", actualAdmin.getMyActivity());
        ArrayList<String> myActivityMembers = actualAdmin.getMyActivityMembers();
        assertSame(stringList1, myActivityMembers);
        assertEquals(bannedList, myActivityMembers);
        assertEquals("{\"myActivity\":\"My Activity\", \"myActivityMembers\":\"[]\", \"bannedList\":\"[]\"}",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *   {@link Admin#Admin(String, ArrayList)}
     *   {@link Admin#setBannedList(ArrayList)}
     *   {@link Admin#setMyActivity(String)}
     *   {@link Admin#setMyActivityMembers(ArrayList)}
     *   {@link Admin#toString()}
     *   {@link Admin#getBannedList()}
     *   {@link Admin#getMyActivity()}
     *   {@link Admin#getMyActivityMembers()}
     */
    @Test
    void testConstructor2() {
        ArrayList<String> stringList = new ArrayList<>();
        Admin actualAdmin = new Admin("foo", stringList);
        ArrayList<String> stringList1 = new ArrayList<>();
        actualAdmin.setBannedList(stringList1);
        actualAdmin.setMyActivity("My Activity");
        ArrayList<String> stringList2 = new ArrayList<>();
        actualAdmin.setMyActivityMembers(stringList2);
        String actualToStringResult = actualAdmin.toString();
        ArrayList<String> bannedList = actualAdmin.getBannedList();
        assertSame(stringList1, bannedList);
        assertEquals(stringList, bannedList);
        assertEquals(stringList2, bannedList);
        assertEquals("My Activity", actualAdmin.getMyActivity());
        ArrayList<String> myActivityMembers = actualAdmin.getMyActivityMembers();
        assertSame(stringList2, myActivityMembers);
        assertEquals(stringList, myActivityMembers);
        assertEquals(bannedList, myActivityMembers);
        assertEquals("{\"myActivity\":\"My Activity\", \"myActivityMembers\":\"[]\", \"bannedList\":\"[]\"}",
                actualToStringResult);
    }

    /**
     * Methods under test:
     *   {@link Admin#Admin(String, ArrayList, ArrayList)}
     *   {@link Admin#setBannedList(ArrayList)}
     *   {@link Admin#setMyActivity(String)}
     *   {@link Admin#setMyActivityMembers(ArrayList)}
     *   {@link Admin#toString()}
     *   {@link Admin#getBannedList()}
     *   {@link Admin#getMyActivity()}
     *   {@link Admin#getMyActivityMembers()}
     */
    @Test
    void testConstructor3() {
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<String> stringList1 = new ArrayList<>();
        Admin actualAdmin = new Admin("foo", stringList, stringList1);
        ArrayList<String> stringList2 = new ArrayList<>();
        actualAdmin.setBannedList(stringList2);
        actualAdmin.setMyActivity("My Activity");
        ArrayList<String> stringList3 = new ArrayList<>();
        actualAdmin.setMyActivityMembers(stringList3);
        String actualToStringResult = actualAdmin.toString();
        ArrayList<String> bannedList = actualAdmin.getBannedList();
        assertSame(stringList2, bannedList);
        assertEquals(stringList, bannedList);
        assertEquals(stringList1, bannedList);
        assertEquals(stringList3, bannedList);
        assertEquals("My Activity", actualAdmin.getMyActivity());
        ArrayList<String> myActivityMembers = actualAdmin.getMyActivityMembers();
        assertSame(stringList3, myActivityMembers);
        assertEquals(stringList, myActivityMembers);
        assertEquals(stringList1, myActivityMembers);
        assertEquals(bannedList, myActivityMembers);
        assertEquals("{\"myActivity\":\"My Activity\", \"myActivityMembers\":\"[]\", \"bannedList\":\"[]\"}",
                actualToStringResult);
    }

    /**
     * Method under test: {@link Admin#addNewMember(String)}
     */
    @Test
    void testAddNewMember() {
        Admin admin = new Admin();
        admin.addNewMember("foo");
        ArrayList<String> myActivityMembers = admin.getMyActivityMembers();
        assertEquals(1, myActivityMembers.size());
        assertEquals("foo", myActivityMembers.get(0));
    }

    /**
     * Method under test: {@link Admin#addNewMember(String)}
     */
    @Test
    void testAddNewMember2() {
        Admin admin = new Admin();
        admin.addNewMember("foo");
        admin.addNewMember("foo");
        assertTrue(admin.getBannedList().isEmpty());
        assertEquals(1, admin.getMyActivityMembers().size());
        assertEquals("", admin.getMyActivity());
    }

    /**
     * Method under test: {@link Admin#removeMember(String, boolean)}
     */
    @Test
    void testRemoveMember() {
        Admin admin = new Admin();
        admin.removeMember("foo", true);
        ArrayList<String> bannedList = admin.getBannedList();
        assertEquals(1, bannedList.size());
        assertEquals("foo", bannedList.get(0));
    }

    /**
     * Method under test: {@link Admin#removeMember(String, boolean)}
     */
    @Test
    void testRemoveMember2() {
        Admin admin = new Admin();
        admin.removeMember("foo", false);
        ArrayList<String> bannedList = admin.getBannedList();
        assertTrue(bannedList.isEmpty());
        assertEquals(bannedList, admin.getMyActivityMembers());
        assertEquals("", admin.getMyActivity());
    }

    /**
     * Method under test: {@link Admin#removeMember(String, boolean)}
     */
    @Test
    void testRemoveMember3() {
        Admin admin = new Admin();
        admin.addNewMember("foo");
        admin.removeMember("foo", true);
        ArrayList<String> bannedList = admin.getBannedList();
        assertEquals(1, bannedList.size());
        assertEquals("foo", bannedList.get(0));
        assertTrue(admin.getMyActivityMembers().isEmpty());
    }
}

