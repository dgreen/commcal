/*
 * File: MDCalendarPrinter.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 11/05/2019 dgg - initial coding
 */
package edu.uab.dgreen.commcal;

import java.util.ArrayList;

/**
 *
 * @author David G. Green dgreen@uab.edu
 */
public class MDCalendarPrinter implements CalendarPrinter {
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
        
        // TBD: create a header file approach
        
        System.out.println("Title: Calendar for " + year);
        System.out.println("CSS: style.css");
        System.out.println();
        System.out.println("# Year: " + year);
        System.out.println();
        System.out.println("| Month | Who | Activity |");
        System.out.println("| --: | :--- | :--- |");
        
        for (Activity activity : activities) {
            month       = activity.getDate().getMonth().toString();
            role        = activity.getRole().getName();
            description = activity.getDescription();

            System.out.format("| %s | %s | %s | ",
                              month, role, description
                    );
            System.out.println("");
        }
    }
 
}
