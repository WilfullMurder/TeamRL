package com.example.teamRl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DataGeneratorTest {
    /**
     * Method under test: {@link DataGenerator#generateUserData(int)}
     */
    @Test
    void testGenerateUserData() {
        assertEquals(3, (new DataGenerator()).generateUserData(3).size());
        assertEquals(1, (new DataGenerator()).generateUserData(1).size());
        assertEquals(5, (new DataGenerator()).generateUserData(5).size());
        assertEquals(6, (new DataGenerator()).generateUserData(6).size());
    }
}

