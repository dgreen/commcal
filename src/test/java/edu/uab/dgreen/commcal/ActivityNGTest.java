/*
 * File: ActivityNGTest.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/19/2019 dgg - initial coding
 */


package edu.uab.dgreen.commcal;

import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test the activity model
 * @author David G. Green dgreen@uab.edu
 */
public class ActivityNGTest {
    
    private Activity a1;
    private Activity a2;
    private Activity a3;
    private Activity a4;
    private Activity a5;

    private Role director;
    private Role excom;
    private Role secretary;
    
    public ActivityNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        
        director = new Role("Director");
        excom = new Role("ExCom");
        secretary = new Role("Secretary");
        
        director.add(excom);
        secretary.add(excom);
        
        a1 = new Activity(new CDate(YearType.EACH, "January"),
                "activity 1", 
                director);
        a2 = new Activity(new CDate(YearType.EVEN, "January"),
                "activity 2", 
                director);
        a3 = new Activity(new CDate(YearType.EACH, "January/February"),
                "activity 3", 
                director);
        a4 = new Activity(new CDate(YearType.EVEN, "January"),
                "activity 4", 
                secretary);
        a5 = new Activity(new CDate(YearType.ODD, "January/February"),
                "activity 5", 
                excom);

    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of matches method, of class Activity.
     */
    @Test
    public void testMatches_3args() {
        assertTrue(a1.matches(2018, "January", director));
        assertTrue(a2.matches(2018, "January", director));
        assertTrue(a3.matches(2018, "January", director));
        assertTrue(! a4.matches(2018, "January", director));
        assertTrue(! a5.matches(2018, "January", director));

        assertTrue(! a1.matches(2018, "February", director));
        assertTrue(! a2.matches(2018, "February", director));
        assertTrue(a3.matches(2018, "February", director));
        assertTrue(! a4.matches(2018, "February", director));
        assertTrue(! a5.matches(2018, "February", director));

        assertTrue(! a1.matches(2018, "January", secretary));
        assertTrue(! a2.matches(2018, "January", secretary));
        assertTrue(! a3.matches(2018, "January", secretary));
        assertTrue(a4.matches(2018, "January", secretary));
        assertTrue(! a5.matches(2018, "January", secretary));

        assertTrue(! a1.matches(2019, "February", director));
        assertTrue(! a2.matches(2019, "February", director));
        assertTrue(a3.matches(2019, "February", director));
        assertTrue(! a4.matches(2019, "February", director));
        assertTrue(a5.matches(2019, "February", director));

        assertTrue(! a1.matches(2018, "February", excom));
        assertTrue(! a2.matches(2018, "February", excom));
        assertTrue(! a3.matches(2018, "February", excom));
        assertTrue(! a4.matches(2018, "February", excom));
        assertTrue(! a5.matches(2018, "February", excom));
        
        assertTrue(a5.matches( 2019, "February", excom));
        assertTrue(a5.matches( 2019, "January", excom));
    }

    /**
     * Test of matches method, of class Activity.
     */
    @Test
    public void testMatches_int_Role() {
        assertTrue(a1.matches(2018, director));
        assertTrue(a2.matches(2018, director));
        assertTrue(a3.matches(2018, director));
        assertTrue(! a4.matches(2018, director));
        assertTrue(! a5.matches(2018, director));

        assertTrue(! a1.matches(2018, secretary));
        assertTrue(! a2.matches(2018, secretary));
        assertTrue(! a3.matches(2018, secretary));
        assertTrue(a4.matches(2018, secretary));
        assertTrue(! a5.matches(2018, secretary));

        assertTrue(a1.matches(2019, director));
        assertTrue(! a2.matches(2019, director));
        assertTrue(a3.matches(2019, director));
        assertTrue(! a4.matches(2019, director));
        assertTrue(a5.matches(2019, director));

        assertTrue(! a1.matches(2018, excom));
        assertTrue(! a2.matches(2018, excom));
        assertTrue(! a3.matches(2018, excom));
        assertTrue(! a4.matches(2018, excom));
        assertTrue(! a5.matches(2018, excom));
        
        assertTrue(a5.matches( 2019, excom));
        
    }

    /**
     * Test of compareTo method, of class Activity.
     */
    @Test
    public void testCompareTo() {
        assertTrue(a1.compareTo(a2) < 0);
        assertTrue(a1.compareTo(a3) < 0);
        assertTrue(a1.compareTo(a4) < 0);
        assertTrue(a1.compareTo(a5) < 0);

        assertTrue(a2.compareTo(a3) < 0);
        assertTrue(a2.compareTo(a4) < 0);
        assertTrue(a2.compareTo(a5) < 0);

        assertTrue(a3.compareTo(a4) > 0);
        assertTrue(a3.compareTo(a5) < 0);

        assertTrue(a4.compareTo(a5) < 0);
        
        assertTrue(a5.compareTo(a3) > 0);
    }

}