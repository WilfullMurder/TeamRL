package com.example.teamRl;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class WriteComponentTest {
    /**
     * Method under test: {@link WriteComponent#writeUserDataToJSON(String, String, ArrayList)}
     */
    @Test
    void testWriteUserDataToJSON() {

        WriteComponent writeComponent = new WriteComponent();
        writeComponent.writeUserDataToJSON("JSONtest.txt", "test", new ArrayList<>());
    }

    /**
     * Method under test: {@link WriteComponent#writeUserDataToCSV(String, String, ArrayList)}
     */
    @Test

    void testWriteUserDataToCSV() {

        WriteComponent writeComponent = new WriteComponent();
        writeComponent.writeUserDataToCSV("csvtest.txt", "test", new ArrayList<>());
    }
}

