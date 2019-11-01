/*
 * File: MonthRangeNGTest.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/19/2019 dgg - initial coding
 *
 * Credits:  (if any for sections of code)
 */


package edu.uab.dgreen.commcal;

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test the MonthRange class
 * @author David G. Green dgreen@uab.edu
 */
public class MonthRangeNGTest {
    
    private MonthRange mr1;
    private MonthRange mr2;
    private MonthRange mr3;
    private MonthRange mr4;
    

    public MonthRangeNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        mr1 = new MonthRange("January");
        mr2 = new MonthRange("February");
        mr3 = new MonthRange("January/February");
        mr4 = new MonthRange("January");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of toString method, of class MonthRange.
     */
    @Test
    public void testToString() {
        assertEquals(mr1.toString(), "January");
    }

    /**
     * Test of compareTo method, of class MonthRange.
     */
    @Test
    public void testCompareTo() {
        assertTrue(mr1.compareTo(mr2) < 0);
        assertTrue(mr2.compareTo(mr1) > 0);
        assertTrue(mr1.compareTo(mr3) < 0);
        assertTrue(mr2.compareTo(mr3) > 0);
        assertTrue(mr1.compareTo(mr4) == 0);
    }

    /**
     * Test of contains method, of class MonthRange.
     */
    @Test
    public void testContains() {
        assertTrue(mr1.contains("January"));
        assertTrue(mr3.contains("January"));
        assertTrue(mr3.contains("February"));
    }

}