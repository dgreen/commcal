/*
 * File: CalendarLoader.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/18/2019 dgg - initial coding
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.dgreen.commcal;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Calendar Loader interface to create a calendar
 * @author David G. Green dgreen@uab.edu
 */
public interface CalendarLoader {

    /**
     * Load and return the calendar
     * @param roles
     * @return calendar object
     * @throws java.io.IOException
     */
    Calendar getCalendar(ArrayList<Role> roles) throws IOException ;
}
