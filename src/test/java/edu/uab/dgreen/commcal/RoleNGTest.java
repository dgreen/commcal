/*
 * File: RoleNGTest.java
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
 * Test the Role class
 * @author David G. Green dgreen@uab.edu
 */
public class RoleNGTest {
    
    private Role director;
    private Role excom;
    private Role member;

    public RoleNGTest() {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        director = new Role("Director");
        excom = new Role("ExCom");
        member = new Role("Member");
        
        director.add(excom);
        excom.add(member);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getAllRoles method, of class Role.
     */
    @Test
    public void testGetAll() {
        Role all = Role.getAllRoles();
        assertTrue(all.includes(director));
        assertTrue(all.includes(excom));
        assertTrue(all.includes(member));
    }


    /**
     * Test of includes method, of class Role.
     */
    @Test
    public void testIncludes() {
        assertTrue(director.includes(director));
        assertTrue(director.includes(member));
        assertTrue(director.includes(excom));
        assertTrue(excom.includes(excom));
        assertTrue(excom.includes(member));
        assertTrue(!excom.includes(director));
        assertTrue(member.includes(member));
        assertTrue(!member.includes(excom));
    }

}