/*
 * File: CalendarApp.java
 * Author: David G. Green dgreen@uab.edu
 * Assignment:  commcal - EE333 Fall 2019
 * Vers: 1.0.0 10/19/2019 dgg - initial coding
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.dgreen.commcal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The application object for the Calendar application
 * @author David G. Green dgreen@uab.edu
 */
public class CalendarApp {
    
    /**
     * Main program to create and then run the calendar app
     * @param args
     */
    public static void main(String[] args) {
        CalendarApp app = new CalendarApp();
        app.run(args);
    }
    
    /**
     * Run the calendar app as an object
     * 
     * Read in the files "roles.txt", "calendar.csv" if the exist.  If calendar.csv
     * does not exist, exit the program.
     * 
     * args[0] is year
     * args[1] is role
     * 
     * @param args command line arguments)
     */
    public void run(String[] args) {
        
        Calendar theCalendar = null;
        ArrayList<Role> roles =  new ArrayList<>();
       
        RoleLoader rLoader = new CSVRoleLoader("roles.csv");
       
        // default if no arguments or error
        int year = 2018;
        Role theRole = Role.getAllRoles();
        String month = "";
        boolean extractAMonth = false;
        
        if (args.length == 2) {
            // get year, theRole from command line arguments
            year = Integer.parseInt(args[0]);
            theRole = Role.find(args[1]);
            extractAMonth = false;
        } else if (args.length == 3) {
            // get year, month, theRole from command line arguments
            year = Integer.parseInt(args[0]);
            month = args[1];
            theRole = Role.find(args[2]);
            extractAMonth = true;
        }
        
        try {
            rLoader.LoadRoles();    
            roles = Role.getAllRoles().getContainedRoles();
        } catch (FileNotFoundException ex) {
            // if no file, continue without it
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
        
        CalendarLoader cLoader = new CSVCalendarLoader("calendar.csv");
        try {
            theCalendar = cLoader.getCalendar(roles);
        } catch (IOException ex) {
            System.err.println(ex.toString());
            System.exit(1);
        }
        
        ArrayList<Activity> activities;
        
        if (extractAMonth) {
           activities = theCalendar.extract(year, month, theRole);
        } else {
            activities = theCalendar.extract(year, theRole);
        }
        
        // CalendarPrinter cp = new TextCalendarPrinter();
        CalendarPrinter cp = new MDCalendarPrinter();
        cp.print(activities, year);
    }
}
