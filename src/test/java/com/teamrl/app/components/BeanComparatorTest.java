package com.teamrl.app.components;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class BeanComparatorTest {
    /**
     * Method under test: {@link BeanComparator#BeanComparator(String)}
     */
    @Test
    void testConstructor() {
        assertEquals(-1, (new BeanComparator("Field")).compare(null, "O2"));
        assertEquals(1, (new BeanComparator("Field")).compare("O1", null));
    }

    /**
     * Method under test: {@link BeanComparator#compare(Object, Object)}
     */
    @Test
    void testCompare() {
        assertThrows(RuntimeException.class, () -> (new BeanComparator("Field")).compare("O1", "O2"));
        assertEquals(-1, (new BeanComparator("Field")).compare(null, null));
        assertEquals(1, (new BeanComparator("Field")).compare("42", null));
    }
}

