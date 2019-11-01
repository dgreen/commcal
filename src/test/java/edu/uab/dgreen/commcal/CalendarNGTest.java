/*
 * File: CalendarNGTest.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/19/2019 dgg - initial coding
 *
 * Credits:  (if any for sections of code)
 */


package edu.uab.dgreen.commcal;

import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author David G. Green dgreen@uab.edu
 */
public class CalendarNGTest {

    private Activity a1;
    private Activity a2;
    private Activity a3;
    private Activity a4;
    private Activity a5;

    private Role director;
    private Role excom;
    private Role secretary;
    
    private Calendar calendar;

    public CalendarNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        director = new Role("Director");
        excom = new Role("ExCom");
        secretary = new Role("Secretary");
        calendar = new Calendar();
        
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
        
        calendar.add(a5);
        calendar.add(a4);
        calendar.add(a3);
        calendar.add(a2);
        calendar.add(a1);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of extract method, of class Calendar.
     */
    @Test
    public void testExtract_int_Role() {

        ArrayList<Activity> result;
        
        result = calendar.extract(2018, director);
        assertEquals(result.size(), 3);
        assertEquals(result.get(0), a1);
        assertEquals(result.get(1), a2);
        assertEquals(result.get(2), a3);
        
        result = calendar.extract(2018, secretary);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), a4);
        
        result = calendar.extract(2019, director);
        assertEquals(result.size(), 3);
        assertEquals(result.get(0), a1);
        assertEquals(result.get(1), a3);
        assertEquals(result.get(2), a5);

        result = calendar.extract(2018, excom);
        assertEquals(result.size(), 0);
        
        result = calendar.extract(2019, excom);
        assertEquals(result.size(), 1);
    }

    /**
     * Test of extract method, of class Calendar.
     */
    @Test
    public void testExtract_3args() {
        ArrayList<Activity> result;
        
        result = calendar.extract(2018, "January", director);
        assertEquals(result.size(), 3);
        assertEquals(result.get(0), a1);
        assertEquals(result.get(1), a2);
        assertEquals(result.get(2), a3);

        result = calendar.extract(2018, "February", director);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), a3);
        
        result = calendar.extract(2018, "January", secretary);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), a4);
        
        result = calendar.extract(2019, "February", director);
        assertEquals(result.size(), 2);
        assertEquals(result.get(0), a3);
        assertEquals(result.get(1), a5);
        
        result = calendar.extract(2019, "February", excom);
        assertEquals(result.size(), 1);
        assertEquals(result.get(0), a5);
    }

}