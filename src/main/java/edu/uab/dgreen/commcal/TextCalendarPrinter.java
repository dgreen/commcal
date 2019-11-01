/*
 * File: TextCalendarPrinter.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/19/2019 dgg - initial coding
 */
package edu.uab.dgreen.commcal;

import java.util.ArrayList;

/**
 * Create a text output of a calendar
 *
 * @author David G. Green dgreen@uab.edu
 */
public class TextCalendarPrinter implements CalendarPrinter {

    /**
     * print the list of activities
     * 
     * Year: {year}
     * 
     * Month\t| Role\t| Description
     * 
     * Note a Month string without a "/" in it, will end with two tabs
     * 
     * @param activities collection of activities in sorted order
     * @param year year to print for the calendar
     */
    @Override
    public void print(ArrayList<Activity> activities, int year) {
        String month;
        String role;
        String description;
        
        System.out.println("Year: " + year);
        System.out.println("====================================================");
        
        for (Activity activity : activities) {
            month       = activity.getDate().getMonth().toString();
            role        = activity.getRole().getName();
            description = activity.getDescription();
            
            System.out.format("%20s | %-18s | %s",
                              month, role,   description);
            System.out.println("");
        }
    }
 
}
