package com.example.teamRl;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {
    /**
     * Methods under test:
     * default or parameterless constructor of {@link Admin}
     * {@link Admin#setMembers(ArrayList)}
     * {@link Admin#setMyActivity(Activity)}
     * {@link Admin#getMembers()}
     * {@link Admin#getMyActivity()}
     */
    @Test
    void testConstructor() {
        Admin actualAdmin = new Admin();
        ArrayList<User> userList = new ArrayList<>();
        actualAdmin.setMembers(userList);
        Activity activity = new Activity();
        actualAdmin.setMyActivity(activity);
        assertSame(userList, actualAdmin.getMembers());
        assertSame(activity, actualAdmin.getMyActivity());
    }

    /**
     * Methods under test:
     *   default or parameterless constructor of {@link Admin}
     *   {@link Admin#setMembers(ArrayList)}
     *   {@link Admin#setMyActivity(Activity)}
     *   {@link Admin#toString()}
     *   {@link Admin#getMembers()}
     *   {@link Admin#getMyActivity()}
     */
    @Test
    void testConstructor2() {
        Admin actualAdmin = new Admin();
        ArrayList<User> userList = new ArrayList<>();
        actualAdmin.setMembers(userList);
        Activity activity = new Activity();
        actualAdmin.setMyActivity(activity);
        actualAdmin.toString();
        assertSame(userList, actualAdmin.getMembers());
        assertSame(activity, actualAdmin.getMyActivity());
    }

    /**
     * Method under test: {@link Admin#getMember(int)}
     */
    @Test
    void testGetMember() {
        Admin admin = new Admin();
        admin.addMember(new User("foo", "foo"));
        User user = new User("foo", "foo");

        admin.addMember(user);
        assertSame(user, admin.getMember(1));
    }

    /**
     * Method under test: {@link Admin#getMember(String)}
     */
    @Test
    void testGetMember2() {
        assertNull((new Admin()).getMember("janedoe"));
    }


    /**
     * Method under test: {@link Admin#getMember(String)}
     */
    @Test
    void testGetMember3() {

        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("Aoe", "foo", "42", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Boe", "foo", "43", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Coe", "foo", "44", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Doe", "foo", "45", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Foe", "foo", "46", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Goe", "foo", "47", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Hoe", "foo", "48", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Joe", "foo", "49", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Koe", "foo", "50", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Loe", "foo", "51", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Moe", "foo", "52", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Noe", "foo", "53", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Ooe", "foo", "54", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Poe", "foo", "55", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Qoe", "foo", "56", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Roe", "foo", "57", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Soe", "foo", "58", "jane.doe@example.org", "foo", "foo", "foo"));
        userList.add(new User("Toe", "foo", "59", "jane.doe@example.org", "foo", "foo", "foo"));

        Admin admin = new Admin();
        admin.setMembers(userList);
        assertEquals(18, admin.getMembers().size());
    }

    /**
     * Method under test: {@link Admin#getMember(String)}
     */
    @Test
    void testGetMember4() {
        assertNull((new Admin()).getMember("Doe"));
    }

    /**
     * Method under test: {@link Admin#getMember(String)}
     */
    @Test
    void testGetMember5() {

        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("aoo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("boo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("coo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("doo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("eoo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("foo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("goo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("hoo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("joo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("loo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("moo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("noo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("ooo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("poo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("qoo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("roo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("soo", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));
        userList.add(new User("too", "foo", "215643", "mail@mail.com", "34678320", "3212", "4321"));;

        Admin admin = new Admin();
        admin.setMembers(userList);
        assertNotNull(admin.getMember("foo"));
    }




    /**
     * Method under test: {@link Admin#addMember(User)}
     */
    @Test
    void testAddMember() {
        Admin admin = new Admin();
        admin.addMember(new User("foo", "foo"));
        assertEquals(1, admin.getMembers().size());
    }
}

