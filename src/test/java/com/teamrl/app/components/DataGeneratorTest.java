package com.teamrl.app.components;

import com.teamrl.app.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DataGeneratorTest {
    /**
     * Method under test: {@link DataGenerator#generateUserData(int)}
     */
    @Test
    void testGenerateUserData() {
        assertNotNull(new DataGenerator().generateUserData(3));
    }

    /**
     * Method under test: {@link DataGenerator#generateUserData(int)}
     */
    @Test
    void testGenerateUserData2() {
        assertNotNull(new DataGenerator().generateUserData(10));
    }

    /**
     * Method under test: {@link DataGenerator#generateUserData(int)}
     */
    @Test
    void testGenerateUserData3() {
        assertEquals(1, (new DataGenerator()).generateUserData(1).size());
    }

    /**
     * Method under test: {@link DataGenerator#generateUserData(int)}
     */
    @Test

    void testGenerateUserData4() {

        assertEquals(2, (new DataGenerator()).generateUserData(2));
    }

    /**
     * Method under test: {@link DataGenerator#generateUserData(int)}
     */
    @Test
    void testGenerateUserData5() {
        assertEquals(11, (new DataGenerator()).generateUserData(11));
    }

    /**
     * Method under test: {@link DataGenerator#generateUserData(int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateUserData6() {
        DataGenerator DG = new DataGenerator();
        ArrayList<User> users = DG.generateUserData(76);
        assertNotNull(users);
        assertEquals(76, users.size());
    }


}

