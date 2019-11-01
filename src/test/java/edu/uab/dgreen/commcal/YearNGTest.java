/*
 * File: YearNGTest.java
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
 * Test the Year model
 * @author David G. Green dgreen@uab.edu
 */
public class YearNGTest {
    
    private Year each1;
    private Year each2;
    private Year even1;
    private Year odd1;

    public YearNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        each1 = new Year(YearType.EACH);
        each2 = new Year(YearType.EACH);
        even1 = new Year(YearType.EVEN);
        odd1 = new Year(YearType.ODD);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getType method, of class Year.
     */
    @Test
    public void testGetType() {
        assertEquals(each1.getType(), YearType.EACH);
    }

    /**
     * Test of compareTo method, of class Year.
     */
    @Test
    public void testCompareTo() {
        assertTrue(each1.compareTo(each2) == 0);
        assertTrue(each1.compareTo(even1) < 0);
        assertTrue(each1.compareTo(odd1) < 0);
        assertTrue(even1.compareTo(odd1) < 0);
    }

    /**
     * Test of equals method, of class Year.
     */
    @Test
    public void testEquals() {
        assertTrue(each1.equals(each2));
        assertTrue(! each1.equals(even1));
        assertTrue(! each1.equals(odd1));
        assertTrue(! even1.equals(odd1));
    }

    /**
     * Test of equal method, of class Year.
     */
    @Test
    public void testEqual() {
        assertTrue(each1.matches(2018));
        assertTrue(each1.matches(2019));
        assertTrue(even1.matches(2018));
        assertTrue(!even1.matches(2019));
        assertTrue(odd1.matches(2019));
        assertTrue(!odd1.matches(2018));
    }

}