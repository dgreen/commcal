/*
 * File: CDateNGTest.java
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
 * Test the CDate model
 * @author David G. Green dgreen@uab.edu
 */
public class CDateNGTest {

    private CDate cd1;
    private CDate cd2;
    private CDate cd3;
    private CDate cd4;
    private CDate cd5;
    
    public CDateNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        cd1 = new CDate(YearType.EACH, "June");
        cd2 = new CDate(YearType.EACH, "July");
        cd3 = new CDate(YearType.EACH, "June/July");
        cd4 = new CDate(YearType.EVEN, "June");
        cd5 = new CDate(YearType.ODD, "July");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of compareTo method, of class CDate.
     */
    @Test
    public void testCompareTo() {
        assertTrue(cd1.compareTo(cd2) < 0);
        assertTrue(cd1.compareTo(cd3) < 0);
        assertTrue(cd2.compareTo(cd3) > 0);
        assertTrue(cd4.compareTo(cd1) > 0);
        assertTrue(cd4.compareTo(cd5) < 0);
        
    }
}